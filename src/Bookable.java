public interface Bookable {
    Ticket bookTicket(User user, Match match, int numberOfSeats, Payment payment);

    boolean cancelTicket(String ticketId);

    void viewTicket(String ticketId);
}
