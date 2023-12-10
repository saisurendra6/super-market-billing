package utils;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static File getFile(String dirString, String fileName) throws IOException {
        String path = dirString + "/" + fileName;
        File dir = new File(dirString);
        File file = new File(path);
        if (!dir.exists())
            dir.mkdir();
        if(!file.exists())
            file.createNewFile();
        return file;
    }
}
