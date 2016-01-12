/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2016-01-09 23:36:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `address` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', '用户1账号', '用户1姓名', '测试地址');
INSERT INTO `user` VALUES ('4', 'user2', 'user2', 'user2');
INSERT INTO `user` VALUES ('5', 'user3', '用户3', '杭州');
INSERT INTO `user` VALUES ('6', '1111', '222', '4333');
INSERT INTO `user` VALUES ('7', '1', '2', '3');
