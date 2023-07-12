package com.bitacademy.guestbook.dao.test;

import java.util.ArrayList;
import java.util.List;

import com.bitacademy.guestbook.dao.GuestBookDao;
import com.bitacademy.guestbook.vo.GuestBookVo;

public class GuestBookDaoTest {

	public static void main(String[] args) {
		//insert test
//		GuestBookVo vo = new GuestBookVo();
//		vo.setName("ds");
//		vo.setPassword("ds");
//		vo.setText("Hi ~~");
//		
//		insert(vo);
		
		//findAll test
		//list();
		
		Long no = 6l;
		String password = "ds2";
		//delete(no);
		
		delete(no,password);
	}

	private static void delete(Long no, String password) {
		// TODO Auto-generated method stub
		boolean check = new GuestBookDao().delete(no,password);
		
		if(!check) System.out.println("delete error");
	}

	private static void delete(Long no) {
		// TODO Auto-generated method stub
		boolean check = new GuestBookDao().delete(no);
		
		if(!check) System.out.println("delete error");
	}

	private static void list() {
		// TODO Auto-generated method stub
		List<GuestBookVo> list = new GuestBookDao().findAll();
		
		for(GuestBookVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void insert(GuestBookVo vo) {
		// TODO Auto-generated method stub
		boolean check = new GuestBookDao().insert(vo);
		
		if(!check) System.out.println("insert error");
	}

}
