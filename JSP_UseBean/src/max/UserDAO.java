package max;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	public List<UserBean> fatchUserDetails()
	{       List<UserBean> list = new ArrayList<>();
		try {
			Connection con = JDBCUtility.getConn();
		PreparedStatement ps = con.prepareStatement("select * from empp");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			UserBean ub = new UserBean();
			
			 ub.setName(rs.getString(1));
			 ub.setEmail(rs.getString(2));
			 ub.setPass(  pass(  rs.getString(3)));
			 ub.setPhone(rs.getString(4));
			 list.add(ub);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static String pass(String p)
	{
		return p.substring(0, 1)+"XXXXXX"+p.substring(3);
		
		
	}
	
	
	
	
	public boolean insertData(UserBean ub)
	{
		try {
			
		Connection con = JDBCUtility.getConn();
		PreparedStatement ps = con.prepareStatement("insert into empp values (?,?,?,?)");
		ps.setString(1, ub.getName());	
		ps.setString(2, ub.getEmail());
		ps.setString(3, ub.getPass());
		ps.setString(4, ub.getPhone());
		int i=ps.executeUpdate();
		if(i>0)
		{
			return true;
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
