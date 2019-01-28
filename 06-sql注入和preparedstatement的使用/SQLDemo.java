package com.itheima.demo05_SQL注入演示;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
/*
 * PreparedStatement: 他是Statement的子类
 * 作用:防止SQL注入,内部会自动对sql语句进行转译,让这个sql语句中的和sql语法有关的字符都失效
 * 获取方法:
 * 		PreparedStatement pst = conn.PrepareStatement(sql语句);//注意 sql语句中不要写具体的参数
 * 		通过set方法为pst中的sql语句设置具体的值
 * 		pst.setXxxx(第几个?号,具体的值);//?号从1开始
 */
public class SQLDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1.提示输入用户名
		System.out.println("请输入您的用户名:");
		String username = sc.nextLine();
		//2.提示输入密码
		System.out.println("请输入您的密码:");
		String password = sc.nextLine();
		//3.根据1和2从数据库中查询数据
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConnection();
//			st = conn.createStatement();
			String sql = "select * from users where username = ? and password = ?";
			st = conn.prepareStatement(sql);
			//设置值
			st.setObject(1,username);// 这里的1代表第一个？号
			st.setObject(2, password);// 2代表第2个问号			
//			System.out.println(sql);
			rs = st.executeQuery();
//			rs = st.executeQuery(sql);
			//4.判断有没有查询到数据,如果有登陆成功,如果没有失败
			if(rs.next()){
				System.out.println("登陆成功");
			}else{
				System.out.println("登陆失败");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}finally {
			JDBCUtils.closeAll(conn, st, rs);
		}
		
		
		
	}
}
