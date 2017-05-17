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
public class PostTypeListAction {

	//输出
	private BBSResult<List<Post>> result;
	//输入
	private int offset;
	private String type;
	
	@Resource
	private PostService postService;
	
	public String execute(){
		result = postService.loadPostForType(offset, type);
		return "success";
	}

	public BBSResult<List<Post>> getResult() {
		return result;
	}

	public void setResult(BBSResult<List<Post>> result) {
		this.result = result;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
