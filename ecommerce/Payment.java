package ecommerce;

public class Payment {
    String method;
    String details;
    double amount;

    public Payment(String method, String details, double amount) {
        this.method = method;
        this.details = details;
        this.amount = amount;
    }

    public void processPayment() {
        if (details.equals("")) {
            System.out.println("Payment method: " + method + " | Amount: Rs." + amount);
        } else {
            System.out.println("Payment method: " + method + " (" + details + ") | Amount: Rs." + amount);
        }
        System.out.println("Payment successful!");
    }

    public String getMethodName() {
        if (details.equals("")) {
            return method;
        }
        return method + " (" + details + ")";
    }
}
