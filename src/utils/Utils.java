package utils;

import java.io.File;
import java.io.IOException;

public class Utils {
    public static final String billsDir = "D:/super market data/bills";
    public static final String customerDetailsDir = "D:/super market data/custmerDetails";

    public static File getFile(String dirString, String fileName) throws IOException {
        String path = getPath(dirString, fileName);
        File dir = new File(dirString);
        File file = new File(path);
        if (!dir.exists())
            dir.mkdir();
        if (!file.exists())
            file.createNewFile();
        return file;
    }

    public static String getPath(String dirString, String fileName) {
        return dirString + "/" + fileName;
    }
}
