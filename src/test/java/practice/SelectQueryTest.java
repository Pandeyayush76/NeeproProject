package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SelectQueryTest {

	public static void main(String[] args) throws SQLException {
		
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		try {
		System.out.println("connection is done");
		Statement s=c.createStatement();
		ResultSet r=s.executeQuery("select * from empDetails");
		while(r.next())
		{
			System.out.println(r.getInt(1)+"\t"+r.getString(2)+"\t"+r.getString(3));
		}
		}
		catch(Exception e) {
			
		}
		finally {
		c.close();
		}

	}
}



