//计算帖子总数
function count(type){
	$.ajax({
		url:path+"/post/count.bbs",
		type:"post",
		data:{"type":type},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				//console.log(result.data);
				$("#count_span").html(result.data);
			}
		},
		error:function(){
			alert("显示帖子数量失败");
		}
	});
}

//按类型显示帖子列表
function typeListPost(offset,type){
	$.ajax({
		url:path+"/post/typeList.bbs",
		type:"post",
		data:{"offset":offset,"type":type},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				var posts = result.data;
				$(".main-ul li").remove();
				for(var i=0;i<posts.length;i++){
					var postId = posts[i].id;
					var picture = posts[i].picture;
					var title = posts[i].title;
					var content = posts[i].content;
					var up = posts[i].up;
					var replyNumber = posts[i].replyNumber;
					var userIcon = posts[i].user.icon;
					//console.log(postId);
					postList(postId,title,content,up,replyNumber,picture,userIcon);
				}
			}
		},
		error:function(){
			alert("列表显示失败");
		}
	});
}
//发帖
function postMessage(){
	var type = $("#select_type option:selected").val();
	//console.log(type);
	var userId = getCookie("userId");
	var title = $("#title").val().trim();
	var content = $("#content").val().trim();
	//console.log(title+"&&&"+content);
	var ok = true;
	if(title == null){
		alert("标题不能为空");
		ok = false;
		return;
	}
	if(content == null){
		alert("内容不能为空");
		ok = false;
		return;
	}
	if(ok){
		$.ajaxFileUpload({
    		url:path+"/post/release.bbs"+"?type="+type+"&userId="+userId+"&title="+title+"&content="+content,
    		type:"post",
    		secureuri:false,
    		fileElementId:"upload_file",
    		dataType:"json",
    		success:function(result){
    			console.log(result);
    			if(result.status == 0){
    				$("#title").val("");
    				$("#content").val("");
    				$("#upload_file").val("");
    				window.location.href="post.html";
    			}
    		},
    		error:function(){
    			alert("发表帖子失败")
    		}
    	});
	}
}
//拼接post列表
function postList(postId,title,content,up,replyNumber,picture,userIcon){
	var sli = "";
	sli += '<li>';
	sli += ' <img src="'+userIcon+'" width="50" height="50" alt="">';
	sli += ' <div class="main-ul-contant">';
	sli += '   <h3><a href="#">'+title+'</a></h3>';
	sli += '    <textarea rows="1">'+content+'</textarea>';
	sli += ' </div>';
	sli += ' <div class="tag-talk" title="顶"><span>&#xe904;</span> '+up+'</div>';
	sli += ' <div class="tag-talk" title="回复数"><span>&#xe903;</span> '+replyNumber+'</div>';
	sli += '</li>';
	var $li = $(sli);
	$li.data("postId",postId);
	$(".main-ul").append($li);
}