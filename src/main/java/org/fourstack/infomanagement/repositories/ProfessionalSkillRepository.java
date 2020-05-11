package org.fourstack.infomanagement.repositories;

import org.fourstack.infomanagement.models.ProfessionalSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalSkillRepository extends JpaRepository<ProfessionalSkill, Long>{

}
