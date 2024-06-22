package max.reg;

public class RegisBO {
	
	
	public boolean getRegisDetails(RegisBean regisBean)
	{
		   String em = regisBean.getEmail();
		    String[] email = em.split("@");
		    RegisDTO regisDTO=	new RegisDTO ();
		     if(email[1].equalsIgnoreCase("gmail.com"))
		     {
		    	    if(regisBean.getPhone().length()==10)
		    	    {
		    	    	
		    	    	regisDTO.setEmail(em);
		    	    	regisDTO.setName(regisBean.getName());
		    	    	regisDTO.setPhone(regisBean.getPhone());
		    	    	regisDTO.setUid(regisBean.getUid());
		    	    	
regisDTO.setPass(generatePass(regisBean.getPhone(),regisBean.getName()));
		    	    }
		    	    else
		    	    {
		    	    	return false;
		    	    }
		    	   
		     }
		     else
		   {
		    	return false; 
		     }
		
		return new RegisDAO().insertRegisDetails(regisDTO);
		
	}
	
	public static String generatePass(String phone,String name)
	{
	     return phone.substring(6)+name.substring(0, 3);
	}

}
