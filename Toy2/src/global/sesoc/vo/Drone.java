package global.sesoc.vo;

public class Drone{
	private int serialNum;
	private String name;
	private int price;
	private int wingCount;

	public Drone() {
		// TODO Auto-generated constructor stub
	}
	public Drone(int serialNum, String name, int price, int wingCount) {
		super();
		this.serialNum = serialNum;
		this.name = name;
		this.price = price;
		this.wingCount = wingCount;
	}
	public int getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getWingCount() {
		return wingCount;
	}
	public void setWingCount(int wingCount) {
		this.wingCount = wingCount;
	}
	@Override
	public String toString() {
		return "[��� : ������ȣ = " + serialNum + ", �̸� = " + name + ", ���� = " +String.format("%,6d",price) + "��" + ", ���� ��=" + wingCount + "]";
	}
}
