package com.wangzhao.service.impl;

import java.util.List;

import com.wangzhao.dao.impl.UserDaoImpl;
import com.wangzhao.entity.User;
import com.wangzhao.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {

	private UserDaoImpl daoimpl = new UserDaoImpl();
	
	
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return daoimpl.getAll();
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return daoimpl.add(user);
	}

	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return daoimpl.delete(id);
	}

	
	
}
