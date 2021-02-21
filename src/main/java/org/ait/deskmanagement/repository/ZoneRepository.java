package org.ait.deskmanagement.repository;

import java.util.Set;
import org.ait.deskmanagement.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ZoneRepository extends JpaRepository<Zone, Long> {

    @Query(value = "select id, name from zones", nativeQuery = true)
    Set<Zone> findAllNative ();
}
