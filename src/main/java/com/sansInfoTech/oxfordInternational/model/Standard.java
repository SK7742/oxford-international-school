package com.sansInfoTech.oxfordInternational.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "standard")
public class Standard {
	@Id
	private Long id;
	private int classCode;
	
	private Set<Section> sections;

}
