package billing;

import java.io.Serializable;
import store.StoreItem;
import utils.Utils;

public class BillItem extends StoreItem implements Serializable {
    public int qty;
    public float totalVal;

    public BillItem(String name, String code, double mRP, int qty, float discount) {
        super(name, code, mRP, discount);
        this.qty = qty;
        getTotalVal();
    }

    public BillItem(BillItem item) {
        super(item.getItemName(), item.getItemCode(), item.getMRP(), item.getDiscount());
        this.qty = item.qty;
        getTotalVal();
    }

    public BillItem(StoreItem storeItem, int qty) {
        super(storeItem);
        this.qty = qty;
        getTotalVal();
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getTotalVal() {
        totalVal = (float) MRP * (qty - Discount / 100);
        return totalVal;
    }

    public static BillItem createFromString(String str) {
        String arr[] = str.split(",");
        return new BillItem(Utils.getItemVal(arr[0]), Utils.getItemVal(arr[1]),
                Double.parseDouble(Utils.getItemVal(arr[2])), Integer.parseInt(Utils.getItemVal(arr[3])),
                Float.parseFloat(Utils.getItemVal(arr[4])));
    }

    @Override
    public String toString() {
        return "Item Name = " + ItemName + ", Item code = " + this.ItemCode + ", MRP = " + MRP + ", Quantity = " + qty
                + ", Discount = " + Discount
                + ", Total = " + totalVal;
    }

}
