package com.sansInfoTech.oxfordInternational.model;

import java.time.LocalDateTime;
import java.util.List;

import com.sansInfoTech.oxfordInternational.constants.Standards;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import lombok.Data;

@Data
@Entity(name = "student_registration")
public class StudentRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Student_studentId")
	private Student student;
	private String registrationReference;
	private String previousSchoolName;
	private double marksInLastStandard;
	private LocalDateTime registrationTs;
	private LocalDateTime recordValidTill;
	private LocalDateTime recordUpdatedTs;
	private boolean isRecordActive;
	private Enum<Standards> appliedForStandard;
	private Enum<Standards> selectedForStandard;
	private boolean isStudentAccepted;
	private boolean isStudentAdmitted;
	private String comment;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "registrationTest_id", nullable = true)
	@OrderBy("testScheduledOn desc")
	private List<RegistrationTest> tests;
	
}
