package com.sansInfoTech.oxfordInternational.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sansInfoTech.oxfordInternational.constants.Sections;
import com.sansInfoTech.oxfordInternational.model.Section;
import com.sansInfoTech.oxfordInternational.service.SectionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/section-controller/")
@RequiredArgsConstructor
@Slf4j
public class SectionController {
	
	private final SectionService sectionService;
	
	@PostMapping("/section")
	public Section registerSection(@RequestParam Sections section){
		return sectionService.registerSection(section);
	}
	
	@GetMapping("/section")
	public List<Section> listSections(){
		return sectionService.fetchSection();
	}
}
