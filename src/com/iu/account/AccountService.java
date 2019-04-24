package com.iu.account;

import java.util.Scanner;

import com.iu.member.MemberDTO;
import com.iu.util.DBConnector;
import com.iu.util.Session;

public class AccountService {
	private Scanner sc;
	private AccountDAO accountDAO;
	
	public AccountService() {
		sc = new Scanner(System.in);
		accountDAO = new AccountDAO();
	}
	
	public String insert() {
		String message = "계좌개설 성공";
		AccountDTO accountDTO = new AccountDTO();
		System.out.print("계좌 번호 : ");
		accountDTO.setAccountnum(sc.next());
		System.out.print("계좌 명 : ");
		accountDTO.setAccountname(sc.next());
		accountDTO.setId(((MemberDTO)(Session.member)).getId());
		int result = 0;
		try {
			result = accountDAO.insert(accountDTO, DBConnector.getConnect());
			if(result < 1) {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "계좌 개설 실패";
		}
		return message;
	}
}