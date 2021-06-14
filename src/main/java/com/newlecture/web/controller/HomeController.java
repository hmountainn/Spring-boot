package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Rest쓰면 데이터로 인식해서 바로 출력
//그냥 Controller는 웹페이지 포워딩함

@Controller
public class HomeController {
	
	@RequestMapping("/index")
	public String index(Model model) {
		
		model.addAttribute("title", "안녕ㅋ<u>안녕ㅋ</u>");
		
		return "index";
	}
	

	

}
