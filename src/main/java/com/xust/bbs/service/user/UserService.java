package com.xust.bbs.service.user;

import java.util.List;

import com.xust.bbs.entity.User;
import com.xust.bbs.util.BBSResult;

public interface UserService {
	public BBSResult<User> nameLogin(String name, String password);
	public BBSResult<Object> regist(String name, String nick, String password, String email);
	public BBSResult<List<User>> loadUserMsg(String userId);
	public BBSResult<Object> updateUserMsg(
			String picture, String password, String nick, String email, String userId, String oldPassword);
}
