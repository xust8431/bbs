package com.xust.bbs.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xust.bbs.dao.user.UserDao;
import com.xust.bbs.entity.User;
import com.xust.bbs.util.BBSResult;
import com.xust.bbs.util.BBSUtil;


@Repository("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	/**
	 * name登录
	 */
	public BBSResult<User> nameLogin(String name, String password) {
		BBSResult<User> result = new BBSResult<User>();
		List<User> list = userDao.findByUserName(name);
		//检测用户名
		if(list==null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		
		User user = list.get(0);
		
		//检测密码
		String pwd = user.getPassword();
		String md5Password = BBSUtil.md5(password);
		
		if(! pwd.equals(md5Password)){
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		
		result.setStatus(0);
		result.setData(user);
		result.setMsg("登录成功");
		return result;
	}
	
	
	/**
	 * 注册
	 */
	public BBSResult<Object> regist(String name, String nick, String password, String email) {
		BBSResult<Object> result = new BBSResult<Object>();
		User user = new User();
		List<User> checkName = userDao.findByUserName(name);
		if(checkName != null){
			result.setStatus(1);
			result.setMsg("用户名已存在！");
			return result;
		}
		
		user.setId(BBSUtil.createId());
		user.setName(name);
		user.setNick(nick);
		user.setPassword(BBSUtil.md5(password));
		user.setPower("0");
		user.setToken(BBSUtil.createId());
		user.setEmail(email);
		userDao.addUser(user);
		result.setStatus(0);
		result.setMsg("注册成功");
		result.setData(user);
		return result;
	}
}
