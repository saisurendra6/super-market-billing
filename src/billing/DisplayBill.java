package billing;

import java.util.ArrayList;

public class DisplayBill extends Thread {
    ArrayList<BillItem> items;

    public DisplayBill(ArrayList<BillItem> items) {
        super("printing bill");
        this.items = items;
    }

    @Override
    public void run() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Directing to Main Menu ---> > >");
        super.run();
    }
}
