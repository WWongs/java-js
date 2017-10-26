package com.wangzhao.entity;

import java.util.List;

public class AllUser {

	
	private int code = FAIlED;
	public static final int SUCCESS = 1;
	public static final int FAIlED = 0;
	
	private List<User> users;
	public AllUser(){}
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "AllUser [code=" + code + ", users=" + users + "]";
	}
	
	
	
}
