import java.util.Scanner;

import customer.CustomerUtils;
import store.DisplayStore;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        DisplayStore dStoreObj = new DisplayStore();

        System.out.println("Hello Welcome to MANA Super Market :-)");
        int choice = 0;
        while (choice != 4) {
            Thread.sleep(200);
            System.out.println("1. Go to Store");
            Thread.sleep(200);
            System.out.println("2. Cutomer Details");
            Thread.sleep(200);
            System.out.println("3. Store Data");
            Thread.sleep(200);
            System.out.println("4. Exit");
            Thread.sleep(500);
            System.out.println("Enter your Choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    dStoreObj.storeCounter();
                    break;
                case 2:
                    System.out.println("directing u to customer details...");
                    System.out.println("enter your Ph No :");
                    String phNo = scanner.next();
                    if (CustomerUtils.checkCustomer(phNo)) {
                        System.out.println(CustomerUtils.readCustomer(phNo));
                    } else {
                        System.out.println("couldnot find customer");
                    }
                    break;
                case 3:
                    System.out.println("printing store data");
                    dStoreObj.display();
                    break;
                case 4:
                    System.out.println("exiting...");
                    break;

                default:
                    System.out.println("enter a valid choice");
                    break;
            }
        }

        scanner.close();
    }
}
