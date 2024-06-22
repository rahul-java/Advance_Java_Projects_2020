package max.reg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import max.JDBCUtility;

public class RegisDAO {
	
	
	public static RegisBean getRecordsByEmail(String email)
	{    PreparedStatement ps=null;
	RegisBean b = new RegisBean();
		try {
			Connection con = JDBCUtility.getConn();
			String q="select * from regis";
			
          ps = con.prepareStatement(q+ " where email = ? and cflag = ?") ;
				 ps.setString(1, email);
				 ps.setInt(2, 0);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				b.setUid(rs.getString("uid"));
				b.setName(rs.getString("name"));
				b.setEmail(rs.getString("email"));
				b.setPhone(rs.getString("phone"));
				
			}
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
		

	public static List<RegisBean> getRecords(String email)
	{    PreparedStatement ps=null;
	    List<RegisBean> l=new ArrayList<RegisBean>();
		try {
			Connection con = JDBCUtility.getConn();
			String q="select * from regis";
			if(email.equalsIgnoreCase("All"))
			{
            ps = con.prepareStatement(q);
				    	
			}
			else
			{
				 ps = con.prepareStatement(q+ " where email = ? and cflag = ?") ;
				 ps.setString(1, email);
				 ps.setInt(2, 0);
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				RegisBean b = new RegisBean();
			
				b.setUid(rs.getString("uid"));
				b.setName(rs.getString("name"));
				b.setEmail(rs.getString("email"));
				b.setPhone(rs.getString("phone"));
				l.add(b);
			}
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return l;
	}
	
	
	
	public static List<String>   getRecords()
	{
		List<String> l=new ArrayList<String>();
		try {
			  Connection con = JDBCUtility.getConn();
			 PreparedStatement ps = con.prepareStatement("select email from regis where cflag=?");
			 ps.setInt(1, 0);
		     
			    ResultSet rs = ps.executeQuery();
		  while(rs.next())
		  {
			 
			  l.add(rs.getString("email"));
		  }
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return l;
	}
	
	
	
	
	  public String login(String email, String pass)
	  {
		  try {
			  Connection con = JDBCUtility.getConn();
			 PreparedStatement ps = con.prepareStatement("select email from regis where email = ? and pass = ? and cflag = ?");
			ps.setString(1, email);  
			ps.setString(2, pass); 
			ps.setInt(3, 0);
			ResultSet rs = ps.executeQuery();
			  while(rs.next())
			  {
				 String emal=  rs.getString("email");
				 if(emal.equalsIgnoreCase(email))
				 {
					 return email;
				 }
				 
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "wrong";
	  }
	
  public int insertRegisDetails(RegisDTO regisDTO)
  {
	  try {
		  	  
		  PreparedStatement ps=null;
		  Connection con = JDBCUtility.getConn();
		  if(checkEmail(con,regisDTO.getEmail()))
		  {
                ps = con.prepareStatement("update regis set name=? , phone = ? where email = ? and cflag =? ");
                ps.setString(1, regisDTO.getName());
                ps.setString(2, regisDTO.getPhone());
                ps.setString(3, regisDTO.getEmail());
                ps.setInt(4, 0);
                
                int q = ps.executeUpdate();
                
                if(q>0)
                 {
    	            return 2;
                  }
		   }
		   else
		     {
	            ps = con.prepareStatement("insert into regis values (?,?,?,?,?,?)");
	 
	            ps.setString(1, regisDTO.getEmail());
	            ps.setString(2, regisDTO.getName());
	            ps.setString(3, regisDTO.getUid());
	            ps.setString(4, regisDTO.getPass());
	            ps.setString(5, regisDTO.getPhone());
	            ps.setInt(6, 0);
	   
	            int q = ps.executeUpdate();
                if(q>0)
                 {
      	            return 1;
                  }
		      }
	   
	     
	  } catch (Exception e) 
	    {
		   e.printStackTrace();
	     }
	return 0;
  }
  
  public static boolean checkEmail( Connection con,String email)
  {
	  try {
		PreparedStatement ps = con.prepareStatement("select email from regis where email = ? and cflag=?");
	    ps.setString(1, email);
	    ps.setInt(2, 0);
	 ResultSet rs = ps.executeQuery();
	 while(rs.next())
	 {
		 String emal= rs.getString("email");
		 if(emal.equalsIgnoreCase(email))
		 {
			 return true;
		 }
	 }
	  } catch (Exception e) {
		// TODO: handle exception
	}
	return false;
  }
}
