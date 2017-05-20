package com.xust.bbs.action.post;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.service.post.PostService;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class PostDownAction {

	private String postId;
	private BBSResult<Object> result;

	@Resource
	private PostService postService;
	
	public String execute() {
		result = postService.downPost(postId);
		return "success";
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public BBSResult<Object> getResult() {
		return result;
	}

	public void setResult(BBSResult<Object> result) {
		this.result = result;
	}
}
