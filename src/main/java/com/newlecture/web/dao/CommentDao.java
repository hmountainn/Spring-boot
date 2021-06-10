package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Comment;

public interface CommentDao {
	Comment get(int id);	
	List<Comment> getList(); // 필터링, 정렬, 페이징, 집계	
	List<Comment> getList(int page); // 필터링, 정렬, 페이징, 집계	
	List<Comment> getList(int page, String field, String query); // 필터링, 정렬, 페이징, 집계
	
	int getCount(String field, String query);
	
	
	int insert(Comment Comment);
	int update(Comment Comment);
	int delete(int id);
}