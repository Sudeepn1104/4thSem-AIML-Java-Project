public class Stadium {
    private String stadiumId;
    private String name;
    private String city;
    private int totalSeats;

    public Stadium(String stadiumId, String name, String city, int totalSeats) {
        this.stadiumId = stadiumId;
        this.name = name;
        this.city = city;
        this.totalSeats = totalSeats;
    }

    public String getStadiumId() {
        return stadiumId;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void displayStadium() {
        System.out.println(stadiumId + " | " + name + " | " + city + " | Seats: " + totalSeats);
    }
}
