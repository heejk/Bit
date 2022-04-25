package jdbc.ex02.jdbc_select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelect {

	// 1. Oracle에 접속하기 위한 클래스 객체를 메모리에 로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// 2. Oracle 서버 접속 주소, 계정
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "bitjava";
		String pass = "bitjava";

		Connection con;
		try {
			// 3. Oracle 서버 접속 객체 생성
			con = DriverManager.getConnection(url, id, pass);

			//4. sql 쿼리문 실행하기 위한 객체 생성
			Statement statemt = con.createStatement();

			// 5. sql문 작성
			String strSelect = "SELECT * FROM dept";
			
			// 6. sql문 서버로 전송 후 결과 받아오기
			ResultSet rs = statemt.executeQuery(strSelect);
			
			// 7. 결과 화면 출력
			int cnt = 1;
			
			while (rs.next()) {
				rs.getString("eno");
				
				System.out.println("----- [ " + cnt + " -----]");
				System.out.println("eno: " + rs.getString(1));
				System.out.println("ename: " + rs.getString(2));
				System.out.println("job: " + rs.getString(3));
				System.out.println("mgr: " + rs.getString(4));
				System.out.println("hdate: " + rs.getString(5));
				System.out.println("sal: " + rs.getString(6));
				System.out.println("comm: " + rs.getString(7));
				System.out.println("dno: " + rs.getString(8));
				
				cnt++;
			}
			
			rs.close();
			statemt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
