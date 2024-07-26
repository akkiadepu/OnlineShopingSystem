package com.codegnan.app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ProductManager {

	
	    private List<Product> products;
	    private static final String FILE_NAME = "products.txt";

	    public ProductManager() {
	        products = new ArrayList<>();
	        loadProducts();
	    }

	    public List<Product> getProducts() {
	        return products;
	    }

	    public Product findProductById(int id) {
	        for (Product product : products) {
	            if (product.getId() == id) {
	                return product;
	            }
	        }
	        return null;
	    }

	    private void loadProducts() {
	        try (FileInputStream fis = new FileInputStream(FILE_NAME);
	             BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                products.add(Product.fromString(line));
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("No existing products found.");
	        } catch (IOException e) {
	            System.out.println("Error loading products: " + e.getMessage());
	        }
	    }

	    public void saveProducts() {
	        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
	             PrintWriter writer = new PrintWriter(fos)) {
	            for (Product product : products) {
	                writer.println(product.toString());
	            }
	        } catch (IOException e) {
	            System.out.println("Error saving products: " + e.getMessage());
	        }
	    }
	}



