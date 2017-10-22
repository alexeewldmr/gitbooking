package com.company.ui;

import com.company.businesslogic.api.GuestListResponse;
import com.company.businesslogic.GuestListService;
import com.company.domian.Guest;

public class PrintBookingListView implements View {
    private GuestListService guestListService;

    public PrintBookingListView(GuestListService guestListService) {
        this.guestListService = guestListService;
    }
    @Override
    public void execute() {
        System.out.println();
        System.out.println("Print booking list to console execution start!");

        //BL
        GuestListResponse response = guestListService.getGuests();
        // End of BL

        for (Guest guest : response.getGuests()) {
            System.out.println(guest.getName() + "[" + guest.getDescription() + "]");
        }
        System.out.println("Print booking list to console execution end!");
        System.out.println();
    }

}
