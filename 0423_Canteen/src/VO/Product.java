package VO;

public class Product {
	private String name, pCode; // 상품명,제품코드
	private int price; // 가격

	public Product() {
		super();
	}

	public Product(String name, String pCode, int price) {
		super();
		this.name = name;
		this.pCode = pCode;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "상품명=" + name + ", 제품코드=" + pCode + ", 가격=" + price;
	}
}
