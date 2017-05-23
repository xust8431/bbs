package com.xust.bbs.action.reply;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.service.reply.ReplyService;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class AddReplyAction {

	private String postId;
	private String userId;
	private String replyText;
	private BBSResult<Object> result;
	
	@Resource
	private ReplyService replyService;
	
	public String execute() {
		result = replyService.addReply(postId, userId, replyText);
		return "success";
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

	public BBSResult<Object> getResult() {
		return result;
	}

	public void setResult(BBSResult<Object> result) {
		this.result = result;
	}
}
