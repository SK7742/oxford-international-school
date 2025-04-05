package com.sansInfoTech.oxfordInternational.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "standard")
public class Standard {
	@Id
	private Long standardId;
	private int standardCode;
	
	@OneToMany(mappedBy = "standard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<StandardSection> standardSections;


}
