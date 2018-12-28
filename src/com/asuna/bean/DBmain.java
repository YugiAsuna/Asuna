package com.asuna.bean;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBmain {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接对象  
		//   url   数据库的地址    user  用户名     密码
		String url="jdbc:mysql://localhost:3306/book";
		String user = "root";
		String password = "Asuna0930";
		Connection connection =	 (Connection) DriverManager.getConnection(url, user, password);
		System.out.println(connection);
		connection.close();
	}
}
