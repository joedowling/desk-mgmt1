package org.ait.deskmanagement.controller;

import java.util.List;
import java.util.Set;
import org.ait.deskmanagement.entity.Desk;
import org.ait.deskmanagement.links.ResourceLinks;
import org.ait.deskmanagement.models.DeskModel;
import org.ait.deskmanagement.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class DeskController {

    @Autowired
    DeskService deskService;

    @GetMapping(path = ResourceLinks.LIST_DESKS)
    public ResponseEntity<?> getDesks () {
        //log.info("DeskController:  list desks");
        final List<DeskModel> resource = deskService.getAllDesks();
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = ResourceLinks.LIST_DESKSBOOKINGS)
    public ResponseEntity<?> getDesksBookings () {
        //log.info("DeskController:  list desks");
        final Set<Desk> resource = deskService.getDesks();
        return ResponseEntity.ok(resource);
    }

}
