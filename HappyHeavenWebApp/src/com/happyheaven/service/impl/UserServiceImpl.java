package com.happyheaven.service.impl;

import java.sql.SQLException;

import com.happyheaven.dao.UserDao;
import com.happyheaven.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public boolean isValidUser(String userName, String password) throws SQLException
	{
		// TODO Auto-generated method stub
		return userDao.isValidUser(userName, password);
	}
	
}
