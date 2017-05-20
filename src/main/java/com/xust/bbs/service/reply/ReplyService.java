package com.xust.bbs.service.reply;

import java.util.List;

import com.xust.bbs.entity.Post;
import com.xust.bbs.entity.Reply;
import com.xust.bbs.util.BBSResult;

public interface ReplyService {

	/**
	 * 加载帖子
	 * @param postId
	 * @return
	 */
	public BBSResult<Post> loadPost(String postId);
	/**
	 * 分页加载回复
	 * @param postId
	 * @param offset
	 * @param length
	 */
	public BBSResult<List<Reply>> loadReply(String postId, int page);
	/**
	 * 添加回复
	 * @param postId
	 * @param userName
	 * @param replyText
	 */
	public BBSResult<Object> addReply(String postId, String userName, String replyText);
	/**
	 * 删除回复
	 * @param postId
	 * @return
	 */
	public BBSResult<Object> deleteReply(String postId);
	/**
	 * 点赞功能
	 * @param replyId
	 * @return
	 */
	public BBSResult<Object> supportReply(String replyId);
}
