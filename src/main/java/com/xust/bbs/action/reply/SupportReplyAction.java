package com.xust.bbs.action.reply;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.service.reply.ReplyService;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class SupportReplyAction {

	private String replyId;
	private BBSResult<Object> result;
	
	@Resource
	private ReplyService replyService;

	public String execute() {
		result = replyService.supportReply(replyId);
		return "success";
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public BBSResult<Object> getResult() {
		return result;
	}
	
	public void setResult(BBSResult<Object> result) {
		this.result = result;
	}
	
}
