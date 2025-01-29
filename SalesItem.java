
// Abstract class for sales items
abstract class SalesItem {
    String itemName;
    double price;
    
    public SalesItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }
    
    public abstract double calculateTotalSales();
    
    public String getItemName() {
        return itemName;
    }
}
