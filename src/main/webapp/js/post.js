//计算帖子总数
function count(){
	$.ajax({
		url:path+"/post/count.bbs",
		type:"post",
		data:{},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				console.log(result.data);
				$("#count_span").html(result.data);
			}
		},
		error:function(){
			alert("显示帖子数量失败");
		}
	});
}

//加载帖子列表
function loadPost(offset){
	$.ajax({
		url:path+"/post/list.bbs",
		type:"post",
		data:{"offset":offset},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				var posts = result.data;
				$(".main-ul li").remove();
				for(var i=0;i<posts.length;i++){
					var postId = posts[i].postId;
					var picture = posts[i].picture;
					var title = posts[i].title;
					var content = posts[i].content;
					var up = posts[i].up;
					var replyNumber = posts[i].replyNumber;
					var sli = "";
					sli += '<li>';
					sli += ' <img src="./img/hico02.gif" width="50" height="50" alt="">';
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
			}
		},
		error:function(){
			alert("列表显示失败");
		}
	});
}