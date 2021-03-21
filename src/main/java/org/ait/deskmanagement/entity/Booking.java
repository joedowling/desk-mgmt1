package org.ait.deskmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//SELECT b.id,b.start_time,z.name, d.name , (select first_name from users where id = b.id ) as username FROM BOOKINGS b
//        left join desks d on b.desk_id =d.id
//        left join zones z on d.zone_id = z.id

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDateTime startTime;
    @Column
    private LocalDateTime endTime;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "desk_id", nullable = false)
    private Desk desk;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;

    public Booking () {
    }

    public long getId () {
        return id;
    }

    public void setId (final long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime () {
        return startTime;
    }

    public void setStartTime (final LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime () {
        return endTime;
    }

    public void setEndTime (final LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Desk getDesk () {
        return desk;
    }

    public void setDesk (final Desk desk) {
        this.desk = desk;
    }

//    public Users getUser () {
//        return users;
//    }
//
//    public void setUser (final Users user) {
//        users = users;
//    }

    @Override
    public boolean equals (final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Booking booking = (Booking) o;
        return id == booking.id;
    }

    @Override
    public int hashCode () {
        return Objects.hash(id);
    }
}
