import java.util.ArrayList;
import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = FileHandler.loadProducts();

        System.out.println("Welcome to Gurmehak's Shop!");
        System.out.print("Enter your E-mail : ");
        String mail = scanner.nextLine();

        System.out.println("Are you a member? (y/n): ");
        String memberResponse = scanner.nextLine();
        User user;
        if (memberResponse.equalsIgnoreCase("y")) {
            user = new MemberUser(mail);
        } else {
            user = new RegularUser(mail);
        }

        ShoppingCart cart = new ShoppingCart(user);

        while (true) {
            System.out.println("\n1. Products Available");
            System.out.println("2. Add a Product to your Cart");
            System.out.println("3. See what's in your cart");
            System.out.println("4. Checkout to complete order");
            System.out.println("5. Exit system");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Displaying available products
                    System.out.println("Available Products:");
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;

                case 2:
                    // Adding requested product to cart
                    System.out.print("Enter the digit corresponding to the product you want to add to cart: ");
                    int productId = scanner.nextInt();
                    Product selectedProduct = findProductById(products, productId);
                    if (selectedProduct != null) {
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        cart.addProduct(selectedProduct, quantity);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    // View the products in cart
                    cart.viewCart();
                    break;

                case 4:
                    // Checkout the order
                    double total = cart.checkout();
                    System.out.printf("Checkout complete! Total amount: $%.2f\n", total);
                    FileHandler.saveProducts(products);
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Thank you for shopping at Gurmehak's shop!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Created a helper method to find the product by number (id)
    private static Product findProductById(ArrayList<Product> products, int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
