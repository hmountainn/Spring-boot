package com.newlecture.web.dao.jdbc;

import java.util.List;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

public class JdbcNoticeDao implements NoticeDao {

	@Override
	public Notice get(int id) {
		Notice notice = null;
		
		return notice;
	}

	@Override
	public List<Notice> getList() {
		
		return null;
	}

	@Override
	public List<Notice> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> getList(int page, String field, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

}
