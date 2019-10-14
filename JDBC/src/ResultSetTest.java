import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!");
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
			System.out.println("DB 연결 성공!");
			String sql = "select * from member";
			Statement stmt = con.createStatement();
			stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String ID = rs.getString("id");
				String pass = rs.getString("password");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.printf("ID:%s\t Password:%s\t Name:%s\t Age%d\n", ID, pass, name, age);
			}
		} catch (SQLException e) {
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