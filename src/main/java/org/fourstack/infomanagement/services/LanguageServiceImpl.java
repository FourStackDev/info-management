package org.fourstack.infomanagement.services;

import java.util.List;
import java.util.Optional;

import org.fourstack.infomanagement.models.Language;
import org.fourstack.infomanagement.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {
	
	@Autowired
	private LanguageRepository repository;

	@Override
	public List<Language> getAllLanguages() {
		return repository.findAll();
	}

	@Override
	public Optional<Language> getLanguageById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Language saveLanguage(Language language) {
		return repository.save(language);
	}

	@Override
	public List<Language> saveAllLanguages(List<Language> languages) {
		return repository.saveAll(languages);
	}

}
