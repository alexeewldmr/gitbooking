package com.company.businesslogic.api;

import com.company.domian.Guest;
import java.util.List;



public class GuestListResponse {

    private List<Guest> guests;

    public GuestListResponse(List<Guest> guests) {
        this.guests = guests;
    }

    public List<Guest> getGuests() {
        return guests;
    }
}
