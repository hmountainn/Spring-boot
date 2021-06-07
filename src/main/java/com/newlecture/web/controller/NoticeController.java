package com.newlecture.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	//Dependency Injection => DI
	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		//this.noticeDao = noticeDao;
	}
	
	
	@RequestMapping("list")
	public String list(Model model) {
		
		List<Notice> list = service.getList();
		model.addAttribute("list", list);
		
		return "notice.list";
	}
	
}
