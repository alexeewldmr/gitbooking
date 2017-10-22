package com.company.businesslogic.impl;

import com.company.businesslogic.api.RemoveGuestResponse;
import com.company.businesslogic.api.RemoveGuestRequest;
import com.company.businesslogic.RemoveGuestService;
import com.company.domian.Guest;
import com.company.database.GuestDAO;

import java.util.Optional;

public class RemoveGuestServiceImpl implements RemoveGuestService {

    private GuestDAO guestDAO;

    public RemoveGuestServiceImpl(GuestDAO guestDAO) {
        this.guestDAO = guestDAO;
    }
    @Override
    public RemoveGuestResponse removeByName(RemoveGuestRequest request) {
        Optional<Guest> guestOpt = guestDAO.getByName(request.getName());
        if (guestOpt.isPresent()){
            Guest guest = guestOpt.get();
            guestDAO.delete(guest);
            return new RemoveGuestResponse(true);
        } else {
            return new RemoveGuestResponse(false);
        }
    }
}
