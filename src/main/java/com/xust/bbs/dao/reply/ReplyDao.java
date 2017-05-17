package com.xust.bbs.dao.reply;

import java.util.List;

import com.xust.bbs.entity.Reply;

public interface ReplyDao {

	/**
	 * 查询所有回复
	 * @return
	 */
	public List<Reply> findByPostId(final String postId, final int offset, final int length);
	/**
	 * 增加回复
	 * @param reply
	 */
	public void save(Reply reply);
	/**
	 * 删除回复
	 * @param replyId
	 */
	public void delete(String replyId);
}
