package com.domain;

public class AppUser {
	private Integer id;
	private String petname;
	private String uname;
	private String pwd;
	private String mail;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "AppUser [petname=" + petname + ", uname=" + uname + ", pwd="
				+ pwd + ", mail=" + mail + ", toString()=" + super.toString()
				+ "]";
	}
	

}
