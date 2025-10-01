package com.sansInfoTech.oxfordInternational.util;

import java.time.YearMonth;
import java.util.function.Function;

import com.sansInfoTech.oxfordInternational.http.requestDTO.RegisterStudentRequestDTO;
import com.sansInfoTech.oxfordInternational.http.responseDTO.StudentRegistrationResponseDTO;
import com.sansInfoTech.oxfordInternational.model.StudentRegistration;

public class StudentUtility {
	
	public static Function<StudentRegistration, StudentRegistrationResponseDTO> studentRegistrationResponseDTOMapper = student -> {
		return new StudentRegistrationResponseDTO(student.getStudent().getStudentId(), 
				student.getStudent().getFirstName(), student.getStudent().getLastName(), student.getRegistrationReference());
	};
	
	public static String registrationReferenceGenerator(RegisterStudentRequestDTO student) {
		StringBuffer reference = new StringBuffer("OI/REG-REF/");
		String yearMonth = YearMonth.now().toString();
		reference.append(yearMonth).append("/")
		.append(student.getApplyingForstandard()).append("/").append(student.getStudent().getUidNumber());
		return reference.toString();
	}
}