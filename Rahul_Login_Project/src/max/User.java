package max;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User
{
	static Connection con=null;
	
	
	public static boolean getUser(String email)
	{
		con=UserConnection.getConnection();
		try {
		
		PreparedStatement ps1 = con.prepareStatement("select * from userlogin where email=? and cflag=0");
		ps1.setString(1, email);
		ResultSet rs = ps1.executeQuery();
		//con.close();
		
		while(rs.next())
		{
			if(rs.getString(1).equals(email))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
	}
	public static int insertUser(String email,String name,String mobile,String pwd)
	{
		con=UserConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into userlogin values (?,?,?,?,?)");
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, mobile);
			ps.setString(4, pwd);
			ps.setInt(5, 0);
			int n=ps.executeUpdate();
			//con.close();
			return n;
		}catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
