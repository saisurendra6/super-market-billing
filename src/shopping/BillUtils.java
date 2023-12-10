package shopping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

import utils.Utils;

public class BillUtils {

    public static void saveBill(String cID, String billID, ArrayList<BillItem> billItemsList) {
        try {
            File billFile = Utils.getFile(Utils.billsDir + "/" + cID, billID + ".txt");
            FileOutputStream fos = new FileOutputStream(billFile);
            for (BillItem billItem : billItemsList)
                fos.write((billItem + "\n").getBytes());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<BillItem> readBill(String cID, String billID) {
        ArrayList<BillItem> billItems = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(Utils.billsDir + "/" + cID + "/" + billID + ".txt"));
            br.lines().forEach(val -> billItems.add(BillItem.createFromString(val)));
            System.out.println("printing val...");
            billItems.forEach((i) -> System.out.println(i));
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return billItems;
    }

    public static String getItemVal(String str) {
        return str.split("=")[1].trim();
    }
}
