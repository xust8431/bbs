package test.user;

import org.junit.Before;
import org.junit.Test;

import com.xust.bbs.dao.user.UserDao;

import com.xust.bbs.service.user.UserService;

import test.BaseTest;

public class TestCase extends BaseTest{

	UserDao userDao = null;
	UserService userService = null;
	@Before
	public void init(){
		userDao =  ac.getBean("userDao",UserDao.class);
		userService = ac.getBean("userService",UserService.class);
	}
	
	@Test
	public void test1(){
		String id = userService.loadUserMsg("655c578bcd2a496986cb150dc8a159d5").getData().get(0).getName();
		System.out.println(id);
	}
}
