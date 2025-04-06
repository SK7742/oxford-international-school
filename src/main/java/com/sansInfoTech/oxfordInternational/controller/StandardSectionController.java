package com.sansInfoTech.oxfordInternational.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sansInfoTech.oxfordInternational.constants.Sections;
import com.sansInfoTech.oxfordInternational.constants.Standards;
import com.sansInfoTech.oxfordInternational.model.Section;
import com.sansInfoTech.oxfordInternational.model.StandardSection;
import com.sansInfoTech.oxfordInternational.service.StandardSectionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/standard-section-controller/")
@RequiredArgsConstructor
@Slf4j
public class StandardSectionController {
	
	private final StandardSectionService standardSectionService;
	
	@PostMapping("/standard-section")
	public StandardSection registerStandard(@RequestParam Standards standard, Sections section){
		return standardSectionService.registerStandard(standard, section);
	}
	
	@GetMapping("/all-standard-section")
	public Map<String, List<Section>> listStandardSections(){
		return standardSectionService.fetchStandardMappedSections();
	}
}
