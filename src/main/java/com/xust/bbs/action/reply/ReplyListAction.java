package com.xust.bbs.action.reply;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.entity.Reply;
import com.xust.bbs.service.reply.ReplyService;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class ReplyListAction {

	private String postId;
	private int page;
	private BBSResult<List<Reply>> result;
	
	@Resource
	private ReplyService replyService;
	
	public String execute() {
		result = replyService.loadReply(postId, page);
		return "success";
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public BBSResult<List<Reply>> getResult() {
		return result;
	}

	public void setResult(BBSResult<List<Reply>> result) {
		this.result = result;
	}
}
