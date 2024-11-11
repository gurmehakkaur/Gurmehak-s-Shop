## Shopping Console App

# Overview
I created a website for a fictional store "Gurmehak's Shop", allowing users to view available products, put required items into cart, apply membership discount 
and checkout. I have implemented modular design to ensure code is easy-to-maintain and scalable. 
Importantly, I created this project to showcase my skills in Object Oriented Programming in JAVA.

## Classes Made

### 1. **MainClass**
- The entry point of the application.Displays the main menu, and calls functions accrodingly- input for product browsing, adds items to the cart, and manages the checkout process.

### 2. **Product**
- Represents an individual product available for purchase in the store.
- **Attributes**: 
  - `String name`: The name of the product.
  - `double price`: The price of the product.
  - `int stock`: The available quantity of the product.
- **Methods**: 
  - `getDetails()`: Returns the product's details for display.
  - `updateStock(int quantity)`: Adjusts the stock level after a purchase.

### 3. **User (Abstract Class)**
- Base class for different user types.
- **Attributes**: 
  - `String name`: The name of the user.
- **Methods**: 
  - `getName()`: Returns the user's name.
  - `applyDiscount(double total)`: Abstract method for subclasses to implement their discount logic.

### 4. **RegularUser**
- For users who do not receive any discounts on their purchases.
- **Methods**: 
  - `applyDiscount(double total)`: Returns the total amount without applying any discounts.

### 5. **MemberUser**
- For users with a membership and eligible for discounts on purchases.
- **Attributes**: 
  - static final double DISCOUNT_RATE: The membership discount rate (e.g., 10%).
- **Methods**: 
  - `applyDiscount(double total)`: Applies the membership discount and returns the new total.


## Technologies Used
- **Programming Language**: Java
- **Development Environment**: Any IDE or text editor that supports Java (e.g., IntelliJ IDEA, Eclipse, VS Code)
- **File I/O**: For storing and retrieving product inventory

## Getting Started

### Prerequisites
- Java Development Kit (JDK) installed on your machine. 

### How to Run the Application
1. Clone this repository:
   
   git clone https://github.com/gurmehakkaur/Gurmehak-s-Shop

2. Navigate to the project directory:

   cd Gurmehak-s-Shop

3. Compile the Java files:

   javac *.java

4. Run the application:

   java MainClass
