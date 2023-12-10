package shopping;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class BillItem {
    String name;
    String code;
    float MRP;
    int qty;
    float discount;
    float totalVal;

    public BillItem(String name, String code, float mRP, int qty, float discount) {
        this.name = name;
        this.code = code;
        MRP = mRP;
        this.qty = qty;
        this.discount = discount;
        getTotalVal();
    }

    public BillItem(BillItem item) {
        this.name = item.name;
        this.code = item.code;
        MRP = item.MRP;
        this.qty = item.qty;
        this.discount = item.discount;
        getTotalVal();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public float getMRP() {
        return MRP;
    }

    public float getDiscount() {
        return discount;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getTotalVal() {
        totalVal = MRP * (qty - discount / 100);
        return totalVal;
    }

    @Override
    public String toString() {
        return "Name: " + name + " code: " + code + " mrp: " + MRP + " qty: " + qty + " discount: " + discount
                + " tot: " + totalVal;
    }

}
