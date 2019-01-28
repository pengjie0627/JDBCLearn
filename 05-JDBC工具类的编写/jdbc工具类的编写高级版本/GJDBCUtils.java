package com.itheima.demo07_�߼���JDBCUtils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class GJDBCUtils {
	//���������,��ҪΪ���ǻ�ȡһ�����ݿ�����
		private static String driverName = null;
		private static String url = null;
		private static String username = null;
		private static String password = null;
		
		//��̬�����,Ŀ��,�õ�һ��ʹ�õ�JDBCUtils�м�������,�ڶ����Ժ��ټ�����
		static{
			//1.��������
			try {
				//0.��ȡ�����ļ�
				Properties ps = new Properties();
				ps.load(new FileInputStream("gjdbc_config.properties"));
				driverName = ps.getProperty("driverName");
				url = ps.getProperty("url");
				username = ps.getProperty("username");
				password = ps.getProperty("password");
				
				Class.forName(driverName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//System.out.println("��������ʧ��..����������");
				throw new RuntimeException("��������ʧ��..����������");
			}
		}
		
		public static Connection getConnection() throws Exception{
			//2.��ȡ�����ݿ������
			Connection conn =  DriverManager.getConnection(url, username, password);
			//3.�������Ӷ���
			return conn;
			
		}
		//�ر�������Դ��ͳһ����
		public static void closeAll(Connection conn,Statement st,ResultSet rs){
			//����ر�
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
