package com.company.businesslogic.impl;

import com.company.businesslogic.AddGuestService;
import com.company.businesslogic.api.AddGuestResponse;
import com.company.businesslogic.api.AddGuestRequest;
import com.company.domian.Guest;
import com.company.database.GuestDAO;


public class AddGuestServiceImpl implements AddGuestService {

    private GuestDAO guestDAO;

    public AddGuestServiceImpl(GuestDAO guestDAO) {
        this.guestDAO = guestDAO;
    }
    @Override
    public AddGuestResponse addGuest(AddGuestRequest request) {
        Guest guest = new Guest();
        guest.setName(request.getName());
        guest.setDescription(request.getDescription());
        guestDAO.save(guest);
        return new AddGuestResponse(true);
    }
}
