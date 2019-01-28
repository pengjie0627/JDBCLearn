package com.itheima.demo07_高级的JDBCUtils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class GJDBCUtils {
	//这个工具类,主要为我们获取一个数据库连接
		private static String driverName = null;
		private static String url = null;
		private static String username = null;
		private static String password = null;
		
		//静态代码块,目的,让第一次使用到JDBCUtils中加载驱动,第二次以后不再加载了
		static{
			//1.加载驱动
			try {
				//0.获取配置文件
				Properties ps = new Properties();
				ps.load(new FileInputStream("gjdbc_config.properties"));
				driverName = ps.getProperty("driverName");
				url = ps.getProperty("url");
				username = ps.getProperty("username");
				password = ps.getProperty("password");
				
				Class.forName(driverName);
			} catch (Exception e) {
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
