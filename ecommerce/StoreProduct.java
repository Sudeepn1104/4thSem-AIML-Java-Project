package ecommerce;

public class StoreProduct extends Product {
    String category;

    public StoreProduct(String name, String category, double price, int stock) {
        super(name, price, stock);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
