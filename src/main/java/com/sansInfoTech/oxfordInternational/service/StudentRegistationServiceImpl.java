package com.sansInfoTech.oxfordInternational.service;


import org.springframework.stereotype.Service;

import com.sansInfoTech.oxfordInternational.http.responseDTO.StudentRegistrationResponseDTO;
import com.sansInfoTech.oxfordInternational.model.Student;
import com.sansInfoTech.oxfordInternational.repository.StudentRepository;
import com.sansInfoTech.oxfordInternational.util.StudentUtility;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@RequiredArgsConstructor
public class StudentRegistationServiceImpl implements StudentRegistationService {

	private final StudentRepository studentRepository;

	@Override
	public StudentRegistrationResponseDTO registerStudent(Student student) {
		log.debug("Registering Student {}", student.getFirstName() + " " + student.getLastName());
		student.setRegistrationReference(StudentUtility.registrationReferenceGenerator("Temp"));
		studentRepository.save(student);
		log.info( "Student {} is registered with referenceNo- {}", 
				student.getFirstName() + " " + student.getLastName(), student.getRegistrationReference());
		return StudentUtility.studentRegistrationResponseDTOMapper.apply(student);
	}

}
