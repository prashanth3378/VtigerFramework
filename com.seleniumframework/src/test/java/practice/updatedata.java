package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class updatedata {

	public static void main(String[] args) throws SQLException {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yentra","root","root");
		Statement stat = conn.createStatement();
		String quary="insert into student(first_name,last_name,address)values('raju','hr','INDIA')";
		int result = stat.executeUpdate(quary);
		if(result==1)
		{
			System.out.println("user created");
		}
		
		else
		{
			System.out.println("user not created");
		}
	}
}


