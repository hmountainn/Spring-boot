package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

@Service
public class NoticeServiceimp implements NoticeService {
	
	@Autowired
	private NoticeDao dao;
	
	@Override
	public Notice get(int id) {
		Notice notice = dao.get(id);
		
		return notice;
	}
	

	@Override
	public List<Notice> getList() { //오버로드
		
		List<Notice> list = getList(1, null, null);
		return list;
	}
	
	@Override
	public List<Notice> getList(int page) { //오버로드
		
		List<Notice> list = getList(page, null, null);
		return list;
	}
	
	@Override
	public List<Notice> getList(int page, String field, String query) {
		int offset = (page-1)*10; // 1->0, 2->10, 3->20
		int size=10;
		
		List<Notice> list = dao.getList(offset, size, field, query);
		
		return list;
	}

	

	@Override
	public int insert(Notice notice) {
		
		return dao.insert(notice);
	}
	
	@Override
	public int delete(int id) {
		
		return dao.delete(id);
	}

	@Override
	public int hitUp(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int likeUp(int id) {
		// TODO Auto-generated method stub
		return 0;
	}







}
