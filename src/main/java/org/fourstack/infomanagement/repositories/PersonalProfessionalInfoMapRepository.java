package org.fourstack.infomanagement.repositories;

import java.util.Optional;

import org.fourstack.infomanagement.models.PersonalProfessionalInfoMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface to handle the CRUD operations related to the
 * {@link PersonalProfessionalInfoMap} Entity.
 * 
 * @author Manjunath HM
 *
 */
@Repository
public interface PersonalProfessionalInfoMapRepository extends JpaRepository<PersonalProfessionalInfoMap, Long> {
	
	public Optional<PersonalProfessionalInfoMap> findByPersonId(Long personId);
	
	public Optional<PersonalProfessionalInfoMap> findByProfessionalId(Long professionalId);
}
