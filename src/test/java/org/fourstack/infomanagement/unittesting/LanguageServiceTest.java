package org.fourstack.infomanagement.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.codetype.FluencyType;
import org.fourstack.infomanagement.codetype.Proficiency;
import org.fourstack.infomanagement.models.Language;
import org.fourstack.infomanagement.repositories.LanguageRepository;
import org.fourstack.infomanagement.services.LanguageServiceImpl;
import org.fourstack.infomanagement.utils.CommonUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LanguageServiceTest {

	@Mock
	private LanguageRepository repository;

	@InjectMocks
	private LanguageServiceImpl languageService;
	
	private ObjectMapper mapper;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		mapper = new ObjectMapper();
	}

	@Test
	public void test_getLanguageById() {
		Long id = CommonUtils.getRandomLong();

		// Do mock for the repository method
		when(repository.findById(id)).thenReturn(Optional.of(getLanguageForId(id)));

		// call the language service to get optional container of language(should return
		// the mock response only)
		Optional<Language> optional = languageService.getLanguageById(id);

		//Verify the results
		assertEquals(id, optional.get().getId());
		assertEquals("Kannada", optional.get().getName());
	}
	
	@Test
	public void test_getAllLanguages() {
		// Do mock for the repository method
		when(repository.findAll()).thenReturn(getLanguageList());
		
		List<Language> allLanguages = languageService.getAllLanguages();
		assertEquals(4, allLanguages.size());
	}

	private Language getLanguageForId(Long id) {
		Language language = new Language("Kannada", Proficiency.EXPERT,
				Arrays.asList(FluencyType.SPEAK, FluencyType.READ, FluencyType.WRITE));
		language.setId(id);
		return language;
	}
	
	private List<Language> getLanguageList() {
		Language[] languages = {};
		try {
			languages = mapper.readValue(CommonUtils.getFileContent("language-list.json"), Language[].class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return Arrays.asList(languages);
	}
}
