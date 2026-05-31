package ecommerce;

public abstract class Product implements Displayable {
    public String name;
    public double price;
    public int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public abstract String getCategory();

    public void display() {
        System.out.println("[" + getCategory() + "] " + name + " - Rs." + price + " (Stock: " + stock + ")");
    }
}
