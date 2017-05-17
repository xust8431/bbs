package test.reply;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xust.bbs.dao.reply.ReplyDao;
import com.xust.bbs.entity.Reply;
import com.xust.bbs.util.BBSUtil;

public class TestReplyDao {

	private ReplyDao replyDao;
	
	@Before
	public void init() {
		String conf = "conf/spring.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		replyDao = ac.getBean("replyDao", ReplyDao.class);
	}
	
	@Test
	public void test1() {
		Reply reply = new Reply();
		reply.setReplyId(BBSUtil.createId());
		reply.setPostId("343c1c592e9a4100a98dff139473c0ca");
		reply.setUserName("admin");
		reply.setReplyText("这里是6楼的回复");
		reply.setReplyUp(666);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		reply.setReplyTime(time);
		replyDao.save(reply);
	}
	
	@Test
	public void test2() {
		List<Reply> replys = replyDao.findByPostId("343c1c592e9a4100a98dff139473c0ca", 0, 5);
		for(Reply r : replys) {
			System.out.println(r.getReplyTime());
			System.out.println(r.getReplyText());
		}
	}
}


















