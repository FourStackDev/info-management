package org.fourstack.infomanagement.repositories;

import org.fourstack.infomanagement.models.ProfessionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalInfoRepository extends JpaRepository<ProfessionalInfo, Long>{

}
