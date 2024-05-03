package com.Project.SpringBoot.Model;


public class PaymentHistory 
{
	private String amount;
	private String date;
	private String status;
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "PaymentHistory [amount=" + amount + ", date=" + date + ", status=" + status + "]";
	}
	
	
	
	
}
