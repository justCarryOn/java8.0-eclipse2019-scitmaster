package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Board;
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

			ResultSet rs = ptst.executeQuery();

			String resultId = null;
			String resultPw = null;

			while (rs.next()) {
				resultId = rs.getString(1);
				resultPw = rs.getString(2);
			}

			if (resultId != null && resultPw != null) {
				result = new Member(resultId, resultPw);
			} else {
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
			int result = ptst.executeUpdate();

			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
			return flag;
		}
	}

	public boolean insertBoard(Board b) {
		boolean flag = true;

		Connection conn = ConnectionManager.getConnection();

		String sql = "INSERT INTO BOARD ";
		sql += " (BOARDSEQ,TITLE,ID,CONTENT,INDATE) ";
		sql += " VALUES ";
		sql += " (BOARDSEQ.NEXTVAL,?,?,?,SYSDATE) ";

		try {
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, b.getTitle());
			pst.setString(2, b.getId());
			pst.setString(3, b.getContent());
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return flag;
	}

	public ArrayList<Board> selectAllBoard() {
		ArrayList<Board> boardList = new ArrayList<>();

		Connection conn = ConnectionManager.getConnection();

		String sql = " SELECT BOARDSEQ,TITLE,ID,CONTENT,INDATE FROM BOARD ORDER BY INDATE DESC";

		try {

			PreparedStatement pst = conn.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String boardseq = rs.getString(1);
				String title = rs.getString(2);
				String id = rs.getString(3);
				String content = rs.getString(4);
				String indate = rs.getString(5);

				boardList.add(new Board(boardseq, id, title, content, indate));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return boardList;

	}

	public Board selectBoard(String boardSeq) {
		Board board = null;

		Connection conn = ConnectionManager.getConnection();

		String sql = " SELECT BOARDSEQ,TITLE,ID,CONTENT,INDATE FROM BOARD";
		sql += " WHERE BOARDSEQ=? ";

		try {

			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, boardSeq);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String boardseq = rs.getString(1);
				String title = rs.getString(2);
				String id = rs.getString(3);
				String content = rs.getString(4);
				String indate = rs.getString(5);

				board = new Board(boardseq, id, title, content, indate);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return board;

	}

	public void deleteBoard(String boardSeq) {

		Connection conn = ConnectionManager.getConnection();

		String sql = "DELETE BOARD WHERE BOARDSEQ=? ";

		try {
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, boardSeq);
			
			int i=pst.executeUpdate();
			System.out.println(i);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void updateBoard(Board board) {

		Connection conn = ConnectionManager.getConnection();

		String sql = "UPDATE BOARD SET "
				+ "	TITLE=?, "
				+ " CONTENT=? "
				+ " WHERE"
				+ "	BOARDSEQ=? ";

		try {
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setString(3, board.getBoardSeq());
			
			int i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
