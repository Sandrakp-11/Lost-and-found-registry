package com.lostfound.main;

import java.util.Scanner;
import com.lostfound.dto.Item;
import com.lostfound.service.ItemService;

public class MainApp {

    public static void main(String[] args) {

        ItemService service = new ItemService();

        try (Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n--- LOST & FOUND REGISTRY ---");
                System.out.println("1. Report Lost Item");
                System.out.println("2. View All Items");
                System.out.println("3. Claim Item");
                System.out.println("4. Delete Item");
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // 🔴 IMPORTANT: clears buffer

                switch (choice) {
                    case 1:
                        System.out.print("Item Name: ");
                        String name = sc.nextLine();

                        System.out.print("Description: ");
                        String desc = sc.nextLine();

                        System.out.print("Location: ");
                        String loc = sc.nextLine();

                        service.reportItem(new Item(name, desc, loc, "LOST"));
                        break;

                    case 2:
                        service.viewItems().forEach(i ->
                            System.out.println(
                                i.getId() + " | " +
                                i.getItemName() + " | " +
                                i.getDescription() + " | " +
                                i.getLocation() + " | " +
                                i.getStatus()
                            )
                        );
                        break;

                    case 3:
                        System.out.print("Enter Item ID to claim: ");
                        service.claimItem(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter Item ID to delete: ");
                        service.removeItem(sc.nextInt());
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return; // exits loop & closes scanner
                }
            }
        }
    }
}