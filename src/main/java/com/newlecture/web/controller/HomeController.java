package com.newlecture.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest쓰면 데이터로 인식해서 바로 출력
//그냥 Controller는 웹페이지 포워딩함

@RestController
public class HomeController {
	
	@RequestMapping("/index")
	public String index() {
		
		return "index";
	}
	

	

}
