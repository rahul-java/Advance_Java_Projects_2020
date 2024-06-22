package max;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtility {
	
	
	static Connection cn=null;
	static
	{
		try {
			Class.forName("org.postgresql.Driver");
             cn = DriverManager.getConnection("jdbc:postgresql://localhost/user","postgres","postgres");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn()
	{
		return cn;
	}

}
