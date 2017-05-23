package com.xust.bbs.service.collect;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xust.bbs.dao.collect.CollectDao;
import com.xust.bbs.entity.Collect;
import com.xust.bbs.entity.Post;
import com.xust.bbs.util.BBSResult;
import com.xust.bbs.util.BBSUtil;

@Repository("collectService")
@Transactional
public class CollectServiceImpl implements CollectService{

	@Resource
	private CollectDao collectDao;
	
	public BBSResult<Collect> collectPost(String postId, String userName) {
		Collect collect = new Collect();
		BBSResult<Collect> result = new BBSResult<Collect>();
		List<Collect> list = collectDao.check(postId, userName);
		System.out.println(list);
		Post post = new Post();
		post.setId(postId);
		if(list.size() == 0){
			collect.setCollectId(BBSUtil.createId());
			collect.setDesc("");
			//collect.setPostId(postId);
			Timestamp time = new Timestamp(System.currentTimeMillis());
			collect.setTime(time);
			collect.setUserName(userName);
			collect.setPosts(post);
			collectDao.save(collect);
			result.setStatus(0);
			result.setMsg("添加至收藏成功");
			//result.setData(collect);
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("已经收藏过啦");
			return result;
		}
	}
	
	public BBSResult<List<Collect>> findCollectList(String userName, int offset) {
		BBSResult<List<Collect>> result = new BBSResult<List<Collect>>();
		List<Collect> list = collectDao.findByUserName(offset, 5, userName);
		result.setStatus(0);
		result.setMsg("查询收藏列表成功");
		result.setData(list);
		return result;
	}
}
