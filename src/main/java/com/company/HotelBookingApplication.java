package com.company;



import com.company.businesslogic.AddGuestService;
import com.company.businesslogic.GuestListService;
import com.company.businesslogic.RemoveGuestService;
import com.company.businesslogic.impl.AddGuestServiceImpl;
import com.company.businesslogic.impl.GuestListServiceImpl;
import com.company.businesslogic.impl.RemoveGuestServiceImpl;
import com.company.database.GuestDAO;
import com.company.database.jdbc.GuestDAOImpl;
import com.company.ui.RemoveGuestView;
import com.company.ui.AddGuestView;
import com.company.ui.PrintBookingListView;
import com.company.ui.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelBookingApplication {

    public static void main(String[] args) {

        GuestDAO guestDAO = new GuestDAOImpl();

        AddGuestService addGuestService = new AddGuestServiceImpl(guestDAO);
        RemoveGuestService removeGuestService = new RemoveGuestServiceImpl(guestDAO);
        GuestListService guestListService = new GuestListServiceImpl(guestDAO);

        Map<Integer, View> commands = new HashMap<>();
        commands.put(1, new AddGuestView(addGuestService));
        commands.put(2, new RemoveGuestView(removeGuestService));
        commands.put(3, new PrintBookingListView(guestListService));

        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            if (menuItem == 4) {
                break;
            }
            View view = commands.get(menuItem);
            view.execute();
        }
    }
    private static void printProgramMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Add Guest name to list");
        System.out.println("2. Remove Guest from list");
        System.out.println("3. Print list to console");
        System.out.println("4. Exit");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}
