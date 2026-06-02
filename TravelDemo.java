import java.util.Scanner;

class Travel {

    final int MAX_SPEED = 800; // Final Variable
    static int tripCount = 0;  // Static Variable

    Travel() {
        tripCount++;
    }

    // Method Overloading
    void travel() {
        System.out.println("Travelling...");
    }

    void travel(String source, String destination) {
        System.out.println("Source      : " + source);
        System.out.println("Destination : " + destination);
    }

    // Calculate Travel Time
    double calculateTime(int distance, int speed) {
        return (double) distance / speed;
    }

    // Calculate Travel Cost
    double calculateCost(int distance, int ratePerKm) {
        return distance * ratePerKm;
    }

    // Travel Category
    String getCategory(int distance) {
        if (distance <= 50)
            return "Local Travel";
        else if (distance <= 200)
            return "Intercity Travel";
        else
            return "Long Distance Travel";
    }

    // Suggest Vehicle
    String suggestVehicle(int distance) {
        if (distance <= 50)
            return "Bike";
        else if (distance <= 100)
            return "Car";
        else if (distance <= 300)
            return "Train";
        else
            return "Plane";
    }
}

// Inheritance
class Trip extends Travel {

    String travellerName;

    Trip(String travellerName) {
        super();
        this.travellerName = travellerName;
    }

    // Method Overriding
    @Override
    void travel(String source, String destination) {

        System.out.println("\n===== JOURNEY DETAILS =====");
        System.out.println("Traveller   : " + travellerName);
        System.out.println("Source      : " + source);
        System.out.println("Destination : " + destination);
    }
}

public class TravelDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Traveller Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Source: ");
            String source = sc.nextLine();

            System.out.print("Enter Destination: ");
            String destination = sc.nextLine();

            System.out.print("Enter Distance (km): ");
            int distance = sc.nextInt();

            Trip t = new Trip(name);

            t.travel(source, destination);

            System.out.println("Distance    : " + distance + " km");
            System.out.println("Category    : " + t.getCategory(distance));

            double bikeTime = t.calculateTime(distance, 60);
            double carTime = t.calculateTime(distance, 100);
            double trainTime = t.calculateTime(distance, 150);
            double planeTime = t.calculateTime(distance, t.MAX_SPEED);

            System.out.println("\n===== TRAVEL TIME =====");

            System.out.printf("Bike  : %.2f hours%n", bikeTime);
            System.out.printf("Car   : %.2f hours%n", carTime);
            System.out.printf("Train : %.2f hours%n", trainTime);
            System.out.printf("Plane : %.2f hours%n", planeTime);

            System.out.println("\n===== TRAVEL COST =====");

            System.out.printf("Bike  : Rs. %.2f%n",
                    t.calculateCost(distance, 2));

            System.out.printf("Car   : Rs. %.2f%n",
                    t.calculateCost(distance, 8));

            System.out.printf("Train : Rs. %.2f%n",
                    t.calculateCost(distance, 4));

            System.out.printf("Plane : Rs. %.2f%n",
                    t.calculateCost(distance, 15));

            System.out.println("\n===== VEHICLE SPEEDS =====");

            System.out.println("Bike  : 60 km/h");
            System.out.println("Car   : 100 km/h");
            System.out.println("Train : 150 km/h");
            System.out.println("Plane : " + t.MAX_SPEED + " km/h");

            System.out.println("\nSuggested Vehicle : "
                    + t.suggestVehicle(distance));

            System.out.println("\nTotal Trips Created : "
                    + Travel.tripCount);

        } catch (Exception e) {

            System.out.println("Invalid Input! Please enter a valid distance.");

        } finally {

            sc.close();

        }
    }
}