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
	
}
