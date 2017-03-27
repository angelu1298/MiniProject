package fieldmap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class InvenDB {
	

	public void getInven() {
		//연결준비 
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//쿼리문 작성
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE INVENTORY ");
		sql.append("SET B_CNT = ? ");
		sql.append("WHERE P_NAME = ? AND B_KEY = ? ");
		
		try {
			//드라이버에 연결
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			//접속
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "PMINI11", "TIGER");
			
			//데이터 베이스에 적용
			for(int i = 1; i < 17 ; i++){
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, ExecGame.player.getBallnum(i)); //플레이어의 볼 개수 입력
				pstmt.setString(2, ExecGame.player.getPname()); //플레이어의 이름
				pstmt.setInt(3, i);								//볼 구분 키값
				pstmt.executeUpdate();
			}
		} // try
		catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}
