package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static String DBName="SMEVCS";
	public static String DBUSER="mahesh";
	public static String DBPASSWORD="mahesh12@";
	public static Connection connection;
	public static Connection getConnection() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName,DBUSER,DBPASSWORD);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}  
}
