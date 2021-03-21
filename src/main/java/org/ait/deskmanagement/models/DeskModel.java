package org.ait.deskmanagement.models;


public class DeskModel {

    private long id;
    private String name;
    private long zone_id;

    public DeskModel () {
    }

    public DeskModel (final long id, final String name, final long zone_id) {
        this.id = id;
        this.name = name;
        this.zone_id = zone_id;
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

    public long getZone_id () {
        return zone_id;
    }

    public void setZone_id (final long zone_id) {
        this.zone_id = zone_id;
    }
}
