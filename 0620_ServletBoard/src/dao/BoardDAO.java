package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Member;

public class BoardDAO {

	ConnectionManager conn;

	public boolean insertMember(Member mem) {
		boolean flag = true;

		Connection con = conn.getConnection();

		String sql = "INSERT INTO BOARDMEMBER VALUES(";
		sql += "?,";
		sql += "?";
		sql += ")";

		try {
			PreparedStatement ptst = con.prepareStatement(sql);
			ptst.setString(1, mem.getId());
			ptst.setString(2, mem.getPw());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
			return flag;
		}
		return flag;
	}

	public Member selectMember(Member mem) {
		Member result = null;

		Connection con = conn.getConnection();

		String sql = "SELECT ID,PW FROM BOARDMEMBER WHERE ";
		sql += "ID=?";
		sql += " AND ";
		sql += "PW=?";

		try {
			PreparedStatement ptst = con.prepareStatement(sql);
			ptst.setString(1, mem.getId());
			ptst.setString(2, mem.getPw());
			
			ResultSet rs=ptst.executeQuery();
			
			String resultId=null;
			String resultPw=null;
			
			while(rs.next()) {
				resultId=rs.getString(1);
				resultPw=rs.getString(2);
			}
			
			if(resultId!=null&&resultPw!=null) {
				result=new Member(resultId,resultPw,null,null,null);
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
	
	
	public boolean deleteMember(Member mem) {
		boolean flag = true;

		Connection con = conn.getConnection();

		String sql = "DELETE BOARDMEMBER WHERE ";
		sql += " ID=? ";
		sql += " AND ";
		sql += " PW=? ";

		try {
			PreparedStatement ptst = con.prepareStatement(sql);
			ptst.setString(1, mem.getId());
			ptst.setString(2, mem.getPw());
			int result=ptst.executeUpdate();
			
			if(result==1) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
			return flag;
		}
	}

}
