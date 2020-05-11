package org.fourstack.infomanagement.repositories;

import org.fourstack.infomanagement.models.EducationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDetailRepository extends JpaRepository<EducationDetail, Long>{

}
