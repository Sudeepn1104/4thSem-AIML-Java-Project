public final class ValidationUtil {
    private ValidationUtil() {
    }

    public static boolean isNonBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isValidMobileNumber(String mobileNumber) {
        return mobileNumber != null && mobileNumber.matches("[6-9][0-9]{9}");
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isValidAge(int age) {
        return age >= 12 && age <= 100;
    }

    public static boolean isValidSeatCount(int numberOfSeats) {
        return numberOfSeats > 0 && numberOfSeats <= 10;
    }

    public static boolean hasEnoughSeats(Match match, int numberOfSeats) {
        return match != null && numberOfSeats > 0 && match.getAvailableSeats() >= numberOfSeats;
    }

    public static boolean isValidUpiId(String upiId) {
        return upiId != null && upiId.matches("^[A-Za-z0-9._-]+@[A-Za-z]{2,}$");
    }

    public static boolean isValidCardNumber(String cardNumber) {
        return cardNumber != null && cardNumber.matches("[0-9]{16}");
    }
}
