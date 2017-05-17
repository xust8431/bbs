package com.xust.bbs.service.post;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xust.bbs.dao.post.PostDao;
import com.xust.bbs.entity.Post;
import com.xust.bbs.util.BBSResult;
import com.xust.bbs.util.BBSUtil;


@Repository("postService")
@Transactional
public class PostServiceImpl implements PostService{

	@Resource
	private PostDao postDao;
	
	public BBSResult<Integer> countPost() {
		BBSResult<Integer> result = new BBSResult<Integer>();
		int rows = postDao.count();//总记录数
		result.setStatus(0);
		result.setData(rows);
		return result;
	}
	
	public BBSResult<List<Post>> loadPost(int offset) {
		BBSResult<List<Post>> result = new BBSResult<List<Post>>();
		List<Post> list = postDao.findAll(offset, 20);
		if(list == null){
			result.setStatus(1);
			result.setMsg("帖子列表为空");
			return result;
		}
		
		result.setStatus(0);
		result.setData(list);
		result.setMsg("显示列表成功");
		return result;
	}
	
	public BBSResult<Post> releasePost(String userName,String type, String title, String content, String picture) {
		BBSResult<Post> result = new BBSResult<Post>();
		Post post = new Post();
		post.setId(BBSUtil.createId());
		post.setUserName(userName);
		post.setTitle(title);
		post.setPicture(picture);
		post.setContent(content);
		post.setReplyNumber((long) 0);
		post.setUp((long) 0);
		post.setDown((long) 0);
		post.setClassify("0");
		post.setType(type);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		post.setCreateTime(time);
		post.setLastReplyTime(time);
		postDao.add(post);
		result.setStatus(0);
		result.setData(post);
		result.setMsg("发表帖子成功");
		return result;
	}
	
	public BBSResult<List<Post>> loadPostForType(int offset, String type) {
		BBSResult<List<Post>> result = new BBSResult<List<Post>>();
		List<Post> list = postDao.findForType(offset, 20, type);
		if(list == null){
			result.setStatus(1);
			result.setMsg("帖子列表为空");
			return result;
		}
		
		result.setStatus(0);
		result.setData(list);
		result.setMsg("显示列表成功");
		return result;
	}
}
