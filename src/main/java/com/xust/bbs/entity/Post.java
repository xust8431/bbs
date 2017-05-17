package com.xust.bbs.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Post implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String userName;
	private String title;
	private String content;
	private String picture;
	private Long replyNumber;
	private Long up;
	private Long down;
	private String type;
	private String classify;
	private Timestamp createTime;
	private Timestamp lastReplyTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Long getReplyNumber() {
		return replyNumber;
	}
	public void setReplyNumber(Long replyNumber) {
		this.replyNumber = replyNumber;
	}
	public Long getUp() {
		return up;
	}
	public void setUp(Long up) {
		this.up = up;
	}
	public Long getDown() {
		return down;
	}
	public void setDown(Long down) {
		this.down = down;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLastReplyTime() {
		return lastReplyTime;
	}
	public void setLastReplyTime(Timestamp lastReplyTime) {
		this.lastReplyTime = lastReplyTime;
	}
	
	
}
