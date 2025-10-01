package com.sansInfoTech.oxfordInternational.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sansInfoTech.oxfordInternational.model.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long>{

	Parent findByFatherUidNumberAndFatherContactNumber(String fatherUidNumber, String fatherContactNumber);
	
}
