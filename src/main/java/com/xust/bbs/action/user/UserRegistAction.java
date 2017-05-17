package com.xust.bbs.action.user;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.service.user.UserService;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class UserRegistAction {

	//输入
	private String name;
	private String nick;
	private String password;
	private String email;
	//输出
	private BBSResult<Object> result;
	
	@Resource
	private UserService userService;
	
	public String execute(){
		result = userService.regist(name, nick, password, email);
		return "success";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BBSResult<Object> getResult() {
		return result;
	}

	public void setResult(BBSResult<Object> result) {
		this.result = result;
	}
	
	
}
