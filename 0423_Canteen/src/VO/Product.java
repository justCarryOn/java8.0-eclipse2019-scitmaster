package VO;

public class Product {
	private String name, pCode; // ��ǰ��,��ǰ�ڵ�
	private int price; // ����

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
		return "��ǰ��=" + name + ", ��ǰ�ڵ�=" + pCode + ", ����=" + price;
	}
}
