package com.itheima.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.dao.AccountDao;
import com.itheima.utils.C3P0Utils02;
import com.itheima.utils.ConnectionManager;

/**
 * ת�˹��ܵ�ҵ���
 * 
 * @author yingpeng
 *
 */
public class AccountService {

	//ת��ҵ��
	public void transfer(String fromName,String toName,double money){
		//ֱ�ӵ���dao
		AccountDao dao = new AccountDao();
		try {
			//��������
			ConnectionManager.start();
			//ת��ȥ
			dao.fromAccount(fromName, money);
			//ģ���쳣
			System.out.println(1/0);
			//�û���
			dao.toAccount(toName, money);
			//�ύ����
			ConnectionManager.commit();
			System.out.println("ת�˳ɹ�!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("��������쳣,����ع�");
			//�ع�����
			try {
				ConnectionManager.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				ConnectionManager.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
