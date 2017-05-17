package com.xust.bbs.action.reply;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.entity.Post;
import com.xust.bbs.service.reply.ReplyService;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class LoadPostAction {

	private String postId;
	private BBSResult<Post> result;
	
	@Resource
	private ReplyService replyService;
	
	public String execute() {
		result = replyService.loadPost(postId);
		return "success";
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public BBSResult<Post> getResult() {
		return result;
	}

	public void setResult(BBSResult<Post> result) {
		this.result = result;
	}
}
