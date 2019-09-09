package com.revature.wp.dao;

import java.sql.SQLException;

import com.revature.wp.model.UserDetail;

public interface UserDAO 

{	
	
	UserDetail findByUsername(String name,String password) throws SQLException;
	

}



