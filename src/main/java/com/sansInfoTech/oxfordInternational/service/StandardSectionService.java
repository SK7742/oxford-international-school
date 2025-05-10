package com.sansInfoTech.oxfordInternational.service;

import java.util.List;
import java.util.Map;

import com.sansInfoTech.oxfordInternational.constants.Sections;
import com.sansInfoTech.oxfordInternational.constants.Standards;
import com.sansInfoTech.oxfordInternational.model.Section;
import com.sansInfoTech.oxfordInternational.model.StandardSection;

public interface StandardSectionService {

	StandardSection registerStandard(Standards standard, Sections section);

	Map<String, List<Section>> fetchStandardMappedSections();
}
