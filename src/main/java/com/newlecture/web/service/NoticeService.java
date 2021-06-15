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
	int update(Notice notice);
	
	//자세한 페이지를 조회 -> 조회수 up
	int hitUp(int id);
	
	//좋아요 클릭 -> 좋아요를 토글
	int likeToggle(int id);
	
	int delete(int id);
	int likeUp(int id);
	int getCount(String field, String query);
}
