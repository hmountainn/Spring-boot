package com.newlecture.web.service;

import java.util.List;


import com.newlecture.web.entity.Notice;

public interface NoticeService {
	
	Notice get(int id);
	List<Notice> getList();
	List<Notice> getList(int page);
	List<Notice> getList(int page,String field, String query); // 검색
	//List<Notice> getList(int page,String field, String query, String colOrder, boolean isAsc); //정렬 
	
	int insert(Notice notice);
	int delete(int id);
	int hitUp(int id);
	int likeUp(int id);
}
