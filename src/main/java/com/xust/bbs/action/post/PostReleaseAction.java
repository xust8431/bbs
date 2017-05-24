package com.xust.bbs.action.post;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xust.bbs.entity.Post;
import com.xust.bbs.service.post.PostService;
import com.xust.bbs.util.BBSImagePathUtil;
import com.xust.bbs.util.BBSResult;

@Controller
@Scope("prototype")
public class PostReleaseAction {

	//输入
	private String userId;
	private String title;
	private String content;
	private String type;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	//输出
	private BBSResult<Object> result;
	
	@Resource
	private PostService postService;
	
	public String execute() throws IOException{
		String path = BBSImagePathUtil.getImagePath(upload, uploadFileName, uploadContentType);
		//System.out.println(path);
		result = postService.releasePost(userId, type, title, content, path);
		return "success";
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BBSResult<Object> getResult() {
		return result;
	}

	public void setResult(BBSResult<Object> result) {
		this.result = result;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
