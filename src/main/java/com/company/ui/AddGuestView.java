package com.company.ui;

import com.company.businesslogic.AddGuestService;
import com.company.businesslogic.api.AddGuestRequest;

import java.util.Scanner;

public class AddGuestView implements View {

    private AddGuestService addGuestService;

    public AddGuestView(AddGuestService addGuestService) {
        this.addGuestService = addGuestService;
    }
    @Override
    public void execute() {
        System.out.println();
        System.out.println("Add guest to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name:");
        String name = sc.nextLine();
        System.out.print("Enter product description:");
        String description = sc.nextLine();

    ///BL
    addGuestService.addGuest(new AddGuestRequest(name, description));
    //End BL

    System.out.println("Add product to list execution end!");
    System.out.println();
    }
}
