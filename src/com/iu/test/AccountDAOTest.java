package com.iu.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iu.account.AccountDAO;
import com.iu.account.AccountDTO;
import com.iu.member.MemberDAO;
import com.iu.util.DBConnector;

public class AccountDAOTest {

	private AccountDAO accountDAO;
	
	@BeforeClass
	public static void start() {
		
	}
	
	@AfterClass
	public static void end() {
		
	}
	
	@Before
	public void MakeDAO() {
		accountDAO = new AccountDAO();
	}
	
	@Test
	public void test() throws Exception {
		Connection con = DBConnector.getConnect();
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountnum("1");
		accountDTO.setAccountname("test");
		accountDTO.setId("iu");
		int result = accountDAO.insert(accountDTO, con);
		assertEquals(1, result);
	}
	
	@After
	public void after() {
		
	}
}