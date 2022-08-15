package MyPractice;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JQueryUpdate {

	public static void main(String[] args) throws Throwable {
		//Driver d=new Driver();
		//DriverManager.registerDriver(d);
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		Statement s=c.createStatement();
		String k="insert into empDetails values('5','Roshan','Calcutta')";
		int r=s.executeUpdate(k);
		if(r==1)
		{
			System.out.println("Deatils updated");
		}else
		{
			System.out.println("Details not updated");
		}
		c.close();

	}

}
