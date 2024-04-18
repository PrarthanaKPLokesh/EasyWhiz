package com.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	//Register
	//getConnwction for DataBase
	//Create Statement
	//Execute query/update query
	//close DBconnection
	Connection con=null;
	public void connectToDB() throws SQLException 
	{
		Driver driver =new Driver();
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection(IpathConstant.DBURL,IpathConstant.DBUsername,IpathConstant.DBPassword);
	}
	public void executeAndGetData(String query,int colIndex,String expData) throws SQLException 
	{
		 Statement state = con.createStatement();
		
		ResultSet result = state.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String actual = result.getString(colIndex);
			if(actual.contains("expData"))
			{
				flag=true;
				break;
				
			}
		}
		if(flag==true)
				System.out.println("element is present");
				else
					System.out.println("element is not present");
					
					
		}
		
	

public void closeDB() throws SQLException
{
	con.close();
}
}

