package com.wangzhao.service;

import java.util.List;

import com.wangzhao.entity.User;

public interface BusinessService {

	
    List<User> getAllUser();
	
	boolean addUser(User user);
	
	boolean deleteUser(String id);
}
