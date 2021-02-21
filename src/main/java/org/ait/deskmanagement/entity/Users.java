package org.ait.deskmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Users {

    @Id
    @Column
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
}
