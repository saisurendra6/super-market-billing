package utils;

import java.io.File;
import java.io.IOException;

public class Utils {
    public static final String billsDir = "D:/SuperMarketData/bills";
    public static final String customerDetailsDir = "D:/SuperMarketData/custmerDetails";

    public static File getFile(String dirString, String fileName) throws IOException {
        String path = getPath(dirString, fileName);
        File dir = new File(dirString);
        File file = new File(path);
        if (!dir.exists()){
            System.out.println("dir not thre " + dirString);
            // dir.mkdir();
            dir.mkdirs();
        }
        if (!file.exists())
            file.createNewFile();
        return file;
    }

    public static void checkDir(String dirPath) {}

    public static String getPath(String dirString, String fileName) {
        return dirString + "/" + fileName;
    }

    public static String getItemVal(String str) {
        return str.split("=")[1].trim();
    }
}
