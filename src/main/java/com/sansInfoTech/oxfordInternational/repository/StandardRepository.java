package com.sansInfoTech.oxfordInternational.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sansInfoTech.oxfordInternational.model.Standard;

@Repository
public interface StandardRepository extends JpaRepository<Standard, Long>{
	final String FETCH_STANDARDS_LIST = "SELECT * FROM STANDARD S";

	@Query(value = FETCH_STANDARDS_LIST, nativeQuery = true)
	List<Standard> fetchStandards();
}
