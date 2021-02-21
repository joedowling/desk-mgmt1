package org.ait.deskmanagement.controller;

import java.util.Set;
import org.ait.deskmanagement.entity.Booking;
import org.ait.deskmanagement.links.ResourceLinks;
import org.ait.deskmanagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping(path = ResourceLinks.LIST_BOOKINGS)
    public ResponseEntity<?> getBookings () {
        //log.info("BookingController:  list bookings");
        final Set<Booking> resource = bookingService.getBookings();
        return ResponseEntity.ok(resource);
    }
}
