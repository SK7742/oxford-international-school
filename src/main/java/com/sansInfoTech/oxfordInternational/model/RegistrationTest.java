package com.sansInfoTech.oxfordInternational.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "registration_test")
public class RegistrationTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime testScheduledOn;
	private double testScore;
	private double maxMarks;
	private LocalDateTime testAttemptTs;
	private String testFeedback;
	
	@ManyToOne
	@JoinColumn(name = "StudentRegistration_id")
	private StudentRegistration studentRegistration;
}
