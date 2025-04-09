package com.sansInfoTech.oxfordInternational.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sansInfoTech.oxfordInternational.constants.Sections;
import com.sansInfoTech.oxfordInternational.constants.Standards;
import com.sansInfoTech.oxfordInternational.http.requestDTO.RegisterStudentRequestDTO;
import com.sansInfoTech.oxfordInternational.http.responseDTO.StudentRegistrationResponseDTO;
import com.sansInfoTech.oxfordInternational.model.Student;
import com.sansInfoTech.oxfordInternational.model.StudentRegistration;
import com.sansInfoTech.oxfordInternational.service.StudentRegistationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/student-registration-controller/")
@RequiredArgsConstructor
@Slf4j
public class StudentRegistrationController {
	
	private final StudentRegistationService studentRegistationService;
	
	@PostMapping("/register-student")
	public ResponseEntity<StudentRegistrationResponseDTO> registerStudent(@RequestBody RegisterStudentRequestDTO student){
		StudentRegistrationResponseDTO response = studentRegistationService.registerStudent(student);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/student-by-registration-reference")
	public StudentRegistration studentByRegistrationReference(@RequestParam String registrationReference){
		return studentRegistationService.fetchStudentDetailsByReference(registrationReference);
	}
	
	@PatchMapping("/update-registration")
	public void updateRegistrationDetails(@RequestBody StudentRegistration studentRegistration) {
		//TODO Need to complete
	}
	
	@PatchMapping("allot-standard-section")
	public Student allotStandardSection(@RequestParam String registrationRef, Standards standard, Sections section) {
		return studentRegistationService.mapStandardSection(registrationRef, standard, section);
	}
	
	
}
