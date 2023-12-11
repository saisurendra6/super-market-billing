package store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class StoreUtils {
    
    public static StoreItem[] getStoreItems() {
        ArrayList<StoreItem> items = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/store/Items.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                items.add(StoreItem.createFromString(line));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        StoreItem sItems[] = new StoreItem[items.size()];
        items.toArray(sItems);
        return sItems;
    }
}
