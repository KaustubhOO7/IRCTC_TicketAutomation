package com.Project.SpringBoot.Model;


public class RegisterPage 
{
   private String id;
   private String accnt;
   private String curr;
   private String first;
   private String middle;
   private String last;
   private String phone;
   private String dob;
   private String add1;
   private String add2;
   private String city;
   private String state;
   private String zip;
   private String occ;
   private String gender;
   private String emailid;
   

   
   
   public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getId() {
		return id;
	}
   public void setId(String id) {
		this.id = id;
	}
public String getAccnt() {
	return accnt;
}
public void setAccnt(String accnt) {
	this.accnt = accnt;
}
public String getCurr() {
	return curr;
}
public void setCurr(String curr) {
	this.curr = curr;
}
public String getFirst() {
	return first;
}
public void setFirst(String first) {
	this.first = first;
}
public String getMiddle() {
	return middle;
}
public void setMiddle(String middle) {
	this.middle = middle;
}
public String getLast() {
	return last;
}
public void setLast(String last) {
	this.last = last;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getAdd1() {
	return add1;
}
public void setAdd1(String add1) {
	this.add1 = add1;
}
public String getAdd2() {
	return add2;
}
public void setAdd2(String add2) {
	this.add2 = add2;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getZip() {
	return zip;
}
public void setZip(String zip) {
	this.zip = zip;
}
public String getOcc() {
	return occ;
}
public void setOcc(String occ) {
	this.occ = occ;
}


@Override
public String toString() {
	return "RegisterPage [id=" + id + ", accnt=" + accnt + ", curr=" + curr + ", first=" + first + ", middle=" + middle
			+ ", last=" + last + ", phone=" + phone + ", dob=" + dob + ", add1=" + add1 + ", add2=" + add2 + ", city="
			+ city + ", state=" + state + ", zip=" + zip + ", occ=" + occ + ", gender=" + gender + "]";
}



}
 
   

