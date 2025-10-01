package com.sansInfoTech.oxfordInternational.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sansInfoTech.oxfordInternational.model.StandardSection;
import com.sansInfoTech.oxfordInternational.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findAllByStandardSection(StandardSection standardSection);

//	Student findByRegistrationReference(String registrationRef);

}
