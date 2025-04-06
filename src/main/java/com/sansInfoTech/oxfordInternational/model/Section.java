package com.sansInfoTech.oxfordInternational.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "section")
public class Section {
	@Id
	private Long sectionId;
	private String sectionName;
	
//	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<StandardSection> standardSections;
	
}
