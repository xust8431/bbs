package com.xust.bbs.action.post;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.entity.Post;
import com.xust.bbs.service.post.PostService;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class PostHotListAction {

	//输出
	private BBSResult<List<Post>> result;
	//输入
	
	@Resource
	private PostService postService;
	
	public String execute(){
		result = postService.loadPostForHot();
		return "success";
	}

	public BBSResult<List<Post>> getResult() {
		return result;
	}

	public void setResult(BBSResult<List<Post>> result) {
		this.result = result;
	}
	
	
}
