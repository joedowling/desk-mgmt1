package org.ait.deskmanagement.service;

import java.util.Set;
import org.ait.deskmanagement.entity.Desk;
import org.ait.deskmanagement.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeskService {

    @Autowired
    private DeskRepository deskRepository;

    public Set<Desk> getDesks () {
        return deskRepository.findAllDesksNative();
    }
}
