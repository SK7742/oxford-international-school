package com.sansInfoTech.oxfordInternational.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sansInfoTech.oxfordInternational.model.RegistrationTest;
import com.sansInfoTech.oxfordInternational.model.StudentRegistration;

public interface RegistrationTestRepository extends JpaRepository<RegistrationTest, Long>{

	RegistrationTest findByStudentRegistration(StudentRegistration studentRegistration);

}
