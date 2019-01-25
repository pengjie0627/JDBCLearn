package com.itheima.demo03_JDBC������;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDemo {
	public static void main(String[] args) {
		// 1.��ȡ�����ݿ�����
		Connection conn = null;
		// 2.ͨ�����Ӷ���, ��ȡSQLִ�ж���
		Statement st = null;
		// 3.stִ��sql���
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from category");
			// 4.��������
			while (rs.next()) {
				Object cid = rs.getObject("cid");
				Object cname = rs.getObject("cname");
				System.out.println(cid + "\t" + cname);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 5.�ͷ���Դ
			JDBCUtils.closeAll(conn, st, rs);
		}
		

	}
}
