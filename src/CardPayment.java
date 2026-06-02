public class CardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;

    public CardPayment(String paymentId, double amount, String cardNumber, String cardHolderName) {
        super(paymentId, amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public String getPaymentMode() {
        return "Card";
    }

    @Override
    public boolean processPayment() {
        if (!ValidationUtil.isValidCardNumber(cardNumber)) {
            System.out.println("Invalid card number. Payment failed.");
            return false;
        }

        printPaymentSummary();
        System.out.println("Card payment processed successfully for " + cardHolderName + ".");
        return true;
    }
}
