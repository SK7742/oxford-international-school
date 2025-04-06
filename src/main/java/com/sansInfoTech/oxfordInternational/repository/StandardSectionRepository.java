package com.sansInfoTech.oxfordInternational.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sansInfoTech.oxfordInternational.model.Section;
import com.sansInfoTech.oxfordInternational.model.Standard;
import com.sansInfoTech.oxfordInternational.model.StandardSection;

@Repository
public interface StandardSectionRepository extends JpaRepository<StandardSection, Long>{

	StandardSection findByStandardAndSection(Standard stan, Section sec);

}
