package VO;

public class Roll extends Bread {
	private int lentgth; // 길이

	public Roll() {
		super();
	}

	public Roll(String name, int price, int lentgth) {
		super(name, price);
		this.lentgth = lentgth;
	}

	public int getLentgth() {
		return lentgth;
	}

	public void setLentgth(int lentgth) {
		this.lentgth = lentgth;
	}

	@Override
	public String toString() {
		return super.toString()+ " 길이=" + lentgth;
	}
}
