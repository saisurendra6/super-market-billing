package store;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import billing.BillItem;
import billing.DisplayBill;
import customer.CustomerInfo;
import customer.CustomerUtils;

public class DisplayStore {

    Date date = new Date();
    StoreItem itemsArr[] = StoreUtils.getStoreItems();

    public void storeCounter() {

        boolean condition = true;
        Scanner scanner = new Scanner(System.in);
        ArrayList<BillItem> billItems = new ArrayList<>();

        display();
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
            System.out.println("Would like to add more items (y/n) ");
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
                    CustomerInfo cInfo = CustomerUtils.readCustomer(phNo);
                    DisplayBill dBill = new DisplayBill(billItems, cInfo, date.toString());
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

    public void display() {
        System.out.println("------------------------------------------------------------------");
        System.out.printf("s.no\titemname\titemcode\tmrp\t\tdiscount\n");
        for (int i = 0; i < itemsArr.length; i++) {
            StoreItem item = itemsArr[i];
            System.out.printf("%d\t%s\t\t%s\t\t%.2f\t\t%.2f\n", (i + 1), item.ItemName, item.ItemCode, item.getMRP(),
                    item.getDiscount());
        }
        System.out.println("------------------------------------------------------------------");
    }

}
