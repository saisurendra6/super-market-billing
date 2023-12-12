package billing;

import java.io.IOException;
import java.util.ArrayList;

import customer.CustomerInfo;
import utils.Utils;

public class DisplayBill extends Thread {
    ArrayList<BillItem> items;
    CustomerInfo cInfo;
    String time;

    public DisplayBill(ArrayList<BillItem> items, CustomerInfo cInfo, String time) {
        super("printing bill");
        this.items = items;
        this.cInfo = cInfo;
        this.time = time;
    }

    @Override
    public void run() {
        String printSt = cInfo.name + "\t\t\t\t\t" + time
                + "\n----------------------------------------------------------------------------------\n"
                + "S.No\tItemname\tQuantity\tMRP\t\tDiscount\tOur Price\n";
        float tot = 0;
        System.out.print(printSt);
        for (int i = 0; i < items.size(); i++) {
            BillItem item = items.get(i);
            float price = item.getTotalVal();
            tot += price;
            String str = (i + 1) + "\t" + item.getItemName() + "\t\t" + item.getQty() + "\t\t" + item.getMRP() + "\t\t"
                    + item.getDiscount() + "\t\t" + price + "/-\n";
            printSt += str;
            System.out.print(str);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String totPriceString = "----------------------------------------------------------------------------------"
                + "\nTotal Amount\t:" + tot + "\nTax\t\t:"
                + (tot * 0.18)
                + "\nTotal Price\t:" + tot * 1.18;
        System.out.println(totPriceString);
        printSt += totPriceString;
        System.out.println("\n\t\t\t\tTHANK YOU\t\t\t\t\n\t\t\t\tVISIT AGAIN\t\t\t\t");
        try {
            Utils.writeFile(Utils.getFile(Utils.billsDir + "/" + cInfo.getPhNo(), time.replaceAll(":", ".") + ".txt"),
                    printSt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Directing to Main Menu ---> > >");
        super.run();
    }
}
