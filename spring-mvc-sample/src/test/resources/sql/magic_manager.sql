/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : magic_manager

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-03-03 15:10:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) NOT NULL COMMENT '初始随机生成 magic-12位数字，后可修改个性域名',
  `is_modify` int(2) DEFAULT '0' COMMENT '是否修改了个性账户，默认0未修改，修改后为1，不可以再次修改',
  `nick_name` varchar(25) DEFAULT NULL COMMENT '昵称，为空时显示为account的值',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像链接地址',
  `mobile` varchar(11) DEFAULT NULL COMMENT '11位手机号',
  `sex` int(2) DEFAULT '1' COMMENT '0女，1男',
  `id_card` varchar(25) DEFAULT NULL COMMENT '身份证号',
  `real_name` varchar(10) DEFAULT NULL COMMENT '真实姓名',
  `is_check` int(2) DEFAULT '0' COMMENT '是否实名认证通过，0未认证，1认证通过，2认证失败',
  `last_login_time` datetime DEFAULT NULL COMMENT '上一次登录时间',
  `add_time` datetime DEFAULT NULL COMMENT '注册时间',
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `sys_flag` int(11) DEFAULT '1' COMMENT '账户状态，1可用，0冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'hwangfantasy', '1', '颜艺学长', null, '18258183782', '1', '362321199503270815', '黄帆', '1', '2017-03-03 14:43:24', '2017-03-03 14:43:00', null, '1');
INSERT INTO `account` VALUES ('2', 'magic-1855115151615', '0', '1855111615', null, '18551151615', '1', '', '', '0', '2017-03-03 14:43:24', '2017-03-03 14:43:00', null, '1');
INSERT INTO `account` VALUES ('3', 'magic-1855115151616', '0', '1855111615', null, '18551151615', '1', '', '', '0', '2017-03-03 14:43:24', '2017-03-02 14:43:00', null, '1');
INSERT INTO `account` VALUES ('4', 'magic-1855115151617', '0', '1855111615', null, '18551151615', '1', '', '', '0', '2017-03-03 14:43:24', '2017-03-01 14:43:00', null, '1');
INSERT INTO `account` VALUES ('5', 'magic-1855115151618', '0', '1855111615', null, '18551151615', '1', '', '', '0', '2017-03-03 14:43:24', '2017-02-28 14:43:00', null, '1');
INSERT INTO `account` VALUES ('6', 'magic-1855115151619', '0', '1855111615', null, '18551151615', '1', '', '', '0', '2017-03-03 14:43:24', '2017-02-27 14:43:00', null, '1');
INSERT INTO `account` VALUES ('7', 'magic-1855115151620', '0', '1855111615', null, '18551151615', '1', '', '', '0', '2017-03-03 14:43:24', '2017-02-26 14:43:00', null, '1');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(50) DEFAULT NULL COMMENT '权限描述',
  `url` varchar(100) DEFAULT NULL COMMENT '权限对应url',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `sys_flag` int(2) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT '' COMMENT '角色名称',
  `role_desc` varchar(20) DEFAULT NULL COMMENT '角色描述：管理员',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `sys_flag` int(2) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN', '管理员', '2017-02-27 23:08:19', '2017-03-02 17:37:56', '1');
INSERT INTO `role` VALUES ('2', 'ROLE_NORMAL', '普通用户', '2017-02-27 23:09:57', '2017-03-03 11:12:20', '1');
INSERT INTO `role` VALUES ('3', 'ROLE_DEVLOPER', '开发者', '2017-03-03 11:12:52', '2017-03-03 11:12:55', '1');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(150) DEFAULT NULL COMMENT '密码',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `sys_flag` int(2) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '2017-02-27 22:43:48', '2017-03-03 14:25:41', '1');
INSERT INTO `user` VALUES ('2', 'hwangfantasy', '4f75d8bc38efe07fd24f303eee69b00b', '2017-02-27 23:10:27', '2017-03-03 14:26:03', '1');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
