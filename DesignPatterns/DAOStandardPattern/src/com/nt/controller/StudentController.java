//StudentController.java
package com.nt.controller;

import java.sql.SQLException;

import com.nt.dao.DAOFactory;
import com.nt.dao.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.vo.StudentVO;

public class StudentController {
	public String registerStudent(StudentVO studentVO) {
		StudentBO studentBO = null;
		StudentDAO studentDAO = null;
		int count = 0;
		studentBO = new StudentBO();
		studentBO.setSid(studentVO.getSid());
		studentBO.setSname(studentVO.getSname());
		studentBO.setSaddress(studentVO.getSaddress());
		studentBO.setEmail(studentVO.getEmail());
		studentDAO = DAOFactory.getInstance("jdbc");
		try {
			count = studentDAO.insert(studentBO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count == 0) {
			return "Registration Failed";
		} else {
			return "Registration Successful";
		}
	}
}
