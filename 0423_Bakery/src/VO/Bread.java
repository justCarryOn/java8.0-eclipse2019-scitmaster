package VO;

public class Bread {
	private String name; // ªß¿Ã∏ß
	private int price; // ∞°∞›
	public Bread() {
		super();
	}
	public Bread(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ªß¿Ã∏ß=" + name + ", ∞°∞›=" + price;
	}
	
	
}
