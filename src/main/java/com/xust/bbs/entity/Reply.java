package com.xust.bbs.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reply implements Serializable {
	
	private String replyId;
	private String postId;
	private String userId;
	private User user;
	private String replyText;
	private long replyUp;
	private Timestamp replyTime;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getReplyId() {
		return replyId;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public long getReplyUp() {
		return replyUp;
	}
	public void setReplyUp(long replyUp) {
		this.replyUp = replyUp;
	}
	public Timestamp getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}
	
}
