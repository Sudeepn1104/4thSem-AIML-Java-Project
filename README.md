# Project Name
E-Commerce

## Team Name
JAVAZON

## Team Members
| Name              | USN        |
|-------------------|------------|
| Darshan Poojary   | 4MT24AI010 |
| Darshan Patel     | 4MT24AI011 |
| Lakshmeesha       | 4MT24AI023 |
| Rachith R Amin    | 4MT24AI038 |
| Sheethal R Jain   | 4MT24AI047 |
| Thrisha           | 4MT24AI055 |

## Problem Statement
In today's world, online shopping is very popular. This project, **JAVAZON**, is a simple consolebased application that shows how an online store works. 

The application helps a user:
1. Log in with a username and password.
2. Browse products under different categories (like Clothing, Electronics, Books).
3. Add products to a shopping cart while checking if the store has enough items in stock.
4. View the items in the cart and calculate the total bill.
5. Checkout using payment options like UPI, Card, or Cash on Delivery.
6. Generate a final receipt (invoice) and automatically reduce the store's stock.

## Technologies Used
- **Language**: Java
- **Concept**: Object-Oriented Programming (OOP)
- **Application Type**: Console-Based (Runs in the terminal)

## OOP Concepts Used
1. **Inheritance**: 
   - We created a main template class called `Product`. The `StoreProduct` class extends (inherits from) `Product` to reuse fields like `name`, `price`, and `stock`.
2. **Polymorphism**: 
   - **Method Overriding**: The `StoreProduct` subclass provides its own custom implementation for the `getCategory()` method defined in `Product`.
   - **Interface**: The `Product` class implements the `Displayable` interface to guarantee it has a `display()` method.
3. **Abstraction**: 
   - `Product` is declared as an `abstract` class. This means we cannot create a generic product directly; we must create a specific `StoreProduct`.
4. **Encapsulation**: 
   - We grouped our files inside the `ecommerce` package. Data like cart items and payment details are kept safe inside classes (`ShoppingCart` and `Payment`) and accessed only through methods.
5. **Static Methods**:
   - Helper functions in the `Main` class (like `login()` and `readInt()`) are defined as `static` so they can run directly without creating a `Main` object.

## Algorithm (How the Program Works)
1. **Start**: The program runs and starts listening for user inputs.
2. **User Login**: The program asks for Username, Password, and Address. It won't let you proceed if you leave them blank.
3. **Set Up Store**: The store loads 20 default products with set prices and stock quantities.
4. **Menu Loop**: The program displays a menu with 5 options:
   * **Option 1: Product Catalog** -> Shows a list of all products, prices, and how many are left.
   * **Option 2: Add to Cart** -> Asks you to choose a product and how many you want. It checks if the store has enough stock before adding.
   * **Option 3: View Cart** -> Shows everything you have added so far and the total price.
   * **Option 4: Checkout** -> Asks you to pay via UPI, Card, or Cash on Delivery, prints a receipt (invoice), updates the product stock, and exits.
   * **Option 5: Exit** -> Exits the application.
5. **End**: The program closes the scanner and stops.

## How To Run
### Step 1: Compile the project
Open your terminal inside the project folder and run:
```bash
javac Main.java
```

### Step 2: Run the program
After compiling, run the program with:
```bash
java Main
```

## Submission Type
- [*] Presented in Class
- [*] YouTube Video

## YouTube Link
https://youtube.com/your-video-link