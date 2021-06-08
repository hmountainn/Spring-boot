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
	public List<Notice> getList() {
		List<Notice> list = dao.getList();
		
		return list;
	}
	
	@Override
	public List<Notice> getList(int page, String field, String query) {
		List<Notice> list = dao.getList(page, field, query);
		
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
