package VO;

public class Cake extends Bread {
	private int size; // Å©±â

	public Cake() {
		super();
	}

	public Cake(String name, int price, int size) {
		super(name, price);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return super.toString() + " È£=" + size;
	}
}
