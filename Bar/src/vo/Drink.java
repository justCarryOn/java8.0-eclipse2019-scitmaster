package vo;

import java.util.ArrayList;

public class Drink {

	private String drinkName;
	private String drinkComment;
	private int price;
	private String indate;
	private int quantity;

	private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();// 원료들

	public Drink() {
		super();
	}

	public Drink(String drinkName, String drinkComment, int price, String indate) {
		super();
		this.drinkName = drinkName;
		this.drinkComment = drinkComment;
		this.price = price;
		this.indate = indate;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public String getDrinkComment() {
		return drinkComment;
	}

	public void setDrinkComment(String drinkComment) {
		this.drinkComment = drinkComment;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ArrayList<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "술이름=" + drinkName + ", 설명=" + drinkComment + ", 가격=" + price + "원";
	}

}
