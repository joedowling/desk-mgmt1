package org.ait.deskmanagement.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull(message = "{NotNull.User.firstName}")
    private String firstName;

    @Column
    @NotNull(message = "{NotNull.User.lastName}")
    private String lastName;

    @Column
    @NotNull(message = "{NotNull.User.email}")
    private String email;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Booking> bookings;

    public Users () {
    }

    public long getId () {
        return id;
    }

    public void setId (final long id) {
        this.id = id;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (final String email) {
        this.email = email;
    }

    public Set<Booking> getBookings () {
        return bookings;
    }

    public void setBookings (final Set<Booking> bookings) {
        this.bookings = bookings;
    }
}
