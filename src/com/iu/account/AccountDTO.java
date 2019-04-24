package com.iu.account;

import java.sql.Date;

public class AccountDTO {
	private String accountnum;
	private String accountname;
	private String id;
	private Long balance;
	private Date makedate;

	public String getAccountnum() {
		return accountnum;
	}

	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Date getMakedate() {
		return makedate;
	}

	public void setMakedate(Date makedate) {
		this.makedate = makedate;
	}
}