package com.domain;

import java.io.InputStream;

public class AppFlower {
	private String fname;
	private String fword;
	private String fimage;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFword() {
		return fword;
	}
	public void setFword(String fword) {
		this.fword = fword;
	}
	public String getFimage() {
		return fimage;
	}
	public void setFimage(String fimage) {
		this.fimage = fimage;
	}
	@Override
	public String toString() {
		return "AppFlower [fname=" + fname + ", fword=" + fword + ", fimage="
				+ fimage + "]";
	}
	

}
