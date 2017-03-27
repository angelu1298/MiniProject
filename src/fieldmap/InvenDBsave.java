package fieldmap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InvenDBsave {
	//플레이어가 생성됨과 동시에 그 플레이어의 인벤토리가 데이터 베이스에 들어간다. 
	public void getInven() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into inventory values(?,?,?,?,?)";

		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "PMINI11", "TIGER");
			pstmt = conn.prepareStatement(sql);
			for(int i = 1; i< 17 ; i++){
				if(i<=4)
					pstmt.setString(1, "몬스터볼");
				else if (i<=8)
					pstmt.setString(1, "슈퍼볼");
				else if (i<=12)
					pstmt.setString(1, "하이퍼볼");
				else 
					pstmt.setString(1, "마스터볼");
			pstmt.setInt(2, ExecGame.player.getBallnum(i));
			pstmt.setString(3, ExecGame.player.getPname());
			pstmt.setInt(4, i);
			if(i<=4)
				pstmt.setInt(5, 50);
			else if (i<=8)
				pstmt.setInt(5, 300);
			else if (i<=12)
				pstmt.setInt(5, 1000);
			else 
				pstmt.setInt(5, 10000);
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
