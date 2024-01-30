package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	private static Connection Conn;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baseProjet","root","root");
		} catch (Exception e) {
			System.out.print("probleme de connexion a la base");
			System.out.print(e);
			e.printStackTrace();
		}
	}
	public static Connection getConn() {
		return Conn;
	}
	public static void setConn(Connection conn) {
		Conn = conn;
	}
	
}