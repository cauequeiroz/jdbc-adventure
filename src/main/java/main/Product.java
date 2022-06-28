package main;

public class Product {
	private int id;
	private String name;
	private String description;
	
	public Product(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Product(int id, String name, String description) {
		this(name, description);
		this.id = id;		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		return String.format("[%d] %s: %s", this.id, this.name, this.description);
	}
}
