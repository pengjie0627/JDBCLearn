package com.itheima.demo05_SQLע����ʾ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
/*
 * PreparedStatement: ����Statement������
 * ����:��ֹSQLע��,�ڲ����Զ���sql������ת��,�����sql����еĺ�sql�﷨�йص��ַ���ʧЧ
 * ��ȡ����:
 * 		PreparedStatement pst = conn.PrepareStatement(sql���);//ע�� sql����в�Ҫд����Ĳ���
 * 		ͨ��set����Ϊpst�е�sql������þ����ֵ
 * 		pst.setXxxx(�ڼ���?��,�����ֵ);//?�Ŵ�1��ʼ
 */
public class SQLDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1.��ʾ�����û���
		System.out.println("�����������û���:");
		String username = sc.nextLine();
		//2.��ʾ��������
		System.out.println("��������������:");
		String password = sc.nextLine();
		//3.����1��2�����ݿ��в�ѯ����
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConnection();
//			st = conn.createStatement();
			String sql = "select * from users where username = ? and password = ?";
			st = conn.prepareStatement(sql);
			//����ֵ
			st.setObject(1,username);// �����1�����һ������
			st.setObject(2, password);// 2�����2���ʺ�			
//			System.out.println(sql);
			rs = st.executeQuery();
//			rs = st.executeQuery(sql);
			//4.�ж���û�в�ѯ������,����е�½�ɹ�,���û��ʧ��
			if(rs.next()){
				System.out.println("��½�ɹ�");
			}else{
				System.out.println("��½ʧ��");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}finally {
			JDBCUtils.closeAll(conn, st, rs);
		}
		
		
		
	}
}
