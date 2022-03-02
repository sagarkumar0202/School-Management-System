package SPHSchool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolAdminister 
{
	DataBaseConnection ob=new DataBaseConnection();
	Connection conn=ob.dbConnection();

public boolean login(int admin_id,String password) 
{
	try
	{
		PreparedStatement ps=conn.prepareStatement("select * from school_administer where admin_id=? && password=?");
		ps.setInt(1, admin_id);
		ps.setString(2, password);
		ResultSet result=ps.executeQuery();
		if(result.next())
		{
			return true; 
		}
		else
		{
			return false;
		}
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	return false;
}

////////////////////////////Student Admission Detail//////////////////////
public boolean StudentAdmission(long stid,String stname,String staddress,long phone,String email, int stclass,String pass) throws SQLException
{
	PreparedStatement ps=conn.prepareStatement("insert into student_admission values(?,?,?,?,?,?,?)");
	ps.setLong(1, stid);
	ps.setString(2, stname);
	ps.setString(3, staddress);
	ps.setLong(4, phone);
	ps.setString(5,email);
	ps.setInt(6,stclass);
	ps.setString(7, pass);
	
	int affectedRows=ps.executeUpdate();
	
	if(affectedRows>0)
		return true;
	else
		return false;
}

//////////////////////////// Teacher Registration Detail//////////////////////

public boolean TeacherRegistration(long teac_id,String teac_name,String teac_address,long teac_phone,String teac_email, String teac_type,double teac_salary,String password1) throws SQLException
{
	PreparedStatement ps=conn.prepareStatement("insert into school_teacher values(?,?,?,?,?,?,?,?)");
	ps.setLong(1, teac_id);
	ps.setString(2, teac_name);
	ps.setString(3, teac_address);
	ps.setLong(4, teac_phone);
	ps.setString(5,teac_email);
	ps.setString(6,teac_type);
	ps.setDouble(7, teac_salary);
	ps.setString(8, password1);
	
	int affectedRows=ps.executeUpdate();
	
	if(affectedRows>0)
		return true;
	else
		return false;
}
public boolean TeacherAttendance(long teac_id,String dat,String teac_att) throws SQLException
{
	PreparedStatement ps=conn.prepareStatement("insert into teacher_attendance values(?,?,?)");
	ps.setLong(1, teac_id);
	ps.setString(2,  dat);
	ps.setString(3,  teac_att);
int affectedRows=ps.executeUpdate();
	
	if(affectedRows>0)
		return true;
	else
		return false;
}

public boolean TimetableGenerateStudent(long stid,String clas,String days,int class_no,double start_tine,double end_tine,String sub) throws SQLException
{
	PreparedStatement ps=conn.prepareStatement("insert into time_table_student values(?,?,?,?,?,?,?)");
	ps.setLong(1, stid);
	ps.setString(2, clas);
	ps.setString(3, days);
 	ps.setInt(4, class_no); 
  	ps.setDouble(5, start_tine);
  	ps.setDouble(6, end_tine); 
  	ps.setString(7, sub); 
	
	int affectedRows=ps.executeUpdate();
	
	if(affectedRows>0)
		return true;
	else
		return false;
}


  public boolean TimetableGenerateTeacher(long teac_id,String clas,String days,int class_no,double start_tine,double end_tine,String sub) throws SQLException 
  {
  	PreparedStatement
 	ps=conn.prepareStatement("insert into time_table_teacher values(?,?,?,?,?,?,?)");
  	ps.setLong(1, teac_id);
  	ps.setString(2, clas); 
  	ps.setString(3, days); 
 	ps.setInt(4, class_no); 
  	ps.setDouble(5, start_tine);
  	ps.setDouble(6, end_tine); 
  	ps.setString(7, sub); 
  	int affectedRows=ps.executeUpdate();
  
  	if(affectedRows>0) return true; else return false;
   }
 

public boolean changePassword(long admin_id,String newPassword) throws SQLException
{
	PreparedStatement ps=conn.prepareStatement("update school_administer set password=? where admin_id=? ");
	ps.setString(1, newPassword);
	ps.setLong(2, admin_id);
	int affectedRows=ps.executeUpdate();
	
	if(affectedRows>0)
		return true;
	else
		return false;
}

//public boolean logout() throws SQLException
//{
//	conn.close();
//	return true;
//}

public boolean logout() 
{
	try
	{
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	return true;
}
}