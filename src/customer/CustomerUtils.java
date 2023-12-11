package customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import utils.Utils;

public class CustomerUtils {
    public static Boolean saveCustomer(CustomerInfo cInfo) {
        try {
            File cFile = Utils.getFile(Utils.customerDetailsDir, cInfo.getPhNo() + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cFile));
            oos.writeObject(cInfo);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static CustomerInfo readCustomer(String phNo) {
        CustomerInfo cInfo = new CustomerInfo("", "", 0);
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(Utils.customerDetailsDir + "/" + phNo + ".ser"));
            cInfo = (CustomerInfo) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cInfo;
    }

    public static Boolean checkCustomer(String phNo) {
        File file = new File(Utils.customerDetailsDir + "/" + phNo + ".ser");
        System.out.println("path: " + file.getPath());
        return file.exists();
    }
}
