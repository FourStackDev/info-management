package org.fourstack.infomanagement.repositories;

import org.fourstack.infomanagement.models.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long>{

}
