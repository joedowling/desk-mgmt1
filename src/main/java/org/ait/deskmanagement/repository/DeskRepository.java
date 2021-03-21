package org.ait.deskmanagement.repository;

import java.util.Set;
import org.ait.deskmanagement.entity.Desk;
import org.ait.deskmanagement.models.DeskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeskRepository extends JpaRepository<Desk, Long> {

    @Query(value = "select id, name, zone_id from desks", nativeQuery = true)
    Set<DeskModel> findAllDesksNative ();
}
