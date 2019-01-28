package com.itheima.demo05_SQL注入演示;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	//这个工具类,主要为我们获取一个数据库连接
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/day04";
	private static String username = "root";
	private static String password = "123";
	
	//静态代码块,目的,让第一次使用到JDBCUtils中加载驱动,第二次以后不再加载了
	static{
		//1.加载驱动
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//System.out.println("驱动加载失败..请检查驱动包");
			throw new RuntimeException("驱动加载失败..请检查驱动包");
		}
	}
	
	public static Connection getConnection() throws Exception{
		//2.获取和数据库的连接
		Connection conn =  DriverManager.getConnection(url, username, password);
		//3.返回连接对象
		return conn;
		
	}
	//关闭所有资源的统一代码
	public static void closeAll(Connection conn,Statement st,ResultSet rs){
		//负责关闭
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
