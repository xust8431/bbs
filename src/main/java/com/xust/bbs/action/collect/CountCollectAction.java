package com.xust.bbs.action.collect;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.service.collect.CollectService;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class CountCollectAction {

	//输出
	private BBSResult<Object> result;
	//输入
	private String userName;
	
	@Resource
	private CollectService collectService;
	
	public String execute(){
		result = collectService.countCollect(userName);
		return "success";
	}

	public BBSResult<Object> getResult() {
		return result;
	}

	public void setResult(BBSResult<Object> result) {
		this.result = result;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
