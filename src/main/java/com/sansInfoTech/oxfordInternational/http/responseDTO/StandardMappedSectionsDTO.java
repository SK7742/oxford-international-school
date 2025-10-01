package com.sansInfoTech.oxfordInternational.http.responseDTO;

import java.util.List;

import com.sansInfoTech.oxfordInternational.model.Section;
import com.sansInfoTech.oxfordInternational.model.Standard;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandardMappedSectionsDTO {
	private Standard standard;
	private List<Section> sections;
}
