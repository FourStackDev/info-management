package org.fourstack.infomanagement.services;

import java.util.Optional;

import org.fourstack.infomanagement.models.Person;
import org.fourstack.infomanagement.models.PersonalProfessionalInfoMap;
import org.fourstack.infomanagement.models.ProfessionalInfo;
import org.fourstack.infomanagement.payload.PersonalProfessionalInfoPayload;
import org.fourstack.infomanagement.repositories.PersonalProfessionalInfoMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonalProfessionalInfoMapServiceImpl implements PersonalProfessionalInfoMapService {

	@Autowired
	private PersonalProfessionalInfoMapRepository mapRepository;

	@Autowired
	private PersonService personService;

	@Autowired
	private ProfessionalInfoService professionalService;
	
	@Override
	public Page<PersonalProfessionalInfoPayload> getPersonAndProfessionInfoPage(Pageable pageable) {
		return null;
	}

	@Override
	public PersonalProfessionalInfoPayload getPayLoadUsingPersonId(Long personId) {
		return null;
	}

	@Override
	public PersonalProfessionalInfoPayload getPayLoadUsingProfessionalId(Long professionalId) {
		return null;
	}

	@Override
	public PersonalProfessionalInfoPayload savePayload(PersonalProfessionalInfoPayload payload) {
		Person person = payload.getPerson() != null ? personService.savePerson(payload.getPerson()) : null;
		ProfessionalInfo profession = payload.getProfessionalInfo() != null
				? professionalService.saveProfessionalInfo(payload.getProfessionalInfo())
				: null;

		PersonalProfessionalInfoMap infoMap = mapPersonAndProfessionInfo(person, profession);
		
		mapRepository.save(infoMap);
		
		payload.setPerson(person);
		payload.setProfessionalInfo(profession);
		return payload;
	}

	@Override
	public Optional<PersonalProfessionalInfoMap> getPayloadByPersonId(Long personId) {
		return mapRepository.findByPersonId(personId);
	}

	@Override
	public Optional<PersonalProfessionalInfoMap> getPayloadByProfessionalId(Long professionalId) {
		return mapRepository.findByProfessionalId(professionalId);
	}
	
	/**
	 * Method to map the {@link Person} info and {@link ProfessionalInfo}. Fetch the
	 * mapping if already exists and map the Objects properly, so that one Person
	 * can have only one ProfessionalInfo mapping.
	 * 
	 * @param person     {@link Person} Object
	 * @param profession {@link ProfessionalInfo} Object
	 * @return {@link PersonalProfessionalInfoMap} Object after properly mapping.
	 */
	private PersonalProfessionalInfoMap mapPersonAndProfessionInfo(Person person, ProfessionalInfo profession) {
		// Create new Object and Set the values
		PersonalProfessionalInfoMap infoMap = new PersonalProfessionalInfoMap();
		infoMap.setPersonId(person != null ? person.getId() : null);
		infoMap.setProfessionalId(profession != null ? profession.getId() : null);

		// Check if already a Entry exist for the Person or Profession in the Mapping
		// table.
		PersonalProfessionalInfoMap infoMap2 = null;
		if (person != null)
			infoMap2 = getPayloadByPersonId(person.getId()).orElse(null);
		if (infoMap2 == null && profession != null)
			infoMap2 = getPayloadByProfessionalId(profession.getId()).orElse(null);

		// Fetch Mapping information and Set if already Exists
		if (infoMap2 != null)
			infoMap.setId(infoMap2.getId());

		// return final Mapping value
		return infoMap;
	}

}
