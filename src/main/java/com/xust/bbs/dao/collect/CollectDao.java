package com.xust.bbs.dao.collect;

import java.util.List;

import com.xust.bbs.entity.Collect;
import com.xust.bbs.entity.Post;

public interface CollectDao {
	/**
	 * 添加帖子至收藏
	 */
	public void save(Collect collect);
	/**
	 * 查重（每个用户只能收藏同一个帖子一次）
	 */
	public List<Collect> check(final String postId, final String userName);
	/**
	 * 通过userName分页查询用户自己收藏的帖子
	 * @param userName
	 * @return
	 */
	public List<Collect> findByUserName(final int offset, final int length, final String userName);
	
	
}
