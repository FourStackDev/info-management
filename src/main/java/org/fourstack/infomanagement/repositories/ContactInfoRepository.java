package org.fourstack.infomanagement.repositories;

import org.fourstack.infomanagement.models.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long>{

}
