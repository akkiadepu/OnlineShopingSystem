package com.codegnan.app;

public class Product {
	
	    private int id;
	    private String name;
	    private double price;

	    public Product(int id, String name, double price) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	    }

	    public int getId() { return id; }
	    public String getName() { return name; }
	    public double getPrice() { return price; }

	    @Override
	    public String toString() {
	        return id + "," + name + "," + price;
	    }

	    public static Product fromString(String productString) {
	        String[] parts = productString.split(",");
	        return new Product(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]));
	    }
	}



