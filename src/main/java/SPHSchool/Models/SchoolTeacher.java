package SPHSchool.Models;

public class SchoolTeacher 
{
	int teac_id;
	String teac_name;
	String teac_address;
	long teac_phone;
	String teac_email;
	String teac_type;
	double teac_salary;
	String password1;
	
	
	
	
	public int getTeac_id() 
	{
		return teac_id;
	}



	public void setTeac_id(int teac_id) 
	{
		this.teac_id = teac_id;
	}



	public String getTeac_name()
	{
		return teac_name;
	}



	public void setTeac_name(String teac_name)
	{
		this.teac_name = teac_name;
	}



	public String getTeac_address() 
	{
		return teac_address;
	}



	public void setTeac_address(String teac_address) 
	{
		this.teac_address = teac_address;
	}



	public long getTeac_phone() 
	{
		return teac_phone;
	}



	public void setTeac_phone(long teac_phone)
	{
		this.teac_phone = teac_phone;
	}



	public String getTeac_email() {
		return teac_email;
	}



	public void setTeac_email(String teac_email) 
	{
		this.teac_email = teac_email;
	}



	public String getTeac_type() 
	{
		return teac_type;
	}



	public void setTeac_type(String teac_type)
	{
		this.teac_type = teac_type;
	}



	public double getTeac_salary() {
		return teac_salary;
	}



	public void setTeac_salary(double teac_salary)
	{
		this.teac_salary = teac_salary;
	}



	public String getPassword1()
	{
		return password1;
	}



	public void setPassword1(String password1) 
	{
		this.password1 = password1;
	}



	@Override
	public String toString() 
	{
		return "SchoolTeacher [teac_id=" + teac_id + ", teac_name=" + teac_name + ", teac_address=" + teac_address
				+ ", teac_phone=" + teac_phone + ", teac_email=" + teac_email + ", teac_type=" + teac_type
				+ ", teac_salary=" + teac_salary + ", password1=" + password1 + "]";
	}



	public SchoolTeacher(int teac_id, String teac_name, String teac_address, long teac_phone, String teac_email,
			String teac_type, double teac_salary, String password1)
	{
		super();
		this.teac_id = teac_id;
		this.teac_name = teac_name;
		this.teac_address = teac_address;
		this.teac_phone = teac_phone;
		this.teac_email = teac_email;
		this.teac_type = teac_type;
		this.teac_salary = teac_salary;
		this.password1 = password1;
	}



	public SchoolTeacher() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
		
}
