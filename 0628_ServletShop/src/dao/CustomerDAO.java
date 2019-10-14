package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Customer;

public class CustomerDAO {

	public boolean insertCustomer(Customer c) {
		Connection con = ConnectionManager.getConnection();

		String sql = "";
		sql += "INSERT INTO CUSTOMER VALUES";
		sql += " (";
		sql += "?,";
		sql += "?,";
		sql += "?,";
		sql += "?,";
		sql += "?,";
		sql += "?,";
		sql += "SYSDATE";
		sql += " )";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getCustomerId());
			pst.setString(2, c.getCustomerPw());
			pst.setString(3, c.getName());
			pst.setString(4, c.getPhone());
			pst.setString(5, c.getBirthdate());
			pst.setString(6, c.getAddress());
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

	public Customer selectCustomer(Customer c) {
		Customer result = null;
		Connection con = ConnectionManager.getConnection();

		String sql = "";
		sql += "SELECT CUSTOMERID,CUSTOMERPW FROM CUSTOMER ";
		sql += " WHERE";
		sql += " CUSTOMERID=? AND ";
		sql += " CUSTOMERPW=?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getCustomerId());
			pst.setString(2, c.getCustomerPw());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);

				result = new Customer(id, pw, null, null, null, null, null);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		return result;

	}

	public boolean deleteCustomer(Customer c) {
		Connection con = ConnectionManager.getConnection();

		String sql = "";
		sql += "DELETE CUSTOMER WHERE ";
		sql += " CUSTOMERID=? AND ";
		sql += " CUSTOMERPW=?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getCustomerId());
			pst.setString(2, c.getCustomerPw());
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

}
