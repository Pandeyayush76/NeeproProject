package MyPractice;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JExecuteQuery {
	
	public static void main(String[] args)throws SQLException {
	Connection c=null;
	//Driver div=new Driver();
		//DriverManager.registerDriver(div);
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			Statement s=c.createStatement();
			ResultSet r=s.executeQuery("select * from empDetails");
			while(r.next())
			{
				System.out.println(r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3));
			}
c.close();
	
	

	}

}
