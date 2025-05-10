package com.sansInfoTech.oxfordInternational.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sansInfoTech.oxfordInternational.model.StudentRegistration;

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Long>{

	StudentRegistration findByRegistrationReference(String registrationRef);

}
