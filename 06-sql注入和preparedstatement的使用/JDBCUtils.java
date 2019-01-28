package com.itheima.demo05_SQLע����ʾ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	//���������,��ҪΪ���ǻ�ȡһ�����ݿ�����
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/day04";
	private static String username = "root";
	private static String password = "123";
	
	//��̬�����,Ŀ��,�õ�һ��ʹ�õ�JDBCUtils�м�������,�ڶ����Ժ��ټ�����
	static{
		//1.��������
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
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
