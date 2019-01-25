package com.itheima.demo03_JDBC工具类;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDemo {
	public static void main(String[] args) {
		// 1.获取到数据库连接
		Connection conn = null;
		// 2.通过连接对象, 获取SQL执行对象
		Statement st = null;
		// 3.st执行sql语句
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from category");
			// 4.处理结果集
			while (rs.next()) {
				Object cid = rs.getObject("cid");
				Object cname = rs.getObject("cname");
				System.out.println(cid + "\t" + cname);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 5.释放资源
			JDBCUtils.closeAll(conn, st, rs);
		}
		

	}
}
