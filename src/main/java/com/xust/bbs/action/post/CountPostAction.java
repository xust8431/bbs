package com.xust.bbs.action.post;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.service.post.PostService;
import com.xust.bbs.util.BBSResult;


@Controller
@Scope("prototype")
public class CountPostAction {
		//输出
		private BBSResult<Integer> result;
		//接收
		
		@Resource
		private PostService postService;
		
		public String execute(){
			result = postService.countPost();
			return "success";
		}

		public BBSResult<Integer> getResult() {
			return result;
		}

		public void setResult(BBSResult<Integer> result) {
			this.result = result;
		}
}
