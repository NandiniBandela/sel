package com.comcast.crm.generic.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection conn;

	public void getDBConnection(String url, String username, String password) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("Exception Handled in DatabaseUtility");
		}
	}

	public void getDBConnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		} catch (Exception e) {
			System.out.println("Exception Handled in DatabaseUtility");
		}
	}

	public void closeDBConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Exception Handled in DatabaseUtility");

		}
	}

	public ResultSet executeSelectQuery(String query) {
		ResultSet result = null;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Exception Handled in DatabaseUtility");

		}
		return result;
	}

	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Exception Handled in DatabaseUtility");

		}
		return result;
	}

}
