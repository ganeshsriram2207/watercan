package com.revature.wp.services;

import java.sql.SQLException;

import com.google.protobuf.ServiceException;
import com.revature.wp.dao.UserDAO;
import com.revature.wp.dao.UserDAOImpl;
import com.revature.wp.exception.DBException;
import com.revature.wp.exception.ValidatorException;

import validator.UserValidator;

public class UserService {

	public UserDAO login(String name, String password) throws ServiceException, SQLException, DBException {

		UserDAOImpl user = null;
		UserValidator uv=null;
		try {
			uv.Login(name, password);
			user.login(name, password);

		} catch (ValidatorException e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
		return user;
	}
}
