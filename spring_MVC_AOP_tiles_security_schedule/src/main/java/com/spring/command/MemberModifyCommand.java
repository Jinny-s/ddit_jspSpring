package com.spring.command;

import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.MemberVO;

public class MemberModifyCommand {
	
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String authority;
	private MultipartFile picture;
	private String oldPicture;
	private String uploadPicture;
	
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
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getPhone() {
		return phone;
	}
	public final void setPhone(String phone) {
		this.phone = phone;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getAuthority() {
		return authority;
	}
	public final void setAuthority(String authority) {
		this.authority = authority;
	}
	public final MultipartFile getPicture() {
		return picture;
	}
	public final void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	public final String getOldPicture() {
		return oldPicture;
	}
	public final void setOldPicture(String oldPicture) {
		this.oldPicture = oldPicture;
	}
	public final String getUploadPicture() {
		return uploadPicture;
	}
	public final void setUploadPicture(String uploadPicture) {
		this.uploadPicture = uploadPicture;
	}
	
	public MemberVO toParseMember() {
		MemberVO member = new MemberVO();
		member.setId(this.id);
		member.setPwd(this.pwd);
		member.setName(this.name);
		member.setPhone(this.phone.replace("-", ""));
		member.setEmail(this.email);
		member.setAuthority(this.authority);
		
		return member;
	}
}
