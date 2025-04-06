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
/**
 * Controller for managing section-related operations.
 * Provides endpoints to register a new section and list all sections.
 */
public class SectionController {

    private final SectionService sectionService;

    /**
     * Registers a new section.
     *
     * @param section the section details to be registered
     * @return the registered Section object
     */
    @PostMapping("/section")
    public Section registerSection(@RequestParam Sections section) {
        return sectionService.registerSection(section);
    }

    /**
     * Fetches a list of all sections.
     *
     * @return a list of all registered sections
     */
    @GetMapping("/all-sections")
    public List<Section> listSections() {
        return sectionService.fetchSection();
    }
}
