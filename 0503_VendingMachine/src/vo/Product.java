package vo;

public class Product {

	private String name;// 제품명
	private String pCode;// 제품코드
	private int price;// 가격
	private int amount;// 현재수량

	public Product(String name, String pCode, int price, int amount) {
		super();
		this.name = name;
		this.pCode = pCode;
		this.price = price;
		this.amount = amount;
	}

	public Product() {
		super();
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 제품코드=" + pCode + ", 가격=" + price + ", 현재수량=" + amount;
	}

}
