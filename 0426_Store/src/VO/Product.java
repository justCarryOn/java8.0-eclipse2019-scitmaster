package VO;

public class Product {
	private String name, pCode;
	private int number, price;

	public Product() {
		super();
	}

	public Product(String name, String pCode, int number, int price) {
		super();
		this.name = name;
		this.pCode = pCode;
		this.number = number;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 제품코드=" + pCode + ", 수량=" + number + ", 가격=" + price;
	}
}
