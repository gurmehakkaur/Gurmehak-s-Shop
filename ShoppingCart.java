import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> cart;
    private User user;

    public ShoppingCart(User user) {
        this.user = user;
        this.cart = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        if (product.getStock() >= quantity) {
            product.reduceStock(quantity);
            for (int i = 0; i < quantity; i++) {
                cart.add(product);
            }
            System.out.println(quantity + " " + product.getName() + "(s) are added to cart.");
        } else {
            System.out.println("Unfortunately, only  " + product.getStock() + " item(s) available.");
        }
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("You haven't put anything in the cart.");
        } else {
            double total = 0;
            System.out.println("Your carthas following items:");
            for (Product product : cart) {
                System.out.println(product);
                total += product.getPrice();
            }

            // Applying discount if user has membership
            total = user.applyDiscount(total);
            System.out.printf("Total (after any discount): $%.2f\n", total);
        }
    }

    public double checkout() {
        double total = 0;
        for (Product product : cart) {
            total += product.getPrice();
        }
        total = user.applyDiscount(total);
        cart.clear();
        return total;
    }
}
