public class Match {
    private String matchId;
    private String teamOne;
    private String teamTwo;
    private String matchDate;
    private String matchTime;
    private Stadium stadium;
    private double baseTicketPrice;
    private int availableSeats;

    public Match(String matchId, String teamOne, String teamTwo, String matchDate, String matchTime,
                 Stadium stadium, double baseTicketPrice) {
        this.matchId = matchId;
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.stadium = stadium;
        this.baseTicketPrice = baseTicketPrice;
        this.availableSeats = stadium.getTotalSeats();
    }

    public String getMatchId() {
        return matchId;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public double getBaseTicketPrice() {
        return baseTicketPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean reserveSeats(int numberOfSeats) {
        if (numberOfSeats <= 0 || numberOfSeats > availableSeats) {
            return false;
        }
        availableSeats -= numberOfSeats;
        return true;
    }

    public void releaseSeats(int numberOfSeats) {
        availableSeats += numberOfSeats;
        if (availableSeats > stadium.getTotalSeats()) {
            availableSeats = stadium.getTotalSeats();
        }
    }

    public void displayMatch() {
        System.out.println(matchId + " | " + teamOne + " vs " + teamTwo);
        System.out.println("Date/Time : " + matchDate + " " + matchTime);
        System.out.println("Stadium   : " + stadium.getName() + ", " + stadium.getCity());
        System.out.println("Price     : Rs." + baseTicketPrice);
        System.out.println("Available : " + availableSeats);
    }
}
