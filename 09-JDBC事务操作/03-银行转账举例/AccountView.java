package com.itheima.view;

import com.itheima.service.AccountService;

public class AccountView {
	public static void main(String[] args) {
		//ģ���û�ת��,���븶���˵�����,�տ��˵�����,ת�˽��
		String fromName = "jack";
		String toName = "tom";
		double money = 5000;
		
		AccountService service = new AccountService();
		
		service.transfer(fromName, toName, money);
	}
}
