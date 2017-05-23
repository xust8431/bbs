package com.xust.bbs.action.collect;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.entity.Collect;
import com.xust.bbs.service.collect.CollectService;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class PostCollectAction {

	//输出
	private BBSResult<Collect> result;
	//输入
	private String postId;
	private String userName;
	
	@Resource
	private CollectService collectService;
	
	public String execute(){
		result = collectService.collectPost(postId, userName);
		return "success";
	}

	public BBSResult<Collect> getResult() {
		return result;
	}

	public void setResult(BBSResult<Collect> result) {
		this.result = result;
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
	
	
}
