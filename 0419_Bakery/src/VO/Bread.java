package VO;

public class Bread {
	private String name, bsn, maker;
	private int price;

	public Bread() {
		super();
	}

	public Bread(String name, String bsn, String maker, int price) {
		super();
		this.name = name;
		this.bsn = bsn;
		this.maker = maker;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBsn() {
		return bsn;
	}

	public void setBsn(String bsn) {
		this.bsn = bsn;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void print() {
		System.out.println(name + " " + bsn + " " + maker + " " + price);
	}
}
