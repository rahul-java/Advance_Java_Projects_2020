package max;

public class UserBean {
     String name;
     String pass=null;
     String email;
     String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
     
	
	
	public boolean getUserDetails()
	{
       return new UserDAO().insertData(this);
		
	}
}
