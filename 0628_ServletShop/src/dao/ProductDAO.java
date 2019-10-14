package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Customer;
import vo.Product;
import vo.Sold;

public class ProductDAO {

	public boolean insertProduct(Product p) {
		Connection con = ConnectionManager.getConnection();

		String sql = "";
		sql += "INSERT INTO PRODUCT VALUES";
		sql += " (";
		sql += "PRODUCTSEQ.NEXTVAL,";
		sql += "?,";
		sql += "?,";
		sql += "?,";
		sql += "?,";
		sql += "SYSDATE";
		sql += " )";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, p.getName());
			pst.setInt(2, p.getQuantity());
			pst.setInt(3, p.getPrice());
			pst.setString(4, p.getComments());
			int result = pst.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean insertSold(Sold s) {
		Connection con = ConnectionManager.getConnection();

		
		String sql = "";
		sql += "INSERT INTO SOLD VALUES";
		sql += " (";
		sql += "SOLDSEQ.NEXTVAL,";
		sql += "?,";
		sql += "?,";
		sql += "?,";
		sql += "SYSDATE";
		sql += " )";

		try {
			con.setAutoCommit(false);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getCustomerId());
			pst.setString(2, s.getProductSeq());
			pst.setInt(3, s.getQuantity());
			if(checkQuantity(s)) {
				pst.executeUpdate();
				con.commit();
				con.setAutoCommit(true);
			}else {
				con.rollback();
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public ArrayList<Product> selectMyList(String customerId){
		ArrayList<Product> pList = new ArrayList<>();

		Connection con = ConnectionManager.getConnection();
		String sql = "SELECT P.NAME, P.PRICE, S.QUANTITY, S.INDATE " + 
				" " + 
				"FROM PRODUCT P, SOLD S " + 
				"WHERE P.PRODUCTSEQ=S.PRODUCTSEQ AND S.CUSTOMERID= ? ORDER BY INDATE DESC";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, customerId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String name = rs.getString(1);
				int price = rs.getInt(2);
				int quantity = rs.getInt(3);
				String indate = rs.getString(4);
				pList.add(new Product(null, name, quantity, price, null, indate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return pList;
		}
		return pList;
	}
	public ArrayList<Product> selectAllSoldList(){
		ArrayList<Product> pList = new ArrayList<>();

		Connection con = ConnectionManager.getConnection();
		String sql = "SELECT P.NAME, P.PRICE, S.QUANTITY, S.INDATE, S.CUSTOMERID " + 
				" " + 
				"FROM PRODUCT P, SOLD S " + 
				"WHERE P.PRODUCTSEQ=S.PRODUCTSEQ ORDER BY INDATE DESC";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String name = rs.getString(1);
				int price = rs.getInt(2);
				int quantity = rs.getInt(3);
				String indate = rs.getString(4);
				String id = rs.getString(5);
				Product p=new Product(null, name, quantity, price, null, indate);
				p.setCustomerId(id);
				pList.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return pList;
		}
		return pList;
	}

	public boolean checkQuantity(Sold s) {
		int quantity = 0;
		Connection con = ConnectionManager.getConnection();
		String sql = "SELECT QUANTITY FROM PRODUCT WHERE PRODUCTSEQ=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getProductSeq());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				quantity = rs.getInt(1);
			}
			
			if (quantity < 1) {
				return false;
			} else if (quantity - s.getQuantity() < 0) {
				return false;
			} else {
				Product p = new Product();
				p.setQuantity(quantity - s.getQuantity());
				p.setProductSeq(s.getProductSeq());
				updateProduct(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList<Product> selectAllProduct() {
		ArrayList<Product> pList = new ArrayList<>();

		Connection con = ConnectionManager.getConnection();
		String sql = "SELECT PRODUCTSEQ,NAME,QUANTITY,PRICE,COMMENTS,INDATE FROM PRODUCT";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String productSeq = rs.getString(1);
				String name = rs.getString(2);
				int quantity = rs.getInt(3);
				int price = rs.getInt(4);
				String comments = rs.getString(5);
				String indate = rs.getString(6);
				pList.add(new Product(productSeq, name, quantity, price, comments, indate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return pList;
		}
		return pList;
	}

	public Product selectProduct(String productSeq) {
		Product p = null;

		Connection con = ConnectionManager.getConnection();
		String sql = "SELECT PRODUCTSEQ,NAME,QUANTITY,PRICE,COMMENTS,INDATE FROM PRODUCT" + " WHERE PRODUCTSEQ=?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, productSeq);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String productNewSeq = rs.getString(1);
				String name = rs.getString(2);
				int quantity = rs.getInt(3);
				int price = rs.getInt(4);
				String comments = rs.getString(5);
				String indate = rs.getString(6);
				p = new Product(productSeq, name, quantity, price, comments, indate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return p;
		}
		return p;
	}

	public boolean updateProduct(Product p) {
		boolean result = true;

		Connection con = ConnectionManager.getConnection();
		String sql = "UPDATE PRODUCT SET QUANTITY=? WHERE PRODUCTSEQ=?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, p.getQuantity());
			pst.setString(2, p.getProductSeq());
			int updated = pst.executeUpdate();
			if (updated == 1) {
				return result;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
	}

}
