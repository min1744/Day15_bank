package com.iu.control;

import java.util.Scanner;

import com.iu.member.MemberService;
import com.iu.util.Session;
import com.iu.view.View;

public class MemberController {
	private MemberService memberService;
	private View view;
	private Scanner sc;
	private AccountController accountController;
	
	public MemberController() {
		memberService = new MemberService();
		view = new View();
		sc = new Scanner(System.in);
		accountController = new AccountController();
	}
	
	public void start() {
		boolean check = true;
		String message=null;
		while(check) {
			if(Session.member != null) {
				System.out.println("1. MyPage");
				System.out.println("2. 로그아웃");
				System.out.println("3. 계좌관리");
				
				int select = sc.nextInt();
				if(select == 1) {
					view.view();
				}else if(select == 2){
					Session.member=null;
				}else {
					accountController.start();
				}
				
			}else {
				System.out.println("1. 회원가입");
				System.out.println("2. 로 그 인");
				System.out.println("3. 종     료");
				int select = sc.nextInt();
				switch(select) {
				case 1:
					message=memberService.insert();
					view.view(message);
					break;
				case 2:
					message=memberService.login();
					view.view(message);
					break;
				default:
					check=!check;
				}
				
			}
			
		}
	}
	

}