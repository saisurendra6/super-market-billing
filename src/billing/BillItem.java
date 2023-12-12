package billing;

import store.StoreItem;
import utils.Utils;

interface totalVal {
    float getTotalVal();
}

public class BillItem extends StoreItem implements totalVal {
    public int qty;

    public BillItem(String name, String code, double mRP, int qty, float discount) {
        super(name, code, mRP, discount);
        this.qty = qty;
    }

    public BillItem(BillItem item) {
        super(item.getItemName(), item.getItemCode(), item.getMRP(), item.getDiscount());
        this.qty = item.qty;
    }

    public BillItem(StoreItem storeItem, int qty) {
        super(storeItem);
        this.qty = qty;
    }

    public int getQty() {
        return qty;
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
                + ", Total = " + getTotalVal();
    }

    @Override
    public float getTotalVal() {
        return (float) MRP * (qty - Discount / 100);
    }

}
