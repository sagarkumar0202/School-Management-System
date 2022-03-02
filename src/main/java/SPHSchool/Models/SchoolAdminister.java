package SPHSchool.Models;

import java.util.Objects;

public class SchoolAdminister 
{
	int admin_id;
	String password;
	
	
	
	public SchoolAdminister(int admin_id, String password) 
	{
		super();
		this.admin_id = admin_id;
		this.password = password;
	}
	
	public SchoolAdminister() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() 
	{
		return Objects.hash(admin_id, password);
	}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolAdminister other = (SchoolAdminister) obj;
		return admin_id == other.admin_id && Objects.equals(password, other.password);
	}
	public int getAdmin_id() 
	{
		return admin_id;
	}
	public void setAdmin_id(int admin_id) 
	{
		this.admin_id = admin_id;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
}
