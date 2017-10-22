package com.company.ui;

import com.company.businesslogic.api.RemoveGuestRequest;
import com.company.businesslogic.api.RemoveGuestResponse;
import com.company.businesslogic.RemoveGuestService;

import java.util.Scanner;

public class RemoveGuestView implements View {

    private RemoveGuestService removeGuestService;

    public RemoveGuestView(RemoveGuestService removeGuestService) {
        this.removeGuestService = removeGuestService;
    }

    @Override
    public void execute() {
        System.out.println("Remove guest from list");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter guest name:");
        final String name = sc.nextLine();

        //BL
        RemoveGuestResponse response = removeGuestService.removeByName(new RemoveGuestRequest(name));
        //END OF BL

        if (response.isRemoved()) {
            System.out.println("Guest with name " + name + " was found and will be removed from list!");
        } else {
            System.out.println("Guest with name " + name + " not found, please try again");
        }
        System.out.println("Remove guest from list execution end!");
        System.out.println();
    }
}
