package com.sansInfoTech.oxfordInternational.service.impl;

import org.springframework.stereotype.Service;

import com.sansInfoTech.oxfordInternational.constants.Standards;
import com.sansInfoTech.oxfordInternational.model.Standard;
import com.sansInfoTech.oxfordInternational.repository.StandardRepository;
import com.sansInfoTech.oxfordInternational.service.StandardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class StandardServiceImpl implements StandardService{
	private final StandardRepository standardRepository;

	@Override
	public Standard registerStandard(Standards registerStandard) {
		log.debug("Registering standard {}", registerStandard.toString());
		Standard standard = new Standard();
		standard.setStandardId(registerStandard.getValue());
		standard.setStandardCode(registerStandard.toString());
		return standardRepository.save(standard);
	}

}
