package com.sansInfoTech.oxfordInternational.http.requestDTO;

import com.sansInfoTech.oxfordInternational.model.Student;

import lombok.Data;

@Data
public class RegisterStudentRequestDTO {
	private Student student;
	private String applyingForstandard;
}
