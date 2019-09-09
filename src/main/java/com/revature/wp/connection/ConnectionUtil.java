package com.revature.wp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/WaterPlant";
		String username = "root";
		String password = "ganeshsriram22";
		Connection con = null;
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, username, password);
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("unable to load driver class");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("unable to get DB Connection");
		}
		return con;

	}

	public static void main(String[] args) {

		getConnection();
	}

}
