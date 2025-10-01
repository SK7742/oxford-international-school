package com.sansInfoTech.oxfordInternational.controller;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.http.HttpHeaders;
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
	public ResponseEntity<byte[]> registerStudent(@RequestBody RegisterStudentRequestDTO student) throws FileNotFoundException, MalformedURLException{
		byte[] response = studentRegistationService.registerStudent(student);
		StringBuffer fileName = new StringBuffer();
		fileName.append(student.getStudent().getFirstName()).append("_")
		.append(student.getStudent().getLastName()).append("_").append(student.getStudent().getUidNumber()).append(".pdf");
		HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(response.length)
                .body(response);

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
