package main;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private int id;
	private String name;
	private List<Product> products = new ArrayList<Product>();
	
	public Category(String name) {
		this.name = name;
	}
	
	public Category(int id, String name) {
		this(name);
		this.id = id;		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}

	@Override
	public String toString() {
		return String.format("<%d> %s", this.id, this.name);
	}
}
