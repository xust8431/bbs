<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="icon/favicon.ico">
    <title>论坛</title>
    <link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="../css/bootstrap/bootstrap-theme.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/base.css">
    <link rel="stylesheet" href="../css/init-top.css">
    <link rel="stylesheet" href="../css/reply.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/docs.min.js"></script>
    <script src="./../js/main.min.js"></script>
    <script type="text/javascript" src="../js/basevalue.js"></script>
    <script type="text/javascript" src="../js/cookie_util.js"></script>
    <script type="text/javascript" src="../js/reply.js"></script>
    <script  type="text/javascript">
        $(function () {
        	//当前的页码
        	var page = 1;
        	var postId = $("#post-id").val();
        	var replyNumber = $("#reply-num").val();
        	var replyPage = parseInt(parseInt(replyNumber, 10) / 20 + 1, 10);
        	//登陆后显示登录名
			var userName = getCookie("userName");
			if(userName != null) {
				$("#login-name").html(userName);
			}
			//页面加载完成自动加载回复信息
			loadReplys(postId, page);
			//添加回复
			$(".submit-comment").click(toAddReply);
			function toAddReply() {
				addReply(postId, userName, page);
			}
			//点赞
			$(".comment-ul").on("click", "li .comment-ul-contant .comment-btns a", support);
			/* ====================================================================================== */
			
			//翻页
			$(".page a").click(function() {
				//alert($(this).html());
				var value = $(this).html();
				if(value == "&lt;") {
					if(page > 1) {
						page -= 1;
						var $a = $(".page a.active");
						$(".page a").removeClass("active");
						$a.prev().addClass("active");
						loadReplys(postId, page);
					}
				} else if(value == "&gt;") {
					if(page < replyPage) {
						page += 1;
						var $a = $(".page a.active");
						$(".page a").removeClass("active");
						$a.next().addClass("active");
						loadReplys(postId, page);
					} else {
						alert("已经是最后一页啦");
					}
				} else {
					page = value;
					$(".page a").removeClass("active");
					$(this).addClass("active");
					loadReplys(postId, page);
				}
				
				if(page < replyPage) {
					var last = $(".page a:last").prev().html();
					if(page == last) {
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
				
				if(page > 1) {
					var first = $(".page a:first").next().html();
					if(page == first) {
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
				
			});
			
			/* ====================================================================================== */
        });
    </script>
    <!--[if lt IE 9]>
    <script src="../js/html5shiv.min.js"></script>
    <script src="../js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">School BBS</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">#</a></li>
                <li><a href="#">#</a></li>
                <li><a href="../info.html">个人资料</a></li>
                <li><a href="../login.html" id="login-name">登录</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>
<div class="container top">
    <div class="logo">
        <img src="../img/logo.png" alt="">
        <a href=""></a>
    </div>
    <div class="masthead">
        <nav>
            <ul class="nav nav-justified">
                <li><a href="../home_page.html">首页</a></li>
                <li class="active"><a href="../post.html">论坛</a></li>
                <li><a href="../activity.html">活动</a></li>
                <li><a href="../share.html">分享</a></li>
                <li><a href="../friend.html">朋友</a></li>
                <li><a href="#">扩展</a></li>
            </ul>
        </nav>
    </div>
    <div id="main">
        <div class="col-md-9 left-side">
            <div class="main-container">
                <ol class="breadcrumb">
                    <li><a href="../post.html">论坛</a></li>
                    <li class="active">${result.data.title }</li>
                    <input type="hidden" id="post-id" value="${result.data.id }" />
                    <input type="hidden" id="reply-num" value="${result.data.replyNumber }" />
                </ol>
                <ul class="main-ul" style="margin-top:0px;">
                    <li>
                        <img src="../img/huser01.gif" width="50" height="50" alt="">
                        <div class="main-ul-contant">
                            <h1>${result.data.title }</h1>
                            <small style="margin-top:0px;font-size:12px;">发表于：${result.data.createTime } 作者：${result.data.userName }</small>
                        </div>
                        <div class="tag-talk" title="顶"><span>&#xe904;</span> ${result.data.up }</div>
                        <div class="tag-talk" title="回复数"><span>&#xe903;</span> ${result.data.down }</div>
                    </li>
                </ul>
                <div class="clear"></div>
                <div class="contant-info">
                    <img src="../img/ChMkJldiS1eIZrq7AA0lqb0yX8kAASqZgLX4XMADSXB895.jpg" alt=""><br>
                    ${result.data.content }
                </div>
                <div class="contant-btn">
                    <a href="javascript:;"><span>&#xe902;</span> 收藏</a>
                    <a href="javascript:;"><span>&#xe024;</span> 分享</a>
                    <a href="javascript:;"><span>&#xe904;</span> 顶</a>
                    <a href="javascript:;"><span class="ico-cai">&#xe904;</span> 踩</a>
                </div>
            </div>
            <div class="comment-container">
                <div class="title">全部评论</div>
                <ul class="comment-ul">
                    <li>
                        <img src="../img/hico02.gif" width="50" height="50" alt="">
                        <div class="comment-ul-contant">
                            <small><a href="#">用户名</a></small>
                            <h3>正文</h3>
                            <div class="comment-btns">
                                <a href="javascript:;"><span>&#xe904;</span> (666)</a>
                            </div>
                        </div>
                        <div class="clear"></div>
                        <a href="" class="btn-jb"><span>2017/5/1 11:11:11</span></a>
                    </li>
                </ul>
                <div class="page">
                    <a href="javascript:;" class="prev">&lt;</a>
                    <a href="javascript:;" class="active">1</a>
                    <a href="javascript:;">2</a>
                    <a href="javascript:;">3</a>
                    <a href="javascript:;">4</a>
                    <a href="javascript:;">5</a>
                    <a href="javascript:;">6</a>
                    <a href="javascript:;" class="next">&gt;</a>
                </div>
            </div>
            <div class="comment-container">
                <div class="reply-title">发表评论</div>
                <div class="input-comment">
                    <!-- 此处添加编辑器 -->
                    <textarea id="replyText" style="width: 100%;height: 100%;padding: 10px"></textarea>
                </div>
                <input type="button" value="发表回复" class="submit-comment" />
                <div class="clear"></div>
            </div>
        </div>

        <div class="col-md-3 right-side">
            <div class="clear"></div>
            <div class="btn-wrap">
                <a href="../release.html" class="btn-theme"><span>&#xe900;</span> 发表主题</a>
            </div>
            <div class="hot-wrap">
                <div class="title">热帖榜</div>
                <ul class="ul-hot">
                    <li><a href="#">西铁城光动能男表BM8475-26E开箱</a></li>
                    <li><a href="#">大婶爱数码，2013年度数码历历数~</a></li>
                    <li><a href="#">小米移动电源的宿敌？ -- AIKa 锋芒</a></li>
                    <li><a href="#">标记你的生活 -- 「Pinco品酷」数字</a></li>
                    <li><a href="#">不止轻薄！--OZAKI iPhone5S超薄保护套</a></li>
                    <li><a href="#">搞机历程2013孤独的搞机历程</a></li>
                    <li><a href="#">居家旅行好帮手——奥睿科多口USB充电器体</a></li>
                    <li><a href="#">我与插座有个约会——实用插座体验</a></li>
                </ul>
            </div>
            <div class="hot-wrap">
                <div class="title">推荐活动</div>
                <div class="img-container">
                    <a href="#"><img src="../img/action.png" width="300" height="184" alt=""></a>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
</body>
</html>
