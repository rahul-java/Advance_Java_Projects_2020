package max;

//import java.rmi.RemoteException;

public class Sachin {
	public static void main(String[] args) {
		FactorialServicesProxy f=	new FactorialServicesProxy();
		 try {
			//String r = f.getFacto("6");
			//System.out.println(r);
			
			String t = f.otp("7609999999");
			System.out.println(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
