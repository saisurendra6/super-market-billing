import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello Welcome to MANA Super Market :-)");
        int choice = 0;
        while (choice != 4) {
            System.out.println("1. Go to shop\n2. Cutomer Details\n3. Store Data\n4.Exit\nEnter your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("directing u to shoping...");
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
