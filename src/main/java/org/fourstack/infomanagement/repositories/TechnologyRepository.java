package org.fourstack.infomanagement.repositories;

import java.util.Optional;

import org.fourstack.infomanagement.models.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {

	/**
	 * Retrieves Optional Container of Technology Object based on name and version
	 * 
	 * @param name    Name of the Technology
	 * @param version Version of the Technology
	 * @return Optional container with Technology Object
	 */
	public Optional<Technology> findByNameAndVersion(String name, String version);
}
