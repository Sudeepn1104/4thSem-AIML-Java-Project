import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

abstract class Hotel {
    static String hotelName;
    static int income = 0;
    static ArrayList<Order> orderHistory = new ArrayList<>();
    static int orderCount = 0;
    int quantity;
    int choice;
    String [] menu = {"Masala Dose", "Coffe", "Biriyani", "Noddles", "Ice cream"};
    int [] prices = {60, 20, 120, 100, 60};
    String ownerName;

    Hotel() {

    }

    Hotel(String hotelname, String ownerName) {
        hotelName = hotelname;
        this.ownerName = ownerName;
    }
    Hotel(int quantity, int choice) {
        this.quantity = quantity;
        this.choice = choice;
    }

    void DisplayMenu() {
        System.out.println("Hotel " + hotelName + " Menu :");
        for(int i = 1; i <= menu.length; i++) {
            System.out.println(i + "] " + menu[i-1]);
        }
        System.out.println();
    }
}

class Order extends Hotel{
    int id;
    int toPay;
    String []location = new String[20];
    String userName;
    String paymentMethod;
    boolean paymentStatus = false;

    Order(int id, int quantity, int choice, String username, String []location) {
        super(quantity, choice);
        this.id = id;
        this.userName = username;
        this.location = location;
        toPay = quantity * prices[choice - 1];
    }
    Order() {

    }

    void generateOrderInfo() {
        System.out.println("+--------------------------------------+");
        System.out.println("Hotel : " + hotelName);
        System.out.println("User Name : " + userName);
        System.out.print("Location : ");
        for(String loc : location) {
            System.out.print(loc + ", ");
        }
        System.out.println();
        System.out.println("Order Id : " + id);
        System.out.println("Food : " + menu[choice-1]);
        System.out.println("Quantity :" + quantity);
        System.out.println("Payment : " + toPay);
        System.out.println("+--------------------------------------+");
    }

    void trackDelivery() {
        System.out.println("\nTracking Delivery...\n");

        for(String loc : location) {
            if(loc != null) {
                System.out.println("Reached : " + loc);
                char [] dot = {'|', '|', '|', '|', '|'} ;
                for(char d : dot) {
                    System.out.println(d);
                    try {
                        Thread.sleep(600);
                    } 
                    catch(InterruptedException e) {
                        System.out.println("Tracking interrupted");
                    }
                }
                try {
                Thread.sleep(100);
                } 
                catch(InterruptedException e) {
                    System.out.println("Tracking interrupted");
                }
            }
        }
        System.out.println("\nOrder Delivered Successfully!");
    }
    void makePayment() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nSelect Payment Method");
        System.out.println("1] UPI");
        System.out.println("2] Cash On Delivery");
        System.out.println("3] Card");

        int payChoice = sc.nextInt();

        switch(payChoice) {
            case 1:
                paymentMethod = "UPI";
                break;

            case 2:
                paymentMethod = "Cash On Delivery";
                break;

            case 3:
                paymentMethod = "Card";
                break;

            default:
                paymentMethod = "Unknown";
                break;
        }

        paymentStatus = true;

        income += toPay;

        orderHistory.add(this);

        System.out.println("\nPayment Successful using " + paymentMethod);
    }
}

class Owner extends Hotel{
    Owner(String hotelname, String name) {
        super(hotelname, name);
    }

    void DisplayIncome() {
        System.out.println("Hotel " + hotelName + " income :" + income);
    }
    void showOrderHistory() {

        for(Order o : orderHistory) {
            System.out.println("\n----------------");
            System.out.println("User : " + o.userName);
            System.out.println("Food : " + o.menu[o.choice - 1]);
            System.out.println("Amount : " + o.toPay);
            System.out.println("Payment : " + o.paymentMethod);
        }
    }
}

class User {
    String userName;
    Order order;
    String []location = new String[3];

    Scanner sc = new Scanner(System.in);
    
    User(String username) {
        userName = username;
    }

    void order() {
        Random random = new Random();
        int id = random.nextInt(1000);
        order = new Order();
        order.DisplayMenu();

        System.out.println("Enter your choice : ");
        int choice = sc.nextInt();

        System.out.println("Enter the quantity : ");
        int quantity = sc.nextInt();

        System.out.println("Enter you location atleast 3 : ");
        for(int i = 0; i < 3; i++) {
            location[i] = sc.next();
        }
        order = new Order(id, quantity, choice, userName, location);
    }
    
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        Owner owner = new Owner("Peak Maters", "John");
        User user1 = new User("Preetham");
        user1.order();
        user1.order.generateOrderInfo();
        user1.order.trackDelivery();
        user1.order.makePayment();

        User user2 = new User("John");
        user2.order();
        user2.order.makePayment();
        
        owner.DisplayIncome();
        owner.showOrderHistory();
    }
}