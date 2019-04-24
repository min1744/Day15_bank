package com.iu.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iu.member.MemberDAO;
import com.iu.member.MemberDTO;

public class MemberDAOTest {

	@Test
	public void loginTest() throws Exception {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("iu");
		memberDTO.setPw("iu");
		memberDTO = memberDAO.login(memberDTO);
		assertNotNull(memberDTO);
	}
	
	//@Test
	public void test() throws Exception{
		
	}
}