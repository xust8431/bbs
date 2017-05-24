package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseTest {
	String[] config = {"conf/spring-base.xml","conf/spring-hibernate.xml","conf/spring-upload.xml"};
	public ApplicationContext ac = new ClassPathXmlApplicationContext(config);
	HibernateTemplate template =  ac.getBean("template",HibernateTemplate.class);
}
