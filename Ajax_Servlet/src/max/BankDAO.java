package max;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankDAO {
	public static String getBankAddress(String ifsc)
	{     String  bank_add ="invalid ifsc code";
		try {
		Connection con = JDBCUtility.getConn();
		PreparedStatement ps = con.prepareStatement("select * from bank_details where ifsc='"+ifsc+"'");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			bank_add=   rs.getString("bank_address");
			System.out.println(bank_add);
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bank_add;
		
	}

}
