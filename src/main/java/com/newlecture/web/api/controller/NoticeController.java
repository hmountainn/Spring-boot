package com.newlecture.web.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@RestController("apiNoticeController") //Controller로 변경(문서반환)
@RequestMapping("/api/notice/") //공통 url
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping("list")
	//@ResponseBody //이건 문서봔환말고 그냥 restController처럼 텍스트 반환
	public Map<String, Object> list(
			@RequestParam(name="p", defaultValue = "1") Integer page,
			@RequestParam(name="f", defaultValue = "title") String field,
			@RequestParam(name="q", defaultValue = "") String query,
			Model model) {
		
		Map<String, Object> map = new HashMap<>();
		
		List<Notice> list = service.getList(page, field, query); //검색
		int count = service.getCount(field, query);
		
		map.put("list", list);
		map.put("count", count);

		
		return map; //mapping 정보
		
	}
	
//	@RequestMapping("detail")
//	//@ResponseBody //이건 문서봔환말고 그냥 restController처럼 텍스트 반환
//	public String detail(Model model) {
//		
//		Notice notice = new Notice();
//		notice.setId(1);
//		notice.setTitle("클릭하세용");
//		notice.setWriterId("JISAN");
//		
//		model.addAttribute("notice", notice);
//		model.addAttribute("title", notice.getTitle());
//		
//		return "admin.notice.detail";
//	}
	
	@GetMapping("detail")
	public String detail(Model model, int id) {
		
		Notice notice = service.get(id);
		model.addAttribute("notice",notice);
		
		return "admin/notice/detail";
	}
	
	
	//@RequestMapping(value = "reg", method = RequestMethod.GET) 옜날방식
	//@GetMapping("reg/{uid}/{id}")
	@GetMapping("reg")
	public ModelAndView reg( //기본값 설정 (defaultValue)
			//2. 파라미터 이름으로 자동입력
			@RequestParam(name = "f", defaultValue = "title") String field, //f로 전달된값 field에 넣기
			@RequestParam(defaultValue="0") Integer x,
			@RequestParam(defaultValue="0") Integer y,/*HttpServletRequest request*/
			@CookieValue(name="test", defaultValue = "jisan") String test,  //쿠키값 test에 넣고 기본값은 "hi"
//			@PathVariable String uid,
//			@PathVariable Integer id, //경로로 온 값 받기
			MultipartFile file, //파일 업로드
			HttpServletResponse response) {
		
		//1. Servlet API를 이용한 방법(옛날방식)
		//String x_ = request.getParameter("x");
		//String y_ = request.getParameter("y");
		
		
		if(test.equals("hi")) {
			Cookie cookie = new Cookie("test", "hello");
			cookie.setMaxAge(60*60*24);
			cookie.setPath("/"); //root에서부터 쿠키설정
			response.addCookie(cookie);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin.notice.reg");
		
		//return String.format("x:%s, y:%s",x_,y_) + "<br>" +String.format("x:%s, y:%s",x,y);
		//return String.format("x:%d, y:%d, result:%d, field:%s, cookie:%s, uid:%s, id:%d",x,y,x+y,field,test,uid,id);
		return mv;
	}
	

	
	//@RequestMapping(value = "reg", method = RequestMethod.POST) 옜날방식
	@PostMapping("reg")
	public String reg(String title, String content) {
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setWriterId("jisan");
		
		service.insert(notice);
		
		return "redirect:list"; //포워딩x redirect하기
	}
	
	@GetMapping("edit")
	public String edit(int id, Model model) {
		Notice notice = service.get(id);
		model.addAttribute("notice",notice);
		
//		int[] ids = {23,40,45};
//		List<Notice> list = noticeDao.getListIn(ids);
//		model.addAttribute("list",list);
		
		
		return "admin.notice.edit";
	}
	
	
	@PostMapping("edit")
//	public String edit(int id,String title, String content) {
//		
//		Notice notice = new Notice();
//		notice.setId(id);
//		notice.setTitle(title);
//		notice.setContent(content);
	public String edit(Notice notice) {
		service.update(notice);
		
		return "redirect:detail?id="+notice.getId();
	}
	
	@RequestMapping("del")
	public String del(int id) {
		
		service.delete(id);
		
		return "redirect:list";
	}
}
