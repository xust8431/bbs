function userLogin(){
				$("#message").hide();
        		var name = $("#name").val().trim();
        		var password = $("#password").val().trim();
        		//console.log(name+"---"+password);
        		
        		//检测格式
        	    var ok = true;//是否通过校验
        	    if(name==""){
        	    	$("#message_strong").html("用户名为空");
        	    	//弹出提示框
        	        $("#message").show();
        	        ok = false;
        	        return;
        	    }

        	    if(password==""){
        	    	$("#message_strong").html("密码为空");
        	    	//弹出提示框
        	        $("#message").show();
        	        ok = false;
        	    }
        	    //发送Ajax请求
        	    if(ok){
        	        $.ajax({
        	            url:path+"/user/nameLogin.bbs",
        	            type:"post",
        	            data:{"name":name,"password":password},
        	            dataType:"json",
        	            success:function(result){
        	                if(result.status == 0){
        	                    //将信息写入cookie
        	                    var userId = result.data.user_id;
        	                    addCookie("userId",userId,2);
        	                    addCookie("userName",name,2);
        	                    window.location.href="home_page.html";
        	                }else if(result.status == 1){//用户名不存在
        	                	$("#message_strong").html(result.msg);
        	                	//弹出提示框
        	                	$("#message").show();
        	                }else if(result.status == 2){//密码错误
        	                    $("#message_strong").html(result.msg);
        	                  	//弹出提示框
        	                    $("#message").show();
        	                }
        	            },
        	            error:function(){
        	                alert("登录失败");
        	            }
        	        });
        	    }
        	}

function userSigin(){
	//alert("-----");
	var name = $("#sigin_name").val().trim();
	var nick = $("#sigin_nick").val().trim();
	var password = $("#sigin_password").val().trim();
	var pwd = $("#sigin_pwd").val().trim();
	var email = $("#sigin_email").val().trim();
	
	var ok = true;
	if(name == ""){
		$("#message_strong").html("用户名不能为空");
    	//弹出提示框
        $("#message").show();
        ok = false;
        return;
	}
	
	if(password == ""){
		$("#message_strong").html("密码不能为空");
    	//弹出提示框
        $("#message").show();
        ok = false;
        return;
	}else if(password.length>0&&password.length<6){
		$("#message_strong").html("密码应该大于6位");
    	//弹出提示框
        $("#message").show();
        ok = false;
        return;
	}
	
	if(pwd == ""){
		$("#message_strong").html("确认密码不能为空");
    	//弹出提示框
        $("#message").show();
        ok = false;
        return;
	}else if(pwd != password){
		$("#message_strong").html("两次输入的不一致");
    	//弹出提示框
        $("#message").show();
        ok = false;
        return;
	}
	
	if(ok){
		$.ajax({
			url:path+"/user/regist.bbs",
			type:"post",
			data:{"name":name,"nick":nick,"password":password,"email":email},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					alert(result.msg);//提示注册成功
					$("#btn-return").click();//返回到登录界面
				}else{
					$("#message_strong").html(result.msg);
        	    	//弹出提示框
        	        $("#message").show();
				}
			},
			error:function(){
				alert("注册失败");
			}
		});
	}
}