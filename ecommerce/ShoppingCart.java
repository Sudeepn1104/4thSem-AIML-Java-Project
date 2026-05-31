package ecommerce;

public class ShoppingCart {
    Product[] items = new Product[10];
    int[] qty = new int[10];
    int count = 0;

    public void addProduct(Product p, int quantity) {
        if (count >= 10) {
            System.out.println("Cart is full!");
            return;
        }
        if (quantity > p.stock) {
            System.out.println("Only " + p.stock + " units available for " + p.name);
            return;
        }
        items[count] = p;
        qty[count] = quantity;
        count++;
        System.out.println("Added: " + p.name + " x" + quantity);
    }

    public void viewCart() {
        if (count == 0) { System.out.println("Cart is empty."); return; }
        System.out.println("\n--- Cart ---");
        for (int i = 0; i < count; i++) {
            double lineTotal = items[i].price * qty[i];
            System.out.println("  " + items[i].name + " x" + qty[i] + " = Rs." + lineTotal);
        }
        System.out.println("  Total: Rs." + getTotal());
        System.out.println("------------");
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++)
            total += items[i].price * qty[i];
        return total;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void checkout(Payment payment, User user) {
        System.out.println("\n====== INVOICE ======");
        System.out.println("Customer: " + user.username);
        System.out.println("Address: " + user.address);
        System.out.println("Items:");
        for (int i = 0; i < count; i++) {
            System.out.println(items[i].name + " x" + qty[i] + " = Rs." + (items[i].price * qty[i]));
            items[i].stock -= qty[i];
        }
        System.out.println("Total: Rs." + getTotal());
        System.out.println("Payment: " + payment.getMethodName());
        System.out.println("=====================");
    }
}
