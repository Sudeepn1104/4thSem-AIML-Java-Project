import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Stadium[] stadiums = new Stadium[10];
    private static final Match[] matches = new Match[20];
    private static int stadiumCount = 0;
    private static int matchCount = 0;

    private static final BookingService bookingService = new BookingService(100);
    private static final User currentUser = new User(
            "P001",
            "Virat Fan",
            22,
            "9876543210",
            "fan@example.com",
            "U001"
    );
    private static final Admin admin = new Admin(
            "P002",
            "IPL Admin",
            30,
            "9876500000",
            "admin@ipl.com",
            "A001",
            "Admin"
    );

    public static void main(String[] args) {
        seedData();
        showWelcome();

        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    viewMatches();
                    break;
                case 2:
                    bookTicketFlow();
                    break;
                case 3:
                    currentUser.viewBookingHistory();
                    break;
                case 4:
                    cancelTicketFlow();
                    break;
                case 5:
                    bookingService.viewRecentBookings();
                    break;
                case 6:
                    adminMenu();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for using IPL Ticket Booking System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void seedData() {
        Stadium stadiumOne = new Stadium("S001", "M. Chinnaswamy Stadium", "Bengaluru", 40000);
        Stadium stadiumTwo = new Stadium("S002", "Wankhede Stadium", "Mumbai", 33000);

        stadiums[stadiumCount] = stadiumOne;
        stadiumCount++;
        stadiums[stadiumCount] = stadiumTwo;
        stadiumCount++;

        matches[matchCount] = new Match("M001", "RCB", "CSK", "12-06-2026", "7:30 PM", stadiumOne, 1500);
        matchCount++;
        matches[matchCount] = new Match("M002", "MI", "KKR", "15-06-2026", "7:30 PM", stadiumTwo, 1200);
        matchCount++;
    }

    private static void showWelcome() {
        System.out.println("==================================");
        System.out.println("     IPL Ticket Booking System    ");
        System.out.println("==================================");
        System.out.println("Current User:");
        currentUser.displayBasicDetails();
        System.out.println();
    }

    private static void showMainMenu() {
        System.out.println();
        System.out.println("1. View IPL Matches");
        System.out.println("2. Book Ticket");
        System.out.println("3. View My Tickets");
        System.out.println("4. Cancel Ticket");
        System.out.println("5. View Recent Booking Stack");
        System.out.println("6. Admin Menu");
        System.out.println("0. Exit");
    }

    private static void adminMenu() {
        boolean inAdminMenu = true;
        while (inAdminMenu) {
            System.out.println();
            System.out.println("Admin Menu");
            System.out.println("1. View Admin Details");
            System.out.println("2. Add Stadium");
            System.out.println("3. Add Match");
            System.out.println("4. View All Bookings");
            System.out.println("0. Back");

            int choice = readInt("Enter admin choice: ");
            switch (choice) {
                case 1:
                    admin.displayBasicDetails();
                    break;
                case 2:
                    addStadiumFlow();
                    break;
                case 3:
                    addMatchFlow();
                    break;
                case 4:
                    bookingService.viewAllTickets();
                    break;
                case 0:
                    inAdminMenu = false;
                    break;
                default:
                    System.out.println("Invalid admin choice.");
            }
        }
    }

    private static void addStadiumFlow() {
        if (stadiumCount == stadiums.length) {
            System.out.println("Stadium storage is full.");
            return;
        }

        String stadiumId = "S" + String.format("%03d", stadiumCount + 1);
        String name = readLine("Enter stadium name: ");
        String city = readLine("Enter city: ");
        int totalSeats = readInt("Enter total seats: ");

        if (!ValidationUtil.isNonBlank(name) || !ValidationUtil.isNonBlank(city) || totalSeats <= 0) {
            System.out.println("Invalid stadium details.");
            return;
        }

        stadiums[stadiumCount] = new Stadium(stadiumId, name, city, totalSeats);
        stadiumCount++;
        System.out.println("Stadium added successfully with ID " + stadiumId + ".");
    }

    private static void addMatchFlow() {
        if (matchCount == matches.length) {
            System.out.println("Match storage is full.");
            return;
        }

        if (stadiumCount == 0) {
            System.out.println("Please add a stadium before adding a match.");
            return;
        }

        viewStadiums();
        String stadiumId = readLine("Enter stadium ID for match: ");
        Stadium stadium = findStadiumById(stadiumId);
        if (stadium == null) {
            System.out.println("Stadium not found.");
            return;
        }

        String matchId = "M" + String.format("%03d", matchCount + 1);
        String teamOne = readLine("Enter team one: ");
        String teamTwo = readLine("Enter team two: ");
        String date = readLine("Enter match date: ");
        String time = readLine("Enter match time: ");
        double price = readDouble("Enter base ticket price: ");

        if (!ValidationUtil.isNonBlank(teamOne) || !ValidationUtil.isNonBlank(teamTwo) || price <= 0) {
            System.out.println("Invalid match details.");
            return;
        }

        matches[matchCount] = new Match(matchId, teamOne, teamTwo, date, time, stadium, price);
        matchCount++;
        System.out.println("Match added successfully with ID " + matchId + ".");
    }

    private static void viewStadiums() {
        System.out.println();
        System.out.println("Available Stadiums:");
        for (int i = 0; i < stadiumCount; i++) {
            stadiums[i].displayStadium();
        }
    }

    private static void viewMatches() {
        if (matchCount == 0) {
            System.out.println("No matches available.");
            return;
        }

        System.out.println();
        System.out.println("Available IPL Matches:");
        for (int i = 0; i < matchCount; i++) {
            matches[i].displayMatch();
            System.out.println("----------------------------------");
        }
    }

    private static void bookTicketFlow() {
        viewMatches();
        String matchId = readLine("Enter match ID: ");
        Match selectedMatch = findMatchById(matchId);

        if (selectedMatch == null) {
            System.out.println("Match not found.");
            return;
        }

        int seats = readInt("Enter number of seats: ");
        String seatCategory = chooseSeatCategory();
        double totalAmount = bookingService.calculateAmount(selectedMatch, seats, seatCategory);

        System.out.println("Total amount to pay: Rs." + totalAmount);
        Payment payment = createPayment(totalAmount);
        bookingService.bookTicket(currentUser, selectedMatch, seats, seatCategory, totalAmount, payment);
    }

    private static String chooseSeatCategory() {
        System.out.println("Choose Seat Category");
        System.out.println("1. GENERAL");
        System.out.println("2. PREMIUM");
        System.out.println("3. VIP");

        int choice = readInt("Enter category choice: ");
        switch (choice) {
            case 2:
                return "PREMIUM";
            case 3:
                return "VIP";
            default:
                return "GENERAL";
        }
    }

    private static Payment createPayment(double amount) {
        System.out.println("Choose Payment Mode");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Net Banking");

        int choice = readInt("Enter payment choice: ");
        String paymentId = "PAY" + System.currentTimeMillis();

        switch (choice) {
            case 1:
                String upiId = readLine("Enter UPI ID: ");
                return new UPIPayment(paymentId, amount, upiId);
            case 2:
                String cardNumber = readLine("Enter 16-digit card number: ");
                String cardHolder = readLine("Enter card holder name: ");
                return new CardPayment(paymentId, amount, cardNumber, cardHolder);
            case 3:
                String bankName = readLine("Enter bank name: ");
                String customerId = readLine("Enter customer ID: ");
                return new NetBankingPayment(paymentId, amount, bankName, customerId);
            default:
                System.out.println("Invalid payment choice.");
                return null;
        }
    }

    private static void cancelTicketFlow() {
        String ticketId = readLine("Enter ticket ID to cancel: ");
        bookingService.cancelTicket(ticketId);
    }

    private static Match findMatchById(String matchId) {
        for (int i = 0; i < matchCount; i++) {
            if (matches[i].getMatchId().equalsIgnoreCase(matchId)) {
                return matches[i];
            }
        }
        return null;
    }

    private static Stadium findStadiumById(String stadiumId) {
        for (int i = 0; i < stadiumCount; i++) {
            if (stadiums[i].getStadiumId().equalsIgnoreCase(stadiumId)) {
                return stadiums[i];
            }
        }
        return null;
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid amount.");
            }
        }
    }
}
