public abstract class Payment {
    private String paymentId;
    private double amount;

    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public abstract String getPaymentMode();

    public abstract boolean processPayment();

    public void printPaymentSummary() {
        System.out.println("Payment ID   : " + paymentId);
        System.out.println("Payment Mode : " + getPaymentMode());
        System.out.println("Amount       : Rs." + amount);
    }
}
