# IPL Ticket Booking System

This is a simple Java console project built around an IPL ticket booking flow.

## Concepts Covered

- Class inheritance using `Person`, `User`, and `Admin`
- Runtime polymorphism using `Payment`, `UPIPayment`, `CardPayment`, and `NetBankingPayment`
- Interface implementation using `Bookable` and `BookingService`
- Arrays for storing stadiums, matches, and tickets
- Stack for viewing recent bookings from latest to oldest
- Dynamic input using `Scanner`
- Method overloading in `BookingService`
- Validation utility methods in `ValidationUtil`

## Compile

From the project folder:

```powershell
javac src\*.java
```

## Run

```powershell
java -cp src Main
```

## Suggested Demo Flow

1. View IPL matches.
2. Book a ticket.
3. Choose a seat category.
4. Choose UPI, card, or net banking payment.
5. View your tickets.
6. View recent booking stack.
7. Cancel a ticket.


YouTube link of project demo : https://youtu.be/4tdI2r1J7as?si=J_rlf3IaGtEUqpkJ
