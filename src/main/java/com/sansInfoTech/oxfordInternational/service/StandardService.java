package com.sansInfoTech.oxfordInternational.service;

import java.util.List;

import com.sansInfoTech.oxfordInternational.constants.Standards;
import com.sansInfoTech.oxfordInternational.model.Standard;

public interface StandardService {

	Standard registerStandard(Standards standard);

	List<Standard> fetchSection();

}
