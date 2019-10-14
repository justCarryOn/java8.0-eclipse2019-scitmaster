package VO;

public class Note extends Product {
	private int noPage; // ��������

	public Note() {
		super();
	}

	public Note(String name, String pCode, int price, int noPage) {
		super(name, pCode, price);
		this.noPage = noPage;
	}

	public int getNoPage() {
		return noPage;
	}

	public void setNoPage(int noPage) {
		this.noPage = noPage;
	}

	@Override
	public String toString() {
		return super.toString() + ", ��������=" + noPage;
	}
}
