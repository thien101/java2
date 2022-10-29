package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class CoSodao {
	public static Connection cn;
	public void ketnoi() throws Exception{
		//b1: Xac dinh he QTCS DL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Ok buoc 1");
		
		//b1: Ket noi he QTCS DL
		
		cn=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-5K2RFED\\SQLEXPRESS:1433;databaseName=QlSach;user=sa; password=1008;");
		//cn = DriverManager.getConnection(url,"sa", "123");
		System.out.println("Ok buoc 2");

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