package com.spring.dao;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/root-context.xml")
@Transactional
public class TestMemberDAO {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void testSelectMember() throws SQLException {
		String id = "mimi";
		
		MemberVO member = memberDAO.selectMemberById(id);
		
		Assert.assertEquals(id, member.getId());
	}
	
	@Test
	@Rollback
	public void testInsertMember() throws SQLException {
		MemberVO testMember = new MemberVO();
		testMember.setId("kaka");
		testMember.setPwd("kaka");
		testMember.setName("kaka");
		testMember.setEmail("kaka@kaka.com");
		testMember.setPhone("010-0101-1010");
		testMember.setPicture("noImage.jpg");
		testMember.setAuthority("ROLE_USER");
		
		memberDAO.insertMember(testMember);
		MemberVO result = memberDAO.selectMemberById(testMember.getId());
		Assert.assertEquals(testMember.getId(), result.getId());
	}
	
	
	
}
