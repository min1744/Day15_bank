package com.iu.ti;

import java.sql.Date;

public class TranDTO {
	private Integer num;

	private String accountnum;

	private Integer amount;

	private Integer kind;

	private Date tdate;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getAccountnum() {
		return accountnum;
	}

	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getKind() {
		return kind;
	}

	public void setKind(Integer kind) {
		this.kind = kind;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

}