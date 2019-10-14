package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Admin;
import vo.Customer;

public class AdminDAO {

	public Admin selectAdmin(Admin a) {
		Admin result = null;
		Connection con = ConnectionManager.getConnection();

		String sql = "";
		sql += "SELECT ADMINID,ADMINPW FROM ADMIN ";
		sql += " WHERE";
		sql += " ADMINID=? AND ";
		sql += " ADMINPW=?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, a.getAdminId());
			pst.setString(2, a.getAdminPw());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);

				result = new Admin(id, pw);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		return result;

	}

}
