package com.codegnan.app;
import java.util.Scanner;

public class OnlineShoppingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        ProductManager productManager = new ProductManager();
		        OrderManager orderManager = new OrderManager();
		        Cart cart = new Cart();
		        Scanner scanner = new Scanner(System.in);

		        while (true) {
		            System.out.println("\nOnline Shopping System");
		            System.out.println("1. Browse Products");
		            System.out.println("2. Add Product to Cart");
		            System.out.println("3. View Cart");
		            System.out.println("4. Process Order");
		            System.out.println("5. Exit");
		            System.out.print("Enter your choice: ");
		            int choice = scanner.nextInt();

		            switch (choice) {
		                case 1:
		                    System.out.println("Products:");
		                    for (Product product : productManager.getProducts()) {
		                        System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice());
		                    }
		                    break;
		                case 2:
		                    System.out.print("Enter product ID to add to cart: ");
		                    int id = scanner.nextInt();
		                    Product product = productManager.findProductById(id);
		                    if (product != null) {
		                        cart.addProduct(product);
		                        System.out.println("Product added to cart.");
		                    } else {
		                        System.out.println("Product not found.");
		                    }
		                    break;
		                case 3:
		                    System.out.println("Cart Contents:");
		                    for (Product p : cart.getProducts()) {
		                        System.out.println(p.getName() + " - $" + p.getPrice());
		                    }
		                    System.out.println("Total Price: $" + cart.getTotalPrice());
		                    break;
		                case 4:
		                    orderManager.processOrder(cart);
		                    cart.clear();
		                    System.out.println("Order processed successfully.");
		                    break;
		                case 5:
		                    System.out.println("Exiting...");
		                    scanner.close();
		                    System.exit(0);
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		            }
		        }
		    }
}


	


