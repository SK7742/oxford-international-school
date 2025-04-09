package com.sansInfoTech.oxfordInternational.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "standard")
public class Standard {
	@Id
	private Long standardId;
	private String standardCode;
}
