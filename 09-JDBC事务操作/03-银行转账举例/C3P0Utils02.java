package com.itheima.utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * ��C3P0���ӳ��� ��ѭ��javax.sql.DataSource�ӿڵ�ʵ����:
 * 		ComboPooledDataSource
 * 		
 * 
 * @author yingpeng
 *
 */
public class C3P0Utils02 {

	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	
	public static DataSource getDataSource(){
		return ds;
	}
	//static������������ݿ������Ĵ�Ҫ��
	
	public static Connection getConnection() throws SQLException{
		//��ȡ����,��Ҫ�Լ�ȥDriverManager��ȡ,���Ǵ�C3P0���ӳػ�ȡ
		return ds.getConnection();
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
