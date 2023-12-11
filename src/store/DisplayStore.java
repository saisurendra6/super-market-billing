package store;

import java.util.ArrayList;
import java.util.Scanner;
import billing.BillItem;
import billing.BillUtils;
import billing.DisplayBill;
import customer.CustomerInfo;
import customer.CustomerUtils;

public class DisplayStore {

    public void display() {

        StoreItem itemsArr[] = StoreUtils.getStoreItems();
        System.out.println("\n>>>>>\n");
        for (int i = 0; i < itemsArr.length; i++) {
            System.out.println(
                    (i + 1) + ".  Item Name: " + itemsArr[i].ItemName + ",   MRP: " + itemsArr[i].MRP + ",   Discount: "
                            + itemsArr[i].Discount + "%");
        }
        System.out.println("\n<<<<<<\n");
        boolean condition = true;

        Scanner scanner = new Scanner(System.in);
        ArrayList<BillItem> billItems = new ArrayList<>();
        // ArrayList<Integer> selectedItems = new ArrayList<>();
        while (condition) {
            System.out.println("select item: ");
            int itemIndex = scanner.nextInt();
            if (itemIndex > itemsArr.length) {
                System.out.println("enter a valid inp");
                continue;
            }
            System.out.println("Quantity: ");
            int qty = scanner.nextInt();
            billItems.add(new BillItem(itemsArr[itemIndex - 1], qty));
            System.out.println("Would like to add more? (y/n) ");
            String ch = scanner.next();
            if (ch.charAt(0) == 'y' || ch.charAt(0) == 'Y') {
                continue;
            } else {
                System.out.println(
                        "\n1. Go to Billing\n2. Contine shoping\n3. Go back to main menu\nEnter your choice: ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("Enter your Ph No. ");
                    String phNo = scanner.next();
                    if (!CustomerUtils.checkCustomer(phNo)) {
                        System.out.println("Enter name: ");
                        String name = scanner.next();
                        CustomerUtils.saveCustomer(new CustomerInfo(name, phNo, 0));
                    }
                    BillUtils.saveBill(phNo, "now", billItems);
                    BillUtils.readBill(phNo, "now");
                    DisplayBill dBill = new DisplayBill(billItems);
                    dBill.start();
                    try {
                        dBill.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    condition = false;
                    break;
                } else if (choice == 2) {
                    continue;
                } else if (choice == 3) {
                    condition = false;
                    break;
                } else {
                    System.out.println("Enter a valid inp\ncontinuing shoping...");
                }
            }
        }
        System.out.println("");
    }
}
