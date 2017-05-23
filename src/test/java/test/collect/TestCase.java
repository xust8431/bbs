package test.collect;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.xust.bbs.dao.collect.CollectDao;
import com.xust.bbs.entity.Collect;
import com.xust.bbs.service.collect.CollectService;

import test.BaseTest;

public class TestCase extends BaseTest{
	CollectDao collectDao = null;
	CollectService collectService = null;
	@Before
	public void init(){
		collectDao = ac.getBean("collectDao",CollectDao.class);
		collectService = ac.getBean("collectService",CollectService.class);
	}
	
	@Test
	public void test1(){
		List<Collect> list = collectDao.check("262915d3f25b40d4a8dfc08d89ae112e", "lx");
		System.out.println(list.get(0).getCollectId());
	}
	
	@Test
	public void test2(){
		List<Collect> list = collectDao.findByUserName(0, 2, "lx");
		for(Collect col : list ){
			System.out.println(col.getPosts().getTitle());
		}
	}
}
