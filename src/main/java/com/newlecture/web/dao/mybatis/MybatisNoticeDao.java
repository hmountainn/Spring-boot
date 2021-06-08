package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Repository //IOC에 담기
public class MybatisNoticeDao implements NoticeDao {

//	@Autowired 
	private SqlSession sqlSession; //Mapper container에서 mapping정보 꺼내서 쓰기
	private NoticeDao mapper;
	
	//생성자로 꺼내쓰는작업 한번에 하기
	@Autowired 
	public MybatisNoticeDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(NoticeDao.class);
	}
	
	@Override
	public Notice get(int id) {	
		return mapper.get(id);
	}

	@Override
	public List<Notice> getList() { //오버로드 하기
		return getList(1, "title", "");
	}

	@Override
	public List<Notice> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> getList(int page, String field, String query) {
		return mapper.getList(page, field, query);
	}

	@Override
	public int insert(Notice notice) {
		return mapper.insert(notice);
	}
	
	@Override
	public int delete(int id) {
		return mapper.delete(id);
		
	}

	@Override
	public int update(Notice notice) {
		
		return mapper.update(notice);
	}

	@Override
	public int getCount(String field, String query) {
		
		return mapper.getCount(field, query);
	}

	@Override
	public List<NoticeView> getViewList(int page, String field, String query) {
		return mapper.getViewList(page,field, query);
	}



}
