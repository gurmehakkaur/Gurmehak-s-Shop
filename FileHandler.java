import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private static final String FILE_PATH = "products.txt";

    public static ArrayList<Product> loadProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] details = line.split(",");
                int id = Integer.parseInt(details[0]);
                String name = details[1];
                double price = Double.parseDouble(details[2]);
                int stock = Integer.parseInt(details[3]);
                products.add(new Product(id, name, price, stock));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Product file not found.");
        }
        return products;
    }

    public static void saveProducts(ArrayList<Product> products) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Product product : products) {
                writer.println(product.getId() + "," + product.getName() + "," + product.getPrice() + ","
                        + product.getStock());
            }
        } catch (IOException e) {
            System.out.println("Error saving products.");
        }
    }
}
