package SPHSchool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolTeacherOperation
{

	DataBaseConnection ob=new DataBaseConnection();
	Connection conn=ob.dbConnection();
	
	public boolean login(int teac_id,String password1) 
	{
		try
		{
			PreparedStatement ps=conn.prepareStatement("select * from school_teacher where teac_id=? && password1=?");
			ps.setInt(1, teac_id);
			ps.setString(2, password1);
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

	/*
	 * public boolean StudentAdmission(long stid,String stname,String staddress,long
	 * phone,String email, int stclass,String pass) throws SQLException {
	 * PreparedStatement ps=conn.
	 * prepareStatement("insert into student_admission values(?,?,?,?,?,?,?)");
	 * ps.setLong(1, stid); ps.setString(2, stname); ps.setString(3, staddress);
	 * ps.setLong(4, phone); ps.setString(5,email); ps.setInt(6,stclass);
	 * ps.setString(7, pass);
	 * 
	 * int affectedRows=ps.executeUpdate();
	 * 
	 * if(affectedRows>0) return true; else return false; }
	 */

	public boolean StudentDetailUpdate(long stid,String newName) throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("update student_admission set stname=? where stid=? ");
		ps.setString(1, newName);
		ps.setLong(2, stid);
		int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0)
			return true;
		else
			return false;
	}
	
	public ResultSet TeacherTimeTable(long teac_id) throws SQLException	
	{
		PreparedStatement ps=conn.prepareStatement("select * from time_table_teacher where teac_id=?");
		ps.setLong(1, teac_id);
		ResultSet result=ps.executeQuery();
		return result;
	}
	
	
	public boolean StudentsAttendance(long stid,String dat, String stu_att) throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("insert into students_attendance values(?,?,?)");
	
		ps.setLong(1, stid);
		ps.setString(2, dat);
		ps.setString(3,  stu_att);
	int affectedRows=ps.executeUpdate();
		
		if(affectedRows>0)
			return true;
		else
			return false;
	}
	
	public boolean changePassword(long teac_id,String newPassword) throws SQLException
	{
		PreparedStatement ps=conn.prepareStatement("update school_teacher set password1=? where teac_id=? ");
		ps.setString(1, newPassword);
		ps.setLong(2, teac_id);
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
