package com.sansInfoTech.oxfordInternational.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "student")
public class Student {
	@Id
	private Long studentId;
	private String firstName;
	private String lastName;
	private String fatherFirstName;
	private String fatherLastName;
	private String motherFirstName;
	private String motherLastName;
	private LocalDate dateOfBirth;
	private String primaryContactNumber;
	private String secondaryContactNumber;
	private String address;
	private LocalDateTime registrationTimeStamp;
	private String registrationReference;
}
