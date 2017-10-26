package com.wangzhao.test;

import java.util.List;

import org.junit.Test;

import com.wangzhao.dao.impl.UserDaoImpl;
import com.wangzhao.entity.User;

public class TestUserDao {

	@Test
	public void testGetAll(){
		
		UserDaoImpl daoimpl = new UserDaoImpl();
		List<User> all = daoimpl.getAll();
		System.out.println(all);
	}
	
	@Test
	public void testUserAdd(){
		
//		UserDaoImpl daoimpl = new UserDaoImpl();
		
//		User user = new User();
//		user.setUsername("1");
//		user.setPassword("1");
//		
//		daoimpl.add(user);
		
	}
	
	
	@Test
	public void testUserDelete(){
		
		UserDaoImpl daoimpl = new UserDaoImpl();
		daoimpl.delete("1212");
		
	}
	
}
