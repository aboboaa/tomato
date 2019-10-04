/*
SQLyog Professional v12.08 (64 bit)
MySQL - 8.0.15 : Database - xhs_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xhs_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xhs_db`;

/*Table structure for table `plate` */

DROP TABLE IF EXISTS `plate`;

CREATE TABLE `plate` (
  `pl_id` int(20) NOT NULL AUTO_INCREMENT,
  `pl_name` varchar(20) NOT NULL,
  `attr1` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `plate` */

/*Table structure for table `post` */

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `post_id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `p_content` varchar(10000) NOT NULL,
  `user_id` int(20) NOT NULL,
  `time` datetime DEFAULT NULL,
  `p_click_count` int(20) DEFAULT NULL,
  `pl_id` int(20) DEFAULT NULL,
  `attr1` varchar(50) DEFAULT NULL,
  `attr2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `post` */

insert  into `post`(`post_id`,`title`,`p_content`,`user_id`,`time`,`p_click_count`,`pl_id`,`attr1`,`attr2`) values (1,'帖子标题1','rewrrwet',1,'2019-10-04 06:01:29',0,NULL,NULL,NULL),(2,'帖子标题2','帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容',1,'2019-10-04 06:03:42',0,NULL,NULL,NULL),(3,'帖子标题3','帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容',3,'2019-10-04 06:21:05',0,NULL,NULL,NULL),(4,'帖子标题4','帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容帖子内容',2,'2019-10-04 15:02:41',0,NULL,NULL,NULL);

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `reply_id` int(20) NOT NULL AUTO_INCREMENT,
  `r_content` varchar(10000) NOT NULL,
  `user_id` int(20) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `post_id` int(20) DEFAULT NULL,
  `p_click_count` int(20) DEFAULT NULL,
  `attr1` varchar(30) DEFAULT NULL,
  `attr2` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `reply` */

insert  into `reply`(`reply_id`,`r_content`,`user_id`,`time`,`post_id`,`p_click_count`,`attr1`,`attr2`) values (1,'retery',1,'2019-10-04',2,NULL,NULL,NULL),(2,'erter',1,'2019-10-04',2,NULL,NULL,NULL),(3,'kreutgyhtgerayh',3,'2019-10-04',3,NULL,NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_paswd` varchar(20) NOT NULL,
  `user_email` varchar(30) DEFAULT NULL,
  `user_pho` varchar(11) DEFAULT NULL,
  `user_sex` int(1) DEFAULT NULL,
  `user_brid` date DEFAULT NULL,
  `user_adr` varchar(40) DEFAULT NULL,
  `captcha` varchar(10) DEFAULT NULL,
  `attr1` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_paswd`,`user_email`,`user_pho`,`user_sex`,`user_brid`,`user_adr`,`captcha`,`attr1`) values (1,'abobo','123456','1774286865@qq.com','18125897601',NULL,NULL,NULL,NULL,NULL),(2,'lisi','12345678',NULL,'123456',NULL,NULL,NULL,NULL,NULL),(3,'谢汉城','123',NULL,'13690058074',NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
