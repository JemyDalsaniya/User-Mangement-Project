package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static MyConnection obj = new MyConnection();

	// private constructor
	private MyConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static MyConnection getInstance() {
		return obj;
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "root");
		if (conn.isClosed()) {
			System.out.println("connection is closed!");
		} else {
			System.out.println("Connected to database..");
		}
		return conn;
	}
}
