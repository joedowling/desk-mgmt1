package org.ait.deskmanagement.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ait.deskmanagement.entity.Desk;
import org.ait.deskmanagement.models.DeskModel;
import org.ait.deskmanagement.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeskService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DeskRepository deskRepository;

    public Set<Desk> getDesks () {
        return new HashSet<>(deskRepository.findAll());
    }

    public List<DeskModel> getAllDesks () {
        return em.createNamedQuery("getAllDesks").getResultList();
    }
}
