package org.fourstack.infomanagement.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.models.Language;
import org.fourstack.infomanagement.repositories.LanguageRepository;
import org.fourstack.infomanagement.services.LanguageServiceImpl;
import org.fourstack.infomanagement.utils.CommonUtils;
import org.fourstack.infomanagement.utils.EntityGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lombok.extern.slf4j.Slf4j;

/**
 * Unit Test class to support the test cases for LanguageService. Class contains
 * the test cases related to the class LanguageService. As this is a unit test
 * case class, we will mock the Repository layer and test only the code for
 * Service layer.
 * 
 * @author Manjunath HM
 *
 */
@Slf4j
public class LanguageServiceTest {

	@Mock
	private LanguageRepository repository;

	@InjectMocks
	private LanguageServiceImpl languageService;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_getLanguageById() {
		Long id = CommonUtils.getRandomLong();
		Language mockLanguage = EntityGenerator.getLanguage(id);

		// Do mock for the repository method
		when(repository.findById(id)).thenReturn(Optional.of(mockLanguage));

		// call the language service to get optional container of language(should return
		// the mock response only)
		Optional<Language> optional = languageService.getLanguageById(id);

		// Verify the results
		assertEquals(id, optional.get().getId());
		assertEquals(mockLanguage.getName(), optional.get().getName());
		assertEquals(mockLanguage.getFluency(), optional.get().getFluency());
		assertEquals(mockLanguage.getProficiency(), optional.get().getProficiency());
	}

	@Test
	public void test_getAllLanguages() {
		List<Language> mockLanguageList = EntityGenerator.getLanguageList();
		// Do mock for the repository method
		when(repository.findAll()).thenReturn(mockLanguageList);

		// call service to get Languages list
		List<Language> allLanguages = languageService.getAllLanguages();

		// verify the results
		assertEquals(mockLanguageList.size(), allLanguages.size());
		assertEquals(mockLanguageList, allLanguages);
	}

	@Test
	public void test_saveLanguage() {
		Language language = EntityGenerator.getLanguage(CommonUtils.getRandomLong());
		language.setId(null);
		// Do mock for the repository method
		when(repository.save(language)).thenReturn(language);

		// call service to save the language.
		Language savedLanguage = languageService.saveLanguage(language);
		log.info("Saved Language :"+savedLanguage);
		
		// verify the result
		assertEquals(language.getProficiency(), savedLanguage.getProficiency());
		assertEquals(language.getFluency(), savedLanguage.getFluency());
		assertEquals(language.getName(), savedLanguage.getName());
		assertEquals(language, savedLanguage);
	}
	
	@Test
	public void test_saveAllLanguages() {
		List<Language> languageList = EntityGenerator.getLanguageList();
		//mock the repository method
		when(repository.saveAll(languageList)).thenReturn(languageList);
		
		//call the service method to save all entities
		List<Language> savedLanguages = languageService.saveAllLanguages(languageList);
		
		//verify the result
		assertEquals(languageList.size(), savedLanguages.size());
		assertEquals(languageList, savedLanguages);
	}
}
