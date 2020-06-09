package org.fourstack.infomanagement.utils;

import java.util.Arrays;
import java.util.List;

import org.fourstack.infomanagement.codetype.FluencyType;
import org.fourstack.infomanagement.codetype.Proficiency;
import org.fourstack.infomanagement.models.Language;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EntityGenerator {
	private static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
	}
	
	public static Language getLanguageForId(Long id) {
		Language language = new Language("Kannada", Proficiency.EXPERT,
				Arrays.asList(FluencyType.SPEAK, FluencyType.READ, FluencyType.WRITE));
		language.setId(id);
		return language;
	}
	
	public static List<Language> getLanguageList() {
		Language[] languages = {};
		try {
			languages = mapper.readValue(CommonUtils.getFileContent("language-list.json"), Language[].class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return Arrays.asList(languages);
	}
}
