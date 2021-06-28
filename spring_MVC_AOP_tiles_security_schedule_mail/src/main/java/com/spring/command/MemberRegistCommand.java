package com.spring.command;

import java.util.Arrays;
import java.util.Date;

import com.spring.dto.MemberVO;

public class MemberRegistCommand {
	
	private String id;
	private String pwd;
	private String email;
	private String picture;
	private String authority;
	private String name;
	private String[] phone;
	
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getPwd() {
		return pwd;
	}
	public final void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getPicture() {
		return picture;
	}
	public final void setPicture(String picture) {
		this.picture = picture;
	}
	public final String getAuthority() {
		return authority;
	}
	public final void setAuthority(String authority) {
		this.authority = authority;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String[] getPhone() {
		return phone;
	}
	public final void setPhone(String[] phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "MemberRegistCommand [id=" + id + ", pwd=" + pwd + ", email=" + email + ", picture=" + picture
				+ ", authority=" + authority + ", name=" + name + ", phone=" + Arrays.toString(phone) + "]";
	}
	
	public MemberVO toMemberVO() {
		
		String phone = "";
		for (String data : this.phone) {
			phone += data;
		}
		
		// MemberVO setting
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setPhone(phone);
		member.setEmail(email);
		member.setPicture(picture);
		member.setAuthority(authority);
		member.setName(name);
		member.setRegdate(new Date());
		
		return member;
	}
}
