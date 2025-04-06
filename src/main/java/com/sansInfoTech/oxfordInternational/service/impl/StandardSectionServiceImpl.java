package com.sansInfoTech.oxfordInternational.service.impl;

import org.springframework.stereotype.Service;

import com.sansInfoTech.oxfordInternational.constants.Sections;
import com.sansInfoTech.oxfordInternational.constants.Standards;
import com.sansInfoTech.oxfordInternational.model.Section;
import com.sansInfoTech.oxfordInternational.model.Standard;
import com.sansInfoTech.oxfordInternational.model.StandardSection;
import com.sansInfoTech.oxfordInternational.repository.SectionRepository;
import com.sansInfoTech.oxfordInternational.repository.StandardRepository;
import com.sansInfoTech.oxfordInternational.repository.StandardSectionRepository;
import com.sansInfoTech.oxfordInternational.service.StandardSectionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class StandardSectionServiceImpl implements StandardSectionService{
	
	private final StandardRepository standardRepository;
	private final SectionRepository sectionRepository;
	private final StandardSectionRepository standardSectionRepository;

	@Override
	public StandardSection registerStandard(Standards standard, Sections section) {
		Standard stan = standardRepository.findById(standard.getValue()).get();
		Section sec = sectionRepository.findById(section.getValue()).get();
		
		StandardSection standardSection = standardSectionRepository.findByStandardAndSection(stan, sec);
		if(standardSection == null) {
			standardSection = new StandardSection();
			standardSection.setStandard(stan);
			standardSection.setSection(sec);
			return standardSectionRepository.save(standardSection);
		}
		log.info("Standard and section is already mapped");
		return null;
	}

}
