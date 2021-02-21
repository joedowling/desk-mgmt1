package org.ait.deskmanagement.repository;

import java.util.Set;
import org.ait.deskmanagement.entity.Booking;
import org.ait.deskmanagement.entity.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "select id, startTime, endTime , desk_id, from bookings", nativeQuery = true)
    Set<Desk> findAllDesksNative ();
}
