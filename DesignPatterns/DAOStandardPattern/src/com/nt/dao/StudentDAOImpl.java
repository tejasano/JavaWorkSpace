//StudentDAOImpl.java
package com.nt.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class StudentDAOImpl implements StudentDAO {
	private static Logger logger = Logger
			.getLogger("d:\\Practices/DesignPatterns/DAOStandardPattern/src/com/nt/logging/logger_student.txt");
	private static final String STUDENT_INSERT_QUERY = "INSERT INTO STUD VALUES(?,?,?,?)";
	private static Properties properties = null;
	static {
		FileInputStream fileInputStream = null;
		// Get Connection Object
		try {
			fileInputStream = new FileInputStream(new File(
					"D:\\Practices/DesignPatterns/DAOStandardPattern/src/com/nt/commons/jdbc.properties"));
		} catch (FileNotFoundException fileNotFoundException) {
			// TODO Auto-generated catch block
			logger.info("StudentDAOImpl:staic:" + fileNotFoundException);
			fileNotFoundException.printStackTrace();
		}
		properties = new Properties();
		try {
			properties.load(fileInputStream);
		} catch (IOException ioException) {
			// TODO Auto-generated catch block
			logger.info("StudentDAOImpl:static:" + ioException);
			ioException.printStackTrace();
		}
	}

	@Override
	public int insert(StudentBO studentBO) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int count = 0;
		try {
			// Get Connection Object From ConnectionFactory
			connection = ConnectionFactory.createConnection(properties.getProperty("jdbc.url"),
					properties.getProperty("jdbc.user"), properties.getProperty("jdbc.password"));
			logger.info("StudentDAOImpl:insert(-):Connection Object gets Created");
			// Create PreparedStatement Object
			preparedStatement = connection.prepareStatement(STUDENT_INSERT_QUERY);
			preparedStatement.setInt(1, studentBO.getSid());
			preparedStatement.setString(2, studentBO.getSname());
			preparedStatement.setString(3, studentBO.getSaddress());
			preparedStatement.setString(4, studentBO.getEmail());
			count = preparedStatement.executeUpdate();
		} // try
		catch (SQLException sqlException) {
			// TODO: handle exception
			logger.info("StudentDAOImpl:insert(-):" + sqlException);
			sqlException.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException sqlException2) {
				logger.info("StudentDAOImpl:insert(-):" + sqlException2);
				sqlException2.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlException3) {
				logger.info("StudentDAOImpl:insert(-):" + sqlException3);
				sqlException3.printStackTrace();
			}
		}
		return count;
	}

}
