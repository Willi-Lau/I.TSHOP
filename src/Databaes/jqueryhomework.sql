/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : jqueryhomework

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2020-12-20 20:16:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` char(50) NOT NULL,
  `password` char(50) NOT NULL,
  `position` char(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin', 'admin');
INSERT INTO `admin` VALUES ('admin1', 'admin1', 'employee');
INSERT INTO `admin` VALUES ('admin2', 'admin2', 'employee');
INSERT INTO `admin` VALUES ('admin3', 'admin3', 'employee');
INSERT INTO `admin` VALUES ('boss1', 'boss1', 'boss');

-- ----------------------------
-- Table structure for admintime
-- ----------------------------
DROP TABLE IF EXISTS `admintime`;
CREATE TABLE `admintime` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` char(10) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admintime
-- ----------------------------
INSERT INTO `admintime` VALUES ('3', 'admin1', '2020-12-20 14:55:56');
INSERT INTO `admintime` VALUES ('4', 'boss1', '2020-12-20 14:56:19');
INSERT INTO `admintime` VALUES ('5', 'admin1', '2020-12-20 15:09:09');
INSERT INTO `admintime` VALUES ('6', 'admin1', '2020-12-20 17:12:44');
INSERT INTO `admintime` VALUES ('7', 'admin2', '2020-12-20 17:44:56');
INSERT INTO `admintime` VALUES ('8', 'admin', '2020-12-20 17:54:21');
INSERT INTO `admintime` VALUES ('9', 'admin', '2020-12-20 17:56:27');
INSERT INTO `admintime` VALUES ('10', 'boss1', '2020-12-20 20:08:52');
INSERT INTO `admintime` VALUES ('11', 'admin', '2020-12-20 20:15:39');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `username` char(50) NOT NULL,
  `id` int(10) NOT NULL,
  `num` int(10) NOT NULL,
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('zzzzz', '90022', '5', '10067');
INSERT INTO `cart` VALUES ('zzzzz', '90027', '5', '10068');
INSERT INTO `cart` VALUES ('zzzzz', '90032', '5', '10069');
INSERT INTO `cart` VALUES ('zzzzz', '90041', '5', '10070');
INSERT INTO `cart` VALUES ('aaaaa', '90001', '9', '10074');
INSERT INTO `cart` VALUES ('aaaaa', '90002', '9', '10075');

-- ----------------------------
-- Table structure for carthistory
-- ----------------------------
DROP TABLE IF EXISTS `carthistory`;
CREATE TABLE `carthistory` (
  `carthistoryid` int(10) NOT NULL AUTO_INCREMENT,
  `username` char(20) NOT NULL,
  `id` int(10) NOT NULL,
  `num` int(20) NOT NULL,
  `money` int(20) NOT NULL,
  `day` char(20) DEFAULT NULL,
  `src` char(20) DEFAULT NULL,
  PRIMARY KEY (`carthistoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carthistory
-- ----------------------------
INSERT INTO `carthistory` VALUES ('3', 'qqqqq', '90003', '6', '6699', '2020/12/18', 'b3.jpg');
INSERT INTO `carthistory` VALUES ('4', 'qqqqq', '90004', '8', '2000', '2020/12/18', 'b4.jpg');
INSERT INTO `carthistory` VALUES ('5', 'liu705195178', '90001', '6', '4999', '2020/12/19', 'b1.jpg');
INSERT INTO `carthistory` VALUES ('6', 'liu705195178', '90004', '9', '2000', '2020/12/20', 'b4.jpg');
INSERT INTO `carthistory` VALUES ('7', 'liu705195178', '90005', '9', '13330', '2020/12/20', 'b5.jpg');
INSERT INTO `carthistory` VALUES ('8', 'liu705195178', '90006', '6', '16900', '2020/12/20', 'b6.jpg');
INSERT INTO `carthistory` VALUES ('9', 'qqqqq', '90001', '6', '4999', '2020/12/20', 'b1.jpg');
INSERT INTO `carthistory` VALUES ('10', 'qqqqq', '90043', '5', '550', '2020/12/20', 'd1.jpg');
INSERT INTO `carthistory` VALUES ('11', 'qqqqq', '90021', '7', '9999', '2020/12/20', 'b21.jpg');
INSERT INTO `carthistory` VALUES ('12', 'qqqqq', '90023', '3', '3799', '2020/12/20', 'c2.jpg');
INSERT INTO `carthistory` VALUES ('13', 'qqqqq', '90001', '2', '4999', '2020/12/20', 'b1.jpg');
INSERT INTO `carthistory` VALUES ('14', 'qqqqq', '90002', '4', '4605', '2020/12/20', 'b2.jpg');
INSERT INTO `carthistory` VALUES ('15', 'qqqqq', '90043', '1', '550', '2020/12/20', 'd1.jpg');
INSERT INTO `carthistory` VALUES ('16', 'liuweiyi', '90018', '7', '25899', '2020/12/20', 'b18.jpg');
INSERT INTO `carthistory` VALUES ('17', 'liuweiyi', '90017', '5', '11299', '2020/12/20', 'b17.jpg');
INSERT INTO `carthistory` VALUES ('18', 'liuweiyi', '90016', '6', '4199', '2020/12/20', 'b16.jpg');
INSERT INTO `carthistory` VALUES ('19', 'liu705195178', '90001', '6', '4999', '2020/12/20', 'b1.jpg');
INSERT INTO `carthistory` VALUES ('20', 'liu705195178', '90002', '5', '4605', '2020/12/20', 'b2.jpg');
INSERT INTO `carthistory` VALUES ('21', 'wwwww', '90003', '4', '6699', '2020/12/20', 'b3.jpg');
INSERT INTO `carthistory` VALUES ('22', 'wwwww', '90006', '8', '16900', '2020/12/20', 'b6.jpg');
INSERT INTO `carthistory` VALUES ('23', 'wwwww', '90008', '10', '5999', '2020/12/20', 'b8.jpg');
INSERT INTO `carthistory` VALUES ('24', 'liu705195178', '90014', '10', '16999', '2020/12/20', 'b14.jpg');
INSERT INTO `carthistory` VALUES ('25', 'liu705195178', '90013', '8', '4490', '2020/12/20', 'b13.jpg');
INSERT INTO `carthistory` VALUES ('26', 'liu705195178', '90012', '20', '5990', '2020/12/20', 'b12.jpg');

-- ----------------------------
-- Table structure for clothes
-- ----------------------------
DROP TABLE IF EXISTS `clothes`;
CREATE TABLE `clothes` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type` char(10) NOT NULL,
  `brand` char(50) DEFAULT NULL,
  `info` char(40) NOT NULL,
  `money` int(10) NOT NULL,
  `num` int(10) NOT NULL,
  `src` char(50) NOT NULL,
  `cart_num` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90068 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes
-- ----------------------------
INSERT INTO `clothes` VALUES ('90001', '男', 'A BATHING APE®', '老虎缝饰连帽羽绒夹克', '4999', '1071', 'b1.jpg', '0');
INSERT INTO `clothes` VALUES ('90002', '男', 'A BATHING APE®', 'Sta 星星印花拉链羽绒服', '4605', '70', 'b2.jpg', '0');
INSERT INTO `clothes` VALUES ('90003', '男', 'A BATHING APE®', 'Logo 刺绣格纹夹克', '6699', '397', 'b3.jpg', '0');
INSERT INTO `clothes` VALUES ('90004', '男', 'NEIGHBORHOOD', 'Logo 刺绣直排扣夹克', '2000', '666', 'b4.jpg', '0');
INSERT INTO `clothes` VALUES ('90005', '男', 'VALENTINO', '饰口袋直排扣西装夹克', '13330', '347', 'b5.jpg', '0');
INSERT INTO `clothes` VALUES ('90006', '男', 'JUNYA WATANABE', 'Canada Goose 联乘系列 连帽羽绒服', '16900', '141', 'b6.jpg', '0');
INSERT INTO `clothes` VALUES ('90007', '男', 'OAMC', '条纹拼接直排扣马甲', '4816', '1407', 'b7.jpg', '0');
INSERT INTO `clothes` VALUES ('90008', '男', 'A BATHING APE®', 'Color Camo 连帽羽绒外套', '5999', '941', 'b8.jpg', '0');
INSERT INTO `clothes` VALUES ('90009', '男', 'A BATHING APE®', '鲨鱼缝饰多口袋夹克', '3999', '871', 'b9.jpg', '0');
INSERT INTO `clothes` VALUES ('90010', '男', 'MCQ', '饰口袋绗缝连帽外套', '10999', '345', 'b10.jpg', '0');
INSERT INTO `clothes` VALUES ('90011', '男', 'Y-3', '饰绊带拼色连帽夹克', '13999', '12', 'b11.jpg', '0');
INSERT INTO `clothes` VALUES ('90012', '男', 'Y-3', '图案印花拉链夹克', '5990', '481', 'b12.jpg', '0');
INSERT INTO `clothes` VALUES ('90013', '男', 'Y-3', '饰绊带连帽马甲', '4490', '743', 'b13.jpg', '0');
INSERT INTO `clothes` VALUES ('90014', '男', 'MR. GENTLEMAN', '拼色连帽外套', '16999', '235', 'b14.jpg', '0');
INSERT INTO `clothes` VALUES ('90015', '男', 'uniform experiment', '饰拉链连帽薄夹克', '4199', '250', 'b15.jpg', '0');
INSERT INTO `clothes` VALUES ('90016', '男', 'uniform experiment', '饰口袋拉链夹克', '4199', '244', 'b16.jpg', '0');
INSERT INTO `clothes` VALUES ('90017', '男', 'Mihara Yasuhiro', '拼接设计连帽外套', '11299', '105', 'b17.jpg', '0');
INSERT INTO `clothes` VALUES ('90018', '男', 'Mihara Yasuhiro', '牛仔拼接连帽外套', '25899', '35', 'b18.jpg', '0');
INSERT INTO `clothes` VALUES ('90019', '男', 'CHILDREN', '饰直排扣佩斯利印花夹克', '12499', '214', 'b19.jpg', '0');
INSERT INTO `clothes` VALUES ('90020', '男', 'MCQ', '饰直排扣多口袋外套', '9990', '207', 'b20.jpg', '0');
INSERT INTO `clothes` VALUES ('90021', '男', 'MCQ', 'Logo 缝饰连帽外套', '9999', '200', 'b21.jpg', '0');
INSERT INTO `clothes` VALUES ('90022', '女', 'A BATHING APE®', 'Line Camo 鲨鱼缝饰连帽羽绒服', '15199', '167', 'c1.jpg', '0');
INSERT INTO `clothes` VALUES ('90023', '女', 'SJYP', 'Felix the Cat 联乘系列 饰口袋牛仔夹克', '3799', '149', 'c2.jpg', '0');
INSERT INTO `clothes` VALUES ('90024', '女', 'MSGM', '磨损细节牛仔夹克', '4699', '271', 'c3.jpg', '0');
INSERT INTO `clothes` VALUES ('90025', '女', 'MSGM', '饰腰带直排扣夹克', '3960', '287', 'c4.jpg', '0');
INSERT INTO `clothes` VALUES ('90026', '女', 'D\'DEMOO', '落肩拉链夹克', '3699', '204', 'c5.jpg', '0');
INSERT INTO `clothes` VALUES ('90027', '女', 'Zadig & Voltaire', 'Magic Poulain 双排扣豹纹西装外套', '19950', '25', 'c6.jpg', '0');
INSERT INTO `clothes` VALUES ('90028', '女', 'IRENE IS GOOD', '拼色毛绒外套', '5599', '260', 'c7.jpg', '0');
INSERT INTO `clothes` VALUES ('90029', '女', 'MSGM', '蝴蝶刺绣双排扣大衣', '8960', '250', 'c8.jpg', '0');
INSERT INTO `clothes` VALUES ('90030', '女', 'D\'DEMOO', '配围脖绗缝羽绒外套', '8999', '270', 'c9.jpg', '0');
INSERT INTO `clothes` VALUES ('90031', '女', 'Tibi', '饰绊带双排扣夹克', '6950', '280', 'c10.jpg', '0');
INSERT INTO `clothes` VALUES ('90032', '女', 'JUNYA WATANABE WOMEN', '饰毛圈拼接设计外套', '18999', '275', 'c11.jpg', '0');
INSERT INTO `clothes` VALUES ('90033', '女', 'A BATHING APE®', '猿人头缝饰拉链连帽羽绒服', '3799', '256', 'c12.jpg', '0');
INSERT INTO `clothes` VALUES ('90034', '女', 'roarguns', 'Logo 缀饰拼接设计外套', '5999', '240', 'c13.jpg', '0');
INSERT INTO `clothes` VALUES ('90035', '女', 'PUSHBUTTON', '饰多口袋夹克', '2950', '220', 'c14.jpg', '0');
INSERT INTO `clothes` VALUES ('90036', '女', 'BAPY®', '饰毛圈绗缝拼接连帽外套', '5399', '210', 'c15.jpg', '0');
INSERT INTO `clothes` VALUES ('90037', '女', 'BAPY®', '格纹边饰落肩外套', '4399', '256', 'c16.jpg', '0');
INSERT INTO `clothes` VALUES ('90038', '女', 'JACQUEMUS', '饰口袋翻领格纹外套', '8299', '284', 'c17.jpg', '0');
INSERT INTO `clothes` VALUES ('90039', '女', 'MCQ', '饰绊带连帽夹克', '5099', '221', 'c18.jpg', '0');
INSERT INTO `clothes` VALUES ('90040', '女', 'MCQ', '多口袋绗缝连帽夹克', '9999', '249', 'c19.jpg', '0');
INSERT INTO `clothes` VALUES ('90041', '女', 'MCQ', '饰直排扣格纹外套', '12199', '218', 'c20.jpg', '0');
INSERT INTO `clothes` VALUES ('90042', '女', 'VIVETTA', '多口袋迷彩印花夹克', '4599', '214', 'c21.jpg', '0');
INSERT INTO `clothes` VALUES ('90043', '童', 'Stella McCartney', '地球印花 T 恤', '550', '279', 'd1.jpg', '0');
INSERT INTO `clothes` VALUES ('90044', '童', 'Stella McCartney', '拼色数字植绒卫衣', '850', '291', 'd2.jpg', '0');
INSERT INTO `clothes` VALUES ('90045', '童', 'Stella McCartney', '文字印花卫衣', '850', '288', 'd3.jpg', '0');
INSERT INTO `clothes` VALUES ('90046', '童', 'Stella McCartney', '饰流苏图案印花卫衣', '960', '330', 'd4.jpg', '0');
INSERT INTO `clothes` VALUES ('90047', '童', 'Stella McCartney', 'Logo 印花 T 恤', '500', '260', 'd5.jpg', '0');
INSERT INTO `clothes` VALUES ('90048', '童', 'Stella McCartney', '褶饰星星印花卫衣', '850', '300', 'd6.jpg', '0');
INSERT INTO `clothes` VALUES ('90049', '童', 'Stella McCartney', '饰流苏卫衣', '885', '260', 'd7.jpg', '0');
INSERT INTO `clothes` VALUES ('90050', '童', 'Stella McCartney', '笑脸印花 T 恤', '460', '234', 'd8.jpg', '0');
INSERT INTO `clothes` VALUES ('90051', '童', 'Stella McCartney', '图案印花 T 恤', '650', '303', 'd9.jpg', '0');
INSERT INTO `clothes` VALUES ('90052', '童', 'A BATHING APE®', 'BOA Baby Milo 缝饰木耳边 T 恤', '759', '226', 'd10.jpg', '0');
INSERT INTO `clothes` VALUES ('90053', '童', 'A BATHING APE®', 'ABC Camo 鲨鱼印花连帽卫衣', '1599', '148', 'd11.jpg', '0');
INSERT INTO `clothes` VALUES ('90054', '童', 'MSGM', 'Logo 印花 T 恤', '499', '297', 'd12.jpg', '0');
INSERT INTO `clothes` VALUES ('90067', '男', 'A BATHING APE®', 'sfgsfd', '10000', '5', 'b22.jpg', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` char(50) NOT NULL,
  `password` char(50) NOT NULL,
  `name` char(50) NOT NULL,
  `birthday` char(50) NOT NULL,
  `sex` char(50) NOT NULL,
  `address` char(50) NOT NULL,
  `email` char(50) NOT NULL,
  `grossmoney` int(10) DEFAULT '0',
  `alive` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('11111', '00000', 'zfd', '2020-10-31T16:00:00.000Z', '男', '沈阳', '1002270955@qq.com', '0', '1');
INSERT INTO `user` VALUES ('12344', '123', '123', '2020-10-25T16:00:00.000Z', '男', '丹东', '123@qq.com', '0', '1');
INSERT INTO `user` VALUES ('12345', '12345', '测试', '2020-10-31T16:00:00.000Z', '男', '沈阳', '12345@qq.com', '341767', '0');
INSERT INTO `user` VALUES ('705195178', '12315qwert', '刘伟艺', '2020-10-31T16:00:00.000Z', '男', '沈阳', '705195178@qq.com', '0', '1');
INSERT INTO `user` VALUES ('aaaaa', 'aaaa', '啊aa', '2020-11-30T16:00:00.000Z', '男', '锦州', 'aaa@qq.com', '648235', '1');
INSERT INTO `user` VALUES ('liu705195178', '12315qwert', '刘伟艺', '1999-10-13T16:00:00.000Z', '男', '沈阳', '2284069530@qq.com', '2945424', '1');
INSERT INTO `user` VALUES ('liuweiyi', 'liuweiyi', '刘伟艺', '1995-06-05T16:00:00.00Z', '男', '沈阳', '2284069530@qq.com', '262982', '1');
INSERT INTO `user` VALUES ('qqqqq', 'qqqq', 'qqq', '2020-11-02T16:00:00.000Z', '女', '锦州', 'QQQ@qq.com', '610982', '1');
INSERT INTO `user` VALUES ('tools', '513328', 'dsp', '2020-11-30T16:00:00.000Z', '男', '丹东', '111233@qq.com', '0', '1');
INSERT INTO `user` VALUES ('tropacid', '513328513', '董世苹', '1999-05-12T16:00:00.000Z', '女', '沈阳', 'tropacid@qq.com', '0', '0');
INSERT INTO `user` VALUES ('white55kai', '55555', '卢本伟', '2020-11-02T16:00:00.000Z', '男', '沈阳', '55kai@qq.com', '0', '0');
INSERT INTO `user` VALUES ('wwwww', 'wwwww', 'wwww', '2020-11-29T16:00:00.000Z', '女', '葫芦岛', '2222@qq.com', '221986', '1');
INSERT INTO `user` VALUES ('zzzzz', 'zzzzz', 'zzz', '2020-11-02T16:00:00.000Z', '男', '朝阳', 'zzz@163.com', '0', '1');

-- ----------------------------
-- Table structure for usertime
-- ----------------------------
DROP TABLE IF EXISTS `usertime`;
CREATE TABLE `usertime` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` char(50) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertime
-- ----------------------------
INSERT INTO `usertime` VALUES ('1', 'qqqqq', '2020-12-20 15:02:20');
INSERT INTO `usertime` VALUES ('2', 'liu705195178', '2020-12-20 15:08:34');
INSERT INTO `usertime` VALUES ('3', 'aaaaa', '2020-12-20 15:08:55');
INSERT INTO `usertime` VALUES ('4', 'liu705195178', '2020-12-20 17:44:25');
INSERT INTO `usertime` VALUES ('5', 'aaaaa', '2020-12-20 17:51:23');
INSERT INTO `usertime` VALUES ('6', 'zzzzz', '2020-12-20 17:51:31');
INSERT INTO `usertime` VALUES ('7', 'zzzzz', '2020-12-20 17:52:41');
INSERT INTO `usertime` VALUES ('8', 'liu705195178', '2020-12-20 17:52:54');
INSERT INTO `usertime` VALUES ('9', 'liuweiyi', '2020-12-20 17:53:38');
INSERT INTO `usertime` VALUES ('10', 'liuweiyi', '2020-12-20 17:53:46');
INSERT INTO `usertime` VALUES ('11', 'tropacid', '2020-12-20 17:56:18');
INSERT INTO `usertime` VALUES ('12', 'wwwww', '2020-12-20 20:06:32');
INSERT INTO `usertime` VALUES ('13', 'liu705195178', '2020-12-20 20:14:53');
