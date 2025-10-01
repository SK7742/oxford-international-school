package com.sansInfoTech.oxfordInternational.constants;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum UidType {
	AADHAR(1),
	VOTER_ID(2),
	DRIVING_LICENSE(3),
	PAN_CARD(4);
	
	private final long value;

	UidType(long value) {
        this.value = value;
    }
	
	 @JsonCreator
	    public static UidType fromString(String value) {
	        return UidType.valueOf(value.toUpperCase());
	    }
}


