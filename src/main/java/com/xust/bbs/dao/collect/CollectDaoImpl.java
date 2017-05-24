package com.xust.bbs.dao.collect;



import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.xust.bbs.entity.Collect;



@Repository("collectDao")
public class CollectDaoImpl implements CollectDao{

	@Resource
	private HibernateTemplate template;
	
	public void save(Collect collect) {
		template.save(collect);
	}
	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public List<Collect> check(final String postId, final String userName) {
		final String hql = "from Collect where post_id = ? and user_name = ? ";
//		Session session = HibernateUtil.getSession();
//		Query query = session.createQuery(hql);
//		query.setString(0, postId);
//		query.setString(1, userName);
//		List<Collect> list = query.list();
		List<Collect> list = template.executeFind(
				new  HibernateCallback() {
		           public Object doInHibernate(Session session)
		             throws HibernateException, SQLException {
		            Query query = session.createQuery(hql);
		            query.setString(0, postId);
		            query.setString(1, userName);
		            List list = query.list();
		            return list;
		           }
		          });
		return list;
	}
	
	public List<Collect> findByUserName(String userName) {
		String hql = "from Collect where user_name = ?";
		
		return template.find(hql,userName);
	}
	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public List<Collect> findByUserName(final int offset, final int length,final String userName) {
		final String hql = "from Collect where user_name = ? order by collect_time desc";
		List<Collect> list = template.executeFind(
				new  HibernateCallback() {
		           public Object doInHibernate(Session session)
		             throws HibernateException, SQLException {
		        	Query query = session.createQuery(hql);
		        	query.setFirstResult(offset);
		        	query.setMaxResults(length);
		            query.setString(0, userName);
		            List list = query.list();
		            return list;
		           }
		          });
		return list;
	}
	
	public int getCount(String userName) {
		String hql = "select count(*) from Collect as collect where user_name = ?";
		Number count = (Number)template.find(hql,userName).listIterator().next();
		return count.intValue();
	}
}
