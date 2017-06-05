package edu.uit.qlcc.common.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/qlcc";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "P@ssword";
	private static ConnectDatabase instance = null;
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectDatabase getInstance() {
		if (null == instance)
			instance = new ConnectDatabase();
		return instance;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("connect fail");
			e.printStackTrace();
		}
		return connection;
	}
}
