package service;

import java.util.ArrayList;

import dao.BarDAO;
import vo.Customer;
import vo.Drink;
import vo.Ingredient;

public class BarService {

	private BarDAO dao = new BarDAO();

	public boolean insertIngredient(Ingredient ing) {
		return dao.insertIngredient(ing);
	}

	public ArrayList<Ingredient> selectAllIngredient() {
		return dao.selectAllIngredient();
	}

	public boolean insertDrink(Drink d) {

		return dao.insertDrink(d);
	}

	public Drink selectDrink(String drinkName) {
		return dao.selectDrink(drinkName);
	}

	public ArrayList<Drink> selectAllDrink() {

		return dao.selectAllDrink();
	}

	public boolean insertCustomer(String customerId) {
		return dao.insertCustomer(customerId);
	}

	public boolean sellDrink(Customer c) {
		return dao.sellDrink(c);
	}

	public ArrayList<Customer> selectAllSold() {
		return dao.selectAllSold();
	}
}
