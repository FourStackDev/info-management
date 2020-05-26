package org.fourstack.infomanagement.services;

import java.util.Optional;

import org.fourstack.infomanagement.models.PersonalProfessionalInfoMap;
import org.fourstack.infomanagement.payload.PersonalProfessionalInfoPayload;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonalProfessionalInfoMapService {
	
	public Page<PersonalProfessionalInfoPayload> getPersonAndProfessionInfoPage(Pageable pageable);
	
	public PersonalProfessionalInfoPayload getPayLoadUsingPersonId(Long personId);
	
	public PersonalProfessionalInfoPayload getPayLoadUsingProfessionalId(Long professionalId);
	
	public PersonalProfessionalInfoPayload savePayload(PersonalProfessionalInfoPayload payload);
	
	public Optional<PersonalProfessionalInfoMap> getPayloadByPersonId(Long personId);
	
	public Optional<PersonalProfessionalInfoMap> getPayloadByProfessionalId(Long professionalId);
}
