package com.newlecture.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;

@Repository
public class MyBatisMemberDao implements MemberDao {
	
	private MemberDao mapper;
	
	@Autowired
	public MyBatisMemberDao(SqlSession session) {
		mapper = session.getMapper(MemberDao.class);
	}
	
	@Override
	public Member getByUid(String uid) {
		return mapper.getByUid(uid);
	}

}
