package com.sansInfoTech.oxfordInternational.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "section")
public class Section {
	@Id
	private Long id;
	private String sectionName;
	private Standard standard;

}
