package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

//SQL을 대신하는 녀석
public interface NoticeDao {
	Notice get(int id);
	List<Notice> getList(); //필터링, 정렬, 집계
	List<Notice> getList(int offset, int size); //페이징
	List<Notice> getList(int offset, int size, String field, String query); //검색
	List<NoticeView> getViewList(int page,String field, String query);
	List<Notice> getListIn(int[] ids);
	
	int getCount(String field, String query);
	
	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);
}
