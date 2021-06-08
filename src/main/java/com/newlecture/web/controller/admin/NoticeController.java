package com.newlecture.web.controller.admin;

import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Controller("adminNoticeController") //Controller로 변경(문서반환)
@RequestMapping("/admin/notice/") //공통 url
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping("list")
	//@ResponseBody //이건 문서봔환말고 그냥 restController처럼 텍스트 반환
	public String list(Model model) {
		
		//List<Notice> list = service.getList();
		List<Notice> list = service.getList(1, "title", "t"); //검색
		model.addAttribute("list",list);
		
		return "admin.notice.list"; //mapping 정보
		
//		List<Notice> list = new ArrayList<>();
//		Notice notice = null;
//		
//		notice = new Notice();
//		notice.setId(1);
//		notice.setTitle("클릭하세용");
//		notice.setWriterId("JISAN");
//		list.add(notice);
		
//		ModelAndView mv = new ModelAndView(); //ModelAndView에 데이터 넣음
//		mv.setViewName("admin.notice.list"); //View주소
//		mv.addObject("list",list); //데이터 객체
		
		//model.addAttribute("list", list); // 데이터 객체
		/* model.addAttribute("title", "test haha"); */
		
		//return "/WEB-INF/view/admin/notice/list.jsp";
		//return mv; //DisPatcher에게 데이터 전달
		//return "admin.notice.list"; //mapping 정보
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
		
		return "admin.notice.detail";
	}
	
	
	//@RequestMapping(value = "reg", method = RequestMethod.GET) 옜날방식
	//@GetMapping("reg/{uid}/{id}")
	@GetMapping("reg")
	public ModelAndView reg( //기본값 설정 (defaultValue)
			//2. 파라미터 이름으로 자동입력
			@RequestParam(name = "f", defaultValue = "title") String field, //f로 전달된값 field에 넣기
			@RequestParam(defaultValue="0") Integer x,
			@RequestParam(defaultValue="0") Integer y,/*HttpServletRequest request*/
			@CookieValue(name="test", defaultValue = "hi") String test,  //쿠키값 test에 넣고 기본값은 "hi"
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
		notice.setWriterId("hi");
		
		service.insert(notice);
		
		return "redirect:list"; //포워딩x redirect하기
	}
	
	@RequestMapping("edit")
	public String edit() {
		return "admin notice edit";
	}
	
	@RequestMapping("del")
	public String del() {
		return "admin notice del";
	}
}
