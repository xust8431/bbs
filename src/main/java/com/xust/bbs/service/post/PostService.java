package com.xust.bbs.service.post;

import java.util.List;

import com.xust.bbs.entity.Post;
import com.xust.bbs.util.BBSResult;

public interface PostService {

	public BBSResult<Integer> countPost();
	public BBSResult<List<Post>> loadPost(int offset);
	public BBSResult<Post> releasePost(String userName,String type, String title, String content, String picture);
	public BBSResult<List<Post>> loadPostForType(int offset, String type);
}
