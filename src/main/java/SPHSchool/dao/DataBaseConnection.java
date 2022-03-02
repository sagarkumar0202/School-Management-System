package SPHSchool.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection
{
	public Connection dbConnection()
	{
		Connection conn=null;
		
		String databaseUrl="jdbc:mysql://localhost:3306/sph";
		String userName="root";
		String userPassword="mysql";
		try 
				{
					conn=DriverManager.getConnection(databaseUrl, userName, userPassword);
					
				} 
				
				catch (SQLException e) 
				{
					System.out.println("Server Problem!!");
				}
		return conn;	
		
	}

}