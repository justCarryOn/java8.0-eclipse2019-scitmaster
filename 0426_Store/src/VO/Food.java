package VO;

public class Food extends Product {
	private int calorie;
	private String dueDate;
	public Food() {
		super();
	}
	public Food(String name, String pCode, int number, int price, int calorie, String dueDate) {
		super(name, pCode, number, price);
		this.calorie = calorie;
		this.dueDate = dueDate;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	public String getdueDate() {
		return dueDate;
	}
	public void setdueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return super.toString()+ ", 칼로리=" + calorie + ", 유통기한=" + dueDate;
	}
}
