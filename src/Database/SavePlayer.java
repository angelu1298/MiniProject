package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SavePlayer { // 플레이어 정보를 DB에 저장
	public void saveNewPlayer(String pname, String gender, long money, int lev_no, long exp, long date, long p_time,
			String arr, int n) {

		Connection conn = null;
		PreparedStatement pstmtAdd = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			ConnDB dbcon = new ConnDB();
			conn = dbcon.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select p_name from player");
			if (rs == null) {
				pstmtAdd = conn.prepareStatement("insert into player values(?,?,?,?,?,?,?,?,?)");

				try {
					// PreparedStatement 생성-> conn은 preDbTreatment() 메소드를 통해
					// 생성되어 있음

					// insert into member values(? -> 1 ,? -> 2, ? -> 3)" 각각의 ?
					// 에 값 대입
					pstmtAdd.setString(1, pname);
					pstmtAdd.setString(2, gender);
					pstmtAdd.setLong(3, money);
					pstmtAdd.setInt(4, lev_no);
					pstmtAdd.setLong(5, exp);
					pstmtAdd.setDate(6, new Date(date));
					pstmtAdd.setLong(7, p_time);
					pstmtAdd.setString(8, arr);
					pstmtAdd.setInt(9, n);

					// 대입받은 쿼리를 실행 -> 입력 (insert)
					pstmtAdd.executeQuery();
					pstmtAdd.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				String p_name = rs.getString("p_name");
				if (p_name.equals(pname)) {
					pstmtAdd = conn.prepareStatement(
							"update player set gender=?, money=?, LEV_NO=?,EXP= ?,s_time=?, E_TIME=?,mon_list=?, TO_CNT=? where p_name = ? ");
					pstmtAdd.setString(1, gender);
					pstmtAdd.setLong(2, money);
					pstmtAdd.setInt(3, lev_no);
					pstmtAdd.setLong(4, exp);
					pstmtAdd.setDate(5, new Date(date));
					pstmtAdd.setLong(6, p_time);
					pstmtAdd.setString(7, arr);
					pstmtAdd.setInt(8, n);
					pstmtAdd.setString(9, pname);
				} else {

					pstmtAdd = conn.prepareStatement("insert into player values(?,?,?,?,?,?,?,?,?)");

					try {
						// PreparedStatement 생성-> conn은 preDbTreatment() 메소드를 통해
						// 생성되어 있음

						// insert into member values(? -> 1 ,? -> 2, ? -> 3)"
						// 각각의 ?
						// 에 값 대입
						pstmtAdd.setString(1, pname);
						pstmtAdd.setString(2, gender);
						pstmtAdd.setLong(3, money);
						pstmtAdd.setInt(4, lev_no);
						pstmtAdd.setLong(5, exp);
						pstmtAdd.setDate(6, new Date(date));
						pstmtAdd.setLong(7, p_time);
						pstmtAdd.setString(8, arr);
						pstmtAdd.setInt(9, n);

						// 대입받은 쿼리를 실행 -> 입력 (insert)
						pstmtAdd.executeQuery();
						pstmtAdd.close();

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Statement를 닫는다.
				pstmtAdd.close();
				// Connection를 닫는다.
				conn.close();
			} catch (SQLException e) {
			}
		}
	} // main()의 끝
} // 클래스의 끝