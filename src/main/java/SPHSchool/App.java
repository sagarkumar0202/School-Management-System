package SPHSchool;

import java.io.ObjectInputFilter.Status;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import SPHSchool.dao.SchoolAdminister;
import SPHSchool.dao.SchoolStudentOperation;
import SPHSchool.dao.SchoolTeacherOperation;


public class App 
{
	public static void main( String[] args ) 
    {
    	boolean status=true;
    	try
    	{
    		do
    		{
    			Scanner scn = new Scanner(System.in);
    			System.out.println("========================================");
    			System.out.println( "             S P H School                               " );
    			System.out.println("========================================");
    			System.out.println("WelCome to S P H School");
    			System.out.println("   1 -> Teacher");
    			System.out.println("   2 -> Student");
    			System.out.println("   3 -> Administer");
    			System.out.println("Enter your Option type:");
    			int userType=scn.nextInt();
        
    		//////////////////userType==1 is Started////////////////////
    			if(userType==1)
    			{
        	
    				System.out.println("Enter your  Teacher id:");
    				int teac_id=scn.nextInt();
    				System.out.println("Enter Password:");
    				String password1=scn.next();
        	
    				SchoolTeacherOperation ob=new SchoolTeacherOperation();
    				  
    				if(ob.login(teac_id, password1))
    				{
    					System.out.println("=======================================================================");
    					System.out.println("Login successfull!!");
    					System.out.println("=======================================================================");
    					boolean statuss=true;
    					do
    					{
    						System.out.println(""
    							+"   1.Student Detail Update \r\n"
    							+"   2.Students Attendance \r\n"
    							+"   3.Today Time-Table \r\n"
    							+"   4.Password Change\r\n"
    							+"   5.Logout");
                				int op=scn.nextInt();
                				if(op==1)
                				{
                				System.out.println("=======================================================================");
                				System.out.println("--- Student Detail Update ----");
                				System.out.println("=======================================================================");
                				
                				System.out.println("Enter your Student ID:");
                				long stid=scn.nextLong();
                				System.out.println("Enter Student Name:");
                				String newName=scn.next();
                				if(ob.StudentDetailUpdate(stid, newName))
                				{
                					System.out.println("Student Detail Update Successfully!!");
                					System.out.println("=======================================================================");
                    				
                				}
                				else
                				{
                					System.out.println("Problem in Student Detail Update!!");
                				}
                			}
                			else if(op==2)
                			{
                				
                    			System.out.println("Enter Students Id :");
                				long stid =scn.nextLong();
                				
                				System.out.println("Enter Date  :");
                				String dat =scn.next();
                				
                				System.out.println("Enter Attendance Status Present or Absent:");
                				String stu_att=scn.next();
                				
                				if(ob.StudentsAttendance(stid,dat,stu_att))
                				{
                					System.out.println("=======================================================================");
                					System.out.println("Students Attendance Done successfully !!!");
                					System.out.println("=======================================================================");
                				}	
                				else
                				{   
                					System.out.println("=======================================================================");
                					System.out.println("Problem in Students Attendance !!!");
                					System.out.println("=======================================================================");
                				}
                			}
                			else if(op==3)
                			{
								
								  System.out.println("Enter Your Id to check Today Time-Table :"); 
								  long teac_id1=scn.nextLong();  
								  ResultSet result=ob.TeacherTimeTable(teac_id);
								  while(result.next()) 
								  { 
									  System.out.println( "=======================================================================");
									  System.out.println("--- Time-Table Details ----"); 
									  System.out.println( "=======================================================================");
								  
									  System.out.println("Class :"+result.getInt(2));
									  System.out.println("Days :"+result.getString(3));
									  System.out.println("Lecture No :"+result.getLong(4));
									  System.out.println("Start Time :"+result.getDouble(5));
									  System.out.println("End Time:"+result.getDouble(6));
									  System.out.println("Subject :"+result.getString(7));
									  System.out.println( "=======================================================================");
								  }
								 
                			}
                			else if(op==4)
                			{
                				System.out.println("=======================================================================");
                				System.out.println("--- Password Change ----");
                				System.out.println("=======================================================================");
                				
                				System.out.println("Enter your Teacher ID:");
                				long teac_id1=scn.nextLong();
                				System.out.println("Enter your New Password:");
                				String newPassword=scn.next();
                				if(ob.changePassword(teac_id1, newPassword))
                				{
                					System.out.println("Password Changed Successfully!!");
                				}
                				else
                				{
                					System.out.println("Problem in password Changed!!");
                				}
                			}
                			else if(op==5)
                			{
                				ob.logout();
                				statuss=false;
                				System.out.println("=======================================================================");
                				System.out.println("Logged Out!!");
                				System.out.println("=======================================================================");
                			}	
        				}
    				
    				while(statuss);
    			}
    				
    					else
    					{
    						System.out.println("Login unsuccessfull!!");
    					}
    				
    				}
    				//////////////////userType==1 is Close////////////////////
    			
    			////////////////// userType==2 is Started////////////////////

    			if(userType==2)
    			{
        	
    				System.out.println("Enter your  Student id:");
    				int stid=scn.nextInt();
    				System.out.println("Enter Password:");
    				String pass=scn.next();
        	
    				SchoolStudentOperation  ob=new SchoolStudentOperation ();
    				//System.out.println(ob.login(teac_id, password));
    				if(ob.login(stid, pass))
    				{
    					System.out.println("=======================================================================");
    					System.out.println("Login successfull!!");
    					System.out.println("=======================================================================");
    					boolean statuss=true;
    					do
    					{
    						System.out.println("=======================================================================");
    						System.out.println("  1.Student Details \r\n"
    							 +"  2.Attendance Status \r\n"
    							 +"  3.Today Time-Table \r\n"
    							 +"  4.Password Change\r\n"
    							 +"  5.Logout");
                			int op=scn.nextInt();
                			if(op==1)
							{
                				System.out.println("Enter User  Id to check Your Information:");
                        		long accId=scn.nextLong();
                        		ResultSet result=ob.StudentDetails(stid);
                        		while(result.next())
                        		{
                        			System.out.println("=======================================================================");
                        			System.out.println("--- Your Information ----");
                                    System.out.println("=======================================================================");

                        			System.out.println(" Your Name :"+result.getString(2));
                        			System.out.println("Your Address :"+result.getString(3));
                        			System.out.println("Your Phone number :"+result.getLong(4));
                        			System.out.println("Your Email :"+result.getString(5));
                        			System.out.println("Your Current Class:"+result.getString(6));
                        			
                        		}
                			}
                			else if(op==2)
                			{
                				System.out.println("Enter Your Id to check Attendance Status :"); 
								  long stid1=scn.nextLong();  
								  ResultSet result=ob.AttendanceStatus(stid);
								  while(result.next()) 
								  { 
									  System.out.println( "=======================================================================");
									  System.out.println("--- Attendance Status ----"); 
									  System.out.println( "=======================================================================");
									  System.out.println("Date :"+result.getString(2));
									  System.out.println("Attendance Status :"+result.getString(3));
									  System.out.println( "=======================================================================");
								  }
                			}
                			else if(op==3)
                			{
                				 System.out.println("Enter Your Id to check Today Time-Table :"); 
								  long stid1=scn.nextLong();  
								  ResultSet result=ob.StudentsTimeTable(stid);
								  while(result.next()) 
								  { 
									  System.out.println( "=======================================================================");
									  System.out.println("--- Time-Table Details ----"); 
									  System.out.println( "=======================================================================");
								  
									  System.out.println("Class :"+result.getInt(2));
									  System.out.println("Days :"+result.getString(3));
									  System.out.println("Lecture No :"+result.getLong(4));
									  System.out.println("Start Time :"+result.getDouble(5));
									  System.out.println("End Time:"+result.getDouble(6));
									  System.out.println("Subject :"+result.getString(7));
									  System.out.println( "=======================================================================");
								  }
                			}
                			else if(op==4)
                			{
                				System.out.println("=======================================================================");
                				System.out.println("--- Password Change ----");
                				System.out.println("=======================================================================");
                				
                				System.out.println("Enter your Student ID:");
                				long stid1=scn.nextLong();
                				System.out.println("Enter your New Password:");
                				String newPassword=scn.next();
                				if(ob.changePassword(stid1, newPassword))
                				{
                					System.out.println("Password Changed Successfully!!");
                				}
                				else
                				{
                					System.out.println("Problem in password Changed!!");
                				}
                			}
                			else if(op==5)
                			{
                				ob.logout();
                				statuss=false;
                				System.out.println("=======================================================================");
                				System.out.println("Logged Out!!");
                				System.out.println("=======================================================================");
                			}	
        				}
    					while(statuss);
    				}
    					else
    					{
    						System.out.println("Login unsuccessfull!!");
    					}
    				}
    			
    	//////////////////userType==2 is Close////////////////////
    			
    	//////////////////userType==3 is Start////////////////////
    			else	if(userType== 3)
                {
        			System.out.println("Enter your  Admin id:");
                	int admin_id=scn.nextInt();
                	System.out.println("Enter Password:");
                	String password=scn.next();
                	
                	SchoolAdminister ob=new SchoolAdminister();
                	//System.out.println(ob.login(teac_id, password));
                	if(ob.login(admin_id, password))
                	{
                		System.out.println("=======================================================================");
                		System.out.println("Login successfull!!");
                        System.out.println("=======================================================================");
                        boolean statuss=true;
    					do
    					{
    						System.out.println("   1.Student Admission \r\n"
                				+ "   2.Teacher Registration  \r\n"
                				+ "   3.Teacher Attendance \r\n"
                				+ "   4.Time table Generate \r\n"
                				+ "   5.Password Change\r\n"
                				+ "   6.Logout");
                        		int op=scn.nextInt();
                        		if(op==1)
                    			{
                    				System.out.println("Enter Student Id for the new Student:");
                    				long stid=scn.nextLong();
                    				System.out.println("Enter Student name:");
                    				String stname=scn.next();
                    				System.out.println("Enter Student  address:");
                    				String staddress=scn.next();
                    				System.out.println("Enter phone number:");
                    				long phone=scn.nextLong();
                    				System.out.println("Enter valid email id:");
                    				String email=scn.next();
                    				System.out.println("Enter Class :");
                    				int stclass=scn.nextInt();
                    				System.out.println("Set Password for the new user :");
                    				String pass=scn.next();
                    				if(ob.StudentAdmission(stid,stname,staddress,phone,email,stclass,pass))
                    				{
                    					System.out.println("=======================================================================");
                    					System.out.println("Student Admission successfully!!");
                    					System.out.println("=======================================================================");
                    				}	
                    				else
                    				{   
                    					System.out.println("=======================================================================");
                    					System.out.println("Problem in Student Admission !!");
                    					System.out.println("=======================================================================");
                    				}
                    			}
                        		else if(op==2)
                    			{
                    				System.out.println("Enter Teacher Id for the new Teacher:");
                    				long teac_id=scn.nextLong();
                    				
                    				System.out.println("Enter Teacher Name:");
                    				String teac_name=scn.next();
                    				
                    				System.out.println("Enter Teacher  Address:");
                    				String teac_address=scn.next();
                    				
                    				System.out.println("Enter phone number:");
                    				long teac_phone=scn.nextLong();
                    				
                    				System.out.println("Enter valid email id:");
                    				String teac_email=scn.next();
                    				
                    				System.out.println("Enter Teacher Type :");
                    				String teac_type=scn.next();
                    				
                    				System.out.println("Enter Teacher Salary");
                    				double teac_salary=scn.nextDouble();
                    				
                    				System.out.println("Set Password for the New Teacher :");
                    				String password1=scn.next();
                    				
                    				if(ob.TeacherRegistration(teac_id,teac_name,teac_address,teac_phone,teac_email,teac_type,teac_salary,password))
                    				{
                    					System.out.println("=======================================================================");
                    					System.out.println("Teacher Registration successfully !!!");
                    					System.out.println("=======================================================================");
                    				}	
                    				else
                    				{   
                    					System.out.println("=======================================================================");
                    					System.out.println("Problem in Teacher Registration !!!");
                    					System.out.println("=======================================================================");
                    				}
                    			}
                        		else if(op==3)
                    			{
                        			System.out.println("Enter Teacher Id :");
                    				long teac_id =scn.nextLong();
                    				
                    				System.out.println("Enter Date  :");
                    				String dat =scn.next();
                    				
                    				System.out.println("Enter Attendance Status Present or Absent:");
                    				String teac_att=scn.next();
                    				
                    				if(ob.TeacherAttendance(teac_id,dat,teac_att))
                    				{
                    					System.out.println("=======================================================================");
                    					System.out.println("Teacher Attendance Done successfully !!!");
                    					System.out.println("=======================================================================");
                    				}	
                    				else
                    				{   
                    					System.out.println("=======================================================================");
                    					System.out.println("Problem in Teacher Attendance !!!");
                    					System.out.println("=======================================================================");
                    				}
                    			}
                        			
                        		else if(op==4)
                        		{
                        			
                        			System.out.println("Select Option ForTime table Generate ");
                        			System.out.println("   1.Student\r\n"
                            				+ "   2.Teacher  \r\n");
                        			System.out.println("Enter your Option type:");
                                    int op1=scn.nextInt();
                                    if(op1==1)
                                	{
                                    	System.out.println("Enter Student Id :");
                        				long stid =scn.nextLong();
                                    	
                        				System.out.println("Enter Class :");
                        				String clas =scn.next();
                        			
                        				System.out.println("Enter Days Name :");
                        				String days =scn.next();
                    				
                        				System.out.println("Enter Lacture Number :");
                        				int class_no =scn.nextInt();
                        				
                        				System.out.println("Enter Class Starting Time:");
                        				double start_tine=scn.nextDouble();
                    				
                        				System.out.println("Enter Class Ending Time:");
                        				double end_tine=scn.nextDouble();
                    				
                        				System.out.println("Enter Subject Name :");
                        				String sub =scn.next();
                        				
                        				if(ob.TimetableGenerateStudent(stid,clas,days,class_no,start_tine,end_tine,sub))
                        				{
                        					System.out.println("=======================================================================");
                        					System.out.println("Time table Generate For Student !!!");
                        					System.out.println("=======================================================================");
                        				}	
                        				else
                        				{   
                        					System.out.println("=======================================================================");
                        					System.out.println("Problem with Time table Generate !!!");
                        					System.out.println("=======================================================================");
                        				}
                        			}
                                    if(op1==2)
                                	{
                                    	System.out.println("Enter Teacher Id :");
                        				long teac_id =scn.nextLong();
                                    	
                        				System.out.println("Enter Class :");
                        				String clas =scn.next();
                        			
                        				System.out.println("Enter Days Name :");
                        				String days =scn.next();
                        				
                        				System.out.println("Enter Lacture Number :");
                        				int class_no =scn.nextInt();
                    				
                        				System.out.println("Enter Class Starting Time:");
                        				double start_tine=scn.nextDouble();
                    				
                        				System.out.println("Enter Class Ending Time:");
                        				double end_tine=scn.nextDouble();
                    				
                        				System.out.println("Enter Subject Name :");
                        				String sub =scn.next();
                    				
                        				if(ob.TimetableGenerateTeacher(teac_id,clas,days,class_no,start_tine,end_tine,sub))
                        				{
                        					System.out.println("=======================================================================");
                        					System.out.println("Time table Generate For Teacher !!!");
                        					System.out.println("=======================================================================");
                        				}	
                        				else
                        				{   
                        					System.out.println("=======================================================================");
                        					System.out.println("Problem with Time table Teacher !!!");
                        					System.out.println("=======================================================================");
                        				}
                        			}
                        			
                        		}
                        		else if(op==5)
                    			{
                    				System.out.println("=======================================================================");
                    				System.out.println("--- Password Change ----");
                    				System.out.println("=======================================================================");
                    				
                    				System.out.println("Enter your Student ID:");
                    				long admin_id1=scn.nextLong();
                    				System.out.println("Enter your New Password:");
                    				String newPassword=scn.next();
                    				if(ob.changePassword(admin_id1, newPassword))
                    				{
                    					System.out.println("Password Changed Successfully!!");
                    				}
                    				else
                    				{
                    					System.out.println("Problem in password Changed!!");
                    				}
                    			}
                    			else if(op==6)
                    			{
                    				ob.logout();
                    				statuss=false;
                    				System.out.println("=======================================================================");
                    				System.out.println("Logged Out!!");
                    				System.out.println("=======================================================================");
                    			}	
            				}
    					while(statuss);
                	}
        					else
        					{
        						System.out.println("Login unsuccessfull!!");
        					}
                        		
                     }
    			//////////////////userType==3 is Close////////////////////
                

                }
    	
        	while(status);
    	}
    	catch(Exception e)
        {
        		System.out.println(e.getMessage());
        }	
    }
}
    	
    
