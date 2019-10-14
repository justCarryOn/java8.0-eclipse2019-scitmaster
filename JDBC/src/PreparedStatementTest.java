import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "cc";
		String password = "cc";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB ���� ����!");

			String ID[] = { "aaa", "bbb", "ccc" };
			String pass[] = { "PassA", "PassB", "PassC" };
			String name[] = { "������", "������", "������" };
			int age[] = { 27, 28, 29 };
			String sql = "insert into member values (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false); // �������� ������ �⺻���� true
			for (int i = 0; i < 3; i++) {
				pstmt.setString(1, ID[i]);
				pstmt.setString(2, pass[i]);
				pstmt.setString(3, name[i]);
				pstmt.setInt(4, age[i]);
				pstmt.executeUpdate();
			}
			con.commit();
			con.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
