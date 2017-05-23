function loadUserMsg(userId){
	$.ajax({
		url:path+"/user/userMsg.bbs",
		type:"post",
		data:{"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				var users = result.data;
				$(".list-unstyled li").remove();
				for(var i=0;i<users.length;i++){
					var nick = users[i].nick;
					var email = users[i].email;
					var picture = users[i].picture;
					//console.log(nick+"--"+email);
				}
				var sli = "";
				sli +='<li>';
				sli +='<strong>昵称</strong><br><span>'+nick+'</span>';
				sli +='</li>';
				sli +='<li>';
				sli +='<strong>邮箱</strong><br><span>'+email+'</span>';
				sli +='</li>';
				$li = $(sli);
				$(".list-unstyled").append($li);
			}
		},
		error:function(){
			alert("查看用户信息失败");
		}
	});
}
//修改用户信息

	function updateUser(userId){
		var picture = "";//TODO:头像
		var pwd = $("#user-pwd").val();//原密码
		var password = $("#user-password").val();//新密码
		var password2 = $("#user-password2").val();//第二次输入新密码
		var nick = $("#user-nick").val();
		var email = $("#user-email").val();
		//console.log(password+"----"+password2);
		var ok = true;
		$("#pwd_span").html("");
		$("#password2_span").html("");
		$("#password_span").html("");
		if(password == null){
			$("#password_span").html("密码不能为空");
			ok = false;
			return;
		}
		if(password2 == null){
			$("#password2_span").html("再次输入的密码不能为空");
			ok = false;
			return;
		}
		if(password != password2){
			$("#password2_span").html("两次输入的密码不一致");
			ok = false;
			return;
		}
		if(ok){
			$.ajax({
				url:path+"/user/updataUserMsg.bbs",
				type:"post",
				data:{"picture":picture,"password":password,"nick":nick,"email":email,"id":userId,"oldPassword":pwd},
				dataType:"json",
				success:function(result){
					if(result.status == 0){
						alert(result.msg);
					}else if(result.status == 1){
						$("#pwd_span").html(result.msg);
					}else if(result.status == 2){
						alert(result.msg);
					}else if(result.status == 3){
						alert(result.msg);
					}
				},
				error:function(){
					alert("修改用户信息失败");
				}
			});
		}
	}
//显示收藏列表
function loadCollectList(userName,offset){
	$.ajax({
		url:path+"/post/collectList.bbs",
		type:"post",
		data:{"userName":userName,"offset":offset},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				var posts = result.data;
				$(".main-ul li").remove();
				for(var i=0;i<posts.length;i++){
					var title = posts[i].posts.title;
					var content = posts[i].posts.content;
					var replyNumber = posts[i].posts.replyNumber;
					var postId = posts[i].posts.id;
					var picture = posts[i].posts.picture;
					var sli = "";
					sli +='<li>';
					sli +='<img src="./img/hico02.gif" width="50" height="50" alt="">';
					sli +='<div class="main-ul-contant">';
					sli +='<h3><a href="#">'+title+'</a></h3>';
					sli +='<small>'+content+'</small>';
					sli +='</div>';
					sli +='<div class="tag-talk" title="回复数"><span>&#xe903;</span> '+replyNumber+'</div>';
					sli +='</li>';
                	var $li = $(sli);
            		$li.data("postId",postId);
            		$(".main-ul").append($li);
				}
			}
		},
		error:function(){
			alert("显示收藏列表失败");
		}
	});
}