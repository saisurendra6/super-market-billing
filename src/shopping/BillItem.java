package shopping;

import java.io.Serializable;

import store.StoreItem;

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
        return new BillItem(BillUtils.getItemVal(arr[0]), BillUtils.getItemVal(arr[1]),
                Double.parseDouble(BillUtils.getItemVal(arr[2])), Integer.parseInt(BillUtils.getItemVal(arr[3])),
                Float.parseFloat(BillUtils.getItemVal(arr[4])));
    }

    @Override
    public String toString() {
        return "Item Name = " + ItemName + ", Item code = " + this.ItemCode + ", MRP = " + MRP + ", Quantity = " + qty
                + ", Discount = " + Discount
                + ", Total = " + totalVal;
    }

}
