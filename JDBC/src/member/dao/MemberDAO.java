package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import member.vo.MemberVO;

public class MemberDAO {

	// DB Driver Loading
	public MemberDAO() {

	}

	/**
	 * ���ο� ȸ�� ������ ���
	 * 
	 * @return ȸ�� ����� �����ϸ� true, �����ϸ� false�� ��ȯ
	 * @param vo ����ϰ����ϴ� ȸ�� ����
	 */
	public boolean insertMember(MemberVO vo) {
		boolean result = false;
		Connection con = getConnection();
		try {
			String sql = "insert into member values (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getAge());
			int count = pstmt.executeUpdate();
			if (count == 1)
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}

		return result;
	}

	/**
	 * �־��� ID�� �ش��ϴ� ��� ������ ��ȯ
	 * 
	 * @param id �˻��ϰ��� �ϴ� ȸ���� ID
	 * @return ȸ������
	 */
	public MemberVO getMember(String id) {
		MemberVO vo = null;

		return vo;
	}

	/**
	 * ��ϵ� ��� ȸ�������� ��ȸ
	 * 
	 * @return ��� ȸ������
	 */
	public ArrayList<MemberVO> getAllMembers() {
		ArrayList<MemberVO> allData = new ArrayList<>();

		return allData;
	}

	/**
	 * �־��� ID�� �ش��ϴ� ȸ�������� ����
	 * 
	 * @param id �����ϰ��� �ϴ� ȸ��ID
	 * @return ������ �����ϸ� true, �����ϸ� false�� ��ȯ
	 */
	public boolean deleteMember(String id) {
		boolean result = false;

		return result;
	}

	/**
	 * ȸ������ ����
	 * 
	 * @param vo ������ ���� ������ �ִ� ȸ������
	 * @return ������ �����ϸ� true, �����ϸ� false�� ��ȯ
	 */
	public boolean updateMember(MemberVO vo) {
		boolean result = false;

		return result;
	}

	private void close(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "hr");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
