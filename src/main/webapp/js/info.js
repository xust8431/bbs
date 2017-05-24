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
						loadUserMsg(userId);
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
//翻页
function changePage(offset) {
	var count = $("#count_span").html();
	var collectPage = 0;
	if(count%5 == 0){
		collectPage = count;
	}else{
		collectPage = count/5 + 1;
	}
	if(offset < collectPage) {
		var last = $(".page a:last").prev().html();
		if(offset == last) {
			var a = $(".page").find("a");
			for(var i = 1; i < a.length-1; i++) {
				var $a = $(a[i]);
				var number = parseInt($a.html(), 10);
				$a.html(number+1);
			}
			$(".page a").removeClass("active");
			$(".page a:last").prev().prev().addClass("active");
		}
	}	
	if(offset > 1) {
		var first = $(".page a:first").next().html();
		if(offset == first) {
			var a = $(".page").find("a");
			for(var i = 1; i < a.length-1; i++) {
				var $a = $(a[i]);
				var number = parseInt($a.html(), 10);
				$a.html(number-1);
			}
			$(".page a").removeClass("active");
			$(".page a:first").next().next().addClass("active");
		}
	}
}
function get_page(t) {
	offset = Number($(t).html());
	if(offset == 1){
		loadCollectList(userName,(offset - 1));
	}else{
		loadCollectList(userName,((offset - 1)*5));
	}
}
function reduce_page() {
	offset = offset - 1;
	if(offset == 0){
		alert("已经是第一页啦!");
		return;
	}
	if(offset == 1){
		loadCollectList(userName,(offset - 1));
	}else{
		loadCollectList(userName,((offset - 1)*5));
	}
	//console.log(offset);
}
function add_page() {
	offset = offset + 1;
	loadCollectList(userName,((offset - 1)*5));
}

//计算帖子数量
function countCollect(userName){
	$.ajax({
		url:path+"/post/countCollect.bbs",
		type:"post",
		data:{"userName":userName},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				var row = result.data;
				$("#count_span").html(row);
			}
		},
		error:function(){
			alert("计算收藏帖子总数失败");
		}
	});
}
//查看收藏帖子内容
function checkCollectMsg() {
	$(".main-ul a").removeClass("checked");
	$(this).find("a").addClass("checked");
	//获取请求参数
	var postId = $(this).data("postId");
	//console.log(postId);
	window.location.href = path + "/reply/load.bbs?postId=" + postId;
}

