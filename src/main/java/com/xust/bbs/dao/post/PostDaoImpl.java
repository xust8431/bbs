package com.xust.bbs.dao.post;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xust.bbs.entity.Post;

@Repository("postDao")
public class PostDaoImpl implements PostDao{

	@Resource
	private HibernateTemplate template;
	
	
	public int count() {
		String hql = "select count(*) from Post as post";
		Number count = (Number)template.find(hql).listIterator().next();
		return count.intValue();
	}
	
	public int otherTypeCount(String type) {
		String hql = "select count(*) from Post as post where post_type = ?";
		Number count = (Number)template.find(hql,type).listIterator().next();
		return count.intValue();
	}
	
	public List<Post> findAll(final int offset, final int length) {
		final String hql = "from Post order by post_last_reply_time desc";
		@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
		List<Post> list = template.executeFind(
				new  HibernateCallback() {
		           public Object doInHibernate(Session session)
		             throws HibernateException, SQLException {
		            Query query = session.createQuery(hql);
		            query.setFirstResult(offset);
		            query.setMaxResults(length);
		            List list = query.list();
		            return list;
		           }
		          });
		 return list;
	}
	
	public void add(Post post) {
		template.save(post);
	}
	
	public List<Post> findByPostId(String postId) {
		String hql = "from Post where post_id = ?";
		List<Post> list = template.find(hql, postId);
		return list;
	}
	
	public List<Post> findForType(final int offset, final int length, final String type) {
		final String hql = "from Post where post_type = ? order by post_last_reply_time desc";
		@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
		List<Post> list = template.executeFind(
				new  HibernateCallback() {
		           public Object doInHibernate(Session session)
		             throws HibernateException, SQLException {
		            Query query = session.createQuery(hql);
		            query.setFirstResult(offset);
		            query.setMaxResults(length);
		            query.setString(0, type);
		            List list = query.list();
		            return list;
		           }
		          });
		 return list;
		
	}
	
	public List<Post> findForHot(final int offset, final int length) {
		final String hql = "from Post order by post_reply_number desc";
		@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
		List<Post> list = template.executeFind(
				new  HibernateCallback() {
		           public Object doInHibernate(Session session)
		             throws HibernateException, SQLException {
		            Query query = session.createQuery(hql);
		            query.setFirstResult(offset);
		            query.setMaxResults(length);
		            List list = query.list();
		            return list;
		           }
		          });
		 return list;
	}
	
	public void update(Post post) {
		template.update(post);
	}
	

}
