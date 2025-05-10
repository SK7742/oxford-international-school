package com.sansInfoTech.oxfordInternational.http.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class StudentRegistrationResponseDTO {
	private Long studentId;
    private String firstName;
    private String lastName;
    private String registrationReferenceNumber;
}
