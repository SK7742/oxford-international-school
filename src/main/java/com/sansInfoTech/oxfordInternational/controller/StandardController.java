package com.sansInfoTech.oxfordInternational.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sansInfoTech.oxfordInternational.constants.Standards;
import com.sansInfoTech.oxfordInternational.model.Standard;
import com.sansInfoTech.oxfordInternational.service.StandardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/standard-controller/")
@RequiredArgsConstructor
@Slf4j
public class StandardController {
	private final StandardService standardService;
	
	@PostMapping("/standard")
	public Standard registerStandard(@RequestParam Standards standard){
		return standardService.registerStandard(standard);
	}
}
