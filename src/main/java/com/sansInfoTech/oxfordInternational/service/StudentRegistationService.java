package com.sansInfoTech.oxfordInternational.service;

import java.time.LocalDateTime;
import java.util.List;

import com.sansInfoTech.oxfordInternational.constants.Sections;
import com.sansInfoTech.oxfordInternational.constants.Standards;
import com.sansInfoTech.oxfordInternational.http.requestDTO.RegisterStudentRequestDTO;
import com.sansInfoTech.oxfordInternational.http.responseDTO.StudentRegistrationResponseDTO;
import com.sansInfoTech.oxfordInternational.model.RegistrationTest;
import com.sansInfoTech.oxfordInternational.model.Student;
import com.sansInfoTech.oxfordInternational.model.StudentRegistration;

public interface StudentRegistationService {
	public StudentRegistrationResponseDTO registerStudent(RegisterStudentRequestDTO student);

	public List<Student> fetchStudents(Standards standard, Sections section);

	public Student mapStandardSection(String registrationRef, Standards standard, Sections section);

	public StudentRegistration fetchStudentDetailsByReference(String registrationReference);

	public RegistrationTest scheduleTestForStudent(String registrationRef, LocalDateTime testTime);

	public RegistrationTest updateTestScore(String registrationRef, Double score, String feedback);

	public void saveRecord(StudentRegistration studentRegistration);

	public void populateUpdateAuditFields(StudentRegistration studentRegistration);
}
