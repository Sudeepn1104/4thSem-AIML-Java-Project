# Food Delivery App (Java Console Project)

## Overview
This is a simple console-based Food Delivery Application developed using Java and Object-Oriented Programming concepts.

The project simulates:
- Food ordering
- Payment system
- Delivery tracking
- Hotel income management
- Order history management

The application is designed mainly for practicing:
- Inheritance
- Constructors
- Arrays & ArrayLists
- Encapsulation concepts
- Static members
- Real-time simulation using `Thread.sleep()`

---

# Features

## User Features
- View hotel menu
- Place food orders
- Select quantity
- Make payments
- Track delivery in real-time
- Generate order receipt

## Owner Features
- View total hotel income
- Access complete order history

---

# Technologies Used

- Java
- OOP Concepts
- ArrayList
- Scanner Class
- Thread.sleep()
- Random ID Generation

---

# Project Structure

## `Hotel` (Abstract Class)
Base class containing:
- Hotel information
- Menu
- Prices
- Income
- Order history

### Variables

```java
static String hotelName;
static int income;
static ArrayList<Order> orderHistory;
````

---

## `Order` Class

Handles:

* Order creation
* Payment
* Delivery tracking
* Receipt generation

### Features

* Random order ID
* Payment methods
* Delivery simulation
* Bill generation

---

## `Owner` Class

Used by hotel owner to:

* Check total income
* View all customer orders

---

## `User` Class

Represents customer functionality:

* Place orders
* Store location
* Interact with menu

# Payment Methods

The application currently supports:

* UPI
* Cash On Delivery
* Card Payment

---

# Delivery Tracking

The project simulates delivery tracking using:

```java
Thread.sleep()
```

Locations are displayed one-by-one with delay similar to real delivery apps.

# Concepts Practiced

## OOP Concepts

* Inheritance
* Abstraction
* Constructors
* Method Reuse

## Java Concepts

* Arrays
* ArrayList
* Static Variables
* Exception Handling
* Loops
* Scanner Input

---

# Sample Flow

```text
User Opens App
      ↓
Menu Displayed
      ↓
Food Ordered
      ↓
Payment Completed
      ↓
Income Updated
      ↓
Order Saved
      ↓
Delivery Tracking
      ↓
Owner Views History
```

---
# Main goal
Java OOP Practice Project

```
```
