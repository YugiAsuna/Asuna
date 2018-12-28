package com.asuna.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
	public static String url  = "jdbc:mysql://localhost:3306/book?rewriteBatchedStatements=true";
	public static String user = "root";
	public static String password = "Asuna0930";
	public static String driver =  "com.mysql.jdbc.Driver";
	static {
		try {
			Class.forName(Util.driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//创建连接对象    定义静态的连接方法      实现调用连接实现数据库的连接
	public static Connection getConn() {
		//加载注册驱动
				try {
					return DriverManager.getConnection(Util.url, Util.user, Util.password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return null;
		
	}
	
	
	   
	public static void close(Connection connection,Statement st,ResultSet rs ) {
		if(st != null) {

			try {
				st.close();
			} catch (Exception e2) {
				e2.printStackTrace();//打印异常信息
			}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();//打印异常信息
				}
				
				
			}
	}
	
	
	
}
