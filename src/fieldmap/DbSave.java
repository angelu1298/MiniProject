package fieldmap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSave {
	public void updatePlayer( String pname, long money, int lev_no, long exp, long p_time, int n){
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
        String DB_USER = "PMINI11";
        String DB_PASSWORD = "TIGER";
        Connection conn = null;
        PreparedStatement pstmtAdd= null;
   
        
        
        try {
            // 드라이버를 로딩한다.
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e ) {
            e.printStackTrace();
        }
        try {
        	
        	conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        	pstmtAdd = conn.prepareStatement("update player set  LEV_NO=?,EXP= ?,E_TIME=?,TO_CNT=?,money = ? where p_name = ? ");
    	
            // 데이터베이스의 연결을 설정한다.

            // Statement를 가져온다.
            
            try{
            	
//    			insert into member values(? -> 1 ,? -> 2, ? -> 3)" 각각의 ? 에 값 대입
            	pstmtAdd.setInt(1, lev_no);
            	pstmtAdd.setLong(2, exp);
            	pstmtAdd.setLong(3, p_time);
            	pstmtAdd.setInt(4, n);
            	pstmtAdd.setLong(5, money);
            	pstmtAdd.setString(6, pname);
            	
            	
//    			대입받은 쿼리를 실행 -> 입력 (insert)
            	pstmtAdd.executeQuery();
            }catch(Exception e){
            	e.printStackTrace();
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            try {
            	pstmtAdd.close();
                conn.close();
            } catch ( SQLException e ) {}
        }
	}
}
