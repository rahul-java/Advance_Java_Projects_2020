package max;

import java.sql.Connection;

import java.sql.DriverManager;

public class UserConnection {

	static Connection con= null;
	static
	{
		try {
			Class.forName("org.postgresql.Driver");
			con= DriverManager.getConnection("jdbc:postgresql://localhost/user", "postgres", "postgres");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() 
	{
		return con;
	}
	
	
	

}
