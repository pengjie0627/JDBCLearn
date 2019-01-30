package com.itheima.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * ���ӹ�����:
 * 	��Ҫ�����ȡ����,��������,�ύ����,�ع�����
 * @author yingpeng
 *
 */
public class ConnectionManager {
	//1.����һ������ ThreadLocal ���������浱ǰ�̵߳�����
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//2.��ȡ����
	public static Connection getConnection() throws SQLException{
		//1.�ȴ�tl�л�ȡ����
		Connection conn =  tl.get();
		//2.�ж�conn�Ƿ�Ϊ��
		if(conn == null){
			//˵�� ��service���һ�λ�ȡ
			conn = C3P0Utils02.getConnection();
			tl.set(conn);
		}
		//�����Ϊ�� ˵�� ��dao��ڶ����Ժ��ȡ
		return conn;
	}
	
	//3.��������
	public static  void start() throws SQLException{
		ConnectionManager.getConnection().setAutoCommit(false);
	}
	
	//4.�ύ����
	public static void commit() throws SQLException{
		ConnectionManager.getConnection().commit();
	}
	//5.�ع�����
	public static void rollback() throws SQLException{
		ConnectionManager.getConnection().rollback();
	}
	//6.�ر�����
	public static void close() throws SQLException{
		ConnectionManager.getConnection().close();
	}
}
