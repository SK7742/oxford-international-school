package com.sansInfoTech.oxfordInternational.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sansInfoTech.oxfordInternational.constants.Sections;
import com.sansInfoTech.oxfordInternational.constants.Standards;
import com.sansInfoTech.oxfordInternational.responseDTO.StudentDetailsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/student-controller/")
@RequiredArgsConstructor
@Slf4j
public class StudentController {
	
	@GetMapping("/all-students-by-standard-section")
	public List<StudentDetailsDTO> allStudents(@RequestParam Standards standard, Sections section){
//		TODO Need to complete
		return null;
	}
}
