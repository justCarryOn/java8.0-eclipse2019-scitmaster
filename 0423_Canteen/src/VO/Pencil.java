package VO;

public class Pencil extends Product {
	private String kind; // 심 종류

	public Pencil(String name, String pCode, int price, String kind) {
		super(name, pCode, price);
		this.kind = kind;
	}

	public Pencil() {
		super();
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return super.toString() + ", 심 종류=" + kind;
	}
}
