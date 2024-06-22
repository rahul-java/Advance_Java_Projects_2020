package max.reg;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import max.JDBCUtility;

public class RegisDAO {
	
	public static List<RegisBean> getRecords(String email)
	{    PreparedStatement ps=null;
	    List<RegisBean> l=new ArrayList<RegisBean>();
		try {
			Connection con = JDBCUtility.getConn();
			
			if(email.equalsIgnoreCase("All"))
			{
                ps = con.prepareStatement("select * from regis where cflag=?");
                ps.setInt(1, 0);
				    	
			}
			else
			{
				 ps = con.prepareStatement("select * from regis where email = ? and cflag=?") ;
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
			 PreparedStatement ps = con.prepareStatement("select email from regis where email = ? and pass = ? and cflag=?");
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
	
	
	
	
	
	
	
	
	
  public boolean insertRegisDetails(RegisDTO regisDTO)
  {
	  try {
		  Connection con = JDBCUtility.getConn();
PreparedStatement ps = con.prepareStatement("insert into regis values (?,?,?,?,?,?)");
	   
	   ps.setString(1, regisDTO.getEmail());
	   ps.setString(2, regisDTO.getName());
	   ps.setString(3, regisDTO.getUid());
	   ps.setString(4, regisDTO.getPass());
	   ps.setString(5, regisDTO.getPhone());
	   ps.setInt(6, 0);
	     int q = ps.executeUpdate();
	         if(q>0)
	         {
	        	 return true;
	         }
	  } catch (Exception e) {
		e.printStackTrace();
	}
	return false;
  }
  
  public static boolean deleteRecords(String email)
  {
	  PreparedStatement ps=null;
	  try {
		  Connection con = JDBCUtility.getConn();
		  if(email.equalsIgnoreCase("All"))
		  {
			  ps = con.prepareStatement("update regis set cflag=? where cflag=?");  
			  ps.setInt(1, 1);
			  ps.setInt(2, 0);
		  }else
		  {
			  ps = con.prepareStatement("update regis set cflag=? where email= ? and cflag=?");  
			  ps.setInt(1, 1);
			  ps.setString(2, email);
			  ps.setInt(3, 0);
		  }

	     int q = ps.executeUpdate();
	         if(q>0)
	         {
	        	 return true;
	         }
	  } catch (Exception e) {
		e.printStackTrace();
	}
	return false;
	  
  }
  public static boolean undoDelete()
  {
	  PreparedStatement ps=null;
	  try {
		  Connection con = JDBCUtility.getConn();
		  
			  ps = con.prepareStatement("update regis set cflag=? where cflag=?");  
			  ps.setInt(1, 0);
			  ps.setInt(2, 1);
		  

	     int q = ps.executeUpdate();
	         if(q>0)
	         {
	        	 return true;
	         }
	  } catch (Exception e) 
	  {
		e.printStackTrace();
	}
	  return false;  
  }
  
  public static List<RegisDTO> getToUpdate(String email)
	{    PreparedStatement ps=null;
	    List<RegisDTO> l=new ArrayList<RegisDTO>();
		try {
			Connection con = JDBCUtility.getConn();
			
              ps = con.prepareStatement("select * from regis where email=? and cflag=?");
              ps.setString(1, email);
              ps.setInt(2, 0);
				    	
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				RegisDTO b = new RegisDTO();
			
				b.setUid(rs.getString("uid"));
				b.setName(rs.getString("name"));
				b.setEmail(rs.getString("email"));
				b.setPhone(rs.getString("phone"));
				b.setPass(rs.getString("pass"));
				
				l.add(b);
			}
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return l;
	}
  
  public static boolean updateDetails(RegisDTO regisDTO)
  {
	  PreparedStatement ps=null;
	  try {
		  Connection con = JDBCUtility.getConn();
		  
			  ps = con.prepareStatement("update regis set name=? , uid=? , pass=? , phone=? , cflag=? where email=? and cflag=?");  
			  ps.setString(1, regisDTO.getName());
			  ps.setString(2, regisDTO.getUid());
			  ps.setString(3, regisDTO.getPass());
			  ps.setString(4, regisDTO.getPhone());
		      ps.setInt(5, 0);
		      ps.setString(6, regisDTO.getEmail());
		      ps.setInt(7, 0);
	     int q = ps.executeUpdate();
	         if(q>0)
	         {
	        	 return true;
	          }
	  } catch (Exception e) 
	   {
		e.printStackTrace();
	}
	  return false;  
  }
}
