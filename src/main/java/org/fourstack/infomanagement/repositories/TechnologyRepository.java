package org.fourstack.infomanagement.repositories;

import java.util.Optional;

import org.fourstack.infomanagement.models.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long>{
	
	public Optional<Technology> findByNameAndVersion(String name, String version);
}
