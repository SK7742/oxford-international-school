package com.sansInfoTech.oxfordInternational.service;

import com.sansInfoTech.oxfordInternational.http.responseDTO.StudentRegistrationResponseDTO;
import com.sansInfoTech.oxfordInternational.model.Student;

public interface StudentRegistationService {
	public StudentRegistrationResponseDTO registerStudent(Student student);
}
