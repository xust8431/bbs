-- 取消外键约束
SET FOREIGN_KEY_CHECKS=0;

-- 创建bbs库
DROP database IF EXISTS `bbs`;
create database bbs default charset=utf8;
use bbs;

-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(100) NOT NULL COMMENT '用户ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `user_nick` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `user_icon` varchar(100) DEFAULT NULL COMMENT '用户头像',
  `user_password` varchar(100) DEFAULT NULL COMMENT '密码',
  `user_token` varchar(100) DEFAULT NULL COMMENT '令牌',
  `user_email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `user_power` varchar(10) COMMENT '权限',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 帖子表
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` varchar(100) NOT NULL COMMENT '帖子ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `post_title` varchar(200) DEFAULT NULL COMMENT '标题',
  `post_content` text COMMENT '帖子内容',
  `post_picture` varchar(100) DEFAULT NULL COMMENT '图片',
  `post_reply_number` bigint(20) DEFAULT NULL COMMENT '回复数',
  `post_up` bigint(20) DEFAULT NULL COMMENT '顶的次数',
  `post_down` bigint(20) DEFAULT NULL COMMENT '踩的次数',
  `post_type` varchar(10) DEFAULT NULL COMMENT '分类(0:默认 1:资讯讨论 2:经验分享)',
  `post_classify` varchar(10) DEFAULT NULL COMMENT '所属性质(0:一般 1:置顶 2:热帖)',
  `post_create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `post_last_reply_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后回复时间',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 回复表
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `reply_id` varchar(100) NOT NULL COMMENT '回复ID',
  `post_id` varchar(100) DEFAULT NULL COMMENT '所属帖子ID',
  `user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `reply_text` text COMMENT '回复内容',
  `reply_up` bigint(20) DEFAULT NULL COMMENT '顶的次数',
  `reply_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '回复时间',
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 收藏表
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `collect_id` varchar(100) NOT NULL COMMENT '收藏ID',
  `user_name` varchar(200) DEFAULT NULL COMMENT '用户名',
  `collect_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '收藏时间',
  `post_id` varchar(100) DEFAULT NULL COMMENT '收藏的帖子ID',
  PRIMARY KEY (`collect_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 朋友表
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `friends_id` varchar(100) NOT NULL COMMENT '朋友关系ID',
  `user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `friend_id` varchar(100) DEFAULT NULL COMMENT '朋友ID',
  `friend_name` varchar(100) DEFAULT NULL COMMENT '朋友名称',
  `friend_create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '建立时间',
  `friend_last_reply_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最近联系时间',
  
  PRIMARY KEY (`friends_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 消息表(私聊消息)
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` varchar(100) NOT NULL COMMENT '消息ID',
  `user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `friend_id` varchar(100) DEFAULT NULL COMMENT '朋友ID',
  `message_status` varchar(10) DEFAULT NULL COMMENT '消息状态 0:接收 1:发送',
  `message_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '消息时间',
  `message_text` text COMMENT '消息文本',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 活动表
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activity_id` varchar(100) NOT NULL COMMENT '活动ID',
  `activity_theme` varchar(100) DEFAULT NULL COMMENT '活动主题',
  `user_id` varchar(100) DEFAULT NULL COMMENT '发起用户ID',
  `activity_status` varchar(10) DEFAULT NULL COMMENT '活动状态0:正在进行 1:结束',
  `activity_picture` varchar(100) DEFAULT NULL COMMENT '活动主题图片',
  `activity_content` text COMMENT '活动内容',
  `activity_amount` bigint(20) DEFAULT NULL COMMENT '参与人数',
  `activity_start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '开始时间',
  `activity_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '结束时间',
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 活动参与表
DROP TABLE IF EXISTS `activity_join`;
CREATE TABLE `activity_join` (
  `activity_join_id` varchar(100) NOT NULL COMMENT '参与信息ID',
  `activity_id` varchar(100) DEFAULT NULL COMMENT '活动ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '参与用户名',
  `activity_phone` varchar(20) DEFAULT NULL COMMENT '参与用户联系电话',
  `activity_join_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '报名时间',
  PRIMARY KEY (`activity_join_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
