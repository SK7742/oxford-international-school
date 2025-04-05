package com.sansInfoTech.oxfordInternational.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sansInfoTech.oxfordInternational.http.responseDTO.StudentRegistrationResponseDTO;
import com.sansInfoTech.oxfordInternational.model.Student;
import com.sansInfoTech.oxfordInternational.service.StudentRegistationService;
import com.sansInfoTech.oxfordInternational.util.StudentUtility;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/student-controller/")
@RequiredArgsConstructor
@Slf4j
public class StudentController {
	
	private final StudentRegistationService studentRegistationService;
	
	@PostMapping("/student")
	public ResponseEntity<StudentRegistrationResponseDTO> registerStudent(@RequestBody Student student){
		StudentRegistrationResponseDTO response = studentRegistationService.registerStudent(student);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
