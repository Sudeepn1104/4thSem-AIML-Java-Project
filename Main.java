import java.util.Scanner;
import ecommerce.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user = login(scanner);

        Product[] catalog = {
                new StoreProduct("Levi's Jeans", "Clothing", 3499, 20),
                new StoreProduct("Nike Hoodie", "Clothing", 2599, 15),
                new StoreProduct("Puma T-Shirt", "Clothing", 1299, 30),
                new StoreProduct("Adidas Shorts", "Clothing", 1799, 18),
                new StoreProduct("Zara Jacket", "Clothing", 4999, 10),
                new StoreProduct("Samsung Galaxy S24", "Electronics", 79999, 8),
                new StoreProduct("Sony Headphones", "Electronics", 6999, 25),
                new StoreProduct("Apple iPad", "Electronics", 45999, 12),
                new StoreProduct("Boat Smartwatch", "Electronics", 2999, 35),
                new StoreProduct("Dell Laptop", "Electronics", 65999, 5),
                new StoreProduct("Dove Shampoo", "Personal Care", 399, 50),
                new StoreProduct("Nivea Face Wash", "Personal Care", 249, 45),
                new StoreProduct("Colgate Toothpaste", "Personal Care", 120, 60),
                new StoreProduct("Mamaearth Body Lotion", "Personal Care", 499, 28),
                new StoreProduct("Gillette Razor", "Personal Care", 350, 22),
                new StoreProduct("The Alchemist", "Books", 499, 40),
                new StoreProduct("Atomic Habits", "Books", 699, 28),
                new StoreProduct("Rich Dad Poor Dad", "Books", 599, 32),
                new StoreProduct("Ikigai", "Books", 450, 25),
                new StoreProduct("Harry Potter", "Books", 899, 20)

        };

        ShoppingCart cart = new ShoppingCart();

        System.out.println("Welcome to the Ecommerce Store, " + user.username + "!");
        boolean shopping = true;
        while (shopping) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Product Catalog");
            System.out.println("2. Add to the cart");
            System.out.println("3. View the cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            int choice = readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1:
                    displayCatalog(catalog);
                    break;
                case 2:
                    addProductToCart(scanner, catalog, cart);
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty. Add products before checkout.");
                        break;
                    }

                    cart.viewCart();
                    Payment payment = choosePayment(scanner, cart.getTotal());
                    payment.processPayment();
                    cart.checkout(payment, user);
                    shopping = false;
                    break;
                case 5:
                    System.out.println("Thanks for visiting, " + user.username + "!");
                    shopping = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1 to 5.");
            }
        }

        scanner.close();
    }

    static User login(Scanner scanner) {
        System.out.println("*** Login ***");

        while (true) {
            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            System.out.print("Address: ");
            String address = scanner.nextLine();

            if (!username.equals("") && !password.equals("") && !address.equals("")) {
                System.out.println("Logged in as " + username);
                return new User(username, password, address);
            }

            System.out.println("Username, password, and address cannot be empty.");
        }
    }

    static void displayCatalog(Product[] catalog) {
        System.out.println("\n=== Product Catalog ===");
        for (int i = 0; i < catalog.length; i++) {
            System.out.print((i + 1) + ". ");
            catalog[i].display();
        }
    }

    static void addProductToCart(Scanner scanner, Product[] catalog, ShoppingCart cart) {
        displayCatalog(catalog);

        int productNumber = readInt(scanner, "Enter product number: ");
        if (productNumber < 1 || productNumber > catalog.length) {
            System.out.println("Invalid product number.");
            return;
        }

        Product selectedProduct = catalog[productNumber - 1];
        int quantity = readInt(scanner, "Enter quantity: ");
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0.");
            return;
        }

        cart.addProduct(selectedProduct, quantity);
    }

    static Payment choosePayment(Scanner scanner, double amount) {
        while (true) {
            System.out.println("\n=== Payment Method ===");
            System.out.println("1. UPI");
            System.out.println("2. Card");
            System.out.println("3. Cash on Delivery");

            int paymentChoice = readInt(scanner, "Choose payment method: ");

            switch (paymentChoice) {
                case 1:
                    System.out.print("Enter UPI ID: ");
                    String upiId = scanner.nextLine();
                    return new Payment("UPI", upiId, amount);
                case 2:
                    System.out.print("Enter card last 4 digits: ");
                    String last4 = scanner.nextLine();
                    return new Payment("Card", "**** " + last4, amount);
                case 3:
                    return new Payment("Cash on Delivery", "", amount);
                default:
                    System.out.println("Invalid payment option. Please choose 1 to 3.");
            }
        }
    }

    static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
