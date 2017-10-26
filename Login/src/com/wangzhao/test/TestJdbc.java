package com.wangzhao.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.wangzhao.utils.JdbcUtils;

public class TestJdbc {

	@Test
	public void testJdbcConnect() throws SQLException{	
		Connection connection = JdbcUtils.getConnection();		
		System.out.println(connection);
	}
	
	
	
}
