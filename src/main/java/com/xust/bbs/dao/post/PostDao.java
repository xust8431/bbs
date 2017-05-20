package com.xust.bbs.dao.post;

import java.util.List;

import com.xust.bbs.entity.Post;



public interface PostDao {
	/**
	 * 查询帖子数量
	 * @return 帖子总数量
	 */
	public int count();
	/**
	 * 查询其他类型帖子的数量
	 */
	public int otherTypeCount(String type);
	/**
	 * 分页查询
	 * @param offset 初始位置
	 * @param length 每页显示数量
	 * @return 查询到的所有帖子
	 */
	public List<Post> findAll(final int offset,final int length);
	
	/**
	 * 发表帖子
	 * @param post 实体类post对象
	 */
	public void add(Post post);
	/**
	 * 通过PostId查询帖子内容
	 * @return 一个帖子内容
	 */
	public List<Post> findByPostId(String postId);
	/**
	 * 按帖子类型分页查询
	 * @param offset 初始位置
	 * @param length 每页显示数量
	 * @return 查询到的所有帖子
	 */
	public List<Post> findForType(final int offset,final int length, final String type);
	/**
	 * 更新post
	 * @param post
	 */
	public void update(Post post);
}
