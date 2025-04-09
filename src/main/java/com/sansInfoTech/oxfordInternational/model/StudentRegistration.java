package com.sansInfoTech.oxfordInternational.model;

import java.time.LocalDateTime;

import com.sansInfoTech.oxfordInternational.constants.Standards;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "student_registration")
public class StudentRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "Student_studentId")
	private Student student;
	private String registrationReference;
	private LocalDateTime registrationTs;
	private LocalDateTime recordValidTill;
	private LocalDateTime recordUpdatedTs;
	private boolean isRecordActive;
	private Enum<Standards> appliedForStandard;
	private Enum<Standards> selectedForStandard;
	private boolean isStudentAccepted;
	private boolean isStudentAdmitted;
	private String comment;
}
