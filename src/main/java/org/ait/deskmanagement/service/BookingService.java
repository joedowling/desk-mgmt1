package org.ait.deskmanagement.service;

import java.util.HashSet;
import java.util.Set;
import org.ait.deskmanagement.entity.Booking;
import org.ait.deskmanagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Set<Booking> getBookings () {
        return new HashSet<>(bookingRepository.findAll());
    }
}
