package com.sansInfoTech.oxfordInternational.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sansInfoTech.oxfordInternational.model.Standard;

@Repository
public interface StandardRepository extends JpaRepository<Standard, Long>{

}
