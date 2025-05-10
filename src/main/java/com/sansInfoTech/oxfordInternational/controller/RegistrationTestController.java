package com.sansInfoTech.oxfordInternational.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sansInfoTech.oxfordInternational.model.RegistrationTest;
import com.sansInfoTech.oxfordInternational.service.RegistationTestService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/registration-test-controller/")
@RequiredArgsConstructor
@Slf4j
public class RegistrationTestController {
	
	private final RegistationTestService registationTestService;
	
	@PatchMapping("/schedule-test")
	public RegistrationTest scheduleTest(@RequestParam String registrationRef, LocalDateTime testTime) {
		return registationTestService.scheduleTestForStudent(registrationRef, testTime);
	}
	
	@PatchMapping("/update-test-score")
	public RegistrationTest updateTestScoreCard(@RequestParam String registrationRef, Double score, String feedback) {
		return registationTestService.updateTestScore(registrationRef, score, feedback);
	}
	
	@PatchMapping("/test-attempt-start")
	public String updateTestAttempt(@RequestParam String registrationRef) {
		return registationTestService.updateTestAttempt(registrationRef);
	}
}
