package org.ait.deskmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import org.ait.deskmanagement.models.DeskModel;

@NamedNativeQueries({
        @NamedNativeQuery(name = "getAllDesks",
                query = "select * from desks",
                resultSetMapping = "allDesk")
})

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "allDesk",
                classes = {
                        @ConstructorResult(
                                targetClass = DeskModel.class,
                                columns = {
                                        @ColumnResult(name = "id", type = Long.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "zone_id", type = Long.class),

                                }
                        )
                }
        )
})

@Entity
@Table(name = "desks")
public class Desk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @OneToMany(mappedBy = "desk", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Booking> bookings;

    public Desk () {
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

    public Zone getZone () {
        return zone;
    }

    public void setZone (final Zone zone) {
        this.zone = zone;
    }

    public Set<Booking> getBookings () {
        return bookings;
    }

    public void setBookings (final Set<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean equals (final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Desk desk = (Desk) o;
        return id == desk.id;
    }

    @Override
    public int hashCode () {
        return Objects.hash(id);
    }
}
