package com.in.Uid.utlity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_connection {
	private Database_connection() {}
	static Connection con = null;

	public static Connection getconnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/adhar","postgres","postgres");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return con;
	}

}
