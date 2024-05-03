package com.Project.SpringBoot.Model;

public class UsingMailId 
{
	private String mailId;
	private String amount;
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "UsingMailId [mailId=" + mailId + ", amount=" + amount + "]";
	}
	
	
}
