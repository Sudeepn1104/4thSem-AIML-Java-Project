import java.util.Stack;

public class BookingService implements Bookable {
    private Ticket[] tickets;
    private int ticketCount;
    private Stack<Ticket> recentBookingStack;

    public BookingService(int capacity) {
        tickets = new Ticket[capacity];
        ticketCount = 0;
        recentBookingStack = new Stack<>();
    }

    @Override
    public Ticket bookTicket(User user, Match match, int numberOfSeats, Payment payment) {
        return bookTicket(user, match, numberOfSeats, "GENERAL", payment);
    }

    public Ticket bookTicket(User user, Match match, int numberOfSeats, String seatCategory, Payment payment) {
        double totalAmount = calculateAmount(match, numberOfSeats, seatCategory);
        return bookTicket(user, match, numberOfSeats, seatCategory, totalAmount, payment);
    }

    public Ticket bookTicket(User user, Match match, int numberOfSeats, String seatCategory, double totalAmount,
                             Payment payment) {
        if (ticketCount == tickets.length) {
            System.out.println("Ticket storage is full. Cannot book more tickets.");
            return null;
        }

        if (!ValidationUtil.isValidSeatCount(numberOfSeats)) {
            System.out.println("You can book between 1 and 10 seats at a time.");
            return null;
        }

        if (!ValidationUtil.hasEnoughSeats(match, numberOfSeats)) {
            System.out.println("Not enough seats available for this match.");
            return null;
        }

        if (payment == null || !payment.processPayment()) {
            System.out.println("Booking stopped because payment was not completed.");
            return null;
        }

        if (!match.reserveSeats(numberOfSeats)) {
            System.out.println("Seat reservation failed.");
            return null;
        }

        String ticketId = "TKT" + (1001 + ticketCount);
        Ticket ticket = new Ticket(ticketId, user, match, numberOfSeats, seatCategory, totalAmount);
        tickets[ticketCount] = ticket;
        ticketCount++;
        user.addBooking(ticket);
        recentBookingStack.push(ticket);

        System.out.println("Ticket booked successfully. Your ticket id is " + ticketId + ".");
        return ticket;
    }

    public double calculateAmount(Match match, int numberOfSeats) {
        return match.getBaseTicketPrice() * numberOfSeats;
    }

    public double calculateAmount(Match match, int numberOfSeats, String seatCategory) {
        return calculateAmount(match, numberOfSeats, getCategoryMultiplier(seatCategory));
    }

    public double calculateAmount(Match match, int numberOfSeats, double multiplier) {
        return match.getBaseTicketPrice() * numberOfSeats * multiplier;
    }

    private double getCategoryMultiplier(String seatCategory) {
        if (seatCategory == null) {
            return 1.0;
        }

        String normalizedCategory = seatCategory.trim().toUpperCase();
        if (normalizedCategory.equals("VIP")) {
            return 2.0;
        }
        if (normalizedCategory.equals("PREMIUM")) {
            return 1.5;
        }
        return 1.0;
    }

    @Override
    public boolean cancelTicket(String ticketId) {
        Ticket ticket = findTicket(ticketId);
        if (ticket == null) {
            System.out.println("Ticket not found.");
            return false;
        }

        if (ticket.getBookingStatus().equals("CANCELLED")) {
            System.out.println("Ticket is already cancelled.");
            return false;
        }

        ticket.cancelTicket();
        ticket.getMatch().releaseSeats(ticket.getNumberOfSeats());
        System.out.println("Ticket cancelled successfully. Refund has been initiated.");
        return true;
    }

    @Override
    public void viewTicket(String ticketId) {
        Ticket ticket = findTicket(ticketId);
        if (ticket == null) {
            System.out.println("Ticket not found.");
            return;
        }
        ticket.displayTicket();
    }

    public void viewAllTickets() {
        if (ticketCount == 0) {
            System.out.println("No tickets booked yet.");
            return;
        }

        for (int i = 0; i < ticketCount; i++) {
            tickets[i].displayTicket();
            System.out.println("----------------------------------");
        }
    }

    public void viewRecentBookings() {
        if (recentBookingStack.empty()) {
            System.out.println("No recent bookings.");
            return;
        }

        System.out.println("Recent bookings shown from latest to oldest:");
        for (int i = recentBookingStack.size() - 1; i >= 0; i--) {
            recentBookingStack.get(i).displayTicket();
            System.out.println("----------------------------------");
        }
    }

    private Ticket findTicket(String ticketId) {
        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getTicketId().equalsIgnoreCase(ticketId)) {
                return tickets[i];
            }
        }
        return null;
    }
}
