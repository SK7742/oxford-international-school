package com.sansInfoTech.oxfordInternational.service;

import java.time.LocalDateTime;

import com.sansInfoTech.oxfordInternational.model.RegistrationTest;

public interface RegistationTestService {

	RegistrationTest scheduleTestForStudent(String registrationRef, LocalDateTime testTime);

	RegistrationTest updateTestScore(String registrationRef, Double score, String feedback);

	String updateTestAttempt(String registrationRef);

}
