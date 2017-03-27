package fieldmap;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Database.ConnDB;

public class MON_DIC {
	ArrayList<String> mon_name;
	ArrayList<String> t_name;
	ArrayList<String> grade;
	ArrayList<ImageIcon> icon;

	public void getMonInfo() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			ConnDB dbcon=new ConnDB();
			conn = dbcon.getConnection();

			stmt = conn.createStatement();

			String select_sql = "select MON_NAME, T_NAME, GRADE, MON_LOB from MONSTER";
			rs = stmt.executeQuery(select_sql);
			mon_name = new ArrayList<String>();
			t_name = new ArrayList<String>();
			grade = new ArrayList<String>();
			icon = new ArrayList<ImageIcon>();
			while (rs.next()) {
				String MON_NAME = rs.getString("MON_NAME");
				String T_NAME = rs.getString("T_NAME");
				String GRADE = rs.getString("GRADE");

				Blob blob = rs.getBlob("MON_LOB"); // 컬럼명
				InputStream is = blob.getBinaryStream();
				byte[] x = new byte[100000];
				while (true) {
					int n = is.read(x);
					if (n == -1)
						break;

				}

				BufferedImage bImage = null;
				try {
					bImage = ImageIO.read(new ByteArrayInputStream(x));
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				ImageIcon image = new ImageIcon(bImage);

				icon.add(image);
				is.close();

				mon_name.add(MON_NAME);
				t_name.add(T_NAME);
				grade.add(GRADE);
				// System.out.printf("%-5d%-7s\t %-10s \t %-10d \t %-5s \n",
				// ++i, MON_NAME, T_NAME, GRADE, MON_LOB);
			} // while
		} // try
		 catch (SQLException se) {
			System.out.println(se.getMessage());
		} catch (IOException ioe) {
			System.out.println("ttt");
		} finally {
			try {
				rs.close();
				stmt.close();

			} catch (Exception e) {

			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

	}
}
