import java.util.ArrayList;
import java.util.Scanner;

import billing.BillItem;
import store.DisplayStore;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        DisplayStore dStoreObj = new DisplayStore();
        ArrayList<BillItem> items = new ArrayList<BillItem>();
        items.add(new BillItem("name1", "code1", 20.0, 1, 5));
        items.add(new BillItem("name2", "code2", 15.0, 1, 3));
        items.add(new BillItem("name3", "code3", 25.0, 1, 8));

        System.out.println("Hello Welcome to MANA Super Market :-)");
        int choice = 0;
        while (choice != 4) {
            System.out.println("1. Go to shop\n2. Cutomer Details\n3. Store Data\n4.Exit\nEnter your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // System.out.println("directing u to shoping...");
                    // BillUtils.saveBill("c-1", "now", items);
                    // BillUtils.readBill("c-1", "now");
                    dStoreObj.display();
                    break;
                case 2:
                    System.out.println("directing u to customer details...");
                    break;
                case 3:
                    System.out.println("directing u to store data...");
                    break;
                case 4:
                    System.out.println("exiting...");
                    break;

                default:
                    System.out.println("enter a valid choice");
                    break;
            }
        }
    }
}
