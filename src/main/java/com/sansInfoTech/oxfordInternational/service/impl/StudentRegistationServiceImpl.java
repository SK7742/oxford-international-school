package com.sansInfoTech.oxfordInternational.service.impl;


import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sansInfoTech.oxfordInternational.constants.Sections;
import com.sansInfoTech.oxfordInternational.constants.Standards;
import com.sansInfoTech.oxfordInternational.http.requestDTO.RegisterStudentRequestDTO;
import com.sansInfoTech.oxfordInternational.http.responseDTO.StudentRegistrationResponseDTO;
import com.sansInfoTech.oxfordInternational.model.Parent;
import com.sansInfoTech.oxfordInternational.model.RegistrationTest;
import com.sansInfoTech.oxfordInternational.model.StandardSection;
import com.sansInfoTech.oxfordInternational.model.Student;
import com.sansInfoTech.oxfordInternational.model.StudentRegistration;
import com.sansInfoTech.oxfordInternational.repository.ParentRepository;
import com.sansInfoTech.oxfordInternational.repository.RegistrationTestRepository;
import com.sansInfoTech.oxfordInternational.repository.StudentRegistrationRepository;
import com.sansInfoTech.oxfordInternational.repository.StudentRepository;
import com.sansInfoTech.oxfordInternational.service.ReferenceGenerator;
import com.sansInfoTech.oxfordInternational.service.StudentRegistationService;
import com.sansInfoTech.oxfordInternational.util.StudentUtility;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@RequiredArgsConstructor
public class StudentRegistationServiceImpl implements StudentRegistationService {

	private final StudentRepository studentRepository;
	private final StandardSectionServiceImpl standardSectionServiceImpl;
	private final StudentRegistrationRepository studentRegistrationRepository;
	private final RegistrationTestRepository registrationTestRepository;
	private final ParentRepository parentRepository;
	private final ReferenceGenerator referenceGenerator;
	

	@Override
	public byte[] registerStudent(RegisterStudentRequestDTO student) throws FileNotFoundException, MalformedURLException {
		log.debug("Registering Student {}", student.getStudent().getFirstName() + " " + student.getStudent().getLastName());
		
		StudentRegistration studentRegistration = new StudentRegistration();
		RegistrationTest registrationTest = new RegistrationTest();
		populateDefaultValuesForStudentRegistration(student, studentRegistration, registrationTest);
		
		StandardSection standardSection = standardSectionServiceImpl.fetchStandardSection(Standards.NOT_ASSIGNED, Sections.NOT_ASSIGNED);
		studentRegistration.getStudent().setStandardSection(standardSection);
		
		
		log.info( "Student {} is registered with referenceNo- {}", 
				studentRegistration.getStudent().getFirstName() + " "
				+ studentRegistration.getStudent().getLastName(), 
				studentRegistration.getRegistrationReference());
		
		byte[] response = referenceGenerator.generateRegistrationReceipt(studentRegistration);
		Parent parent = parentRepository.findByFatherUidNumberAndFatherContactNumber(
				student.getStudent().getParent().getFatherUidNumber(), student.getStudent().getParent().getFatherContactNumber());
		if(parent != null) {
			log.info("Parents Exists");
			studentRegistration.getStudent().setParent(parent);
		}
		studentRegistrationRepository.save(studentRegistration);
		
		
		return response;
	}

	@Override
	public List<Student> fetchStudents(Standards standard, Sections section) {
		StandardSection standardSection = standardSectionServiceImpl.fetchStandardSection(standard, section);
		return studentRepository.findAllByStandardSection(standardSection);
	}

	@Override
	public Student mapStandardSection(String registrationRef, Standards standard, Sections section) {
		StudentRegistration studentRegistration = studentRegistrationRepository.findByRegistrationReference(registrationRef);
		StandardSection standardSection = standardSectionServiceImpl.fetchStandardSection(standard, section);
		studentRegistration.getStudent().setStandardSection(standardSection);
		populateUpdateAuditFields(studentRegistration);
		studentRegistrationRepository.save(studentRegistration);
		return studentRegistration.getStudent();
	}
	
	private void populateDefaultValuesForStudentRegistration(RegisterStudentRequestDTO student,
			StudentRegistration studentRegistration, RegistrationTest registrationTest) {
		
		LocalDateTime now = LocalDateTime.now();
//		student.getStudent().setStudentId(1l);
		studentRegistration.setStudent(student.getStudent());
		studentRegistration.setAppliedForStandard(Standards.valueOf(student.getApplyingForstandard()));
		studentRegistration.setRecordActive(true);
		studentRegistration.setRecordUpdatedTs(now);
		studentRegistration.setRecordValidTill(LocalDateTime.of(9999, 12, 31, 0, 0));
		studentRegistration.setRegistrationReference(
				StudentUtility.registrationReferenceGenerator(student));
		studentRegistration.setRegistrationTs(now);
		
		registrationTest.setMaxMarks(100);
		registrationTest.setTestScheduledOn(LocalDateTime.of(now.toLocalDate().plusDays(1), LocalTime.of(13, 0)));
		studentRegistration.setTests(List.of(registrationTest));
	}

	@Override
	public StudentRegistration fetchStudentDetailsByReference(String registrationReference) {
		return studentRegistrationRepository.findByRegistrationReference(registrationReference);
	}

	@Override
	public RegistrationTest scheduleTestForStudent(String registrationRef, LocalDateTime testTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistrationTest updateTestScore(String registrationRef, Double score, String feedback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRecord(StudentRegistration studentRegistration) {
		this.studentRegistrationRepository.save(studentRegistration);
		
	}
	
	@Override
	public void populateUpdateAuditFields(StudentRegistration studentRegistration) {
		studentRegistration.setRecordUpdatedTs(LocalDateTime.now());
	}
	
}
