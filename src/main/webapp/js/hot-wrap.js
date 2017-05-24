	function hotWrap(){
		$.ajax({
			url:path+"/post/hotList.bbs",
			type:"post",
			data:{},
			dataType:"json",
			success:function(result){
				if(result.status == 0){
					var posts = result.data;
					for(var i=0;i<posts.length;i++){
						var title = posts[i].title;
						var postId = posts[i].id;
						var sli = "";
						sli += '<li><a href="#">'+title+'</a></li>';
						var $li = $(sli);
						$li.data("postId",postId);
						$(".ul-hot").append($li);
					}
				}
			},
			error:function(){
				alert("显示热帖榜失败");
			}
		});
	}

//查看帖子内容
function checkPostMsg() {
	$(".ul-hot a").removeClass("checked");
	$(this).find("a").addClass("checked");
	//获取请求参数
	var postId = $(this).data("postId");
	//console.log(postId);
	window.location.href = path + "/reply/load.bbs?postId=" + postId;
	}

        
                    
                    
