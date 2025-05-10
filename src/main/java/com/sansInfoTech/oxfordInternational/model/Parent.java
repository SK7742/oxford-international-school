package com.sansInfoTech.oxfordInternational.model;


import com.sansInfoTech.oxfordInternational.constants.UidType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "parent")
public class Parent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fatherFirstName;
	private String fatherLastName;
	private String fatherUidNumber;
	private Enum<UidType> fatherUidType;
	private String motherFirstName;
	private String motherLastName;
	private String motherUidNumber;
	private Enum<UidType> motherUidType;
	private String fatherContactNumber;
	private String fatherOccupation;
	private String motherOccupation;
	private String fatherQualification;
	private String motherQualification;
	private String guardianName;
	
	
}
