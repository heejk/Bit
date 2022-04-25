package jdbc.ex01.jdbc_create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCreate {
	
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
		String url = "jdbc:oracle:thin:@11.2.0.2.0:1521:xe";
		String id = "bitjava";
		String pass = "bitjava";
		
		try {
			// 3. Oracle 서버 접속 객체 생성
			Connection con = DriverManager.getConnection(url, id, pass);
			
			//4. sql 쿼리문 실행하기 위한 객체 생성
			Statement statemt = con.createStatement();
			
			// 5. sql문 작성
			String strCreate = "CREATE TABLE dept (\n"
							+ "    dno VARCHAR2(2),\n"
							+ "    dname VARCHAR2(14),\n"
							+ "    loc VARCHAR2(8),\n"
							+ "    director VARCHAR2(4)\n"
							+ ")";
			
			// 6. 실행
			int cnt = statemt.executeUpdate(strCreate); // 몇 개의 행이 적용되었는가?
			System.out.println("result: " + cnt);
			
			// 7. 데이터 삽입
			String strInsert = "INSERT INTO dept(dno, dname, loc) VALUES ('01', '개발', '서울')";
			
			cnt = statemt.executeUpdate(strInsert);
			System.out.println("result: " + cnt);
			
			// 8. dept의 pk 제약조건
			String strAlter = "ALTER TABLE dept ADD CONSTRAINT dept_dno_pk PRIMARY KEY(dno)";
			
			cnt = statemt.executeUpdate(strAlter);
			System.out.println("result: " + cnt);
			
			// 9. 객체 해제
			statemt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}