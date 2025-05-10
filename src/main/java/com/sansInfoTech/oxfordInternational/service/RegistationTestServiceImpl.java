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
		studentRegistration.getTests().get(0).setMaxMarks(100.0);
		studentRegistration.getTests().get(0).setTestScheduledOn(testTime);
		studentRegistationService.populateUpdateAuditFields(studentRegistration);
		return registrationTestRepository.save(studentRegistration.getTests().get(0));
	
	}

	@Override
	public RegistrationTest updateTestScore(String registrationRef, Double score, String feedback) {
		LocalDateTime now = LocalDateTime.now();
		StudentRegistration studentRegistration = studentRegistationService.fetchStudentDetailsByReference(registrationRef);
		if(studentRegistration.getTests().get(0).getTestAttemptTs() == null) {
			studentRegistration.getTests().get(0).setTestAttemptTs(LocalDateTime.now().minusHours(2));
		}
		studentRegistration.getTests().get(0).setTestScore(score);
		studentRegistration.getTests().get(0).setTestFeedback(feedback);
		
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
		return registrationTestRepository.save(studentRegistration.getTests().get(0));
	}

	@Override
	public String updateTestAttempt(String registrationRef) {
		StudentRegistration studentRegistration = studentRegistationService.fetchStudentDetailsByReference(registrationRef);
		studentRegistration.getTests().get(0).setTestAttemptTs(LocalDateTime.now());
		registrationTestRepository.save(studentRegistration.getTests().get(0));
		return "Test Attempt time logged.";
	}
	

}
