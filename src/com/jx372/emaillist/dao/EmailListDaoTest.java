package com.jx372.emaillist.dao;

import java.util.List;

import com.jx372.emaillist.vo.emailListVo;

public class EmailListDaoTest {

	public static void main(String[] args) {
		insertTests();
		getListTest();
		
	}
	
	public static void insertTests(){
		emailListVo vo = new emailListVo();
		vo.setLastName("허");
		vo.setFirstName("규준");
		vo.setEmail("herojoon1378@naver.com");
		EmailListDao dao = new EmailListDao();
		dao.insert(vo);
		
		
	}
	
	public static void getListTest(){
		EmailListDao dao = new EmailListDao();
		List<emailListVo> list = dao.getList();
		
		for(emailListVo vo : list){
			System.out.println(vo.toString());
		}
	}

}
