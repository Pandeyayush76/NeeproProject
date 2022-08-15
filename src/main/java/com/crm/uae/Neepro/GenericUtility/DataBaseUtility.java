package com.crm.uae.Neepro.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {

	/*
	 * --->Fetch data from database.
	 * Make Driver,Connection and ResultSet as Static 
	 */
	static Driver driver;
	static Connection c;
	static ResultSet r;
	public void getConnectionFromDataBase() throws Throwable
	{
		driver=new Driver();
		DriverManager.registerDriver(driver);
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	}
	public void closeDataBaseConnection() throws Throwable
	{
		c.close();
	}
	public ResultSet executeQuery(String query) throws Throwable
	{
		r=c.createStatement().executeQuery(query);
		return r;
	}
	public int updateQuery(String query) throws Throwable
	{
		int r=c.createStatement().executeUpdate(query);
		return r;
	}
	public boolean executeQueryAndVerify(String query,String colName,String expectedData) throws Throwable
	{
		r=c.createStatement().executeQuery(query);
		while(r.next())
		{
			if(r.getString(colName).equals(expectedData))
				break;
		}
		return false;
	}
	
}
