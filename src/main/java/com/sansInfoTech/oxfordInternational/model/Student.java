package com.sansInfoTech.oxfordInternational.model;

import java.time.LocalDate;

import com.sansInfoTech.oxfordInternational.constants.UidType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String nationality;
	private String presentAddress;
	private String permanentAddress;
	private String uidNumber;
	private Enum<UidType> uidType;
	private String mobile;

	@ManyToOne
    @JoinColumn(name = "standard_section_id", nullable = true)
    private StandardSection standardSection;
	
	@ManyToOne
	@JoinColumn(name = "parent_id", nullable = false)
	private Parent parent;

}
