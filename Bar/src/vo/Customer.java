package vo;

import java.util.ArrayList;

public class Customer {

	private String customerId;
	private int total;

	private ArrayList<Drink> drinkList = new ArrayList<Drink>();

	public Customer(String customerId) {
		super();
		this.customerId = customerId;
	}

	public Customer(String customerId, int total) {
		super();
		this.customerId = customerId;
		this.total = total;
	}

	public Customer() {
		super();
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public ArrayList<Drink> getDrinkList() {
		return drinkList;
	}

	public void setDrinkList(ArrayList<Drink> drinkList) {
		this.drinkList = drinkList;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "손님아이디=" + customerId;
	}

}
