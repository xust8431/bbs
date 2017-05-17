package com.xust.bbs.dao.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xust.bbs.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Resource
	private HibernateTemplate template;
	
	/**
	 * 用户名登录
	 */
	public List<User> findByUserName(String name) {
		String hql = "from User where name = ?";
		List<User> user = template.find(hql,name);
		if(user.isEmpty()){
			return null;
		}else{
			return user;
		}
	}
	
	
	/**
	 * 注册
	 */
	public void addUser(User user) {
		template.save(user);
	}
}
