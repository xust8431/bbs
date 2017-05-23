package com.xust.bbs.entity;

import java.io.Serializable;
import java.sql.Timestamp;


public class Collect implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String collectId;
	private String postId;
	private String userName;
	private Timestamp time;
	private Post posts;
	public String getCollectId() {
		return collectId;
	}
	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Post getPosts() {
		return posts;
	}
	public void setPosts(Post posts) {
		this.posts = posts;
	}
	
	
	
}
