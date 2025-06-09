# Shopping Cart Simulation (Java CLI Project)

This is a simple command-line shopping cart simulation built in Java as part of coursework at the Polish-Japanese Academy of Information Technology (PJATK). The project demonstrates core object-oriented programming (OOP) principles and includes basic inventory and order management logic.

## 🚀 Features

- Add and remove products from a cart
- Manage inventory using a `Magazyn` (warehouse) class
- Track orders with a simple `Zamowienie` (order) system
- Display available products and order summaries
- Text-based user interface with input validation

## 🛠️ Technologies

- Java (standard libraries)
- Command Line Interface (CLI)

## 📁 Structure

- `Produkt.java` – defines the product class
- `Koszyk.java` – manages the shopping cart and its contents
- `Magazyn.java` – handles the available product inventory
- `Zamowienie.java` – represents a user's order
- `Main.java` – main application logic and user interface

## 🎓 Context

This project was created as part of first-year studies in Computer Science Engineering at PJATK Gdańsk. It focuses on clean class design, encapsulation, and simple business logic implementation.

## 📸 Preview

=== WELCOME TO THE SHOPPING SYSTEM ===

Choose an option:
1. Show products
2. Add product to cart
3. Remove product from cart
4. View cart
5. Confirm order
6. Exit

> 1

Available products:
1. Milk - 4.50 PLN
2. Bread - 3.00 PLN
3. Cheese - 8.99 PLN

> 2

Enter product ID: 1
Enter quantity: 2

Product added to cart.

> 4

Your cart:
- Milk x2 - 9.00 PLN

> 5

Order confirmed. Thank you!
