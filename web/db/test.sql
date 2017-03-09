/*
Navicat MySQL Data Transfer

Source Server         : one
Source Server Version : 50635
Source Host           : 192.168.2.111:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-03-09 19:49:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permissionId` varchar(20) DEFAULT NULL,
  `permissionName` varchar(20) DEFAULT NULL,
  `permissionDesc` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'user:add', 'add');
INSERT INTO `permission` VALUES ('2', 'user:del', 'del');
INSERT INTO `permission` VALUES ('3', 'user:update', 'update');
INSERT INTO `permission` VALUES ('4', 'user:query', 'query');

-- ----------------------------
-- Table structure for `rolepermission`
-- ----------------------------
DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission` (
  `permissionId` varchar(20) DEFAULT NULL,
  `roleId` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of rolepermission
-- ----------------------------
INSERT INTO `rolepermission` VALUES ('1', '1');
INSERT INTO `rolepermission` VALUES ('2', '1');
INSERT INTO `rolepermission` VALUES ('3', '1');
INSERT INTO `rolepermission` VALUES ('4', '1');
INSERT INTO `rolepermission` VALUES ('3', '2');
INSERT INTO `rolepermission` VALUES ('4', '2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userName` varchar(20) DEFAULT NULL,
  `userPsw` varchar(20) DEFAULT NULL,
  `roleId` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'admin', '1');
INSERT INTO `user` VALUES ('test', 'test', '2');

-- ----------------------------
-- Function structure for `minScore`
-- ----------------------------
DROP FUNCTION IF EXISTS `minScore`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `minScore`(`p` varchar(2),`num` int(5)) RETURNS int(5)
BEGIN
	DECLARE x int;
	SELECT MIN(t.score) into x FROM ( SELECT score FROM person WHERE project = p  GROUP BY score ORDER BY score DESC LIMIT num ) t;
	RETURN x;
END
;;
DELIMITER ;
