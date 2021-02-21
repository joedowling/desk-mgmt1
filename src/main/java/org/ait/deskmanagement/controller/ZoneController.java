package org.ait.deskmanagement.controller;

import java.util.Set;
import org.ait.deskmanagement.entity.Zone;
import org.ait.deskmanagement.links.ResourceLinks;
import org.ait.deskmanagement.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ZoneController {

    @Autowired
    ZoneService zoneService;

    @GetMapping(path = ResourceLinks.LIST_ZONES)
    public ResponseEntity<?> getZones () {
        //log.info("ZoneController:  list zones");
        final Set<Zone> resource = zoneService.getZones();
        return ResponseEntity.ok(resource);
    }
}
