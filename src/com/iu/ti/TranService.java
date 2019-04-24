package com.iu.ti;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.iu.account.AccountDAO;
import com.iu.account.AccountDTO;
import com.iu.member.MemberDTO;
import com.iu.util.DBConnector;
import com.iu.util.Session;

public class TranService {
	private Scanner sc;
	private TranDAO tranDAO;
	private AccountDAO accountDAO;
	
	public TranService() {
		sc = new Scanner(System.in);
		tranDAO = new TranDAO();
		accountDAO = new AccountDAO();
	}
	
	public String tran(int num) {
		int kind = 1;
		String message="입금";
		if(num!=0) {
			message="출금";
			kind = -1;
		}
		System.out.println(message+ " 금액 입력");
		TranDTO tranDTO = new TranDTO();
		//account num, amount, kind
		tranDTO.setAmount(sc.nextInt());
		tranDTO.setKind(num);
		
		int result =0;
		String id = ((MemberDTO)Session.member).getId();
		Connection con=null;
		try {
			con = DBConnector.getConnect();
			con.setAutoCommit(false);
			result = tranDAO.insert(tranDTO, con, id);
			
			if(result<1) {
				throw new Exception();
			}
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setBalance((long)(tranDTO.getAmount()*kind));
			accountDTO.setId(id);
			
			result = accountDAO.update(accountDTO, con);
			if(result<1) {
				throw new Exception();
			}
			con.commit();
			message=message + " 성공";
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			e.printStackTrace();
			message = message + " 실패";
		}
		
		
		return message;
	}

}