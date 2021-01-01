//ConnectionFactory.java
package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionFactory {
	private static Logger logger = Logger.getLogger("d://Practices/DesignPatterns/DAOStandardPattern/src/com/nt/logging/logging_student.txt");

	public static Connection createConnection(String url, String username, String password) {
		Connection connection = null;
		try {
			// Establish Connection With DB S/W
			connection = DriverManager.getConnection(url, username, password);
			logger.info("Connection With Database S/W created Successfully");
		} catch (SQLException sqlException) {
			// TODO Auto-generated catch block
			logger.throwing("ConnectionFactory", "createConnection(-,-,-)", sqlException);
			sqlException.printStackTrace();
		}
		return connection;
	}// method
}// class
