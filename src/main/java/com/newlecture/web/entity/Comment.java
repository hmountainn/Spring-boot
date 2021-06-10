package com.newlecture.web.entity;

import java.util.Date;

public class Comment {
	// ID, CONTENT, REGDATE, WRITER_NICNAME, NOTICE_ID
	private int id;
	private String content;
	private Date regdate;
	private String writerId;
	private int noticeId;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, String content, Date regdate, String writerId, int noticeId) {
		super();
		this.id = id;
		this.content = content;
		this.regdate = regdate;
		this.writerId = writerId;
		this.noticeId = noticeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterNicName(String writerId) {
		this.writerId = writerId;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", regdate=" + regdate + ", writerId="
				+ writerId + ", noticeId=" + noticeId + "]";
	}
	
	
}