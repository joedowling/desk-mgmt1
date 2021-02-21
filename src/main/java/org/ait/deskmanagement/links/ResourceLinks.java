package org.ait.deskmanagement.links;

import org.springframework.stereotype.Component;

@Component
public class ResourceLinks {

    public static final String LIST_USERS = "/users";
    public static final String ADD_USER = "/user";

    public static final String LIST_ZONES = "/zones";
    public static final String ADD_ZONE = "/zone";

    public static final String LIST_DESKS = "/desks";
    public static final String ADD_DESK = "/desk";

    public static final String LIST_BOOKINGS = "/bookings";
    public static final String ADD_BOOKING = "/booking";
}
