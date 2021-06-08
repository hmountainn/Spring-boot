package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

@Repository //IOC에 담기
public class MybatisNoticeDao implements NoticeDao {

	@Autowired 
	private SqlSession sqlSession; //Mapper container에서 mapping정보 꺼내서 쓰기
	
	@Override
	public Notice get(int id) {
		// TODO Auto-generated method stub
		return null;
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
		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		
		return mapper.getList(page, field, query);
	}

	@Override
	public int insert(Notice notice) {
		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		
		return mapper.insert(notice);
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
