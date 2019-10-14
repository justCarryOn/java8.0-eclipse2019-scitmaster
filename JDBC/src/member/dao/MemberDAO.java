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
	 * 새로운 회원 정보를 등록
	 * 
	 * @return 회원 등록을 성공하면 true, 실패하면 false를 반환
	 * @param vo 등록하고자하는 회원 정보
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
	 * 주어진 ID에 해당하는 멤버 정보를 반환
	 * 
	 * @param id 검색하고자 하는 회원의 ID
	 * @return 회원정보
	 */
	public MemberVO getMember(String id) {
		MemberVO vo = null;

		return vo;
	}

	/**
	 * 등록된 모든 회원정보를 조회
	 * 
	 * @return 모든 회원정보
	 */
	public ArrayList<MemberVO> getAllMembers() {
		ArrayList<MemberVO> allData = new ArrayList<>();

		return allData;
	}

	/**
	 * 주어진 ID에 해당하는 회원정보를 삭제
	 * 
	 * @param id 삭제하고자 하는 회원ID
	 * @return 삭제를 성공하면 true, 실패하면 false를 반환
	 */
	public boolean deleteMember(String id) {
		boolean result = false;

		return result;
	}

	/**
	 * 회원정보 수정
	 * 
	 * @param vo 수정할 값을 가지고 있는 회원정보
	 * @return 수정을 성공하면 true, 실패하면 false를 반환
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
