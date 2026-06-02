public class NetBankingPayment extends Payment {
    private String bankName;
    private String customerId;

    public NetBankingPayment(String paymentId, double amount, String bankName, String customerId) {
        super(paymentId, amount);
        this.bankName = bankName;
        this.customerId = customerId;
    }

    @Override
    public String getPaymentMode() {
        return "Net Banking";
    }

    @Override
    public boolean processPayment() {
        if (!ValidationUtil.isNonBlank(bankName) || !ValidationUtil.isNonBlank(customerId)) {
            System.out.println("Invalid net banking details. Payment failed.");
            return false;
        }

        printPaymentSummary();
        System.out.println("Net banking payment processed successfully through " + bankName + ".");
        return true;
    }
}
