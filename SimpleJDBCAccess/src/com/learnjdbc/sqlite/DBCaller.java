package com.learnjdbc.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCaller {

	public static void main(String[] args) {
		System.out.println("Welcome to JDBC");
		connectWithDatabase();
	}
	
	private static void connectWithDatabase() {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");  // http://jtds.sourceforge.net/
			Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.150/SQLEXPRESS:1433;databaseName=DATABASE;user=sa;password=PASSWORD");
			Statement statement = connection.createStatement();
	        ResultSet rs = statement.executeQuery("select * from students");
	      while(rs.next())
	      {
	        System.out.print("name = " + rs.getString("name"));
	        System.out.println(", age = " + rs.getInt("age"));
	      }
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found.. check if your classpath is missing the jar file");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Sql exception occured: "+e.getMessage());
			e.printStackTrace();
		}
	}

}
