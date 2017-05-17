package test.post;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.xust.bbs.dao.post.PostDao;
import com.xust.bbs.entity.Post;
import com.xust.bbs.service.post.PostService;
import com.xust.bbs.util.BBSResult;

import test.BaseTest;


public class TestCase extends BaseTest{

	PostDao postDao = null;
	PostService postService = null;
	@Before
	public void init(){
		postDao = ac.getBean("postDao",PostDao.class);
		postService = ac.getBean("postService",PostService.class);
	}
	
	@Test
	public void test1(){
		List<Post> list = postDao.findAll(0, 20);
		for(Post post : list){
			System.out.println(post.getTitle());
		}
		
	}
	@Test
	public void test2(){
		List<Post> list = postDao.findByPostId("6aab86e4921c4eb69d3e191223513c8a");
		for(Post post : list){
			System.out.println(post.getTitle());
		}
	}
	
	@Test
	public void test3(){
		List<Post> list = postDao.findForType(0, 10, "2");
		for(Post post : list){
			System.out.println(post.getTitle());
		}
	}
	
	@Test
	public void test4(){
		int rows = postDao.otherTypeCount("0");
		System.out.println(rows);
	}
	@Test
	public void test5(){
		BBSResult<Integer> result = postService.countPost("1");
		System.out.println(result.getData());
	}
}
