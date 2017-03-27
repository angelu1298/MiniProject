package Database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Level implements Serializable {
	private static final long serialVersionUID = 100;
	private int levelno;
	int[] levs = new int[30];			//레벨이 1부터 30까지 있으니까 크기가 30인 배열 생성 
	int[] lowexps = new int[30]; 
	int[] highexps = new int[30];

	Level() {
		levelno=1;						//레벨을 1로 초기화
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";//DB연동
		String DB_USER = "PMINI11";
		String DB_PASSWORD = "TIGER";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 드라이버를 로딩한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("클래스접속");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			stmt = conn.createStatement();
			System.out.println("커넥션완료");
			rs = stmt.executeQuery("select lev_no, low, high from lev ");
			int i = 0;
			while (rs.next()) {
				levs[i] = rs.getInt(1);			//1은 컬럼인덱스숫자 --> lev_no
				lowexps[i] = rs.getInt(2);		//			  --> low				
				highexps[i] = rs.getInt(3);		//			  --> high
				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally

		{
			try {
				// Statement를 닫는다.
				stmt.close();
				// Connection를 닫는다.
				conn.close();
			} catch (SQLException e) {
			}
		}
	} 


	public void setLev(int exp) {						//exp를 인자로 받아서 레벨설정하는 메소드
		for(int i = 0; i<lowexps.length ;i++){
			if(exp>=lowexps[i]&&exp<=highexps[i]){		//최저경험치 <= exp <= 최대경험치
				levelno = levs[i];						//levs배열의 인덱스 i번째 값이 levelno에 대입됨 
			}
		}
	}

	public int getLev() {								//레벨을 가져오는 메소드
		return levelno;
	}


}
