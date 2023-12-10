package shopping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import utils.Utils;

public class BillUtils {

    public static void saveBill(String cID, String billID, ArrayList<BillItem> billItemsList) {
        try {
            File billFile = Utils.getFile("D:/super market data/" + cID, billID + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(billFile));
            oos.writeObject(billItemsList.toArray());
            oos.flush();
            oos.close();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readBill(String cID, String billID) {
        try {
            File billFile = new File("D:/super market data/" + cID + "/" + billID + ".ser");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(billFile));
            // ArrayList<BillItem> billItemsArrayList= (ArrayList<BillItem>)
            // ois.readObject();
            ArrayList obj = (ArrayList) ois.readObject();
            System.out.println(obj.getClass());
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
