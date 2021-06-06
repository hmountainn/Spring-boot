package com.newlecture.web.entity;

import java.util.Date;

public class Notice2 {
	private int num;
	private String title;
	private String writer;
	private Date regdate;
	private int hit;
	private String content;
	private String files;
	
	public Notice2() {
		// TODO Auto-generated constructor stub
	}
	
	public Notice2(int num, String title, String writer, Date regdate, int hit, String content, String files) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
		this.hit = hit;
		this.content = content;
		this.files = files;
	}


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "Notice2 [num=" + num + ", title=" + title + ", writer=" + writer + ", regdate=" + regdate + ", hit="
				+ hit + ", content=" + content + ", files=" + files + "]";
	}
	
	

}
