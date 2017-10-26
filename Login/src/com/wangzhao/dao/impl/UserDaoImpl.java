package com.wangzhao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangzhao.dao.UserDAO;
import com.wangzhao.entity.User;
import com.wangzhao.utils.JdbcUtils;

public class UserDaoImpl implements UserDAO{

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet executeQuery = null;		
		try {			
			connection = JdbcUtils.getConnection();
		    String sql = "select * from Login";
		    prepareStatement = connection.prepareStatement(sql);
		    executeQuery = prepareStatement.executeQuery();
		    
		    ArrayList<User> listUsers = new ArrayList<User>();
		    while(executeQuery.next()){
		    	User user = new User();
		    	user.setUsername(executeQuery.getString("username"));
		    	user.setPassword(executeQuery.getString("password"));
		    	listUsers.add(user);
		    }		    
		    return listUsers;	
		} catch (Exception e) {			
			e.printStackTrace();
		}finally{
			JdbcUtils.release(connection, prepareStatement, executeQuery);
		}		
		return null;		
	}

	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into Login (username,password) values(?,?)";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, user.getUsername());
			prepareStatement.setString(2, user.getPassword());

			
			return prepareStatement.executeUpdate() > 0;
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally{
			JdbcUtils.release(connection, prepareStatement, null);
		}
		
		return false;
	}

	@Override
	public boolean delete(String username) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			
			connection = JdbcUtils.getConnection();
			String sql = "delete from Login where username = ?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1,username);
			
			return prepareStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	
}
