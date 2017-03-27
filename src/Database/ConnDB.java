package Database;
import java.sql.*;
public class ConnDB {//DB연결
	 {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." 
		      + cnfe.getMessage());
		}
	}

	public  Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";			//xe는 DB버전
		return DriverManager.getConnection(url, "pmini11", "TIGER");//아이디,비번
	}
}
