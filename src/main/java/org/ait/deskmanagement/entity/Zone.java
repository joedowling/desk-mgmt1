package org.ait.deskmanagement.entity;

import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(
        name = "Zone.findAllCustom", query = "select z from Zone z"
)
@Table(name = "zones")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    
    @OneToMany(mappedBy = "zone", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Desk> desks;

    public Zone () {
    }

    public long getId () {
        return id;
    }

    public void setId (final long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (final String name) {
        this.name = name;
    }

    public Set<Desk> getDesks () {
        return desks;
    }

    public void setDesks (final Set<Desk> desks) {
        this.desks = desks;
    }

    @Override
    public boolean equals (final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Zone zone = (Zone) o;
        return id == zone.id;
    }

    @Override
    public int hashCode () {
        return Objects.hash(id);
    }
}
