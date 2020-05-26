package org.fourstack.infomanagement.services;

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

		PersonalProfessionalInfoMap infoMap = new PersonalProfessionalInfoMap();
		infoMap.setPersonId(person != null ? person.getId() : null);
		infoMap.setProfessionalId(profession != null ? profession.getId() : null);

		mapRepository.save(infoMap);
		
		payload.setPerson(person);
		payload.setProfessionalInfo(profession);
		return payload;
	}

}
