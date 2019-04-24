package com.iu.member;

import java.util.Scanner;

import com.iu.util.Session;

public class MemberService {
	private Scanner sc;
	private MemberDAO memberDAO;
	public MemberService() {
		sc = new Scanner(System.in);
		memberDAO = new MemberDAO();
	}
	public String login() {
		MemberDTO memberDTO = new MemberDTO();
		System.out.print("ID : ");
		memberDTO.setId(sc.next());
		System.out.print("PW : ");
		memberDTO.setPw(sc.next());
		String message = "로그인 실패";
		try {
			memberDTO = memberDAO.login(memberDTO);
			Session.member = memberDTO;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//예외 발생 위치 파악
		}
		if(memberDTO != null) {
			message = "로그인 성공";
		}
		return message;
	}
	
	public String insert() {
		MemberDTO memberDTO = new MemberDTO();
		System.out.print("ID : ");
		memberDTO.setId(sc.next());
		System.out.print("PW : ");
		memberDTO.setPw(sc.next());
		System.out.print("Name : ");
		memberDTO.setName(sc.next());
		System.out.print("Phone : ");
		memberDTO.setPhone(sc.next());
		System.out.print("Email : ");
		memberDTO.setEmail(sc.next());
		int result = 0;
		String message = "회원가입 성공";
		try {
			result = memberDAO.insert(memberDTO);
			if(result<1) {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "회원가입 실패";
		}
		return message;
	}
}