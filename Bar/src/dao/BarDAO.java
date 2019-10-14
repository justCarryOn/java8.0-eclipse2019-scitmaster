package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Customer;
import vo.Drink;
import vo.Ingredient;

public class BarDAO {

	public boolean insertIngredient(Ingredient ing) {// �썝猷뚮벑濡�
		boolean result = true;
		Connection con = ConnectionManager.getConnection();

		String sql = "	INSERT INTO INGREDIENTS " + " (INGREDIENTSEQ, INGREDIENTNAME, INGREDIENTCOMMENT) " + " VALUES "
				+ " (INGREDIENTSEQ.NEXTVAL,?,?) ";

		PreparedStatement pst;
		try {

			pst = con.prepareStatement(sql);
			pst.setString(1, ing.getIngredientName());
			pst.setString(2, ing.getIngredientComment());

			int inserted = pst.executeUpdate();

			if (inserted != 1) {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = false;
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<Ingredient> selectAllIngredient() {// �썝猷뚯꽑�깮
		ArrayList<Ingredient> ingredientList = new ArrayList<>();

		Connection con = ConnectionManager.getConnection();

		String sql = "	SELECT  INGREDIENTSEQ, INGREDIENTNAME, INGREDIENTCOMMENT FROM INGREDIENTS ";
		PreparedStatement pst;
		try {

			pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String seq = rs.getString(1);
				String name = rs.getString(2);
				String comment = rs.getString(3);

				ingredientList.add(new Ingredient(seq, name, comment));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ingredientList;
		}

		return ingredientList;
	}

	public boolean insertDrink(Drink d) {
		boolean result = true;
		Connection con = ConnectionManager.getConnection();

		String sql = "	INSERT INTO DRINKS " + " (DRINKNAME, DRINKCOMMENT, PRICE, INDATE) " + " VALUES "
				+ " (?,?,?,SYSDATE) ";

		PreparedStatement pst;
		PreparedStatement recipePst;

		try {
			con.setAutoCommit(false);

			pst = con.prepareStatement(sql);

			pst.setString(1, d.getDrinkName());
			pst.setString(2, d.getDrinkComment());
			pst.setInt(3, d.getPrice());
			int inserted = pst.executeUpdate();

			if (inserted == 1) {

				ArrayList<Ingredient> ingList = d.getIngredientList();
				String insertRecipe = "" + "INSERT INTO RECIPES"
						+ " (RECIPESEQ,DRINKNAME,INGREDIENTSEQ,QUANTITY,INDATE)" + "VALUES "
						+ " (RECIPESEQ.NEXTVAL,?,?,?,SYSDATE)";

				recipePst = con.prepareStatement(insertRecipe);

				for (Ingredient ingredient : ingList) {

					recipePst.setString(1, d.getDrinkName());
					recipePst.setString(2, ingredient.getIngredientSeq());
					recipePst.setInt(3, ingredient.getQuantity());

					recipePst.executeUpdate();
				}

				con.commit();
				con.setAutoCommit(true);

			} else {
				result = false;
				con.rollback();
				con.setAutoCommit(true);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = false;
			e.printStackTrace();
		}

		return result;
	}

	public Drink selectDrink(String drinkName) {
		Drink result = null;

		ArrayList<Ingredient> ingredientList = new ArrayList<>();

		Connection con = ConnectionManager.getConnection();

		String sql = "	SELECT  DRINKNAME, DRINKCOMMENT, PRICE, INDATE FROM DRINKS WHERE DRINKNAME=?";
		PreparedStatement pst;
		PreparedStatement recipePst;

		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, drinkName);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {

				String drinkname = rs.getString(1);
				String drinkComment = rs.getString(2);
				int price = rs.getInt(3);
				String indate = rs.getString(4);

				result=new Drink(drinkname,drinkComment,price,indate);
				
				
				String recipeSql = "	SELECT  I.INGREDIENTSEQ, I.INGREDIENTNAME, I.INGREDIENTCOMMENT, R.QUANTITY "
						+ "FROM INGREDIENTS I, RECIPES R "
						+ "WHERE I.INGREDIENTSEQ=R.INGREDIENTSEQ AND DRINKNAME=?";
				recipePst=con.prepareStatement(recipeSql);
				recipePst.setString(1, drinkName);
				ResultSet recipeRs = recipePst.executeQuery();
				
				while(recipeRs.next()){

					String ingredientSeq=recipeRs.getString(1);
					String ingredientName=recipeRs.getString(2);
					String ingredientComment=recipeRs.getString(3);
					int quantity=recipeRs.getInt(4);
					
					result.getIngredientList().add(new Ingredient(ingredientSeq,ingredientName,ingredientComment,quantity));
				}
				
			}else {
				
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return result;
	}
	
	public ArrayList<Drink> selectAllDrink(){
		ArrayList<Drink> drinkList = new ArrayList<>();

		Connection con = ConnectionManager.getConnection();

		String sql = "	SELECT  DRINKNAME, DRINKCOMMENT, PRICE, INDATE FROM DRINKS ";
		PreparedStatement pst;
		try {

			pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String drinkName = rs.getString(1);
				String drinkComment = rs.getString(2);
				int price = rs.getInt(3);
				String indate = rs.getString(4);

				drinkList.add(new Drink(drinkName, drinkComment, price,indate));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return drinkList;
		}

		return drinkList;
	}
	public boolean sellDrink(Customer c){
		insertCustomer(c.getCustomerId());
		boolean result = true;
		Connection con = ConnectionManager.getConnection();

		String sql = "	INSERT INTO SOLD "
				+ " (SOLDSEQ,CUSTOMERID,DRINKNAME,QUANTITY) " 
				+ " VALUES "
				+ " (SOLDSEQ.NEXTVAL,?,?,?) ";

		PreparedStatement pst;
		try {
			
			
			pst = con.prepareStatement(sql);
			pst.setString(1, c.getCustomerId());
			pst.setString(2, c.getDrinkList().get(0).getDrinkName());
			pst.setInt(3, c.getDrinkList().get(0).getQuantity());

			int inserted = pst.executeUpdate();

			if (inserted != 1) {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = false;
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	public boolean insertCustomer(String customerId){
		boolean result = true;
		Connection con = ConnectionManager.getConnection();

		String sql = "	INSERT INTO CUSTOMERS "
				+ " (CUSTOMERID) " 
				+ " VALUES "
				+ " (?) ";

		PreparedStatement pst;
		try {

			pst = con.prepareStatement(sql);
			pst.setString(1, customerId);

			int inserted = pst.executeUpdate();

			if (inserted != 1) {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = false;
		}
		return result;
		
	}
	
	
	public ArrayList<Customer> selectAllSold(){
		ArrayList<Customer> result=new ArrayList<Customer>();
		Connection con = ConnectionManager.getConnection();

		String sql = "	SELECT C.CUSTOMERID, S.DRINKNAME, S.QUANTITY, S.QUANTITY*D.PRICE "
				+ " FROM CUSTOMERS C, SOLD S, DRINKS D " 
				+ " WHERE "
				+ " D.DRINKNAME=S.DRINKNAME AND S.CUSTOMERID=C.CUSTOMERID "
				+ " ORDER BY"
				+ " TO_NUMBER(S.SOLDSEQ) DESC";

		PreparedStatement pst;
		try {
			pst=con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {

				String customerId = rs.getString(1);
				String drinkName = rs.getString(2);
				int quantity = rs.getInt(3);
				int total=rs.getInt(4);

				Customer c=new Customer(customerId,total);
				Drink d=new Drink();
				d.setDrinkName(drinkName);
				d.setQuantity(quantity);
				c.getDrinkList().add(d);
				result.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		return result;
		
	}
}
