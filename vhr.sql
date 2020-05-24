/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : vhr

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-05-24 12:06:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `adjustsalary`
-- ----------------------------
DROP TABLE IF EXISTS `adjustsalary`;
CREATE TABLE `adjustsalary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `asDate` date DEFAULT NULL COMMENT '调薪日期',
  `beforeSalary` int(11) DEFAULT NULL COMMENT '调前薪资',
  `afterSalary` int(11) DEFAULT NULL COMMENT '调后薪资',
  `reason` varchar(255) DEFAULT NULL COMMENT '调薪原因',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `pid` (`eid`),
  CONSTRAINT `adjustsalary_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adjustsalary
-- ----------------------------

-- ----------------------------
-- Table structure for `appraise`
-- ----------------------------
DROP TABLE IF EXISTS `appraise`;
CREATE TABLE `appraise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `appDate` date DEFAULT NULL COMMENT '考评日期',
  `appResult` varchar(32) DEFAULT NULL COMMENT '考评结果',
  `appContent` varchar(255) DEFAULT NULL COMMENT '考评内容',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `pid` (`eid`),
  CONSTRAINT `appraise_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appraise
-- ----------------------------

-- ----------------------------
-- Table structure for `change_manage`
-- ----------------------------
DROP TABLE IF EXISTS `change_manage`;
CREATE TABLE `change_manage` (
  `change_id` int(3) NOT NULL AUTO_INCREMENT,
  `curent_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `work_status` int(2) unsigned DEFAULT NULL,
  `over_remark` varchar(1000) DEFAULT NULL,
  `is_over` int(2) DEFAULT '0',
  `oparator_name` varchar(255) DEFAULT NULL,
  `oparator_workID` varchar(255) DEFAULT NULL,
  `over_name` varchar(255) DEFAULT NULL,
  `over_workID` varchar(255) DEFAULT NULL,
  `over_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`change_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of change_manage
-- ----------------------------
INSERT INTO `change_manage` VALUES ('1', '2020-03-31', '1', '尽快完成', '1', '江南一点雨', '00000001', '陈静', '0000002', '2020-04-07 17:05:57');
INSERT INTO `change_manage` VALUES ('2', null, null, '今天客户送来一件珍贵的衣服，一定按计量放洗涤剂', '0', '赵琳浩', '00000003', '', '00000004', '鹿存亮');
INSERT INTO `change_manage` VALUES ('3', null, null, '好好工作', '1', '贾旭明', '00000007', '鹿存亮2', '00000014', '2020-03-31 16:07:38');

-- ----------------------------
-- Table structure for `clock`
-- ----------------------------
DROP TABLE IF EXISTS `clock`;
CREATE TABLE `clock` (
  `clock_id` int(5) NOT NULL AUTO_INCREMENT,
  `emp_workID` varchar(255) DEFAULT NULL,
  `clock_date` varchar(255) DEFAULT NULL,
  `start_work` int(2) DEFAULT '0',
  `end_work` int(2) DEFAULT '0',
  `endClock_date` varchar(255) DEFAULT NULL,
  `is_leave` int(255) DEFAULT '0',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`clock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clock
-- ----------------------------
INSERT INTO `clock` VALUES ('1', '00000001', '2020-03-30 18:13:44', '1', '0', null, null, null);
INSERT INTO `clock` VALUES ('2', '00000002', '2020-03-30 18:15:00', '1', '0', null, null, null);
INSERT INTO `clock` VALUES ('3', '00000003', '2020-03-30 18:18:06', '1', '1', null, null, null);
INSERT INTO `clock` VALUES ('4', '00000004', '2020-03-30 21:02:18', '1', '0', null, null, null);
INSERT INTO `clock` VALUES ('8', '00000001', '2020-03-31 09:35:59', '1', '1', null, null, null);
INSERT INTO `clock` VALUES ('9', '00000004', '2020-03-31 11:27:22', '1', '0', null, null, null);
INSERT INTO `clock` VALUES ('10', '00000006', '2020-03-31 17:52:00', '1', '0', null, null, null);
INSERT INTO `clock` VALUES ('11', '00000003', '2020-03-31 17:52:43', '1', '0', null, null, null);
INSERT INTO `clock` VALUES ('12', 'GDF', '2020-03-31 17:57:56', '1', '0', null, null, null);
INSERT INTO `clock` VALUES ('13', 'GDF', '2020-03-31 17:58:02', '1', '0', null, null, null);
INSERT INTO `clock` VALUES ('14', 'GDF', '2020-03-31 18:03:06', '1', '0', null, null, null);
INSERT INTO `clock` VALUES ('15', 'GDF', '2020-03-31 18:04:27', '1', '0', null, null, null);
INSERT INTO `clock` VALUES ('16', 'GDF', '2020-03-31 18:04:57', '1', '0', null, null, null);
INSERT INTO `clock` VALUES ('17', 'GDF', '2020-03-31 18:06:20', '1', '0', null, null, null);
INSERT INTO `clock` VALUES ('18', '00000005', '2020-03-31 18:13:17', '1', '1', '2020-03-31 22:28:44', null, null);
INSERT INTO `clock` VALUES ('19', '00000002', '2020-03-31 18:14:32', '1', '1', null, null, null);
INSERT INTO `clock` VALUES ('20', '', '2020-04-24 13:59:38', '1', '0', null, '0', null);
INSERT INTO `clock` VALUES ('21', '00000003', '2020-04-24 13:59:38', '0', '0', null, '0', null);
INSERT INTO `clock` VALUES ('22', '00000003', '2020-04-24 13:59:38', '1', '0', null, '0', null);
INSERT INTO `clock` VALUES ('23', '00000003', '2020-04-24 13:59:38', '0', '0', null, '0', null);
INSERT INTO `clock` VALUES ('24', '00000003', '2020-04-24 13:59:38', '1', '0', null, '0', null);
INSERT INTO `clock` VALUES ('25', '00000006', '2020-04-24 14:00:21', '1', '0', null, '0', null);
INSERT INTO `clock` VALUES ('26', '00000002', '2020-05-13 20:14:57', '1', '0', null, '0', null);

-- ----------------------------
-- Table structure for `clocount`
-- ----------------------------
DROP TABLE IF EXISTS `clocount`;
CREATE TABLE `clocount` (
  `datetime` varchar(255) NOT NULL,
  `clothcount` varchar(255) DEFAULT NULL,
  `user_id` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clocount
-- ----------------------------
INSERT INTO `clocount` VALUES ('2020-04-11`', '12', '5');
INSERT INTO `clocount` VALUES ('2020-04-12', '18', '5');
INSERT INTO `clocount` VALUES ('2020-04-13', '20', '5');
INSERT INTO `clocount` VALUES ('2020-04-14', '99', '5');
INSERT INTO `clocount` VALUES ('2020-04-15', '45', '5');
INSERT INTO `clocount` VALUES ('2020-04-16', '34', '5');
INSERT INTO `clocount` VALUES ('2020-04-17', '56', '5');
INSERT INTO `clocount` VALUES ('2020-04-18', '18', '5');
INSERT INTO `clocount` VALUES ('2020-04-19', '67', '5');
INSERT INTO `clocount` VALUES ('2020-04-20', '78', '5');

-- ----------------------------
-- Table structure for `clothes`
-- ----------------------------
DROP TABLE IF EXISTS `clothes`;
CREATE TABLE `clothes` (
  `clothes_id` int(11) NOT NULL AUTO_INCREMENT,
  `clothes_color` varchar(20) DEFAULT NULL,
  `clothes_num` varchar(20) DEFAULT NULL,
  `customer_id` int(20) DEFAULT NULL,
  `clothes_flow` varchar(100) DEFAULT NULL,
  `clothes_adjunct` varchar(100) DEFAULT NULL,
  `clothes_brand` varchar(100) DEFAULT NULL,
  `type_id` int(10) DEFAULT NULL,
  `emp_id` int(10) DEFAULT NULL,
  `put_clothes_time` varchar(32) DEFAULT NULL,
  `take_clothes_time` varchar(32) DEFAULT NULL,
  `progress` varchar(32) DEFAULT NULL,
  `pre_time` varchar(32) DEFAULT NULL,
  `real_price` double(10,1) DEFAULT NULL,
  `is_pay` int(2) DEFAULT '0',
  `is_take` int(2) DEFAULT '0',
  `user_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`clothes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes
-- ----------------------------
INSERT INTO `clothes` VALUES ('1', '黑色', '#0001', '1', '无', '无', '耐克', '3', '3', '2020-05-13 20:19:06', null, '已赔偿', '2020-05-14 00:00:00', '15.0', '0', '0', '5');
INSERT INTO `clothes` VALUES ('2', '黑色', '#0002', '2', '无', '无', '耐克', null, null, null, null, null, null, null, '0', '0', '5');
INSERT INTO `clothes` VALUES ('5', '黑色', '#0005', '4', '无', '一个腰带', '普通品牌', '4', '7', '2020-04-20 16:49:27', null, '已洗完', '2020-04-21 16:00:00  ', '10.5', '0', '0', '5');
INSERT INTO `clothes` VALUES ('6', '彩色', '#0006', '5', '无', '无', '高档品牌', '6', '7', '2020-04-20 16:54:14', null, '已洗完', '2020-04-21 16:00:00', '14.2', '1', '0', '5');
INSERT INTO `clothes` VALUES ('7', '灰色', '#0007', '3', '无', '无', '不晓得', '7', '2', '2020-04-20 17:00:33', null, '正在洗', '2020-04-20 16:00:00', '9.0', '0', '0', '10');
INSERT INTO `clothes` VALUES ('8', '白色', '#0008', '6', '无', '无', '森马', '4', '6', '2020-04-23 15:53:02', null, '已重洗', '2020-04-24 00:00:00', '15.0', '1', '0', '5');
INSERT INTO `clothes` VALUES ('9', '红色', '#0009', '7', '有点褶', '无', '不知道', '18', '6', '2020-04-20 21:28:00', null, '已洗完', '2020-04-22 16:00:00', '20.0', '1', '0', '5');
INSERT INTO `clothes` VALUES ('10', '黑色', '#00010', '8', '无', '无', '唐狮', '3', '4', '2020-04-23 14:47:24', null, '已赔偿', '2020-04-24 00:00:00', '15.0', '1', '0', '10');
INSERT INTO `clothes` VALUES ('11', '黑色', '#00011', '9', '无', '无', '唐狮', '3', '4', '2020-04-20 21:55:59', '2020-04-23 13:33:32', '已取衣', '2020-04-20 16:00:00', '15.0', '1', '1', '5');
INSERT INTO `clothes` VALUES ('12', '黑色', '#00012', '10', '无', '无', '貂皮', '23', '22', '2020-04-20 21:59:59', '2020-04-23 13:22:58', '已取衣', '2020-04-21 00:00:00', '40.0', '1', '1', '10');
INSERT INTO `clothes` VALUES ('13', '黑', '#00013', '2', '无', '无', '耐克', '1', '1', '2020-05-13 20:43:01', null, '正在洗', '2020-05-14 00:00:00', '20.0', '0', '0', '5');
INSERT INTO `clothes` VALUES ('14', '黑', '#00014', '11', '有', '无', '耐克', '3', '4', '2020-05-13 20:44:59', null, '正在洗', '2020-05-13 00:00:00', '34.0', '0', '0', '5');

-- ----------------------------
-- Table structure for `clothes_type_price`
-- ----------------------------
DROP TABLE IF EXISTS `clothes_type_price`;
CREATE TABLE `clothes_type_price` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL,
  `type_price` int(11) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes_type_price
-- ----------------------------
INSERT INTO `clothes_type_price` VALUES ('1', '西服上装', '20');
INSERT INTO `clothes_type_price` VALUES ('2', '裤子', '15');
INSERT INTO `clothes_type_price` VALUES ('3', '裙子', '15');
INSERT INTO `clothes_type_price` VALUES ('4', '衬衫', '15');
INSERT INTO `clothes_type_price` VALUES ('5', 'T恤', '15');
INSERT INTO `clothes_type_price` VALUES ('6', '领带', '10');
INSERT INTO `clothes_type_price` VALUES ('7', '围巾', '10');
INSERT INTO `clothes_type_price` VALUES ('8', '套衫', '15');
INSERT INTO `clothes_type_price` VALUES ('9', '羊毛衫', '20');
INSERT INTO `clothes_type_price` VALUES ('10', '短大衣', '30');
INSERT INTO `clothes_type_price` VALUES ('11', '连衣裙', '30');
INSERT INTO `clothes_type_price` VALUES ('12', '长大衣', '35');
INSERT INTO `clothes_type_price` VALUES ('13', '风衣', '35');
INSERT INTO `clothes_type_price` VALUES ('14', '棉服', '40');
INSERT INTO `clothes_type_price` VALUES ('15', '羽绒服', '40');
INSERT INTO `clothes_type_price` VALUES ('16', '毛毯', '50');
INSERT INTO `clothes_type_price` VALUES ('17', '羽绒被', '50');
INSERT INTO `clothes_type_price` VALUES ('18', '床单', '20');
INSERT INTO `clothes_type_price` VALUES ('19', '被套', '20');
INSERT INTO `clothes_type_price` VALUES ('20', '皮上装', '100');
INSERT INTO `clothes_type_price` VALUES ('21', '裘制品', '300');
INSERT INTO `clothes_type_price` VALUES ('22', '毛皮衣', '300');
INSERT INTO `clothes_type_price` VALUES ('23', '毛领', '40');
INSERT INTO `clothes_type_price` VALUES ('24', '单独清洗（3件）', '200');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cus_id` int(5) NOT NULL AUTO_INCREMENT,
  `cus_name` varchar(255) DEFAULT NULL,
  `cus_email` varchar(255) DEFAULT NULL,
  `cus_address` varchar(255) DEFAULT NULL,
  `cus_phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '张阿斗', '1473673516@qq.com', null, '17854337592');
INSERT INTO `customer` VALUES ('2', '江小白', 'jiangxiaobai@qq.com', null, '17854337895');
INSERT INTO `customer` VALUES ('3', '可乐', 'kelue@qq.com', null, '17854996885');
INSERT INTO `customer` VALUES ('4', '世达', 'shida@qq.com', null, '17854339685');
INSERT INTO `customer` VALUES ('5', '炸鸡', 'zhaji@qq.com', null, '17854339879');
INSERT INTO `customer` VALUES ('6', '章子怡', 'zhangziyi@qq.com', null, '15654338790');
INSERT INTO `customer` VALUES ('7', '章章', 'zhangzhang@qq.com', null, '17854338808');
INSERT INTO `customer` VALUES ('8', '白闹', 'bainao@qq.com', null, '13456784567');
INSERT INTO `customer` VALUES ('9', '白闹', 'bainao@qq.com', null, '13456784567');
INSERT INTO `customer` VALUES ('10', '小雕', 'xiaodiao@qq.com', null, '13456638909');
INSERT INTO `customer` VALUES ('11', '张大爷', 'zhangdaye0105@qq.com', null, '17854337894');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `parentId` int(11) DEFAULT NULL,
  `depPath` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `isParent` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '总公司', '-1', '.1', '1', '1');
INSERT INTO `department` VALUES ('4', '第一分店', '105', '.1.1.105.1', '1', '0');
INSERT INTO `department` VALUES ('5', '第二分店', '105', '.1.1.105.2', '1', '0');
INSERT INTO `department` VALUES ('8', '第三分店', '105', '.1.1.105.3', '1', '0');
INSERT INTO `department` VALUES ('78', '第四分店', '105', '.1.1.105.4', '1', '0');
INSERT INTO `department` VALUES ('105', '青岛子公司', '1', '.1.1', '1', '1');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(10) DEFAULT NULL COMMENT '员工姓名',
  `gender` char(4) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `idCard` char(18) DEFAULT NULL COMMENT '身份证号',
  `wedlock` enum('已婚','未婚','离异') DEFAULT NULL COMMENT '婚姻状况',
  `nationId` int(8) DEFAULT NULL COMMENT '民族',
  `nativePlace` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `politicId` int(8) DEFAULT NULL COMMENT '政治面貌',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `departmentId` int(11) DEFAULT NULL COMMENT '所属部门',
  `jobLevelId` int(11) DEFAULT NULL COMMENT '职称ID',
  `posId` int(11) DEFAULT NULL COMMENT '职位ID',
  `engageForm` varchar(8) DEFAULT NULL COMMENT '聘用形式',
  `tiptopDegree` enum('博士','硕士','本科','大专','高中','初中','小学','其他') DEFAULT NULL COMMENT '最高学历',
  `specialty` varchar(32) DEFAULT NULL COMMENT '所属专业',
  `school` varchar(32) DEFAULT NULL COMMENT '毕业院校',
  `beginDate` date DEFAULT NULL COMMENT '入职日期',
  `workState` enum('在职','离职') DEFAULT '在职' COMMENT '在职状态',
  `workID` char(8) DEFAULT NULL COMMENT '工号',
  `contractTerm` double DEFAULT NULL COMMENT '合同期限',
  `conversionTime` date DEFAULT NULL COMMENT '转正日期',
  `notWorkDate` date DEFAULT NULL COMMENT '离职日期',
  `beginContract` date DEFAULT NULL COMMENT '合同起始日期',
  `endContract` date DEFAULT NULL COMMENT '合同终止日期',
  `workAge` int(11) DEFAULT NULL COMMENT '工龄',
  `isEntry` int(5) DEFAULT '1',
  `cooperationId` int(5) DEFAULT NULL,
  `is_clock` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `departmentId` (`departmentId`),
  KEY `jobId` (`jobLevelId`),
  KEY `dutyId` (`posId`),
  KEY `nationId` (`nationId`),
  KEY `politicId` (`politicId`),
  KEY `workID_key` (`workID`)
) ENGINE=InnoDB AUTO_INCREMENT=1943 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '江南一点雨', '男', '1990-01-01', '610122199001011256', '已婚', '1', '陕西', '13', 'laowang@qq.com', '18565558897', '深圳市南山区', '5', '9', '29', '劳务合同', '本科', '信息管理与信息系统', '深圳大学', '2018-01-01', '在职', '00000001', '2', '2018-04-01', null, '2018-01-01', '2020-01-01', null, '0', '2', '1');
INSERT INTO `employee` VALUES ('2', '陈静', '女', '1989-02-01', '421288198902011234', '已婚', '1', '海南', '1', 'chenjing@qq.com', '18795556693', '海南省海口市美兰区', '91', '12', '29', '劳动合同', '高中', '市场营销', '武汉大学', '2015-06-09', '在职', '00000002', '3', '2015-09-10', null, '2015-06-09', '2018-06-08', null, '0', '1', '0');
INSERT INTO `employee` VALUES ('3', '赵琳浩', '男', '1993-03-04', '610122199303041456', '未婚', '1', '陕西', '3', 'zhao@qq.com', '15698887795', '陕西省西安市莲湖区', '91', '12', '33', '劳动合同', '博士', '电子工程', '哈尔滨理工大学', '2018-01-01', '在职', '00000003', '3.5', '2018-04-01', null, '2018-01-01', '2021-07-14', null, '0', '4', '0');
INSERT INTO `employee` VALUES ('4', '鹿存亮', '男', '1990-01-03', '610122199001031456', '已婚', '1', '陕西', '3', 'zhao@qq.com', '15612347795', '陕西省西安市莲湖区', '92', '12', '34', '劳动合同', '高中', '电子工程', '哈尔滨理工大学', '2018-01-01', '在职', '00000004', '3.5', '2018-04-01', null, '2018-01-01', '2021-07-14', null, '0', '3', '0');
INSERT INTO `employee` VALUES ('5', '姚森', '男', '1991-02-05', '610122199102058952', '已婚', '1', '河南', '3', 'yaosen@qq.com', '14785559936', '河南洛阳人民大道58号', '92', '15', '34', '劳动合同', '硕士', '室内装修设计', '西北大学', '2017-01-02', '在职', '00000005', '7', '2017-04-02', null, '2017-01-02', '2024-01-17', null, '0', '6', '0');
INSERT INTO `employee` VALUES ('6', '云星', '女', '1993-01-05', '610122199301054789', '已婚', '1', '陕西西安', '1', 'yunxing@qq.com', '15644442252', '陕西西安新城区', '92', '16', '34', '劳务合同', '硕士', '通信工程', '西安电子科技学校', '2018-01-01', '在职', '00000006', '5.25', '2018-04-01', null, '2018-01-01', '2023-04-13', null, '0', '5', '0');
INSERT INTO `employee` VALUES ('7', '贾旭明', '男', '1993-11-11', '610122199311111234', '已婚', '1', '广东广州', '4', 'jiaxuming@qq.com', '15644441234', '广东省广州市天河区冼村路', '78', '15', '33', '劳务合同', '初中', '通信工程', '西北大学', '2018-01-01', '在职', '00000007', '5.25', '2018-04-01', null, '2018-01-01', '2023-04-13', null, '0', '8', '0');
INSERT INTO `employee` VALUES ('8', '张黎明', '男', '1991-02-01', '610144199102014569', '已婚', '1', '广东', '6', 'zhangliming@qq.com', '18979994478', '广东珠海', '91', '15', '33', '劳动合同', '高中', '考古', '清华大学', '2018-01-01', '在职', '00000008', '7', '2018-04-01', null, '2018-01-01', '2025-01-30', null, '0', '7', '0');
INSERT INTO `employee` VALUES ('9', '薛磊', '男', '1992-07-01', '610144199207017895', '已婚', '1', '陕西西安', '13', 'xuelei@qq.com', '15648887741', '西安市雁塔区', '92', '14', '34', '劳动合同', '初中', '无', '华胥中学', '2018-01-01', '在职', '00000009', '6', '2018-04-01', null, '2018-01-01', '2024-01-17', null, '0', '10', '0');
INSERT INTO `employee` VALUES ('11', '江南一点雨2', '男', '1990-01-01', '610122199001011256', '已婚', '1', '陕西', '13', 'laowang@qq.com', '18565558897', '深圳市南山区', '91', '9', '29', '劳动合同', '本科', '信息管理与信息系统', '深圳大学', '2018-01-01', '在职', '00000011', '1', '2018-04-01', null, '2018-01-01', '2019-01-01', null, '0', '12', '0');
INSERT INTO `employee` VALUES ('12', '陈静2', '女', '1989-02-01', '421288198902011234', '已婚', '1', '海南', '1', 'chenjing@qq.com', '18795556693', '海南省海口市美兰区', '82', '12', '30', '劳动合同', '高中', '市场营销', '武汉大学', '2015-06-09', '在职', '00000012', '3', '2015-09-10', null, '2015-06-09', '2018-06-08', null, '0', '11', '0');
INSERT INTO `employee` VALUES ('13', '赵琳浩2', '男', '1993-03-04', '610122199303041456', '未婚', '1', '陕西', '3', 'zhao@qq.com', '15698887795', '陕西省西安市莲湖区', '91', '12', '33', '劳动合同', '博士', '电子工程', '哈尔滨理工大学', '2018-01-01', '在职', '00000013', '3.5', '2018-04-01', null, '2018-01-01', '2021-07-14', null, '0', '14', '0');
INSERT INTO `employee` VALUES ('14', '鹿存亮2', '男', '1990-01-03', '610122199001031456', '已婚', '1', '陕西', '3', 'zhao@qq.com', '15612347795', '陕西省西安市莲湖区', '92', '12', '34', '劳动合同', '高中', '电子工程', '哈尔滨理工大学', '2018-01-01', '在职', '00000014', '3.5', '2018-04-01', null, '2018-01-01', '2021-07-14', null, '0', '13', '0');
INSERT INTO `employee` VALUES ('15', '姚森2', '男', '1991-02-05', '610122199102058952', '已婚', '1', '河南', '3', 'yaosen@qq.com', '14785559936', '河南洛阳人民大道58号', '92', '15', '34', '劳动合同', '初中', '室内装修设计', '西北大学', '2017-01-02', '在职', '00000015', '7', '2017-04-02', null, '2017-01-02', '2024-01-17', null, '0', '16', '0');
INSERT INTO `employee` VALUES ('16', '云星2', '女', '1993-01-05', '610122199301054789', '已婚', '1', '陕西西安', '1', 'yunxing@qq.com', '15644442252', '陕西西安新城区', '92', '16', '34', '劳务合同', '硕士', '通信工程', '西安电子科技学校', '2018-01-01', '在职', '00000016', '5.25', '2018-04-01', null, '2018-01-01', '2023-04-13', null, '0', '15', '0');
INSERT INTO `employee` VALUES ('17', '贾旭明2', '男', '1993-11-11', '610122199311111234', '已婚', '1', '广东广州', '4', 'jiaxuming@qq.com', '15644441234', '广东省广州市天河区冼村路', '78', '15', '33', '劳务合同', '初中', '通信工程', '西北大学', '2018-01-01', '在职', '00000017', '5.25', '2018-04-01', null, '2018-01-01', '2023-04-13', null, '0', '18', '0');
INSERT INTO `employee` VALUES ('18', '王一亭', '男', '1991-02-01', '610144199102014569', '已婚', '1', '广东', '6', 'zhangliming@qq.com', '18979994478', '广东珠海', '91', '15', '33', '劳动合同', '高中', '考古', '清华大学', '2018-01-01', '在职', '00000018', '7', '2018-04-01', null, '2018-01-01', '2025-01-30', null, '0', '17', '0');
INSERT INTO `employee` VALUES ('19', '薛磊2', '男', '1992-07-01', '610144199207017895', '已婚', '1', '陕西西安', '13', 'xuelei@qq.com', '15648887741', '西安市雁塔区', '92', '14', '34', '劳动合同', '初中', '无', '华胥中学', '2018-01-01', '在职', '00000019', '1', '2018-04-01', null, '2018-01-01', '2019-01-01', null, '0', '20', '0');
INSERT INTO `employee` VALUES ('20', '张洁2', '女', '1990-10-09', '420177199010093652', '未婚', '1', '海南', '5', 'zhangjie@qq.com', '13695557742', '海口市美兰区', '92', '16', '34', '劳动合同', '高中', '无', '海南侨中', '2018-01-01', '在职', '00000020', '1', '2018-01-31', null, '2018-01-01', '2019-01-01', null, '0', '19', '0');
INSERT INTO `employee` VALUES ('21', '王董', '男', '1990-01-01', '610122199001011256', '已婚', '1', '陕西', '13', 'laowang@qq.com', '18565558897', '深圳市南山区', '8', '9', '29', '劳动合同', '本科', '信息管理与信息系统', '深圳大学', '2018-01-01', '在职', '00000021', '1', '2018-04-01', null, '2018-01-01', '2019-01-01', null, '0', '22', '0');
INSERT INTO `employee` VALUES ('22', '陈静3', '女', '1989-02-01', '421288198902011234', '已婚', '1', '海南', '1', 'chenjing@qq.com', '18795556693', '海南省海口市美兰区', '82', '12', '30', '劳动合同', '高中', '市场营销', '武汉大学', '2015-06-09', '在职', '00000022', '3', '2015-09-10', null, '2015-06-09', '2018-06-08', null, '0', '21', '0');
INSERT INTO `employee` VALUES ('24', '鹿存亮3', '男', '1990-01-03', '610122199001031456', '已婚', '1', '陕西', '3', 'zhao@qq.com', '15612347795', '陕西省西安市莲湖区', '92', '12', '34', '劳动合同', '高中', '电子工程', '哈尔滨理工大学', '2018-01-01', '在职', '00000024', '3.5', '2018-04-01', null, '2018-01-01', '2021-07-14', null, '0', '24', '0');
INSERT INTO `employee` VALUES ('25', '姚森3', '男', '1991-02-05', '610122199102058952', '已婚', '1', '河南', '3', 'yaosen@qq.com', '14785559936', '河南洛阳人民大道58号', '92', '15', '34', '劳动合同', '初中', '室内装修设计', '西北大学', '2017-01-02', '在职', '00000025', '7', '2017-04-02', null, '2017-01-02', '2024-01-17', null, '0', '23', '0');
INSERT INTO `employee` VALUES ('26', '云星3', '女', '1993-01-05', '610122199301054789', '已婚', '1', '陕西西安', '1', 'yunxing@qq.com', '15644442252', '陕西西安新城区', '92', '16', '34', '劳务合同', '硕士', '通信工程', '西安电子科技学校', '2018-01-01', '在职', '00000026', '5.25', '2018-04-01', null, '2018-01-01', '2023-04-13', null, '0', '26', '0');
INSERT INTO `employee` VALUES ('27', '贾旭明3', '男', '1993-11-11', '610122199311111234', '已婚', '1', '广东广州', '4', 'jiaxuming@qq.com', '15644441234', '广东省广州市天河区冼村路', '78', '15', '33', '劳务合同', '初中', '通信工程', '西北大学', '2018-01-01', '在职', '00000027', '5.25', '2018-04-01', null, '2018-01-01', '2023-04-13', null, '0', '25', '0');
INSERT INTO `employee` VALUES ('28', '张黎明3', '男', '1991-02-01', '610144199102014569', '已婚', '1', '广东', '6', 'zhangliming@qq.com', '18979994478', '广东珠海', '91', '15', '33', '劳动合同', '高中', '考古', '清华大学', '2018-01-01', '在职', '00000028', '7', '2018-04-01', null, '2018-01-01', '2025-01-30', null, '0', '28', '0');
INSERT INTO `employee` VALUES ('29', '薛磊3', '男', '1992-07-01', '610144199207017895', '已婚', '1', '陕西西安', '13', 'xuelei@qq.com', '15648887741', '西安市雁塔区', '92', '14', '34', '劳动合同', '初中', '无', '华胥中学', '2018-01-01', '在职', '00000029', '6', '2018-04-01', null, '2018-01-01', '2024-01-17', null, '0', '27', '0');
INSERT INTO `employee` VALUES ('31', '江南一点雨4', '男', '1990-01-01', '610122199001011256', '已婚', '1', '陕西', '13', 'laowang@qq.com', '18565558897', '深圳市南山区', '8', '9', '29', '劳动合同', '本科', '信息管理与信息系统', '深圳大学', '2018-01-01', '在职', '00000031', '1', '2018-04-01', null, '2018-01-01', '2019-01-01', null, '0', '30', '0');
INSERT INTO `employee` VALUES ('32', '陈静4', '女', '1989-02-01', '421288198902011234', '已婚', '1', '海南', '1', 'chenjing@qq.com', '18795556693', '海南省海口市美兰区', '82', '12', '30', '劳动合同', '高中', '市场营销', '武汉大学', '2015-06-09', '在职', '00000032', '3', '2015-09-10', null, '2015-06-09', '2018-06-08', null, '0', '29', '0');
INSERT INTO `employee` VALUES ('33', '赵琳浩4', '男', '1993-03-04', '610122199303041456', '未婚', '1', '陕西', '3', 'zhao@qq.com', '15698887795', '陕西省西安市莲湖区', '91', '12', '33', '劳动合同', '博士', '电子工程', '哈尔滨理工大学', '2018-01-01', '在职', '00000033', '3.5', '2018-04-01', null, '2018-01-01', '2021-07-14', null, '0', '32', '0');
INSERT INTO `employee` VALUES ('34', '鹿存亮4', '男', '1990-01-03', '610122199001031456', '已婚', '1', '陕西', '3', 'zhao@qq.com', '15612347795', '陕西省西安市莲湖区', '92', '12', '34', '劳动合同', '高中', '电子工程', '哈尔滨理工大学', '2018-01-01', '在职', '00000034', '3.5', '2018-04-01', null, '2018-01-01', '2021-07-14', null, '0', '31', '0');
INSERT INTO `employee` VALUES ('35', '姚森4', '男', '1991-02-05', '610122199102058952', '已婚', '1', '河南', '3', 'yaosen@qq.com', '14785559936', '河南洛阳人民大道58号', '92', '15', '34', '劳动合同', '初中', '室内装修设计', '西北大学', '2017-01-02', '在职', '00000035', '7', '2017-04-02', null, '2017-01-02', '2024-01-17', null, '0', '34', '0');
INSERT INTO `employee` VALUES ('36', '云星4', '女', '1993-01-05', '610122199301054789', '已婚', '1', '陕西西安', '1', 'yunxing@qq.com', '15644442252', '陕西西安新城区', '92', '16', '34', '劳务合同', '硕士', '通信工程', '西安电子科技学校', '2018-01-01', '在职', '00000036', '5.25', '2018-04-01', null, '2018-01-01', '2023-04-13', null, '0', '33', '0');
INSERT INTO `employee` VALUES ('37', '贾旭明4', '男', '1993-11-11', '610122199311111234', '已婚', '1', '广东广州', '4', 'jiaxuming@qq.com', '15644441234', '广东省广州市天河区冼村路', '78', '15', '33', '劳务合同', '初中', '通信工程', '西北大学', '2018-01-01', '在职', '00000037', '5.25', '2018-04-01', null, '2018-01-01', '2023-04-13', null, '0', '36', '0');
INSERT INTO `employee` VALUES ('38', '张黎明2', '男', '1991-02-01', '610144199102014569', '已婚', '1', '广东', '6', 'zhangliming@qq.com', '18979994478', '广东珠海', '91', '15', '33', '劳动合同', '高中', '考古', '清华大学', '2018-01-01', '在职', '00000038', '7', '2018-04-01', null, '2018-01-01', '2025-01-30', null, '0', '35', '0');
INSERT INTO `employee` VALUES ('39', '薛磊4', '男', '1992-07-01', '610144199207017895', '已婚', '1', '陕西西安', '13', 'xuelei@qq.com', '15648887741', '西安市雁塔区', '92', '14', '34', '劳动合同', '初中', '无', '华胥中学', '2018-01-01', '在职', '00000039', '6', '2018-04-01', null, '2018-01-01', '2024-01-17', null, '0', '38', '0');
INSERT INTO `employee` VALUES ('40', '张洁4', '女', '1990-10-09', '420177199010093652', '未婚', '1', '海南', '5', 'zhangjie@qq.com', '13695557742', '海口市美兰区', '92', '16', '34', '劳动合同', '高中', '无', '海南侨中', '2018-01-01', '在职', '00000040', '1', '2018-01-31', null, '2018-01-01', '2019-01-01', null, '0', '37', '0');
INSERT INTO `employee` VALUES ('41', '江南一点雨5', '男', '1990-01-01', '610122199001011256', '已婚', '1', '陕西', '13', 'laowang@qq.com', '18565558897', '深圳市南山区', '8', '9', '29', '劳动合同', '本科', '信息管理与信息系统', '深圳大学', '2018-01-01', '在职', '00000041', '1', '2018-04-01', null, '2018-01-01', '2019-01-01', null, '1', '40', '0');
INSERT INTO `employee` VALUES ('42', '陈静5', '女', '1989-02-01', '421288198902011234', '已婚', '1', '海南', '1', 'chenjing@qq.com', '18795556693', '海南省海口市美兰区', '82', '12', '30', '劳动合同', '高中', '市场营销', '武汉大学', '2015-06-09', '在职', '00000042', '3', '2015-09-10', null, '2015-06-09', '2018-06-08', null, '1', '39', '0');
INSERT INTO `employee` VALUES ('43', '赵琳浩5', '男', '1993-03-04', '610122199303041456', '未婚', '1', '陕西', '3', 'zhao@qq.com', '15698887795', '陕西省西安市莲湖区', '91', '12', '33', '劳动合同', '博士', '电子工程', '哈尔滨理工大学', '2018-01-01', '在职', '00000043', '3.5', '2018-04-01', null, '2018-01-01', '2021-07-14', null, '1', null, '0');
INSERT INTO `employee` VALUES ('44', '鹿存亮5', '男', '1990-01-03', '610122199001031456', '已婚', '1', '陕西', '3', 'zhao@qq.com', '15612347795', '陕西省西安市莲湖区', '92', '12', '34', '劳动合同', '高中', '电子工程', '哈尔滨理工大学', '2018-01-01', '在职', '00000044', '3.5', '2018-04-01', null, '2018-01-01', '2021-07-14', null, '1', null, '0');
INSERT INTO `employee` VALUES ('45', '姚森5', '男', '1991-02-05', '610122199102058952', '已婚', '1', '河南', '3', 'yaosen@qq.com', '14785559936', '河南洛阳人民大道58号', '92', '15', '34', '劳动合同', '初中', '室内装修设计', '西北大学', '2017-01-02', '在职', '00000045', '7', '2017-04-02', null, '2017-01-02', '2024-01-17', null, '1', null, '0');
INSERT INTO `employee` VALUES ('46', '云星5', '女', '1993-01-05', '610122199301054789', '已婚', '1', '陕西西安', '1', 'yunxing@qq.com', '15644442252', '陕西西安新城区', '92', '16', '34', '劳务合同', '硕士', '通信工程', '西安电子科技学校', '2018-01-01', '在职', '00000046', '5.25', '2018-04-01', null, '2018-01-01', '2023-04-13', null, '1', null, '0');
INSERT INTO `employee` VALUES ('47', '贾旭明5', '男', '1993-11-11', '610122199311111234', '已婚', '1', '广东广州', '4', 'jiaxuming@qq.com', '15644441234', '广东省广州市天河区冼村路', '78', '15', '33', '劳务合同', '初中', '通信工程', '西北大学', '2018-01-01', '在职', '00000047', '5.25', '2018-04-01', null, '2018-01-01', '2023-04-13', null, '1', null, '0');
INSERT INTO `employee` VALUES ('48', '张黎明5', '男', '1991-02-01', '610144199102014569', '已婚', '1', '广东', '6', 'zhangliming@qq.com', '18979994478', '广东珠海', '91', '15', '33', '劳动合同', '高中', '考古', '清华大学', '2018-01-01', '在职', '00000048', '7', '2018-04-01', null, '2018-01-01', '2025-01-30', null, '1', null, '0');
INSERT INTO `employee` VALUES ('49', '薛磊5', '男', '1992-07-01', '610144199207017895', '已婚', '1', '陕西西安', '13', 'xuelei@qq.com', '15648887741', '西安市雁塔区', '92', '14', '34', '劳动合同', '初中', '无', '华胥中学', '2018-01-01', '在职', '00000049', '6', '2018-04-01', null, '2018-01-01', '2024-01-17', null, '1', null, '0');
INSERT INTO `employee` VALUES ('50', '张洁5', '女', '1990-10-09', '420177199010093652', '未婚', '1', '海南', '5', 'zhangjie@qq.com', '13695557742', '海口市美兰区', '92', '16', '34', '劳动合同', '高中', '无', '海南侨中', '2018-01-01', '在职', '00000050', '1', '2018-01-31', null, '2018-01-01', '2019-01-01', null, '1', null, '0');
INSERT INTO `employee` VALUES ('51', '江南一点雨6', '男', '1990-01-01', '610122199001011256', '已婚', '1', '陕西', '13', 'laowang@qq.com', '18565558897', '深圳市南山区', '8', '9', '29', '劳动合同', '本科', '信息管理与信息系统', '深圳大学', '2018-01-01', '在职', '00000051', '1', '2018-04-01', null, '2018-01-01', '2019-01-01', null, '1', null, '0');
INSERT INTO `employee` VALUES ('52', '陈静6', '女', '1989-02-01', '421288198902011234', '已婚', '1', '海南', '1', 'chenjing@qq.com', '18795556693', '海南省海口市美兰区', '82', '12', '30', '劳动合同', '高中', '市场营销', '武汉大学', '2015-06-09', '在职', '00000052', '3', '2015-09-10', null, '2015-06-09', '2018-06-08', null, '1', null, '0');
INSERT INTO `employee` VALUES ('53', '赵琳浩6', '男', '1993-03-04', '610122199303041456', '未婚', '1', '陕西', '3', 'zhao@qq.com', '15698887795', '陕西省西安市莲湖区', '91', '12', '33', '劳动合同', '博士', '电子工程', '哈尔滨理工大学', '2018-01-01', '在职', '00000053', '3.5', '2018-04-01', null, '2018-01-01', '2021-07-14', null, '1', null, '0');
INSERT INTO `employee` VALUES ('54', '鹿存亮6', '男', '1990-01-03', '610122199001031456', '已婚', '1', '陕西', '3', 'zhao@qq.com', '15612347795', '陕西省西安市莲湖区', '92', '12', '34', '劳动合同', '高中', '电子工程', '哈尔滨理工大学', '2018-01-01', '在职', '00000054', '3.5', '2018-04-01', null, '2018-01-01', '2021-07-14', null, '1', null, '0');
INSERT INTO `employee` VALUES ('55', '姚森6', '男', '1991-02-05', '610122199102058952', '已婚', '1', '河南', '3', 'yaosen@qq.com', '14785559936', '河南洛阳人民大道58号', '92', '15', '34', '劳动合同', '初中', '室内装修设计', '西北大学', '2017-01-02', '在职', '00000055', '7', '2017-04-02', null, '2017-01-02', '2024-01-17', null, '1', null, '0');
INSERT INTO `employee` VALUES ('56', '云星6', '女', '1993-01-05', '610122199301054789', '已婚', '1', '陕西西安', '1', 'yunxing@qq.com', '15644442252', '陕西西安新城区', '92', '16', '34', '劳务合同', '硕士', '通信工程', '西安电子科技学校', '2018-01-01', '在职', '00000056', '5.25', '2018-04-01', null, '2018-01-01', '2023-04-13', null, '1', null, '0');
INSERT INTO `employee` VALUES ('1942', '张三', '男', '2020-04-15', '370481199602237713', '未婚', '1', '汉', '13', '1473673516@qq.com', '17854337592', '济南', '91', '9', '29', '劳动合同', '本科', '计算机科学与技术', '滨州学院', '2020-04-23', '在职', '00000057', '2', '2020-04-25', null, '2020-04-23', '2022-04-30', null, '1', null, '0');

-- ----------------------------
-- Table structure for `employeeec`
-- ----------------------------
DROP TABLE IF EXISTS `employeeec`;
CREATE TABLE `employeeec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL COMMENT '员工编号',
  `ecDate` date DEFAULT NULL COMMENT '奖罚日期',
  `ecReason` varchar(255) DEFAULT NULL COMMENT '奖罚原因',
  `ecPoint` int(11) DEFAULT NULL COMMENT '奖罚分',
  `ecType` int(11) DEFAULT NULL COMMENT '奖罚类别，0：奖，1：罚',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `pid` (`eid`),
  CONSTRAINT `employeeec_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeeec
-- ----------------------------

-- ----------------------------
-- Table structure for `employeeremove`
-- ----------------------------
DROP TABLE IF EXISTS `employeeremove`;
CREATE TABLE `employeeremove` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `afterDepId` int(11) DEFAULT NULL COMMENT '调动后部门',
  `afterJobId` int(11) DEFAULT NULL COMMENT '调动后职位',
  `removeDate` date DEFAULT NULL COMMENT '调动日期',
  `reason` varchar(255) DEFAULT NULL COMMENT '调动原因',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pid` (`eid`),
  CONSTRAINT `employeeremove_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeeremove
-- ----------------------------

-- ----------------------------
-- Table structure for `employeetrain`
-- ----------------------------
DROP TABLE IF EXISTS `employeetrain`;
CREATE TABLE `employeetrain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL COMMENT '员工编号',
  `trainDate` date DEFAULT NULL COMMENT '培训日期',
  `trainContent` varchar(255) DEFAULT NULL COMMENT '培训内容',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `pid` (`eid`),
  CONSTRAINT `employeetrain_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeetrain
-- ----------------------------

-- ----------------------------
-- Table structure for `empsalary`
-- ----------------------------
DROP TABLE IF EXISTS `empsalary`;
CREATE TABLE `empsalary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `eid` (`eid`),
  KEY `empsalary_ibfk_2` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of empsalary
-- ----------------------------
INSERT INTO `empsalary` VALUES ('6', '4', '10');
INSERT INTO `empsalary` VALUES ('10', '5', '9');
INSERT INTO `empsalary` VALUES ('11', '6', '13');
INSERT INTO `empsalary` VALUES ('12', '7', '13');
INSERT INTO `empsalary` VALUES ('14', '8', '10');
INSERT INTO `empsalary` VALUES ('15', '9', '10');
INSERT INTO `empsalary` VALUES ('20', '10', '13');
INSERT INTO `empsalary` VALUES ('21', '11', '9');
INSERT INTO `empsalary` VALUES ('22', '3', '13');
INSERT INTO `empsalary` VALUES ('24', '2', '9');
INSERT INTO `empsalary` VALUES ('25', '1', '13');
INSERT INTO `empsalary` VALUES ('26', '33', '10');
INSERT INTO `empsalary` VALUES ('28', '34', '9');
INSERT INTO `empsalary` VALUES ('29', '44', '10');
INSERT INTO `empsalary` VALUES ('30', '45', '10');
INSERT INTO `empsalary` VALUES ('31', '43', '10');
INSERT INTO `empsalary` VALUES ('32', '47', '10');
INSERT INTO `empsalary` VALUES ('33', '52', '13');
INSERT INTO `empsalary` VALUES ('34', '53', '10');
INSERT INTO `empsalary` VALUES ('35', '54', '10');
INSERT INTO `empsalary` VALUES ('36', '56', '10');
INSERT INTO `empsalary` VALUES ('38', '21', '9');
INSERT INTO `empsalary` VALUES ('39', '1423', '16');

-- ----------------------------
-- Table structure for `hr`
-- ----------------------------
DROP TABLE IF EXISTS `hr`;
CREATE TABLE `hr` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'hrID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(16) DEFAULT NULL COMMENT '住宅电话',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `enabled` tinyint(1) DEFAULT '1',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `userface` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `is_clock` int(3) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr
-- ----------------------------
INSERT INTO `hr` VALUES ('3', '大BOSS', '18568887789', '029-82881234', '深圳南山', '1', 'admin', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', null, '0');
INSERT INTO `hr` VALUES ('5', '第一分店', '18568123489', '029-82123434', '海口美兰', '1', 'first', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', null, '0');
INSERT INTO `hr` VALUES ('10', '第二分店', '18568123666', '029-82111555', '广州番禺', '0', 'hanyu', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg', null, '0');
INSERT INTO `hr` VALUES ('11', '第三分店', '18568123377', '029-82111333', '广州天河', '1', 'liuzongyuan', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515233756&di=0856d923a0a37a87fd26604a2c871370&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2014-09-27%2F041716704.jpg', null, '0');
INSERT INTO `hr` VALUES ('12', '第四分店', '18568128888', '029-82111222', '广州越秀', '1', 'zenggong', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg', null, '0');
INSERT INTO `hr` VALUES ('15', '热天', '17854533234', '4567421', null, '1', 'first1', '$2a$10$TmwR7HnvBefASt9UKhTtD.RA0OpiS88DTFvTrKsKadbaF4iaCKHKC', null, null, '0');

-- ----------------------------
-- Table structure for `hr_role`
-- ----------------------------
DROP TABLE IF EXISTS `hr_role`;
CREATE TABLE `hr_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hrid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `hr_role_ibfk_1` (`hrid`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr_role
-- ----------------------------
INSERT INTO `hr_role` VALUES ('1', '3', '6');
INSERT INTO `hr_role` VALUES ('37', '12', '2');
INSERT INTO `hr_role` VALUES ('46', '11', '1');
INSERT INTO `hr_role` VALUES ('48', '10', '2');
INSERT INTO `hr_role` VALUES ('72', '5', '1');
INSERT INTO `hr_role` VALUES ('75', '15', '1');

-- ----------------------------
-- Table structure for `joblevel`
-- ----------------------------
DROP TABLE IF EXISTS `joblevel`;
CREATE TABLE `joblevel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '职称名称',
  `titleLevel` enum('正高级','副高级','中级','初级','员级') DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of joblevel
-- ----------------------------
INSERT INTO `joblevel` VALUES ('9', '收银员', '正高级', '2018-01-11 00:00:00', '1');
INSERT INTO `joblevel` VALUES ('10', '衣服护理工程师', '副高级', '2018-01-11 21:19:20', '1');
INSERT INTO `joblevel` VALUES ('12', '洗衣员', '初级', '2018-01-11 21:35:39', '1');
INSERT INTO `joblevel` VALUES ('13', '熨烫师', '中级', '2018-01-11 00:00:00', '0');
INSERT INTO `joblevel` VALUES ('18', '衣服护理工程师', '正高级', '2020-04-27 10:52:05', '1');
INSERT INTO `joblevel` VALUES ('19', '衣服护理工程师', '中级', '2020-04-27 10:53:44', '1');
INSERT INTO `joblevel` VALUES ('20', '衣服护理工程师', '初级', '2020-04-27 10:53:59', '1');
INSERT INTO `joblevel` VALUES ('21', '熨烫师', '初级', '2020-04-27 10:54:21', '1');
INSERT INTO `joblevel` VALUES ('22', '熨烫师', '正高级', '2020-04-27 10:54:36', '1');

-- ----------------------------
-- Table structure for `mail_send_log`
-- ----------------------------
DROP TABLE IF EXISTS `mail_send_log`;
CREATE TABLE `mail_send_log` (
  `msgId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `empId` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '0发送中，1发送成功，2发送失败',
  `routeKey` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `exchange` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `count` int(11) DEFAULT NULL COMMENT '重试次数',
  `tryTime` date DEFAULT NULL COMMENT '第一次重试时间',
  `createTime` date DEFAULT NULL,
  `updateTime` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of mail_send_log
-- ----------------------------
INSERT INTO `mail_send_log` VALUES ('eafbe56b-8bee-435c-a0f0-2d6faac65a3d', '1942', '0', 'javaboy.mail.routing.key', 'javaboy.mail.exchange', null, '2020-04-24', '2020-04-24', null);

-- ----------------------------
-- Table structure for `members`
-- ----------------------------
DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
  `member_id` int(5) NOT NULL AUTO_INCREMENT,
  `member_num` varchar(255) DEFAULT NULL,
  `type_id` int(5) DEFAULT NULL,
  `custom_id` int(5) DEFAULT NULL,
  `create_time` varchar(50) DEFAULT NULL,
  `is_logout` int(2) DEFAULT '0',
  `balance` double(10,2) DEFAULT NULL,
  `user_id` int(6) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of members
-- ----------------------------
INSERT INTO `members` VALUES ('1', '#000001', '4', '1', '2020-04-03', '1', '1520.12', '5');
INSERT INTO `members` VALUES ('4', '#000002', '2', '2', '2020-04-07 16:27:55', '0', '820.89', '5');
INSERT INTO `members` VALUES ('5', '#000003', '4', '3', '2020-04-07 16:38:31', '0', '991.09', '10');
INSERT INTO `members` VALUES ('6', '#000004', '3', '4', '2020-04-07 16:44:31', '0', '1200.00', '10');
INSERT INTO `members` VALUES ('7', '#000005', '3', '5', '2020-04-07 16:56:29', '0', '445.81', '5');

-- ----------------------------
-- Table structure for `member_type`
-- ----------------------------
DROP TABLE IF EXISTS `member_type`;
CREATE TABLE `member_type` (
  `type_id` int(5) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL,
  `recharge_acount` double(255,0) DEFAULT NULL,
  `discount` varchar(255) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `total` varchar(255) DEFAULT NULL,
  `conditions` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `total_money` double(5,0) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member_type
-- ----------------------------
INSERT INTO `member_type` VALUES ('1', '普通会员', '0', '不打折', '一年之内洗衣十次可以享受一次免费洗衣', '0', '任何人都可以免费注册成为普通会员', '0');
INSERT INTO `member_type` VALUES ('2', '铜牌会员', '100', '不打折', '不定期为铜牌会员推出的特价活动', '冲100送20', '最低充值100元可以成为铜牌会员', '120');
INSERT INTO `member_type` VALUES ('3', '银牌会员', '200', '九五折', '不定期为银牌会员推出的特价活动。\r\n成为银牌会员可以享受九五折服务。', '冲200送60', '最低充值200可以成为银牌会员', '260');
INSERT INTO `member_type` VALUES ('4', '金牌会员', '300', '九折', '不定期为金牌会员推出的特价活动。\r\n成为金牌会员可以享受九折服务。\r\n本店周年庆赠送三等奖礼品一份。', '冲300送100', '最低充值300可以成为金牌会员', '400');
INSERT INTO `member_type` VALUES ('5', '铂金会员', '500', '八折', '不定期为铂金会员推出的特价活动。\r\n成为铂金会员可以享受八折服务。\r\n本店周年庆赠送二等奖礼品一份。', '冲500送200', '最低充值500可以成为铂金会员', '700');
INSERT INTO `member_type` VALUES ('6', '钻石会员', '1000', '七折', '不定期为钻石会员推出的特价活动。\r\n成为钻石会员可以享受七折服务。\r\n本店周年庆赠送一等奖礼品一份。\r\n每年免费赠送一次高档的洗衣服务。', '冲1000送500', '最低充值1000可以成为钻石会员', '1500');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL,
  `path` varchar(64) DEFAULT NULL,
  `component` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `iconCls` varchar(64) DEFAULT NULL,
  `keepAlive` tinyint(1) DEFAULT NULL,
  `requireAuth` tinyint(1) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `parentId` (`parentId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '/', null, null, '所有', null, null, null, null, '1');
INSERT INTO `menu` VALUES ('2', '/', '/home', 'Home', '员工管理', 'fa fa-user-circle-o', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('3', '/', '/home', 'Home', '会员管理', 'fa fa-address-card-o', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('4', '/', '/home', 'Home', '服务管理', 'fa fa-money', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('5', '/', '/home', 'Home', '统计管理', 'fa fa-bar-chart', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('6', '/', '/home', 'Home', '系统管理', 'fa fa-windows', null, '1', '1', '1');
INSERT INTO `menu` VALUES ('7', '/employee/basic/**', '/emp/basic', 'EmpBasic', '基本资料', 'fa fa-th-large', null, '1', '2', '1');
INSERT INTO `menu` VALUES ('8', '/employee/advanced/**', '/emp/adv', 'EmpAdv', '考勤记录', 'fa fa-th-large', null, '1', '2', '1');
INSERT INTO `menu` VALUES ('9', '/personnel/emp/**', '/mem/info', 'PerInfo', '会员信息', 'fa fa-th-large', null, '1', '3', '1');
INSERT INTO `menu` VALUES ('10', '/personnel/ec/**', '/mem/type', 'PerType', '会员类型', 'fa fa-th-large', null, '1', '3', '1');
INSERT INTO `menu` VALUES ('11', '/personnel/train/**', '/mem/record', 'PerRecord', '消费记录', 'fa fa-th-large', null, '1', '3', '1');
INSERT INTO `menu` VALUES ('12', '/personnel/salary/**', '/mem/Topup', 'PerTopup', '充值记录', 'fa fa-th-large', null, '1', '3', '1');
INSERT INTO `menu` VALUES ('13', '/personnel/remove/**', '/mem/up', 'PerUp', '会员充值', 'fa fa-th-large', null, '1', '3', '1');
INSERT INTO `menu` VALUES ('14', '/salary/sob/**', '/serve/wash', 'SalWash', '洗衣管理', 'fa fa-th-large', null, '1', '4', '1');
INSERT INTO `menu` VALUES ('18', '/salary/search/**', '/sal/search', 'SalSearch', '工资表查询', 'fa fa-th-large', null, '1', '2', '1');
INSERT INTO `menu` VALUES ('19', '/statistics/all/**', '/sta/all', 'StaAll', '各店营业统计', 'fa fa-th-large', null, '1', '5', '1');
INSERT INTO `menu` VALUES ('20', '/statistics/score/**', '/sta/score', 'StaScore', '每日数据分析', 'fa fa-th-large', null, '1', '5', '1');
INSERT INTO `menu` VALUES ('23', '/system/basic/**', '/sys/basic', 'SysBasic', '基础信息设置', 'fa fa-th-large', null, '1', '6', '1');
INSERT INTO `menu` VALUES ('26', '/system/hr/**', '/sys/hr', 'SysHr', '操作员管理', 'fa fa-th-large', null, '1', '6', '1');
INSERT INTO `menu` VALUES ('29', '/change/basic/**', '/emp/class', 'EmpClass', '交接班管理', 'fa fa-th-large', null, '1', '2', '1');
INSERT INTO `menu` VALUES ('30', '/salary/sobcfg/**', '/serve/pay', 'SalPay', '支付页面', 'fa fa-th-large', null, '1', '4', '1');

-- ----------------------------
-- Table structure for `menu_role`
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  KEY `rid` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=395 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES ('329', '3', '3');
INSERT INTO `menu_role` VALUES ('346', '9', '2');
INSERT INTO `menu_role` VALUES ('347', '10', '2');
INSERT INTO `menu_role` VALUES ('348', '11', '2');
INSERT INTO `menu_role` VALUES ('349', '12', '2');
INSERT INTO `menu_role` VALUES ('350', '13', '2');
INSERT INTO `menu_role` VALUES ('351', '14', '2');
INSERT INTO `menu_role` VALUES ('352', '20', '2');
INSERT INTO `menu_role` VALUES ('353', '29', '2');
INSERT INTO `menu_role` VALUES ('354', '30', '2');
INSERT INTO `menu_role` VALUES ('369', '7', '1');
INSERT INTO `menu_role` VALUES ('370', '8', '1');
INSERT INTO `menu_role` VALUES ('371', '18', '1');
INSERT INTO `menu_role` VALUES ('372', '29', '1');
INSERT INTO `menu_role` VALUES ('373', '9', '1');
INSERT INTO `menu_role` VALUES ('374', '10', '1');
INSERT INTO `menu_role` VALUES ('375', '11', '1');
INSERT INTO `menu_role` VALUES ('376', '12', '1');
INSERT INTO `menu_role` VALUES ('377', '13', '1');
INSERT INTO `menu_role` VALUES ('378', '14', '1');
INSERT INTO `menu_role` VALUES ('379', '30', '1');
INSERT INTO `menu_role` VALUES ('380', '20', '1');
INSERT INTO `menu_role` VALUES ('381', '7', '6');
INSERT INTO `menu_role` VALUES ('382', '8', '6');
INSERT INTO `menu_role` VALUES ('383', '18', '6');
INSERT INTO `menu_role` VALUES ('384', '29', '6');
INSERT INTO `menu_role` VALUES ('385', '9', '6');
INSERT INTO `menu_role` VALUES ('386', '10', '6');
INSERT INTO `menu_role` VALUES ('387', '11', '6');
INSERT INTO `menu_role` VALUES ('388', '12', '6');
INSERT INTO `menu_role` VALUES ('389', '13', '6');
INSERT INTO `menu_role` VALUES ('390', '14', '6');
INSERT INTO `menu_role` VALUES ('391', '30', '6');
INSERT INTO `menu_role` VALUES ('392', '19', '6');
INSERT INTO `menu_role` VALUES ('393', '23', '6');
INSERT INTO `menu_role` VALUES ('394', '26', '6');

-- ----------------------------
-- Table structure for `msgcontent`
-- ----------------------------
DROP TABLE IF EXISTS `msgcontent`;
CREATE TABLE `msgcontent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msgcontent
-- ----------------------------
INSERT INTO `msgcontent` VALUES ('14', '2222222222', '11111111111111111', '2018-02-02 20:46:19');
INSERT INTO `msgcontent` VALUES ('15', '22222222', '3333333333333333333333', '2018-02-02 21:45:57');
INSERT INTO `msgcontent` VALUES ('16', '通知标题1', '通知内容1', '2018-02-03 11:41:39');
INSERT INTO `msgcontent` VALUES ('17', '通知标题2', '通知内容2', '2018-02-03 11:52:37');
INSERT INTO `msgcontent` VALUES ('18', '通知标题3', '通知内容3', '2018-02-03 12:19:41');
INSERT INTO `msgcontent` VALUES ('19', '通知标题1', '通知内容1', '2018-02-03 11:41:39');
INSERT INTO `msgcontent` VALUES ('20', '通知标题2', '通知内容2', '2018-02-03 11:52:37');
INSERT INTO `msgcontent` VALUES ('21', '通知标题3', '通知内容3', '2018-02-03 12:19:41');
INSERT INTO `msgcontent` VALUES ('22', '通知标题1', '通知内容1', '2018-02-03 11:41:39');
INSERT INTO `msgcontent` VALUES ('23', '通知标题2', '通知内容2', '2018-02-03 11:52:37');
INSERT INTO `msgcontent` VALUES ('24', '通知标题3', '通知内容3', '2018-02-03 12:19:41');
INSERT INTO `msgcontent` VALUES ('25', '通知标题1', '通知内容1', '2018-02-03 11:41:39');
INSERT INTO `msgcontent` VALUES ('26', '通知标题2', '通知内容2', '2018-02-03 11:52:37');
INSERT INTO `msgcontent` VALUES ('27', '通知标题3', '通知内容3', '2018-02-03 12:19:41');
INSERT INTO `msgcontent` VALUES ('28', '通知标题1', '通知内容1', '2018-02-03 11:41:39');
INSERT INTO `msgcontent` VALUES ('29', '通知标题2', '通知内容2', '2018-02-03 11:52:37');
INSERT INTO `msgcontent` VALUES ('30', '通知标题3', '通知内容3', '2018-02-03 12:19:41');

-- ----------------------------
-- Table structure for `nation`
-- ----------------------------
DROP TABLE IF EXISTS `nation`;
CREATE TABLE `nation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nation
-- ----------------------------
INSERT INTO `nation` VALUES ('1', '汉族');
INSERT INTO `nation` VALUES ('2', '蒙古族');
INSERT INTO `nation` VALUES ('3', '回族');
INSERT INTO `nation` VALUES ('4', '藏族');
INSERT INTO `nation` VALUES ('5', '维吾尔族');
INSERT INTO `nation` VALUES ('6', '苗族');
INSERT INTO `nation` VALUES ('7', '彝族');
INSERT INTO `nation` VALUES ('8', '壮族');
INSERT INTO `nation` VALUES ('9', '布依族');
INSERT INTO `nation` VALUES ('10', '朝鲜族');
INSERT INTO `nation` VALUES ('11', '满族');
INSERT INTO `nation` VALUES ('12', '侗族');
INSERT INTO `nation` VALUES ('13', '瑶族');
INSERT INTO `nation` VALUES ('14', '白族');
INSERT INTO `nation` VALUES ('15', '土家族');
INSERT INTO `nation` VALUES ('16', '哈尼族');
INSERT INTO `nation` VALUES ('17', '哈萨克族');
INSERT INTO `nation` VALUES ('18', '傣族');
INSERT INTO `nation` VALUES ('19', '黎族');
INSERT INTO `nation` VALUES ('20', '傈僳族');
INSERT INTO `nation` VALUES ('21', '佤族');
INSERT INTO `nation` VALUES ('22', '畲族');
INSERT INTO `nation` VALUES ('23', '高山族');
INSERT INTO `nation` VALUES ('24', '拉祜族');
INSERT INTO `nation` VALUES ('25', '水族');
INSERT INTO `nation` VALUES ('26', '东乡族');
INSERT INTO `nation` VALUES ('27', '纳西族');
INSERT INTO `nation` VALUES ('28', '景颇族');
INSERT INTO `nation` VALUES ('29', '柯尔克孜族');
INSERT INTO `nation` VALUES ('30', '土族');
INSERT INTO `nation` VALUES ('31', '达斡尔族');
INSERT INTO `nation` VALUES ('32', '仫佬族');
INSERT INTO `nation` VALUES ('33', '羌族');
INSERT INTO `nation` VALUES ('34', '布朗族');
INSERT INTO `nation` VALUES ('35', '撒拉族');
INSERT INTO `nation` VALUES ('36', '毛难族');
INSERT INTO `nation` VALUES ('37', '仡佬族');
INSERT INTO `nation` VALUES ('38', '锡伯族');
INSERT INTO `nation` VALUES ('39', '阿昌族');
INSERT INTO `nation` VALUES ('40', '普米族');
INSERT INTO `nation` VALUES ('41', '塔吉克族');
INSERT INTO `nation` VALUES ('42', '怒族');
INSERT INTO `nation` VALUES ('43', '乌孜别克族');
INSERT INTO `nation` VALUES ('44', '俄罗斯族');
INSERT INTO `nation` VALUES ('45', '鄂温克族');
INSERT INTO `nation` VALUES ('46', '崩龙族');
INSERT INTO `nation` VALUES ('47', '保安族');
INSERT INTO `nation` VALUES ('48', '裕固族');
INSERT INTO `nation` VALUES ('49', '京族');
INSERT INTO `nation` VALUES ('50', '塔塔尔族');
INSERT INTO `nation` VALUES ('51', '独龙族');
INSERT INTO `nation` VALUES ('52', '鄂伦春族');
INSERT INTO `nation` VALUES ('53', '赫哲族');
INSERT INTO `nation` VALUES ('54', '门巴族');
INSERT INTO `nation` VALUES ('55', '珞巴族');
INSERT INTO `nation` VALUES ('56', '基诺族');

-- ----------------------------
-- Table structure for `oplog`
-- ----------------------------
DROP TABLE IF EXISTS `oplog`;
CREATE TABLE `oplog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addDate` date DEFAULT NULL COMMENT '添加日期',
  `operate` varchar(255) DEFAULT NULL COMMENT '操作内容',
  `hrid` int(11) DEFAULT NULL COMMENT '操作员ID',
  PRIMARY KEY (`id`),
  KEY `hrid` (`hrid`),
  CONSTRAINT `oplog_ibfk_1` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oplog
-- ----------------------------

-- ----------------------------
-- Table structure for `politicsstatus`
-- ----------------------------
DROP TABLE IF EXISTS `politicsstatus`;
CREATE TABLE `politicsstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of politicsstatus
-- ----------------------------
INSERT INTO `politicsstatus` VALUES ('1', '中共党员');
INSERT INTO `politicsstatus` VALUES ('2', '中共预备党员');
INSERT INTO `politicsstatus` VALUES ('3', '共青团员');
INSERT INTO `politicsstatus` VALUES ('4', '民革党员');
INSERT INTO `politicsstatus` VALUES ('5', '民盟盟员');
INSERT INTO `politicsstatus` VALUES ('6', '民建会员');
INSERT INTO `politicsstatus` VALUES ('7', '民进会员');
INSERT INTO `politicsstatus` VALUES ('8', '农工党党员');
INSERT INTO `politicsstatus` VALUES ('9', '致公党党员');
INSERT INTO `politicsstatus` VALUES ('10', '九三学社社员');
INSERT INTO `politicsstatus` VALUES ('11', '台盟盟员');
INSERT INTO `politicsstatus` VALUES ('12', '无党派民主人士');
INSERT INTO `politicsstatus` VALUES ('13', '普通公民');

-- ----------------------------
-- Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '职位',
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('29', '董事长', '2018-01-11 21:13:42', '1');
INSERT INTO `position` VALUES ('30', '总经理', '2018-01-11 21:13:48', '1');
INSERT INTO `position` VALUES ('31', '店长', '2018-01-11 00:00:00', '1');
INSERT INTO `position` VALUES ('33', '洗衣员', '2018-01-14 00:00:00', '1');
INSERT INTO `position` VALUES ('34', '前台', '2018-01-14 16:11:41', '1');
INSERT INTO `position` VALUES ('36', '收银', '2019-10-01 00:00:00', '1');

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_id` int(5) NOT NULL AUTO_INCREMENT,
  `cus_id` int(5) DEFAULT NULL,
  `mem_id` int(5) DEFAULT NULL,
  `record_time` varchar(255) DEFAULT NULL,
  `record_money` double(20,2) DEFAULT NULL,
  `record_detail` varchar(255) DEFAULT NULL,
  `clothes_id` int(3) DEFAULT NULL,
  `user_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1', '1', '2020-04-08', '2.00', '讷讷呢', null, '5');
INSERT INTO `record` VALUES ('7', '8', null, '2020-04-21 14:16:24', '15.00', '裙子', '10', '5');
INSERT INTO `record` VALUES ('8', '8', null, '2020-04-21 14:16:37', '15.00', '裙子', '10', '5');
INSERT INTO `record` VALUES ('9', '9', null, '2020-04-21 14:28:47', '15.00', '裙子', '11', '5');
INSERT INTO `record` VALUES ('10', '8', null, '2020-04-21 14:29:02', '15.00', '裙子', '10', '5');
INSERT INTO `record` VALUES ('11', '4', '6', '2020-04-21 16:18:16', '10.50', '衬衫', '5', '5');
INSERT INTO `record` VALUES ('12', '3', '5', '2020-04-21 16:21:37', '9.00', '围巾', '7', '5');
INSERT INTO `record` VALUES ('13', '7', null, '2020-04-21 23:35:06', '20.00', '床单', '9', '5');
INSERT INTO `record` VALUES ('14', '8', null, '2020-04-22 17:43:06', '15.00', '裙子', '10', '5');
INSERT INTO `record` VALUES ('15', '9', null, '2020-04-22 21:47:56', '15.00', '裙子', '11', '5');
INSERT INTO `record` VALUES ('16', '10', null, '2020-04-22 21:51:22', '40.00', '毛领', '12', '5');
INSERT INTO `record` VALUES ('17', '9', null, '2020-04-22 21:52:19', '15.00', '裙子', '11', '5');
INSERT INTO `record` VALUES ('18', '7', null, '2020-04-22 21:53:05', '20.00', '床单', '9', '5');
INSERT INTO `record` VALUES ('19', null, null, '2020-04-22 22:14:14', '56.00', '', null, '5');
INSERT INTO `record` VALUES ('20', null, null, '2020-04-22 22:14:51', '67.00', '铜牌会员', null, '5');
INSERT INTO `record` VALUES ('21', null, null, '2020-04-22 22:16:36', '67.00', '', null, '5');
INSERT INTO `record` VALUES ('22', null, null, '2020-04-22 22:16:59', '67.00', null, null, '5');
INSERT INTO `record` VALUES ('23', null, null, '2020-04-22 22:18:44', '67.00', '不计后果', null, '5');
INSERT INTO `record` VALUES ('24', null, null, '2020-04-22 22:20:27', '6768.00', '一', null, '5');
INSERT INTO `record` VALUES ('25', '6', null, '2020-04-25 17:08:46', '15.00', '衬衫', '8', '5');
INSERT INTO `record` VALUES ('26', '5', '7', '2020-04-26 17:52:19', '14.20', '领带', '6', '5');

-- ----------------------------
-- Table structure for `refound`
-- ----------------------------
DROP TABLE IF EXISTS `refound`;
CREATE TABLE `refound` (
  `refound_id` int(5) NOT NULL AUTO_INCREMENT,
  `reason` varchar(1000) DEFAULT NULL,
  `clothes_id` int(5) DEFAULT NULL,
  `time` varchar(32) DEFAULT NULL,
  `refound_amount` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`refound_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of refound
-- ----------------------------
INSERT INTO `refound` VALUES ('1', '洗坏', null, '2020-04-23 15:28:22', '788.00');
INSERT INTO `refound` VALUES ('2', '洗坏', null, '2020-04-23 15:29:25', '567.00');
INSERT INTO `refound` VALUES ('3', '人退还给好', '10', '2020-04-23 15:31:58', '4565.00');
INSERT INTO `refound` VALUES ('4', '二维', '1', '2020-05-13 20:19:19', '34.00');

-- ----------------------------
-- Table structure for `refound_count`
-- ----------------------------
DROP TABLE IF EXISTS `refound_count`;
CREATE TABLE `refound_count` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `curdate` varchar(32) DEFAULT NULL,
  `count` int(6) DEFAULT NULL,
  `user_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of refound_count
-- ----------------------------
INSERT INTO `refound_count` VALUES ('1', '2020-04-15', '5', '5');
INSERT INTO `refound_count` VALUES ('2', '2020-04-16', '0', '5');
INSERT INTO `refound_count` VALUES ('3', '2020-04-17', '0', '5');
INSERT INTO `refound_count` VALUES ('4', '2020-04-18', '0', '5');
INSERT INTO `refound_count` VALUES ('5', '2020-04-19', '0', '5');
INSERT INTO `refound_count` VALUES ('6', '2020-04-20', '1', '5');
INSERT INTO `refound_count` VALUES ('7', '2020-04-21', '1', '5');
INSERT INTO `refound_count` VALUES ('8', '2020-04-22', '0', '5');
INSERT INTO `refound_count` VALUES ('9', '2020-04-23', '1', '5');
INSERT INTO `refound_count` VALUES ('10', '2020-04-24', '2', '5');

-- ----------------------------
-- Table structure for `rewash`
-- ----------------------------
DROP TABLE IF EXISTS `rewash`;
CREATE TABLE `rewash` (
  `re_id` int(4) NOT NULL AUTO_INCREMENT,
  `clothes_id` int(10) DEFAULT NULL,
  `reason` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`re_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rewash
-- ----------------------------
INSERT INTO `rewash` VALUES ('1', '8', '洗什么东西，和没洗之前一样');
INSERT INTO `rewash` VALUES ('2', '10', '效果不好');
INSERT INTO `rewash` VALUES ('3', '8', '问我');
INSERT INTO `rewash` VALUES ('4', '1', '诶欧文恢复');

-- ----------------------------
-- Table structure for `rewash_count`
-- ----------------------------
DROP TABLE IF EXISTS `rewash_count`;
CREATE TABLE `rewash_count` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `curdate` varchar(32) DEFAULT NULL,
  `count` int(6) DEFAULT NULL,
  `user_id` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rewash_count
-- ----------------------------
INSERT INTO `rewash_count` VALUES ('1', '2020-04-15', '3', '5');
INSERT INTO `rewash_count` VALUES ('2', '2020-04-16', '0', '5');
INSERT INTO `rewash_count` VALUES ('3', '2020-04-17', '1', '5');
INSERT INTO `rewash_count` VALUES ('4', '2020-04-18', '2', '5');
INSERT INTO `rewash_count` VALUES ('5', '2020-04-19', '0', '5');
INSERT INTO `rewash_count` VALUES ('6', '2020-04-20', '1', '5');
INSERT INTO `rewash_count` VALUES ('7', '2020-04-21', '4', '5');
INSERT INTO `rewash_count` VALUES ('8', '2020-04-22', '0', '5');
INSERT INTO `rewash_count` VALUES ('9', '2020-04-23', '0', '5');
INSERT INTO `rewash_count` VALUES ('10', '2020-04-24', '0', '5');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `nameZh` varchar(64) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_manager', '店长');
INSERT INTO `role` VALUES ('2', 'ROLE_personnel', '员工');
INSERT INTO `role` VALUES ('6', 'ROLE_admin', '系统管理员');

-- ----------------------------
-- Table structure for `salarcount`
-- ----------------------------
DROP TABLE IF EXISTS `salarcount`;
CREATE TABLE `salarcount` (
  `datetime` varchar(255) NOT NULL,
  `salar` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salarcount
-- ----------------------------
INSERT INTO `salarcount` VALUES ('2020-04-11', '899');
INSERT INTO `salarcount` VALUES ('2020-04-12', '1099');
INSERT INTO `salarcount` VALUES ('2020-04-13', '3022');
INSERT INTO `salarcount` VALUES ('2020-04-14', '4432');
INSERT INTO `salarcount` VALUES ('2020-04-15', '3432');
INSERT INTO `salarcount` VALUES ('2020-04-16', '5454');
INSERT INTO `salarcount` VALUES ('2020-04-17', '5674');
INSERT INTO `salarcount` VALUES ('2020-04-18', '3456');
INSERT INTO `salarcount` VALUES ('2020-04-19', '5453');
INSERT INTO `salarcount` VALUES ('2020-04-20', '4444');

-- ----------------------------
-- Table structure for `salary`
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `basicSalary` int(11) DEFAULT NULL COMMENT '基本工资',
  `bonus` int(11) DEFAULT NULL COMMENT '奖金',
  `lunchSalary` int(11) DEFAULT NULL COMMENT '午餐补助',
  `trafficSalary` int(11) DEFAULT NULL COMMENT '交通补助',
  `allSalary` int(11) DEFAULT NULL COMMENT '应发工资',
  `pensionBase` int(11) DEFAULT NULL COMMENT '养老金基数',
  `pensionPer` float DEFAULT NULL COMMENT '养老金比率',
  `createDate` timestamp NULL DEFAULT NULL COMMENT '启用时间',
  `medicalBase` int(11) DEFAULT NULL COMMENT '医疗基数',
  `medicalPer` float DEFAULT NULL COMMENT '医疗保险比率',
  `accumulationFundBase` int(11) DEFAULT NULL COMMENT '公积金基数',
  `accumulationFundPer` float DEFAULT NULL COMMENT '公积金比率',
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES ('9', '9000', '4000', '700', '500', '14200', '2000', '0.07', '2018-01-24 00:00:00', '2000', '0.07', '2000', '0.07', '江南一点雨3');
INSERT INTO `salary` VALUES ('10', '2000', '2000', '500', '1000', '5500', '2000', '0.07', '2018-01-01 00:00:00', '2000', '0.07', '2000', '0.07', '张黎明');
INSERT INTO `salary` VALUES ('13', '20000', '3000', '500', '600', '24100', '4000', '0.07', '2018-01-25 00:00:00', '4000', '0.07', '4000', '0.07', '贾旭明');
INSERT INTO `salary` VALUES ('16', '5600', '256', '500', '1000', '7356', '2000', '0.07', '2020-03-28 09:53:05', '2000', '0.07', null, null, '赵琳浩');

-- ----------------------------
-- Table structure for `sysmsg`
-- ----------------------------
DROP TABLE IF EXISTS `sysmsg`;
CREATE TABLE `sysmsg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL COMMENT '消息id',
  `type` int(11) DEFAULT '0' COMMENT '0表示群发消息',
  `hrid` int(11) DEFAULT NULL COMMENT '这条消息是给谁的',
  `state` int(11) DEFAULT '0' COMMENT '0 未读 1 已读',
  PRIMARY KEY (`id`),
  KEY `hrid` (`hrid`),
  KEY `sysmsg_ibfk_1` (`mid`),
  CONSTRAINT `sysmsg_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `msgcontent` (`id`),
  CONSTRAINT `sysmsg_ibfk_2` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysmsg
-- ----------------------------
INSERT INTO `sysmsg` VALUES ('57', '14', '0', '3', '1');
INSERT INTO `sysmsg` VALUES ('58', '14', '0', '5', '1');
INSERT INTO `sysmsg` VALUES ('59', '14', '0', '10', '1');
INSERT INTO `sysmsg` VALUES ('60', '14', '0', '11', '0');
INSERT INTO `sysmsg` VALUES ('61', '14', '0', '12', '0');
INSERT INTO `sysmsg` VALUES ('62', '15', '0', '3', '1');
INSERT INTO `sysmsg` VALUES ('63', '15', '0', '5', '1');
INSERT INTO `sysmsg` VALUES ('64', '15', '0', '10', '1');
INSERT INTO `sysmsg` VALUES ('65', '15', '0', '11', '0');
INSERT INTO `sysmsg` VALUES ('66', '15', '0', '12', '0');
INSERT INTO `sysmsg` VALUES ('67', '16', '0', '3', '1');
INSERT INTO `sysmsg` VALUES ('68', '16', '0', '5', '1');
INSERT INTO `sysmsg` VALUES ('69', '16', '0', '10', '1');
INSERT INTO `sysmsg` VALUES ('70', '16', '0', '11', '0');
INSERT INTO `sysmsg` VALUES ('71', '16', '0', '12', '0');
INSERT INTO `sysmsg` VALUES ('72', '17', '0', '3', '1');
INSERT INTO `sysmsg` VALUES ('73', '17', '0', '5', '1');
INSERT INTO `sysmsg` VALUES ('74', '17', '0', '10', '1');
INSERT INTO `sysmsg` VALUES ('75', '17', '0', '11', '0');
INSERT INTO `sysmsg` VALUES ('76', '17', '0', '12', '0');
INSERT INTO `sysmsg` VALUES ('77', '18', '0', '3', '1');
INSERT INTO `sysmsg` VALUES ('78', '18', '0', '5', '0');
INSERT INTO `sysmsg` VALUES ('79', '18', '0', '10', '0');
INSERT INTO `sysmsg` VALUES ('80', '18', '0', '11', '0');
INSERT INTO `sysmsg` VALUES ('81', '18', '0', '12', '0');

-- ----------------------------
-- Table structure for `take_clothes`
-- ----------------------------
DROP TABLE IF EXISTS `take_clothes`;
CREATE TABLE `take_clothes` (
  `take_id` int(4) NOT NULL AUTO_INCREMENT,
  `clothes_id` int(10) DEFAULT NULL,
  `take_time` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`take_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of take_clothes
-- ----------------------------
INSERT INTO `take_clothes` VALUES ('1', '12', '2020-04-23 13:22:58');
INSERT INTO `take_clothes` VALUES ('2', '11', '2020-04-23 13:33:32');

-- ----------------------------
-- Table structure for `take_clothes_count`
-- ----------------------------
DROP TABLE IF EXISTS `take_clothes_count`;
CREATE TABLE `take_clothes_count` (
  `take_id` int(5) NOT NULL AUTO_INCREMENT,
  `take_date` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `take_count` int(5) DEFAULT NULL,
  `user_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`take_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of take_clothes_count
-- ----------------------------
INSERT INTO `take_clothes_count` VALUES ('1', '2020-04-15', '30', '5');
INSERT INTO `take_clothes_count` VALUES ('2', '2020-04-16', '50', '5');
INSERT INTO `take_clothes_count` VALUES ('3', '2020-04-17', '12', '5');
INSERT INTO `take_clothes_count` VALUES ('4', '2020-04-18', '15', '5');
INSERT INTO `take_clothes_count` VALUES ('5', '2020-04-19', '23', '5');
INSERT INTO `take_clothes_count` VALUES ('6', '2020-04-20', '54', '5');
INSERT INTO `take_clothes_count` VALUES ('7', '2020-04-21', '49', '5');
INSERT INTO `take_clothes_count` VALUES ('8', '2020-04-22', '89', '5');
INSERT INTO `take_clothes_count` VALUES ('9', '2020-04-23', '51', '5');
INSERT INTO `take_clothes_count` VALUES ('10', '2020-04-24', '53', '5');

-- ----------------------------
-- Table structure for `topup`
-- ----------------------------
DROP TABLE IF EXISTS `topup`;
CREATE TABLE `topup` (
  `topup_id` int(5) NOT NULL AUTO_INCREMENT,
  `topup_time` varchar(255) DEFAULT NULL,
  `topup_money` double(50,2) DEFAULT NULL,
  `cus_id` int(5) DEFAULT NULL,
  `member_id` int(5) DEFAULT NULL,
  `user_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`topup_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topup
-- ----------------------------
INSERT INTO `topup` VALUES ('1', '2020-04-08', '1.00', '1', '1', '5');
INSERT INTO `topup` VALUES ('2', '2020-04-21 22:29:27', '1000.00', '4', '6', '5');
INSERT INTO `topup` VALUES ('3', '2020-04-21 22:51:30', '200.00', '5', '7', '5');
INSERT INTO `topup` VALUES ('4', '2020-04-21 22:52:00', '100.00', '1', '1', '5');
INSERT INTO `topup` VALUES ('5', '2020-04-21 22:52:26', '300.00', '3', '5', '5');
INSERT INTO `topup` VALUES ('6', '2020-04-21 22:53:30', '100.00', '2', '4', '5');
INSERT INTO `topup` VALUES ('7', '2020-04-21 22:53:34', '100.00', '2', '4', '5');
INSERT INTO `topup` VALUES ('8', '2020-04-21 22:53:38', '100.00', '2', '4', '5');
INSERT INTO `topup` VALUES ('9', '2020-04-21 22:55:40', '100.00', '2', '4', '5');
INSERT INTO `topup` VALUES ('10', '2020-04-21 22:58:29', '100.00', '2', '4', '5');
INSERT INTO `topup` VALUES ('11', '2020-04-21 22:58:33', '100.00', '2', '4', '5');
INSERT INTO `topup` VALUES ('12', '2020-04-21 22:58:48', '100.00', '2', '4', '5');
INSERT INTO `topup` VALUES ('13', '2020-04-21 22:59:27', '100.00', '1', '1', '5');
INSERT INTO `topup` VALUES ('14', '2020-04-21 23:00:50', '100.00', '1', '1', '5');
INSERT INTO `topup` VALUES ('15', '2020-04-21 23:01:04', '100.00', '1', '1', '5');
INSERT INTO `topup` VALUES ('16', '2020-04-21 23:05:29', '100.00', '1', '1', '5');
INSERT INTO `topup` VALUES ('17', '2020-04-21 23:33:20', '100.00', '1', '1', '5');
INSERT INTO `topup` VALUES ('18', '2020-04-21 23:34:49', '100.00', '1', '1', '5');
INSERT INTO `topup` VALUES ('19', '2020-04-21 23:44:17', '100.00', '1', '1', '5');
INSERT INTO `topup` VALUES ('20', '2020-04-22 18:03:15', '300.00', '3', '5', '5');
INSERT INTO `topup` VALUES ('21', '2020-04-22 18:08:14', '100.00', '2', '4', '5');
INSERT INTO `topup` VALUES ('22', '2020-04-22 18:11:34', '100.00', '2', '4', '5');
INSERT INTO `topup` VALUES ('23', '2020-04-22 23:01:03', '100.00', '2', '4', '5');
INSERT INTO `topup` VALUES ('24', '2020-04-23 09:12:59', '300.00', '1', '1', '5');
INSERT INTO `topup` VALUES ('25', '2020-04-24 16:45:21', '200.00', '4', '6', '5');
INSERT INTO `topup` VALUES ('26', '2020-04-26 17:48:37', '100.00', '2', '4', '5');
INSERT INTO `topup` VALUES ('27', '2020-05-13 20:15:29', '300.00', null, '1', '5');

-- ----------------------------
-- Table structure for `turnover`
-- ----------------------------
DROP TABLE IF EXISTS `turnover`;
CREATE TABLE `turnover` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `currdate` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `count` int(5) DEFAULT NULL,
  `user_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of turnover
-- ----------------------------
INSERT INTO `turnover` VALUES ('1', '2020-04-15', '30', '5');
INSERT INTO `turnover` VALUES ('2', '2020-04-16', '50', '10');
INSERT INTO `turnover` VALUES ('3', '2020-04-17', '12', '11');
INSERT INTO `turnover` VALUES ('4', '2020-04-18', '15', '12');
INSERT INTO `turnover` VALUES ('5', '2020-04-19', '23', '5');
INSERT INTO `turnover` VALUES ('6', '2020-04-20', '54', '10');
INSERT INTO `turnover` VALUES ('7', '2020-04-21', '49', '11');
INSERT INTO `turnover` VALUES ('8', '2020-04-22', '89', '12');
INSERT INTO `turnover` VALUES ('9', '2020-04-23', '51', '5');
INSERT INTO `turnover` VALUES ('10', '2020-04-24', '53', '10');
INSERT INTO `turnover` VALUES ('11', '2020-04-24', '34', '5');
INSERT INTO `turnover` VALUES ('12', '2020-04-24', '35', '12');
INSERT INTO `turnover` VALUES ('13', '2020-04-24', '12', '11');
INSERT INTO `turnover` VALUES ('14', '2020-04-24', '34', '10');
INSERT INTO `turnover` VALUES ('15', '2020-04-24', '90', '11');
INSERT INTO `turnover` VALUES ('16', '2020-04-24', '56', '12');
INSERT INTO `turnover` VALUES ('17', '2020-04-15', '42', '3');
INSERT INTO `turnover` VALUES ('18', '2020-04-16', '57', '3');
INSERT INTO `turnover` VALUES ('19', '2020-04-17', '78', '3');
INSERT INTO `turnover` VALUES ('20', '2020-04-24', '108', '3');
INSERT INTO `turnover` VALUES ('21', '2020-04-21', '567', '3');

-- ----------------------------
-- Procedure structure for `addDep`
-- ----------------------------
DROP PROCEDURE IF EXISTS `addDep`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addDep`(in depName varchar(32),in parentId int,in enabled boolean,out result int,out result2 int)
begin
  declare did int;
  declare pDepPath varchar(64);
  insert into department set name=depName,parentId=parentId,enabled=enabled;
  select row_count() into result;
  select last_insert_id() into did;
  set result2=did;
  select depPath into pDepPath from department where id=parentId;
  update department set depPath=concat(pDepPath,'.',did) where id=did;
  update department set isParent=true where id=parentId;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `deleteDep`
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteDep`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDep`(in did int,out result int)
begin
  declare ecount int;
  declare pid int;
  declare pcount int;
  declare a int;
  select count(*) into a from department where id=did and isParent=false;
  if a=0 then set result=-2;
  else
  select count(*) into ecount from employee where departmentId=did;
  if ecount>0 then set result=-1;
  else 
  select parentId into pid from department where id=did;
  delete from department where id=did and isParent=false;
  select row_count() into result;
  select count(*) into pcount from department where parentId=pid;
  if pcount=0 then update department set isParent=false where id=pid;
  end if;
  end if;
  end if;
end
;;
DELIMITER ;
