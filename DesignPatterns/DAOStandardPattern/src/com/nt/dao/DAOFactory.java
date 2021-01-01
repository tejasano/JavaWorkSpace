//DAOFactory.java
package com.nt.dao;

public class DAOFactory {

	public static StudentDAO getInstance(String type) {
		if (type.equals("jdbc")) {
			return new StudentDAOImpl();
		} else {
			return null;
		}
	}
}