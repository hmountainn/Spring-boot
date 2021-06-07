package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;

//SQL을 대신하는 녀석
@Mapper
public interface NoticeDao {
	Notice get(int id);
	
	@Select("select * from Notice")
	List<Notice> getList(); //필터링, 정렬, 집계
	
	List<Notice> getList(int page); //페이징
	List<Notice> getList(int page, String field, String query); //검색
	
	int insert(Notice notice);
	int update(Notice notice);
	int delete(Notice notice);
}
