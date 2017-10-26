package com.wangzhao.dao;

import java.util.List;

import com.wangzhao.entity.User;

public interface UserDAO {

	
	List<User> getAll();
	
	boolean add(User user);
	
	boolean delete(String username);
}
