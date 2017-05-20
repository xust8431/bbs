package com.xust.bbs.action.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.entity.User;
import com.xust.bbs.service.user.UserService;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class LoadUserMsgAction {

	//输出
	private BBSResult<List<User>> result;
	//输入
	private String userId;
	
	@Resource
	private UserService userService;
	
	public String execute(){
		result = userService.loadUserMsg(userId);
		return "success";
	}

	public BBSResult<List<User>> getResult() {
		return result;
	}

	public void setResult(BBSResult<List<User>> result) {
		this.result = result;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
