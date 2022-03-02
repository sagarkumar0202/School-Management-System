package SPHSchool.Models;

public class SchoolStudent 
{
	int stid;
	String stname;
	String staddress;
	int phone;
	String email;
	int stclass;
	String pass;
	
	public SchoolStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SchoolStudent(int stid, String stname, String staddress, int phone, String email, int stclass, String pass) {
		super();
		this.stid = stid;
		this.stname = stname;
		this.staddress = staddress;
		this.phone = phone;
		this.email = email;
		this.stclass = stclass;
		this.pass = pass;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getStaddress() {
		return staddress;
	}
	public void setStaddress(String staddress) {
		this.staddress = staddress;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStclass() {
		return stclass;
	}
	public void setStclass(int stclass) {
		this.stclass = stclass;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
