package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DBConnection{
	
	public static void closeDB(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection(){
		Connection con = null;
		
		//1. oracle driver 로딩  ojdbc6.jar
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("oracle driver 없다!");
		}
		
		//2. database 접속
		String db_url 	   ="jdbc:oracle:thin:@jsl-704:1521:xe";
		String db_user     ="track23";
		String db_password ="5678";
		
		try {
			con = DriverManager.getConnection(db_url, db_user, db_password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("계정 설정 오류~~~");
		}
		
		return con;
	}
	
}





