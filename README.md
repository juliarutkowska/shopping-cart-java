# JavaMarkt Shopping Cart (Java CLI Project)

This is a command-line shopping cart system developed in Java, designed for the JavaMarkt online store. The project demonstrates advanced object-oriented principles, design patterns, and implements complex promotion logic.

🚀 **Features**

- Add and manage products in a shopping cart  
- Apply various dynamic promotions and discounts:  
  - 5% discount on orders over 300 PLN  
  - Free third cheapest product when buying at least three items  
  - Free branded mug for orders over 200 PLN  
  - One-time 30% coupon for selected products  
- Automatically find the optimal order of applying promotions for maximum savings  
- Sort products by price or name dynamically  
- Clean, extensible design using SOLID principles and Command pattern  
- Unit tested with JUnit 5 for reliability

🛠️ **Technologies**

- Java 17 (standard libraries)  
- Command Line Interface (CLI)  
- JUnit 5 for unit testing

🎓 **Context**

This project was developed as part of my learning journey in Java programming. It emphasizes clean code, design patterns like Command, and principles such as SOLID. The application simulates a realistic shopping cart with promotion logic, preparing me for enterprise-grade software development.

📸 **Sample Output**

Applied promotions in optimal order:

5% discount over 300 PLN

Free third cheapest product

Free branded mug for orders over 200 PLN

30% coupon for product: Mouse

Final products with discounted prices:

Laptop: 2500.00 PLN → 2375.00 PLN (5% discount)
Mouse: 100.00 PLN → 70.00 PLN (30% coupon)
Mug: 25.00 PLN → 0.00 PLN (free mug)
Keyboard: 200.00 PLN → 0.00 PLN (free third cheapest product)


