package com.newlecture.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice/")
public class NoticeController {
	@RequestMapping("list")
	public String list() {
		return "notice list";
	}
	
}
