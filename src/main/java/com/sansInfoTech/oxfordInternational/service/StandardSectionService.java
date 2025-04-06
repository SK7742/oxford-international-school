package com.sansInfoTech.oxfordInternational.service;

import com.sansInfoTech.oxfordInternational.constants.Sections;
import com.sansInfoTech.oxfordInternational.constants.Standards;
import com.sansInfoTech.oxfordInternational.model.Standard;
import com.sansInfoTech.oxfordInternational.model.StandardSection;

public interface StandardSectionService {

	StandardSection registerStandard(Standards standard, Sections section);
}
