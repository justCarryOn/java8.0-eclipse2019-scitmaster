package VO;

public class Medicine extends Product {
	private String kind, shelfLife;

	public Medicine() {
		super();
	}

	public Medicine(String name, String pCode, int number, int price, String kind, String shelfLife) {
		super(name, pCode, number, price);
		this.kind = kind;
		this.shelfLife = shelfLife;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}

	@Override
	public String toString() {
		return super.toString()+", 약종류=" + kind + ", 유효기간=" + shelfLife;
	}
	
}
