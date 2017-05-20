package com.xust.bbs.action.user;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.service.user.UserService;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class UpdateUserMsgAction {

	//输出
	private BBSResult<Object> result;
	//输入
	private String id;
	private String nick;
	private String picture;
	private String password;
	private String email;
	private String oldPassword;
	
	@Resource
	private UserService userService;
	
	public String execute(){
		result = userService.updateUserMsg(picture, password, nick, email, id, oldPassword);
		return "success";
	}

	public BBSResult<Object> getResult() {
		return result;
	}

	public void setResult(BBSResult<Object> result) {
		this.result = result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	
}
