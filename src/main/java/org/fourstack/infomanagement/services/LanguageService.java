package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.models.Language;

public interface LanguageService {
	
	public List<Language> getAllLanguages();
	
	public Optional<Language> getLanguageById(Long id);
	
	public Language saveLanguage(Language language);
	
	public List<Language> saveAllLanguages(List<Language> languages);
}
