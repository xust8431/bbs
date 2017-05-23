package com.xust.bbs.action.collect;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xust.bbs.entity.Collect;
import com.xust.bbs.service.collect.CollectService;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class CollectListAction {

	//输出
	private BBSResult<List<Collect>> result;
	//输入
	private String userName;
	private int offset;
	
	@Resource
	private CollectService collectService;
	
	public String execute(){
		result = collectService.findCollectList(userName, offset);
		return "success";
	}

	public BBSResult<List<Collect>> getResult() {
		return result;
	}

	public void setResult(BBSResult<List<Collect>> result) {
		this.result = result;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	
}
