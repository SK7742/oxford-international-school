package com.sansInfoTech.oxfordInternational.service;

import java.util.List;

import com.sansInfoTech.oxfordInternational.constants.Sections;
import com.sansInfoTech.oxfordInternational.model.Section;

public interface SectionService {

	Section registerSection(Sections section);

	List<Section> fetchSection();
}
