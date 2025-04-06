package com.sansInfoTech.oxfordInternational.service.impl;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sansInfoTech.oxfordInternational.constants.Sections;
import com.sansInfoTech.oxfordInternational.constants.Standards;
import com.sansInfoTech.oxfordInternational.http.responseDTO.StudentRegistrationResponseDTO;
import com.sansInfoTech.oxfordInternational.model.Section;
import com.sansInfoTech.oxfordInternational.model.Standard;
import com.sansInfoTech.oxfordInternational.model.StandardSection;
import com.sansInfoTech.oxfordInternational.model.Student;
import com.sansInfoTech.oxfordInternational.repository.SectionRepository;
import com.sansInfoTech.oxfordInternational.repository.StandardRepository;
import com.sansInfoTech.oxfordInternational.repository.StandardSectionRepository;
import com.sansInfoTech.oxfordInternational.repository.StudentRepository;
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

	

	@Override
	public StudentRegistrationResponseDTO registerStudent(Student student) {
		log.debug("Registering Student {}", student.getFirstName() + " " + student.getLastName());
		student.setRegistrationReference(StudentUtility.registrationReferenceGenerator("Temp"));
		
		StandardSection standardSection = standardSectionServiceImpl.fetchStandardSection(Standards.NOT_ASSIGNED, Sections.NOT_ASSIGNED);
		student.setStandardSection(standardSection);
		student.setRegistrationTimeStamp(LocalDateTime.now());
		studentRepository.save(student);
		log.info( "Student {} is registered with referenceNo- {}", 
				student.getFirstName() + " " + student.getLastName(), student.getRegistrationReference());
		return StudentUtility.studentRegistrationResponseDTOMapper.apply(student);
	}

	@Override
	public List<Student> fetchStudents(Standards standard, Sections section) {
		StandardSection standardSection = standardSectionServiceImpl.fetchStandardSection(standard, section);
		return studentRepository.findAllByStandardSection(standardSection);
	}

}
