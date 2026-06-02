public class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(String paymentId, double amount, String upiId) {
        super(paymentId, amount);
        this.upiId = upiId;
    }

    @Override
    public String getPaymentMode() {
        return "UPI";
    }

    @Override
    public boolean processPayment() {
        if (!ValidationUtil.isValidUpiId(upiId)) {
            System.out.println("Invalid UPI ID. Payment failed.");
            return false;
        }

        printPaymentSummary();
        System.out.println("UPI payment processed successfully using " + upiId + ".");
        return true;
    }
}
