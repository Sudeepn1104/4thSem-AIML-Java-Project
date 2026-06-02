public class Ticket {
    private String ticketId;
    private User user;
    private Match match;
    private int numberOfSeats;
    private String seatCategory;
    private double totalAmount;
    private String bookingStatus;
    private String paymentStatus;

    public Ticket(String ticketId, User user, Match match, int numberOfSeats, String seatCategory, double totalAmount) {
        this.ticketId = ticketId;
        this.user = user;
        this.match = match;
        this.numberOfSeats = numberOfSeats;
        this.seatCategory = seatCategory;
        this.totalAmount = totalAmount;
        this.bookingStatus = "CONFIRMED";
        this.paymentStatus = "PAID";
    }

    public String getTicketId() {
        return ticketId;
    }

    public Match getMatch() {
        return match;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void cancelTicket() {
        bookingStatus = "CANCELLED";
        paymentStatus = "REFUND INITIATED";
    }

    public void displayTicket() {
        System.out.println("Ticket ID      : " + ticketId);
        System.out.println("User           : " + user.getName());
        System.out.println("Match          : " + match.getTeamOne() + " vs " + match.getTeamTwo());
        System.out.println("Stadium        : " + match.getStadium().getName());
        System.out.println("Seats          : " + numberOfSeats);
        System.out.println("Category       : " + seatCategory);
        System.out.println("Total Amount   : Rs." + totalAmount);
        System.out.println("Booking Status : " + bookingStatus);
        System.out.println("Payment Status : " + paymentStatus);
    }
}
