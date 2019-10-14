package VO;

public class Pencil extends Product {
	private String kind; // �� ����

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
		return super.toString() + ", �� ����=" + kind;
	}
}
