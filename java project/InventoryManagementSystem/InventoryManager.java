import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Product added successfully!");
    }

    public void viewAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("\nProduct List:");
        for (Product p : products) {
            p.display();
        }
    }

    public Product searchProductById(int productId) {
        for (Product p : products) {
            if (p.getProductId() == productId) {
                return p;
            }
        }
        return null;
    }

    public Product searchProductByName(String name) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public void deleteProduct(int productId) {
        Product p = searchProductById(productId);
        if (p != null) {
            products.remove(p);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void updateProductQuantity(int productId, int quantity) {
        Product p = searchProductById(productId);
        if (p != null) {
            p.setQuantity(quantity);
            System.out.println("Quantity updated successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }
}
