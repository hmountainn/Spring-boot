package com.newlecture.web.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller("adminHomeController")
@RequestMapping("/admin/") //공통 url
public class HomeController {
	
	// /admin/index
	@GetMapping("index")
	public String index() {
		return "admin.index";
	}
	
	
	@PostMapping("upload")
	public String upload(MultipartFile[] files, HttpServletRequest request) {
		
		for(MultipartFile file : files) {
			
			if(file.getSize() == 0) //파일 1개만 올려도 넘어가기
				continue;
		
			String fileName = file.getOriginalFilename();//파일이름
			
			ServletContext application = request.getServletContext();
			String path = "/upload";
			String realPath = application.getRealPath(path);
			
			File pathFile = new File(realPath);
			if(!pathFile.exists()) //upload할 경로 존재x하면
				pathFile.mkdirs(); //경로 생성
			
			String filePath = realPath + File.separator + fileName;
			
			File saveFile = new File(filePath); //저장할 파일
			
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return "ok";
	}
}
