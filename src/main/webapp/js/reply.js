//添加回复
function addReply(postId, userName) {
	var replyText = $("#replyText").val();
	//alert(replyText);
	var ok = true;
	if(postId == null) {
		ok = false;
	}
	if(replyText == "") {
		ok = false;
	}
	if(ok) {
		$.ajax({
			url : path+"/reply/add.bbs",
			type : "post",
			data : {
				"postId" : postId,
				"userName" : userName,
				"replyText" : replyText
			},
			dataType : "json",
			success : function(result) {
				if(result.status == 0) {
					var replyText = $("#replyText").val("");
					loadReplys(postId, 1);
				} else {
					alert(result.msg);
				}
			},
			error : function() {
				alert("回复失败");
			}
		});
	}
}
//加载回复
function loadReplys(postId, page) {
	//console.log(postId);
	$.ajax({
		url : path+"/reply/list.bbs",
		type : "post",
		data : {
			"postId" : postId,
			"page" : page
		},
		dataType : "json",
		success : function(result) {
			if(result.status == 0) {
				//移除所有的回复
				$(".comment-ul li").remove();
				var replys = result.data;
				for(var i = 0; i < replys.length; i++) {
					var reply = replys[i];
					var replyId = reply.replyId;
					var userName = reply.userName;
					var replyText = reply.replyText;
					var replyUp = reply.replyUp;
					var replyTime = reply.replyTime;
					replyTime = replyTime.replace("T", " ");
					
					var sli = "";
					sli += '<li>';
					sli += '<img src="../img/hico02.gif" width="50" height="50" alt="">';
					sli += '<div class="comment-ul-contant">';
					sli += '<small><a href="#">';
					sli += userName;
					sli += '</a></small>';
					sli += '<h3>';
					sli += replyText;
					sli += '</h3>';
					sli += '<div class="comment-btns">';
					sli += '<a href="javascript:;"><span>&#xe904;</span> (';
					sli += replyUp;
					sli += ')</a></div></div>';
               		sli += '<div class="clear"></div>';
         			sli += '<a class="btn-jb"><span>';
       				sli += replyTime;
             		sli += '</span></a></li>';
             		var $li = $(sli);
             		$li.data("replyId", replyId);
					$(".comment-ul").append($li);
				}
			}
		},
		error : function() {
			alert("加载失败");
		}
	});
}