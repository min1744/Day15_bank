package com.iu.control;

import java.util.Scanner;

import com.iu.account.AccountService;
import com.iu.ti.TranService;
import com.iu.view.View;

public class AccountController {
	private Scanner sc;
	private AccountService accountService;
	private TranService tranService;
	private View view;
	
	public AccountController() {
		sc = new Scanner(System.in);
		accountService = new AccountService();
		tranService = new TranService();
		view = new View();
	}
	
	public void start() {
		boolean check = true;
		String message = null;
		while(check) {
			System.out.println("1.계좌개설");
			System.out.println("2.입금");
			System.out.println("3.출금");
			System.out.println("4.종료");
			System.out.print("번호를 입력하세요 : ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				message = accountService.insert();
				view.view(message);
				break;
			case 2:
				message = tranService.tran(0);
				view.view(message);
				break;
			case 3:
				message = tranService.tran(1);
				view.view(message);
				break;
			default:
				check = !check;
				break;
			}
		}
	}
}
