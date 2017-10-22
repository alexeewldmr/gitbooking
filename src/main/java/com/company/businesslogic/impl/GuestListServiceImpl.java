package com.company.businesslogic.impl;

import com.company.businesslogic.GuestListService;
import com.company.database.GuestDAO;
import com.company.businesslogic.api.GuestListResponse;

public class GuestListServiceImpl implements GuestListService{

    private GuestDAO guestDAO;

    public GuestListServiceImpl(GuestDAO guestDAO) {
        this.guestDAO = guestDAO;
    }
    @Override
    public GuestListResponse getGuests() {
        return new GuestListResponse(guestDAO.getAll());
    }
}
