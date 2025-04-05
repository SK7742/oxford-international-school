package com.sansInfoTech.oxfordInternational.service.impl;

import org.springframework.stereotype.Service;

import com.sansInfoTech.oxfordInternational.constants.Sections;
import com.sansInfoTech.oxfordInternational.model.Section;
import com.sansInfoTech.oxfordInternational.repository.SectionRepository;
import com.sansInfoTech.oxfordInternational.service.SectionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService{

	private final SectionRepository sectionRepository;
	@Override
	public Section registerSection(Sections registerSection) {
		log.debug("Registering section {}", registerSection.toString());
		Section section = new Section();
		section.setSectionId(registerSection.getValue());
		section.setSectionName(registerSection.toString());
		return sectionRepository.save(section);
	}

}
