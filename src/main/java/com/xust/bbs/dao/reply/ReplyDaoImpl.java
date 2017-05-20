package com.xust.bbs.dao.reply;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xust.bbs.entity.Reply;

@Repository("replyDao")
public class ReplyDaoImpl implements ReplyDao {
	
	@Resource
	private HibernateTemplate template;

	public List<Reply> findByPostId(final String postId, final int offset, final int length) {
		final String hql = "from Reply where postId=? order by replyTime";
		@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
		List<Reply> replys = template.executeFind(
			new  HibernateCallback() {
		           public Object doInHibernate(Session session)
		             throws HibernateException, SQLException {
		            Query query = session.createQuery(hql);
		            query.setString(0, postId);
		            query.setFirstResult(offset);
		            query.setMaxResults(length);
		            List list = query.list();
		            return list;
		           }});
		return replys;
	}

	public void save(Reply reply) {
		template.save(reply);
	}

	public void delete(String replyId) {
		Reply reply = new Reply();
		reply.setReplyId(replyId);
		template.delete(reply);
	}

	public void update(Reply reply) {
		template.update(reply);
	}

	public Reply findByReplyId(String replyId) {
		Reply reply = template.get(Reply.class, replyId);
		return reply;
	}

}
