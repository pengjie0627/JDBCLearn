package com.itheima.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.utils.C3P0Utils02;
import com.itheima.utils.ConnectionManager;

/**
 * ת��DAO��,��Ҫ���ǲ������ݿ�
 * 
 * ���ǰ�����ֻ�漰���޸Ĳ���
 * 
 * @author yingpeng
 *
 */
public class AccountDao {
	
	//ת�˳�ȥ
	//jack ת��ȥ 1000Ԫ
	public void fromAccount(String fromName,double money) throws SQLException{
		Connection conn = ConnectionManager.getConnection();
		//1.����QueryRunner����
		QueryRunner qr = new QueryRunner();
		//2.ִ�м�Ǯ����
		qr.update(conn,"update account set money=money-? where name=?", money,fromName);
	}
	
	//��Ǯ����
	public void toAccount(String toName,double money) throws SQLException{
		Connection conn = ConnectionManager.getConnection();
		//1.����QueryRunner����
		QueryRunner qr = new QueryRunner();
		//2.��Ǯ����
		qr.update(conn,"update account set money=money+? where name=?",money,toName);

	}
	
}
