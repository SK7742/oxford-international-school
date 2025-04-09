package com.sansInfoTech.oxfordInternational.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import com.sansInfoTech.oxfordInternational.model.RegistrationTest;
import com.sansInfoTech.oxfordInternational.model.StudentRegistration;
import com.sansInfoTech.oxfordInternational.repository.RegistrationTestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistationTestServiceImpl implements RegistationTestService{
	
	private final RegistrationTestRepository registrationTestRepository;
	private final StudentRegistationService studentRegistationService;

	@Override
	public RegistrationTest scheduleTestForStudent(String registrationRef, LocalDateTime testTime) {

		StudentRegistration studentRegistration = studentRegistationService.fetchStudentDetailsByReference(registrationRef);
		RegistrationTest registrationTest = registrationTestRepository.findByStudentRegistration(studentRegistration);
		registrationTest.setMaxMarks(100.0);
		registrationTest.setTestScheduledOn(testTime);
		studentRegistationService.populateUpdateAuditFields(studentRegistration);
		return registrationTestRepository.save(registrationTest);
	
	}

	@Override
	public RegistrationTest updateTestScore(String registrationRef, Double score, String feedback) {
		LocalDateTime now = LocalDateTime.now();
		StudentRegistration studentRegistration = studentRegistationService.fetchStudentDetailsByReference(registrationRef);
		RegistrationTest registrationTest = registrationTestRepository.findByStudentRegistration(studentRegistration);
		registrationTest.setTestScore(score);
		registrationTest.setTestFeedback(feedback);
		
		if(score > 60) {
			studentRegistration.setSelectedForStandard(studentRegistration.getAppliedForStandard());
			studentRegistration.setRecordUpdatedTs(now);
			studentRegistration.setRecordValidTill(now.plusMonths(1));
			studentRegistration.setStudentAccepted(true);
		}else {
			studentRegistration.setRecordUpdatedTs(now);
			studentRegistration.setRecordValidTill(now.plusMonths(1));
			studentRegistration.setStudentAccepted(false);
		}
		
		studentRegistationService.saveRecord(studentRegistration);
		return registrationTestRepository.save(registrationTest);
	}

	@Override
	public String updateTestAttempt(String registrationRef) {
		StudentRegistration studentRegistration = studentRegistationService.fetchStudentDetailsByReference(registrationRef);
		RegistrationTest registrationTest = registrationTestRepository.findByStudentRegistration(studentRegistration);
		registrationTest.setTestAttemptTs(LocalDateTime.now());
		registrationTestRepository.save(registrationTest);
		return "Test Attempt time logged";
	}
	

}
