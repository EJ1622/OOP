
// Concrete class for repair services
class RepairService extends SalesItem {
    double hours;
    
    public RepairService(String itemName, double price, double hours) {
        super(itemName, price);
        this.hours = hours;
    }
    
    @Override
    public double calculateTotalSales() {
        return price * hours;
    }
}
