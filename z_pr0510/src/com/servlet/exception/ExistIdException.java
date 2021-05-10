package com.servlet.exception;

public class ExistIdException extends Exception {
	
	public ExistIdException() {
		super("이미 사용 중인 아이디 입니다.");
	}

}
