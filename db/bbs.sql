-- ȡ�����Լ��
SET FOREIGN_KEY_CHECKS=0;

-- ����bbs��
DROP database IF EXISTS `bbs`;
create database bbs default charset=utf8;
use bbs;

-- �û���
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(100) NOT NULL COMMENT '�û�ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '�û���',
  `user_nick` varchar(100) DEFAULT NULL COMMENT '�û��ǳ�',
  `user_icon` varchar(100) DEFAULT NULL COMMENT '�û�ͷ��',
  `user_password` varchar(100) DEFAULT NULL COMMENT '����',
  `user_token` varchar(100) DEFAULT NULL COMMENT '����',
  `user_email` varchar(100) DEFAULT NULL COMMENT '����',
  `user_power` varchar(10) COMMENT 'Ȩ��',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ���ӱ�
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` varchar(100) NOT NULL COMMENT '����ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '�û���',
  `post_title` varchar(200) DEFAULT NULL COMMENT '����',
  `post_content` text COMMENT '��������',
  `post_picture` varchar(100) DEFAULT NULL COMMENT 'ͼƬ',
  `post_reply_number` bigint(20) DEFAULT NULL COMMENT '�ظ���',
  `post_up` bigint(20) DEFAULT NULL COMMENT '���Ĵ���',
  `post_down` bigint(20) DEFAULT NULL COMMENT '�ȵĴ���',
  `post_type` varchar(10) DEFAULT NULL COMMENT '����(0:Ĭ�� 1:��Ѷ���� 2:�������)',
  `post_classify` varchar(10) DEFAULT NULL COMMENT '��������(0:һ�� 1:�ö� 2:����)',
  `post_create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '����ʱ��',
  `post_last_reply_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '���ظ�ʱ��',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- �ظ���
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `reply_id` varchar(100) NOT NULL COMMENT '�ظ�ID',
  `post_id` varchar(100) DEFAULT NULL COMMENT '��������ID',
  `user_id` varchar(100) DEFAULT NULL COMMENT '�û�ID',
  `reply_text` text COMMENT '�ظ�����',
  `reply_up` bigint(20) DEFAULT NULL COMMENT '���Ĵ���',
  `reply_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '�ظ�ʱ��',
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- �ղر�
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `collect_id` varchar(100) NOT NULL COMMENT '�ղ�ID',
  `user_name` varchar(200) DEFAULT NULL COMMENT '�û���',
  `collect_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '�ղ�ʱ��',
  `post_id` varchar(100) DEFAULT NULL COMMENT '�ղص�����ID',
  PRIMARY KEY (`collect_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ���ѱ�
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `friends_id` varchar(100) NOT NULL COMMENT '���ѹ�ϵID',
  `user_id` varchar(100) DEFAULT NULL COMMENT '�û�ID',
  `friend_id` varchar(100) DEFAULT NULL COMMENT '����ID',
  `friend_name` varchar(100) DEFAULT NULL COMMENT '��������',
  `friend_create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '����ʱ��',
  `friend_last_reply_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '�����ϵʱ��',
  
  PRIMARY KEY (`friends_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ��Ϣ��(˽����Ϣ)
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` varchar(100) NOT NULL COMMENT '��ϢID',
  `user_id` varchar(100) DEFAULT NULL COMMENT '�û�ID',
  `friend_id` varchar(100) DEFAULT NULL COMMENT '����ID',
  `message_status` varchar(10) DEFAULT NULL COMMENT '��Ϣ״̬ 0:���� 1:����',
  `message_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '��Ϣʱ��',
  `message_text` text COMMENT '��Ϣ�ı�',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ���
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activity_id` varchar(100) NOT NULL COMMENT '�ID',
  `activity_theme` varchar(100) DEFAULT NULL COMMENT '�����',
  `user_id` varchar(100) DEFAULT NULL COMMENT '�����û�ID',
  `activity_status` varchar(10) DEFAULT NULL COMMENT '�״̬0:���ڽ��� 1:����',
  `activity_picture` varchar(100) DEFAULT NULL COMMENT '�����ͼƬ',
  `activity_content` text COMMENT '�����',
  `activity_amount` bigint(20) DEFAULT NULL COMMENT '��������',
  `activity_start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '��ʼʱ��',
  `activity_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '����ʱ��',
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ������
DROP TABLE IF EXISTS `activity_join`;
CREATE TABLE `activity_join` (
  `activity_join_id` varchar(100) NOT NULL COMMENT '������ϢID',
  `activity_id` varchar(100) DEFAULT NULL COMMENT '�ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '�����û���',
  `activity_phone` varchar(20) DEFAULT NULL COMMENT '�����û���ϵ�绰',
  `activity_join_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '����ʱ��',
  PRIMARY KEY (`activity_join_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
