package com.sansInfoTech.oxfordInternational.constants;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum Standards {
	NOT_ASSIGNED(0),
    KG(11),
    LKG(12),
    UKG(13),
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5);

    private final long value;

    Standards(long value) {
        this.value = value;
    }
    
    @JsonCreator
    public static Standards fromString(String value) {
        return Standards.valueOf(value.toUpperCase());
    }

    
}


