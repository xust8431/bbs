package com.xust.bbs.service.post;

import java.util.List;

import com.xust.bbs.entity.Post;
import com.xust.bbs.util.BBSResult;

public interface PostService {

	public BBSResult<Integer> countPost(String type);
	public BBSResult<List<Post>> loadPost(int offset);
	public BBSResult<Object> releasePost(String userId,String type, String title, String content, String picture);
	public BBSResult<List<Post>> loadPostForType(int offset, String type);
	public BBSResult<List<Post>> loadPostForHot();
	/**
	 * 顶帖子
	 * @param postId
	 * @return
	 */
	public BBSResult<Object> upPost(String postId);
	/**
	 * 踩帖子
	 * @param postId
	 * @return
	 */
	public BBSResult<Object> downPost(String postId);
}
