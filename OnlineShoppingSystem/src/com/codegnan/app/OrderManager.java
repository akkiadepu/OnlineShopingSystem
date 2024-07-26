package com.codegnan.app;

import java.io.*;
public class OrderManager {



	    private static final String ORDER_FILE_NAME = "orders.txt";

	    public void processOrder(Cart cart) {
	        try (FileOutputStream fos = new FileOutputStream(ORDER_FILE_NAME, true);
	             PrintWriter writer = new PrintWriter(fos)) {
	            writer.println("New Order:");
	            writer.println(cart.toString());
	            writer.println("Total Price: " + cart.getTotalPrice());
	            writer.println("------------------------------");
	        } catch (IOException e) {
	            System.out.println("Error processing order: " + e.getMessage());
	        }
	    }
	}


