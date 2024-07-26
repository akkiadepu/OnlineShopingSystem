package com.codegnan.app;
import java.util.ArrayList;
import java.util.List;

public class Cart {



	    private List<Product> products;

	    public Cart() {
	        products = new ArrayList<>();
	    }

	    public void addProduct(Product product) {
	        products.add(product);
	    }

	    public List<Product> getProducts() {
	        return products;
	    }

	    public double getTotalPrice() {
	        double total = 0;
	        for (Product product : products) {
	            total += product.getPrice();
	        }
	        return total;
	    }

	    public void clear() {
	        products.clear();
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        for (Product product : products) {
	            sb.append(product.toString()).append("\n");
	        }
	        return sb.toString();
	    }

	    public static Cart fromString(String cartString) {
	        Cart cart = new Cart();
	        String[] lines = cartString.split("\n");
	        for (String line : lines) {
	            if (!line.isEmpty()) {
	                cart.addProduct(Product.fromString(line));
	            }
	        }
	        return cart;
	    }
	}



