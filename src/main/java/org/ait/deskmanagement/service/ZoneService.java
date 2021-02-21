package org.ait.deskmanagement.service;

import java.util.Set;
import org.ait.deskmanagement.entity.Zone;
import org.ait.deskmanagement.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    public Set<Zone> getZones () {
        return (zoneRepository.findAllNative());
    }
}
