package com.Project.SpringBoot.Model;

public class UsingBank
{
	private String name;
	private String accountNo;
	private String ifsc;
	private String amount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "UsingBank [name=" + name + ", accountNo=" + accountNo + ", ifsc=" + ifsc + ", amount=" + amount + "]";
	}
	
	
}
