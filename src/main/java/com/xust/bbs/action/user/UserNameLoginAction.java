package com.xust.bbs.action.user;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.entity.User;
import com.xust.bbs.service.user.UserService;
import com.xust.bbs.util.BBSResult;


@Controller
@Scope("prototype")
public class UserNameLoginAction {

	//输入
	private String password;
	private String name;
	
	//输出
	private BBSResult<User> result;
	
	@Resource
	private UserService userService;
	
	public String execute(){
		result = userService.nameLogin(name, password);
		return "success";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BBSResult<User> getResult() {
		return result;
	}

	public void setResult(BBSResult<User> result) {
		this.result = result;
	}
	
	
}
