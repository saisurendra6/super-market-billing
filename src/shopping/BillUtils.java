package shopping;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class BillUtils {
    
    void saveBill(String cID, String billID){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("D:/super market data/" + cID + "/" + billID + ".txt"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
