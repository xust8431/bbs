package test.reply;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xust.bbs.service.reply.ReplyService;

public class TestReplyService {

private ReplyService replyService;
	
	@Before
	public void init() {
		String conf = "conf/spring.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		replyService = ac.getBean("replyService", ReplyService.class);
	}
	
	@Test
	public void test1() {
		replyService.supportReply("75e5e27f1875421eb6ba5293d3666a7b");
	}
	
	@Test
	public void test2() {
		for(int i = 0; i < 100; i++) {
			replyService.addReply("b6fcff5805be45cea0bc4e5f3a5ff463", "admin", "雪地里相爱他们说零下已结晶的誓言不会坏");
		}
	}
	
}
