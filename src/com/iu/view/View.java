package com.iu.view;

import com.iu.member.MemberDTO;
import com.iu.util.Session;

public class View {
	
	public void view() {
		MemberDTO memberDTO = (MemberDTO)Session.member;
		System.out.println("ID : " + memberDTO.getId());
		System.out.println("Name : " + memberDTO.getName());
		System.out.println("Phone : " + memberDTO.getPhone());
		System.out.println("Email : " + memberDTO.getEmail());
		//System.out.println("AccountName : " + memberDTO.getAccountDTO().getAccountname());
		//System.out.println("AccountNum : " + memberDTO.getAccountDTO().getAccountnum());
		//System.out.println("Balance : " + memberDTO.getAccountDTO().getBalance());
		//System.out.println("Date : " + memberDTO.getAccountDTO().getMakedate());
	}
	
	public void view(String message) {
		System.out.println(message);
	}
}