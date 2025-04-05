package com.sansInfoTech.oxfordInternational.model;
import java.util.Set;

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
    @JoinColumn(name = "standard_id", nullable = false)
    private Standard standard;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @OneToMany(mappedBy = "standardSection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Student> students;

}

