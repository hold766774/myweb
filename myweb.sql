/*
Navicat MySQL Data Transfer

Source Server         : phpProject
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : myweb

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2017-07-11 16:56:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mymessage
-- ----------------------------
DROP TABLE IF EXISTS `mymessage`;
CREATE TABLE `mymessage` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sender` varchar(50) DEFAULT NULL,
  `receiver` varchar(50) DEFAULT NULL,
  `sendtime` datetime DEFAULT NULL COMMENT '消息发送时间',
  `msgcnt` varchar(2000) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mymessage
-- ----------------------------
INSERT INTO `mymessage` VALUES ('1', 'abc', 'xiaoping', '2017-07-10 01:01:30', 'hello2', '2017-07-10 13:59:08');
INSERT INTO `mymessage` VALUES ('2', 'abc', 'xiaoping', '2017-07-10 01:01:30', 'hello2', '2017-07-10 14:01:40');

-- ----------------------------
-- Table structure for navbar
-- ----------------------------
DROP TABLE IF EXISTS `navbar`;
CREATE TABLE `navbar` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` char(20) DEFAULT NULL,
  `link` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of navbar
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `news_title` varchar(200) NOT NULL DEFAULT '',
  `classid` int(11) NOT NULL DEFAULT '0',
  `pubuser` char(20) NOT NULL DEFAULT '',
  `pubtime` datetime DEFAULT NULL,
  `news_content` text,
  `clicknum` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '中国新能源重大突破 获得距今六亿年页岩气藏', '1', '新浪', '2017-07-07 16:30:43', '　此次获得重大突破的页岩气井——鄂宜页1井位于湖北省宜昌市，是我国在长江中游部署实施的第一口页岩气压裂试气井。鄂宜页1井纵向分为五个含油气地层，科研人员在其中分别发现了高产页岩气流，和迄今为止全球最古老的页岩气藏。\r\n\r\n　　国土资源部中国地质调查局资源评价部负责人 邢树文：鄂宜页1井一共钻遇五套含油气地层，其中在陡山沱组，距今六亿年发现了应该说是迄今为止最古老的页岩气层。它未来的勘查开发价值潜力是很大的。', '11');
INSERT INTO `news` VALUES ('2', '乐视惊魂一日:贾跃亭已在洛杉矶 大部分时间在美造车', '2', '阿飞飞', '2017-07-06 12:31:41', '　对于乐视大厦楼下讨债的供应商来说，贾跃亭在微博上、在新闻里，却从未出现在他本应该出现的大楼里，贾跃亭的行踪成为供应商、乐视网投资者们最大的疑惑。新浪科技独家获悉，在7月5日中午，贾跃亭就已到达美国洛杉矶。而在随后，乐视经历了惊魂一日。', '6');
INSERT INTO `news` VALUES ('3', '中青报曹林：每一句为王者农药的辩护词都写满丑陋 中', '3', '房费', '2017-07-05 16:35:37', '在游戏负效应控制上，也不能走“先火爆再防沉迷”的老路。如果设计时少点儿功利心，少点儿急切的赚钱冲动，多点儿责任意识，流淌一点儿道德血液，就会在设计起点上多点儿防沉迷安排。保护未成年人的防沉迷设计，应该成为每款游戏的道义门槛。一家企业，如果利润中有不道德的成份，注定不会成为真正让人尊敬的企业。', '1');
INSERT INTO `news` VALUES ('4', '男子地铁尾随女子猥亵 被跟在身后的便衣民警目击', '1', '分辅导费', '2017-07-07 16:57:21', '今早八点半左右，在地铁八通线传媒大学站四惠方向站台，一中年男子尾随一名身穿黑色短裙女子，在上车瞬间对其进行猥亵，后因车上拥挤，男子又转移作案目标。而这些动作早已被跟在身后的便衣民警目击，实际上，该男子昨日就以类似手法在地铁上进行猥亵行为，但当日没有合适的抓捕时机。当地铁到达四惠东站后，便衣民警一把抓住男子胳膊，没想到男子转身就要逃跑。跑出十几米后，被地铁站务员和便衣民警一块制服，而在男子被带至站台层时，男子开始剧烈反抗，把住楼梯扶手欲往下跳，此时有乘客上前帮忙，五六个人合力终将男子制服。目前，男子已被带至北京市公安局公交总队四惠东站派出所进行审讯。', '1');
INSERT INTO `news` VALUES ('5', '90后美女骗40万人300亿 记者探访：家中人去楼空', '2', '的放到地方', '2017-07-11 17:01:22', '最近这几天，一则消息刷爆很多人的朋友圈。该消息称，常州一名90后美女张某某疑与马来西亚籍老公合谋，以IGOFX中国区总代理身份，半年内在中国发展40多万会员后宣告“崩盘”，卷走人民币近300亿元！7月6日，现代快报记者在常州武进区找到当事女子的家，遗憾的是，他们一家人却如同人间蒸发，早已不知去向。', '116');

-- ----------------------------
-- Table structure for news_class
-- ----------------------------
DROP TABLE IF EXISTS `news_class`;
CREATE TABLE `news_class` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `class_name` varchar(20) NOT NULL DEFAULT '' COMMENT '新闻类别',
  `pid` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '父Id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news_class
-- ----------------------------
INSERT INTO `news_class` VALUES ('1', '新闻', '0');
INSERT INTO `news_class` VALUES ('2', '观点', '0');
INSERT INTO `news_class` VALUES ('3', '科技', '0');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rcnt` varchar(2000) NOT NULL,
  `username` char(20) NOT NULL,
  `userip` varchar(15) NOT NULL,
  `addtime` datetime NOT NULL,
  `newsid` int(10) unsigned NOT NULL DEFAULT '1',
  `newstype` tinyint(255) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES ('1', 'first one review', 'xiaoping', '0:0:0:0:0:0:0:1', '2017-07-10 15:58:54', '5', '1');
INSERT INTO `review` VALUES ('2', 'second', 'abc', '0:0:0:0:0:0:0:1', '2017-07-10 18:08:21', '5', '1');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` char(20) DEFAULT NULL,
  `userpwd` char(20) DEFAULT NULL,
  `useremail` char(50) DEFAULT NULL,
  `sex` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1 男 2 女',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'xiaoing', '123', null, '1');
INSERT INTO `users` VALUES ('2', 'zhangsan', '456', null, '1');
INSERT INTO `users` VALUES ('3', 'abc', '344', null, '1');
INSERT INTO `users` VALUES ('4', 'xiaoping', '766774', 'aa@com.cn', '0');
INSERT INTO `users` VALUES ('5', 'bbb', '123', 'bbb@com.cn', '1');
