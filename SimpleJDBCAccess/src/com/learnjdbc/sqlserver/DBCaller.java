package com.learnjdbc.sqlserver;

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
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:sqlite_test_db.db");//using a relative path here
			Statement statement = connection.createStatement();
	        ResultSet rs = statement.executeQuery("select * from students"); // READ STATMENT
	        //statement.executeUpdate("INSERT/UPDATE/DROP SQL STATEMENTS HERE"); // WRITE STATMENT
	      while(rs.next())
	      {
	        // read the result set
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
