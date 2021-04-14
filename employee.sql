-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: employee
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `advantage`
--

DROP TABLE IF EXISTS `advantage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `advantage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_15mxuyekf3cgulvsu3psvnlsx` (`userid`),
  CONSTRAINT `FK_15mxuyekf3cgulvsu3psvnlsx` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advantage`
--

LOCK TABLES `advantage` WRITE;
/*!40000 ALTER TABLE `advantage` DISABLE KEYS */;
INSERT INTO `advantage` VALUES (14,'Football',24),(15,'Volleyball',24);
/*!40000 ALTER TABLE `advantage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'EMPLOYEE'),(9,'MANAGER'),(10,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `namemanager` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'DG5','Duy Nguyen',5),(2,'DG3','Duy Nguyen',4);
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technical`
--

DROP TABLE IF EXISTS `technical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technical` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `level` varchar(255) DEFAULT NULL,
  `skill` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_suxqft3ewv13tqbl19fuuk69` (`userid`),
  CONSTRAINT `FK_suxqft3ewv13tqbl19fuuk69` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technical`
--

LOCK TABLES `technical` WRITE;
/*!40000 ALTER TABLE `technical` DISABLE KEYS */;
INSERT INTO `technical` VALUES (34,'Junior','Java',24),(35,'Junior','C#',24),(36,'Junior','C++',24);
/*!40000 ALTER TABLE `technical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` varchar(255) DEFAULT NULL,
  `daystart` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `roleId` bigint(20) DEFAULT NULL,
  `teamId` bigint(20) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ao5g1e3yutsfcfv8pp9ym93c2` (`roleId`),
  KEY `FK_5yl5on2fylrkb4vq06srebk17` (`teamId`),
  CONSTRAINT `FK_5yl5on2fylrkb4vq06srebk17` FOREIGN KEY (`teamId`) REFERENCES `team` (`id`),
  CONSTRAINT `FK_ao5g1e3yutsfcfv8pp9ym93c2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (24,'22','2021-02-21T17:00:00.000Z','buiduythanh24399@gmail.com','Thanh Bui','CauUt','5D5277DE896FEAD437A5422C242C2693','My name is Thanh Bui, i from Quang Ngai',0,1,10,1,'default.png'),(25,'23','2021-02-21T17:00:00.000Z','duynguyen@gmail.com','Duy Nguyen','Duy','E10ADC3949BA59ABBE56E057F20F883E','<p>not</p>\n',0,1,9,1,'default.png'),(29,'22','2021-09-12T17:00:00.000Z','quynguyen@gmail.com','Quy Nguyen','Quy Nguyen','E10ADC3949BA59ABBE56E057F20F883E','<p>not</p>\n',0,1,9,2,'quynguyen.png'),(30,'5','2021-04-06T17:00:00.000Z','ngasd@gmail.com','Duy Nguyen','Duy','E10ADC3949BA59ABBE56E057F20F883E','<p>My name is Quy Nguyen, i from Quang Ngai City. However, i have had best friend Hung. He is simp&nbsp;boy.</p>\n',0,1,1,2,'default.png'),(31,'22','2022-02-07T17:00:00.000Z','phamhongnghia02468@gmail.com','Nghia Pham','Nghia','8B3428B8214BC104881F4AA6403B76E2','<p>not</p>\n',0,1,10,1,'default.png'),(32,'23','2021-04-04T17:00:00.000Z','quy@gmail.cfom','Duy Nguyen','Duy','F3AE1E93F5F0671E75AE22CB07AA41C2','<p>not</p>\n',1,1,1,1,'default.png'),(33,'23','2021-04-11T17:00:00.000Z','duynguyen@gmail.com','Thanh','Duy','E10ADC3949BA59ABBE56E057F20F883E','<p>not</p>\n',1,0,1,2,'default.png'),(34,'23','2021-03-31T17:00:00.000Z','duynguyen@gmail.com','Duy Nguyen','Duy','E10ADC3949BA59ABBE56E057F20F883E','not',1,1,10,NULL,'default.png'),(35,'24','2021-09-13T17:00:00.000Z','duynguyen@gmail.com','Quy Nguyen','Duy','25D55AD283AA400AF464C76D713C07AD','not',1,1,9,NULL,'default.png');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-14 17:39:24
