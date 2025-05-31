import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();

        int choice;
        do {
            System.out.println("\n==== Inventory Management System ====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Delete Product");
            System.out.println("5. Search Product by ID");
            System.out.println("6. Search Product by Name");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    Product p = new Product(id, name, qty, price);
                    manager.addProduct(p);
                    break;
                case 2:
                    manager.viewAllProducts();
                    break;
                case 3:
                    System.out.print("Enter Product ID to Update Quantity: ");
                    int upId = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();
                    manager.updateProductQuantity(upId, newQty);
                    break;
                case 4:
                    System.out.print("Enter Product ID to Delete: ");
                    int delId = sc.nextInt();
                    manager.deleteProduct(delId);
                    break;
                case 5:
                    System.out.print("Enter Product ID to Search: ");
                    int searchId = sc.nextInt();
                    Product searchProduct = manager.searchProductById(searchId);
                    if (searchProduct != null) {
                        searchProduct.display();
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter Product Name to Search: ");
                    String searchName = sc.nextLine();
                    Product searchByName = manager.searchProductByName(searchName);
                    if (searchByName != null) {
                        searchByName.display();
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);
    }
}
