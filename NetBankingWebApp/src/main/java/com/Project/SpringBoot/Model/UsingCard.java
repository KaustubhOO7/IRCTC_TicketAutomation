package com.Project.SpringBoot.Model;

public class UsingCard 
{
	private String card;
	private String expiry;
	private String cvv;
	private String amount;
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "UsingCard [card=" + card + ", expiry=" + expiry + ", cvv=" + cvv + ", amount=" + amount + "]";
	}
	
	
}
