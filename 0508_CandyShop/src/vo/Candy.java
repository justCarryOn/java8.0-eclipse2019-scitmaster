package vo;

import java.io.Serializable;

public class Candy implements Serializable{
	private String name;
	private String color;
	private int amount;
	private String flavor;
	private String pCode;
	public Candy() {
		super();
	}
	public Candy(String name, String color, int amount, String flavor, String pCode) {
		super();
		this.name = name;
		this.color = color;
		this.amount = amount;
		this.flavor = flavor;
		this.pCode = pCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	@Override
	public String toString() {
		return "이름=" + name + ", 색상=" + color + ", 수량=" + amount + ", 맛=" + flavor + ", 제품코드="
				+ pCode;
	}
}
