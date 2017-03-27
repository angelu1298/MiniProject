package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LevelInsert {
	public static void main(String[] args) {
		
		// SQL문 작성하기
		StringBuffer sql1 = new StringBuffer();
		sql1.append("insert into lev ");
		sql1.append("values(?, ?, ?, ?) ");

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			ConnDB dbcon = new ConnDB();
			conn = dbcon.getConnection();

			conn.setAutoCommit(false);

			// PreparedStatement 객체 얻기
			// 파라미터 세팅
			// 쿼리의 바인딩 변수에 대체될 실제 값 지정하기
			pstmt = conn.prepareStatement(sql1.toString());
			for (int i = 1; i <= 30; i++) {//??
				if (i <= 3) {
					pstmt.setInt(1, i);
					pstmt.setInt(2, 10 * (int) Math.pow(1.1, i - 1));
					pstmt.setInt(3, 40 * (i - 1));
					pstmt.setInt(4, 40 * i - 1);
					pstmt.executeUpdate();
				} else if (i <= 10) {
					pstmt.setInt(1, i);
					pstmt.setInt(2, 10 * (int) Math.pow(1.1, i - 1));
					pstmt.setInt(3, 80 + 80 * (i - 3));
					pstmt.setInt(4, 80 + 80 * (i - 2) - 1);
					pstmt.executeUpdate();
				} else if (i <= 13) {
					pstmt.setInt(1, i);
					pstmt.setInt(2, 10 * (int) Math.pow(1.1, i - 1));
					pstmt.setInt(3, 640 + 800 * (i - 10));
					pstmt.setInt(4, 640 + 800 * (i - 9) - 1);
					pstmt.executeUpdate();
				} else if (i <= 17) {
					pstmt.setInt(1, i);
					pstmt.setInt(2, 10 * (int) Math.pow(1.1, i - 1));
					pstmt.setInt(3, 3040 + 1000 * (i - 13));
					pstmt.setInt(4, 3040 + 1000 * (i - 12) - 1);
					pstmt.executeUpdate();
				} else if (i <= 22) {
					pstmt.setInt(1, i);
					pstmt.setInt(2, 10 * (int) Math.pow(1.1, i - 1));
					pstmt.setInt(3, 7040 + 1200 * (i - 17));
					pstmt.setInt(4, 7040 + 1200 * (i - 16) - 1);
					pstmt.executeUpdate();
				} else if (i <= 27) {
					pstmt.setInt(1, i);
					pstmt.setInt(2, 10 * (int) Math.pow(1.1, i - 1));
					pstmt.setInt(3, 13040 + 4000 * (i - 22));
					pstmt.setInt(4, 13040 + 4000 * (i - 21) - 1);
					pstmt.executeUpdate();
				} else if (i < 30) {
					pstmt.setInt(1, i);
					pstmt.setInt(2, 10 * (int) Math.pow(1.1, i - 1));
					pstmt.setInt(3, 33040 + 8000 * (i - 27));
					pstmt.setInt(4, 33040 + 8000 * (i - 26) - 1);
					pstmt.executeUpdate();
				} else {
					pstmt.setInt(1, i);
					pstmt.setInt(2, 10 * (int) Math.pow(1.1, i - 1));
					pstmt.setInt(3, 33040 + 8000 * 3);//최소
					pstmt.setInt(4, 33040 + 8000 * 3 + 16000);//최대
					pstmt.executeUpdate();
				}

			}
			pstmt.close();
			

			// 쿼리가 정상적으로 실행된 경우 db에 반영
			conn.commit();

		} catch (SQLException se) {
			try {
				conn.rollback();
				System.out.println("db에 반영이 취소 됨......");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}
}