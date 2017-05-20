package com.xust.bbs.dao.user;

import java.util.List;

import com.xust.bbs.entity.User;

public interface UserDao {

	public List<User> findByUserName(String name);
	public void addUser(User user);
	public List<User> findByUserId(String userId);
	public void update(User user);
}
