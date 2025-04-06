package com.sansInfoTech.oxfordInternational.service;

import java.util.List;

import com.sansInfoTech.oxfordInternational.constants.Sections;
import com.sansInfoTech.oxfordInternational.constants.Standards;
import com.sansInfoTech.oxfordInternational.http.responseDTO.StudentRegistrationResponseDTO;
import com.sansInfoTech.oxfordInternational.model.Student;

public interface StudentRegistationService {
	public StudentRegistrationResponseDTO registerStudent(Student student);

	public List<Student> fetchStudents(Standards standard, Sections section);
}
