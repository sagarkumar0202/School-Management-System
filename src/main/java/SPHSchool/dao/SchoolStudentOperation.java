package SPHSchool.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolStudentOperation 
{
	DataBaseConnection ob=new DataBaseConnection();
	Connection conn=ob.dbConnection();

public boolean login(int stid,String pass) 
{
	try
	{
		PreparedStatement ps=conn.prepareStatement("select * from student_admission where stid=? && pass=?");
		ps.setInt(1, stid);
		ps.setString(2, pass);
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

//public void StudentDetails(long stid)
public ResultSet StudentDetails(long stid) throws SQLException	
{
	PreparedStatement ps=conn.prepareStatement("select * from student_admission where stid=?");
	ps.setLong(1, stid);
	ResultSet result=ps.executeQuery();
	return result;
}

public ResultSet StudentsTimeTable(long stid) throws SQLException	
{
	PreparedStatement ps=conn.prepareStatement("select * from time_table_student where stid=?");
	ps.setLong(1, stid);
	ResultSet result=ps.executeQuery();
	return result;
}

public ResultSet AttendanceStatus(long stid) throws SQLException	
{
	PreparedStatement ps=conn.prepareStatement("select * from students_attendance where stid=?");
	ps.setLong(1, stid);
	ResultSet result=ps.executeQuery();
	return result;
}


public boolean changePassword(long stid,String newPassword) throws SQLException
{
	PreparedStatement ps=conn.prepareStatement("update student_admission set pass=? where stid=? ");
	ps.setString(1, newPassword);
	ps.setLong(2, stid);
	int affectedRows=ps.executeUpdate();
	
	if(affectedRows>0)
		return true;
	else
		return false;
}
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