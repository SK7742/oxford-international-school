package com.sansInfoTech.oxfordInternational.constants;

import lombok.Getter;

@Getter
public enum Sections {
	NOT_ASSIGNED(0),
	 A(1),
	 B(2),
	 C(3),
	 D(4),
	 E(5);
	
	private final long value;

	Sections(long value) {
        this.value = value;
    }
}
