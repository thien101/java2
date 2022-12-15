package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class CoSodao {
	public static Connection cn;
	public void ketnoi() throws Exception{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		cn=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-5K2RFED\\SQLEXPRESS:1433;databaseName=	QLLapTop;user=sa; password=1008;");

	}
	public static void main(String[] args) {
		try {
			CoSodao cs = new CoSodao();
			cs.ketnoi();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}