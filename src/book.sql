/*
Navicat MySQL Data Transfer

Source Server         : Asuna
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-28 18:04:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `barCode` varchar(255) NOT NULL,
  `bName` varchar(255) DEFAULT NULL,
  `writer` varchar(255) DEFAULT NULL,
  `press` varchar(255) DEFAULT NULL,
  `presstime` varchar(255) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `sort` varchar(255) DEFAULT NULL,
  `pageNum` int(11) DEFAULT NULL,
  `LendNum` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`barCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('0001', 'Java疯狂讲义', '李刚', '电子工程出版社', '2008-09-01', '109', '计算机', '877', '1', '已借');
INSERT INTO `books` VALUES ('0002', '王文兴文集', '王文兴', '北京科学出版社', '2007-12-01', '120', '文学', '430', '1', '未借');
INSERT INTO `books` VALUES ('0003', 'C语言', '谭浩强', '清华大学出版社', '2016-04-12', '50', '计算机', '500', '3', '已借');
INSERT INTO `books` VALUES ('0004', '大学物理', '赵近芳', '北京邮电大学', '2014-11-01', '36', '物理', '292', '1', '已借');
INSERT INTO `books` VALUES ('0005', '大学英语', '康璐璐', '清华电视出版社', '2012-02-01', '65', '英语', '454', '1', '已借');
INSERT INTO `books` VALUES ('0006', 'Java Web开发与应用', '郭克华', '清华大学出版社', '2012-04-01', '45', '计算机', '435', '0', '未借');

-- ----------------------------
-- Table structure for booksort
-- ----------------------------
DROP TABLE IF EXISTS `booksort`;
CREATE TABLE `booksort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bSort` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booksort
-- ----------------------------
INSERT INTO `booksort` VALUES ('1', '文学');
INSERT INTO `booksort` VALUES ('2', '物理');
INSERT INTO `booksort` VALUES ('3', '英语');
INSERT INTO `booksort` VALUES ('4', '计算机');
INSERT INTO `booksort` VALUES ('5', '机械');

-- ----------------------------
-- Table structure for lendbooks
-- ----------------------------
DROP TABLE IF EXISTS `lendbooks`;
CREATE TABLE `lendbooks` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `rNo` varchar(255) DEFAULT NULL,
  `lendbook` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lendbooks
-- ----------------------------
INSERT INTO `lendbooks` VALUES ('1', '2016034633', 'Java疯狂讲义');
INSERT INTO `lendbooks` VALUES ('2', '0001', 'Java疯狂讲义');
INSERT INTO `lendbooks` VALUES ('4', '0001', '大学物理');
INSERT INTO `lendbooks` VALUES ('6', '0001', '大学英语');
INSERT INTO `lendbooks` VALUES ('10', '0001', 'C语言');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `rNo` varchar(255) NOT NULL,
  `rName` varchar(255) DEFAULT NULL,
  `rsex` varchar(255) DEFAULT NULL,
  `rage` int(11) DEFAULT NULL,
  `rClass` varchar(255) DEFAULT NULL,
  `rSort` varchar(255) DEFAULT NULL,
  `rPhoneNum` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `lendNum` int(2) DEFAULT NULL,
  `canLendNum` int(2) DEFAULT NULL,
  PRIMARY KEY (`rNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('0001', 'admin', '男', '20', '16软二', '管理员', '17759718386', 'admin', '4', '16');
INSERT INTO `reader` VALUES ('123456', '123', '男', '20', '16软二', '学生', '17759718386', '123456', '0', '10');
INSERT INTO `reader` VALUES ('2016034633', 'yehaoxin', '男', '21', '16软二', '学生', '17759718386', '123', '0', '10');
