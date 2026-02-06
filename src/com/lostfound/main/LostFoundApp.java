package com.lostfound.main;

import com.lostfound.dto.ItemDTO;
import com.lostfound.service.ItemService;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class LostFoundApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ItemService service = new ItemService();

        while (true) {
            System.out.println("\n===== LOST & FOUND REGISTRY =====");
            System.out.println("1. Add Item");
            System.out.println("2. View All Items");
            System.out.println("3. View LOST Items");
            System.out.println("4. View FOUND Items");
            System.out.println("5. Delete Item");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    ItemDTO item = new ItemDTO();

                    System.out.print("Item Name: ");
                    item.setItemName(sc.nextLine());

                    System.out.print("Description: ");
                    item.setDescription(sc.nextLine());

                    System.out.print("Category: ");
                    item.setCategory(sc.nextLine());

                    System.out.print("Status (LOST/FOUND): ");
                    item.setStatus(sc.nextLine().toUpperCase());

                    System.out.print("Location: ");
                    item.setLocation(sc.nextLine());

                    item.setDateReported(new Date(System.currentTimeMillis()));

                    if (service.addItem(item))
                        System.out.println("Item added successfully.");
                    else
                        System.out.println("Failed to add item.");
                    break;

                case 2:
                    display(service.getAllItems());
                    break;

                case 3:
                    display(service.getItemsByStatus("LOST"));
                    break;

                case 4:
                    display(service.getItemsByStatus("FOUND"));
                    break;

                case 5:
                    System.out.print("Enter Item ID to delete: ");
                    int id = sc.nextInt();
                    if (service.deleteItem(id))
                        System.out.println("Item deleted.");
                    else
                        System.out.println("Item not found.");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void display(List<ItemDTO> list) {
        if (list.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (ItemDTO i : list) {
            System.out.println(
                i.getItemId() + " | " +
                i.getItemName() + " | " +
                i.getStatus() + " | " +
                i.getLocation() + " | " +
                i.getDateReported()
            );
        }
    }
}
