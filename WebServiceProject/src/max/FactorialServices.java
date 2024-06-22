package max;

import java.util.Random;

public class FactorialServices {
	
	public String otp(String mob)
	{
		     try {
				
		    	StringBuilder sb = new StringBuilder();
		    	for(int i=1; i<10;i++)
		    	{
		    		sb.append(new Random().nextInt(10));
		    	}
		    	return sb.substring(5);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return "0";
	}
	
	
	
	
   public String getFacto(String n)
   {   int f=1;
	  int i= Integer.parseInt(n);
	    if(i==1 || i==0)
	    {
	    	return "Facto is "+f;
	    }
	    else
	    {
	    	for(int j=i;j>1;j--)
	    	{
	    		f*=j;
	    	}
	    	return "Facto is "+f;
	    }
   }
}
