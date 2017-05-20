package com.xust.bbs.service.reply;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xust.bbs.dao.post.PostDao;
import com.xust.bbs.dao.reply.ReplyDao;
import com.xust.bbs.entity.Post;
import com.xust.bbs.entity.Reply;
import com.xust.bbs.util.BBSResult;
import com.xust.bbs.util.BBSUtil;

@Service("replyService")
@Transactional
public class ReplyServiceImpl implements ReplyService {
	
	@Resource
	private ReplyDao replyDao;
	@Resource
	private PostDao postDao;

	public BBSResult<Post> loadPost(String postId) {
		BBSResult<Post> result = new BBSResult<Post>();
		List<Post> posts = postDao.findByPostId(postId);
		if(posts.size() == 0) {
			result.setStatus(1);
			result.setMsg("加载失败");
			return result;
		}
		Post post = posts.get(0);
		result.setStatus(0);
		result.setMsg("加载成功");
		result.setData(post);
		return result;
	}
	
	public BBSResult<List<Reply>> loadReply(String postId, int page) {
		BBSResult<List<Reply>> result = new BBSResult<List<Reply>>();
		int offset = (page - 1) * 20;
		int length = 20;
		List<Reply> replys = replyDao.findByPostId(postId, offset, length);
		result.setStatus(0);
		result.setMsg("加载成功");
		result.setData(replys);
		return result;
	}

	public BBSResult<Object> addReply(String postId, String userName, String replyText) {
		BBSResult<Object> result = new BBSResult<Object>();
		List<Post> posts = postDao.findByPostId(postId);
		if(posts != null) {
			Post post = posts.get(0);
			//post表回复数+1
			long replyNumber = post.getReplyNumber();
			post.setReplyNumber(replyNumber + 1);
			postDao.update(post);
			//添加回复至reply表
			Reply reply = new Reply();
			reply.setReplyId(BBSUtil.createId());
			reply.setPostId(postId);
			reply.setUserName(userName);
			reply.setReplyText(replyText);
			reply.setReplyUp(0);
			Timestamp time = new Timestamp(System.currentTimeMillis());
			reply.setReplyTime(time);
			replyDao.save(reply);
			result.setStatus(0);
			result.setMsg("回复成功");
			return result;
		}
		result.setStatus(1);
		result.setMsg("回复失败");
		return result;
	}

	public BBSResult<Object> deleteReply(String postId) {
		BBSResult<Object> result = new BBSResult<Object>();
		replyDao.delete(postId);
		result.setStatus(0);
		result.setMsg("删除成功");
		return null;
	}

	public BBSResult<Object> supportReply(String replyId) {
		BBSResult<Object> result = new BBSResult<Object>();
		Reply reply = replyDao.findByReplyId(replyId);
		reply.setReplyUp(reply.getReplyUp() + 1);
		replyDao.update(reply);
		result.setStatus(0);
		result.setMsg("点赞成功");
		return result;
	}

}
