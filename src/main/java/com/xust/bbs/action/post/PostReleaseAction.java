package com.xust.bbs.action.post;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.entity.Post;
import com.xust.bbs.service.post.PostService;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class PostReleaseAction {

	//输入
	private String userName;
	private String title;
	private String content;
	private String picture;
	private String type;
	//输出
	private BBSResult<Post> result;
	
	@Resource
	private PostService postService;
	
	public String execute(){
		result = postService.releasePost(userName, type, title, content, picture);
		return "success";
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

	public BBSResult<Post> getResult() {
		return result;
	}

	public void setResult(BBSResult<Post> result) {
		this.result = result;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
