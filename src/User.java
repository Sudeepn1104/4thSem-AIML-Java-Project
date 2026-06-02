public class User extends Person {
    private String userId;
    private Ticket[] bookingHistory;
    private int bookingCount;

    public User(String personId, String name, int age, String mobileNumber, String email, String userId) {
        super(personId, name, age, mobileNumber, email);
        this.userId = userId;
        this.bookingHistory = new Ticket[20];
        this.bookingCount = 0;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String getRole() {
        return "User";
    }

    public void addBooking(Ticket ticket) {
        if (bookingCount < bookingHistory.length) {
            bookingHistory[bookingCount] = ticket;
            bookingCount++;
        } else {
            System.out.println("Booking history is full for this user.");
        }
    }

    public void viewBookingHistory() {
        if (bookingCount == 0) {
            System.out.println("No tickets booked yet.");
            return;
        }

        for (int i = 0; i < bookingCount; i++) {
            bookingHistory[i].displayTicket();
            System.out.println("----------------------------------");
        }
    }
}
