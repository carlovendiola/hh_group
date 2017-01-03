package com.happyheaven.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.happyheaven.dao.UserDao;

public class UserDaoImpl implements UserDao
{

	private DataSource dataSource;
	
	
	public DataSource getDataSource() {
		return dataSource;
	}



	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}



	@Override
	public boolean isValidUser(String userName, String password) throws SQLException{
		
		String query = "Select count(1) from user where username = ? and password = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, userName);
		pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		if(resultSet.next())
		    return (resultSet.getInt(1) > 0);
        else
           return false;
	}
	

}
