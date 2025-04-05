package com.sansInfoTech.oxfordInternational.util;

import java.time.YearMonth;
import java.util.UUID;
import java.util.function.Function;

import com.sansInfoTech.oxfordInternational.http.responseDTO.StudentRegistrationResponseDTO;
import com.sansInfoTech.oxfordInternational.model.Student;

public class StudentUtility {
	
	public static Function<Student, StudentRegistrationResponseDTO> studentRegistrationResponseDTOMapper = student -> {
		return new StudentRegistrationResponseDTO(student.getStudentId(), student.getFirstName(), student.getLastName(),
				student.getRegistrationReference());
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