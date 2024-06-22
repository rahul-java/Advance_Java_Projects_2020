package max;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User
{
	static Connection con=null;
	
	
	public static boolean checkUserEmail(String email)
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
	public static boolean checkUserEmailMobile(String email,String mobile)
	{
		con=UserConnection.getConnection();
		try {
		
		PreparedStatement ps = con.prepareStatement("select * from userlogin where email=? and cflag=0");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			if(rs.getString(1).equalsIgnoreCase(email) && rs.getString(3).equalsIgnoreCase(mobile))
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
	public static int insertUser(UserBean user)
	{
		con=UserConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into userlogin values (?,?,?,?,?)");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getName());
			ps.setString(3, user.getMobile());
			ps.setString(4, user.getPassword());
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
	public static UserBean getUserDetail(String email)
	{
		UserBean user=new UserBean();
		con=UserConnection.getConnection();
		try {
		
		PreparedStatement ps = con.prepareStatement("select * from userlogin where email=? and cflag=0");
		ps.setString(1, email);
		//ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			user.setEmail(rs.getString(1));
			user.setName(rs.getString(2));
			user.setMobile(rs.getString(3));
			user.setPassword(rs.getString(4));
		}
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;

	}
}
