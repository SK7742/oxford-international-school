package com.sansInfoTech.oxfordInternational.util;

import java.time.YearMonth;
import java.util.UUID;
import java.util.function.Function;

import com.sansInfoTech.oxfordInternational.http.responseDTO.StudentRegistrationResponseDTO;
import com.sansInfoTech.oxfordInternational.model.Student;
import com.sansInfoTech.oxfordInternational.model.StudentRegistration;

public class StudentUtility {
	
	public static Function<StudentRegistration, StudentRegistrationResponseDTO> studentRegistrationResponseDTOMapper = student -> {
		return new StudentRegistrationResponseDTO(student.getStudent().getStudentId(), 
				student.getStudent().getFirstName(), student.getStudent().getLastName(), "Test");
	};
	
	public static String registrationReferenceGenerator(String classId) {
		UUID sequence = UUID.randomUUID();
		StringBuffer reference = new StringBuffer("OI/");
		String yearMonth = YearMonth.now().toString();
		reference.append(yearMonth).append("/")
		.append(classId).append("/").append(sequence);
		return reference.toString();
	}
}