package com.sansInfoTech.oxfordInternational.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "standard_section")
public class StandardSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "standard_id")
    private Standard standard;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
}

