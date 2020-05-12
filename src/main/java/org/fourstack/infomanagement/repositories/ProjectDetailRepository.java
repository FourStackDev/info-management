package org.fourstack.infomanagement.repositories;

import org.fourstack.infomanagement.models.ProjectDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDetailRepository extends JpaRepository<ProjectDetail, Long>{

}
