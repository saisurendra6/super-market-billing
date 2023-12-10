package store;

public class StoreItem {
    public final String ItemName;
    protected final String ItemCode;
    public double MRP;
    public float Discount;

    public StoreItem(String itemName, String itemCode, double mRP, float discount) {
        ItemName = itemName;
        ItemCode = itemCode;
        MRP = mRP;
        Discount = discount;
    }

    public StoreItem(StoreItem storeItem) {
        ItemName = storeItem.ItemName;
        ItemCode = storeItem.ItemCode;
        MRP = storeItem.MRP;
        Discount = storeItem.Discount;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public float getDiscount() {
        return Discount;
    }

    public double getMRP() {
        return MRP;
    }

    public void setMRP(double mRP) {
        MRP = mRP;
    }

    public void setDiscount(float discount) {
        Discount = discount;
    }

    @Override
    public String toString() {
        return "ItemName = " + ItemName + ", ItemCode = " + ItemCode + ", MRP = " + MRP + ", Discount = " + Discount;
    }

}
