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
	
	public BBSResult<List<User>> loadUserMsg(String userId) {
		BBSResult<List<User>> result = new BBSResult<List<User>>();
		List<User> user = userDao.findByUserId(userId);
		result.setStatus(0);
		result.setMsg("显示用户信息成功");
		result.setData(user);
		return result;
	}
	
	public BBSResult<Object> updateUserMsg(
			String picture, String password, String nick, String email, String userId, String oldPassword) {
		BBSResult<Object> result = new BBSResult<Object>();
		User user = new User();
		List<User> list = userDao.findByUserId(userId);
		String oldPwd = BBSUtil.md5(oldPassword);
		if(list != null){
			User userList = list.get(0);
			String pwd = userList.getPassword();
			if(oldPwd.equals(pwd)){
				if(!password.equals("")){
					user.setName(userList.getName());
					user.setIcon(picture);
					user.setPassword(BBSUtil.md5(password));
					user.setNick(nick);
					user.setEmail(email);
					user.setId(userId);
					user.setToken(userList.getToken());
					user.setPower(userList.getPower());
					userDao.update(user);
					result.setStatus(0);
					result.setData(user);
					result.setMsg("修改信息成功");
					return result;
				}else{
					result.setStatus(3);
					result.setMsg("密码不能为空");
					return result;
				}
		}else{
			result.setStatus(1);
			result.setMsg("和原密码不一致");
			return result;
		}
	}else{
			result.setStatus(2);
			result.setMsg("修改信息失败");
			return result;
		}
	}
}
