package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utils {
    public static final String billsDir = "D:/SuperMarketData/bills";
    public static final String customerDetailsDir = "D:/SuperMarketData/custmerDetails";
    public static final String gstNo = "GST-IN097343821";
    public static final String nameStr = "\n\t\t\t\t ------------------------------- \n\t\t\t\t|\tMANA SUPER MARKET\t|\t\t\n\t\t\t\t ------------------------------- \n";

    public static void writeFile(File file, String data) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static File getFile(String dirString, String fileName) throws IOException {
        String path = getPath(dirString, fileName);
        File dir = new File(dirString);
        File file = new File(path);
        if (!dir.exists())
            dir.mkdirs();
        if (!file.exists())
            file.createNewFile();
        return file;
    }

    public static void checkDir(String dirPath) {
    }

    public static String getPath(String dirString, String fileName) {
        return dirString + "/" + fileName;
    }

    public static String getItemVal(String str) {
        return str.split("=")[1].trim();
    }
}
