import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

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
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("DB ���� ����!");
			Statement stmt = con.createStatement();
			String sql = "insert into member values('java','pass','���ڹ�',26)";
			int row = stmt.executeUpdate(sql);
			System.out.printf("%d�� ���Լ���", row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
