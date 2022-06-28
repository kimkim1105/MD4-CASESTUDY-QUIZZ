-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: quizz
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL DEFAULT b'0',
  `question_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3erw1a3t0r78st8ty27x6v3g1` (`question_id`)
) ENGINE=MyISAM AUTO_INCREMENT=216 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES (1,'instanceBean()',_binary '\0',1),(2,'instanceBean()',_binary '\0',1),(3,'instanceBean()',_binary '\0',1),(4,'getBean()',_binary '',1),(5,' Spring MVC khởi tạo các lớp controller và gắn các bean với các đầu vào của người dùng',_binary '\0',2),(6,'Tất cả',_binary '',2),(7,'Spring MVC sử dụng tệp cấu hình dựa trên XML mà bạn có thể chỉnh sửa mà không cần biên dịch lại ứng dụng',_binary '\0',2),(8,'Spring MVC cung cấp một trình điều phối, lưu bản ghi của bạn',_binary '\0',2),(9,'ViewRequest',_binary '\0',3),(10,'Tất cả',_binary '\0',3),(11,'ViewResponse',_binary '\0',3),(12,'ViewResolver',_binary '',3),(17,' Tất cả các đáp án trên đúng',_binary '\0',5),(18,'không cần sử dụng SQL thuần',_binary '\0',5),(19,'Tránh được các lỗi cú pháp SQL',_binary '',5),(20,'hiệu năng truy xuất dữ liệu cao, không bị hạn chế',_binary '\0',5),(21,'Hiệu năng truy xuất dữ liệu không bị hạn chế',_binary '\0',4),(22,'Có thể cache dữ liệu để truy xuất nhanh hơn',_binary '',4),(23,'Các thao tác với dữ liệu được thực hiện tự động',_binary '',4),(24,'Quản lý dữ liệu tập trung trong code',_binary '',4),(186,'Java Persistent API',_binary '\0',125),(187,'Java Persistence Application',_binary '\0',125),(188,' Java Persistence API',_binary '\0',125),(189,' Java Persistent Application',_binary '\0',125),(190,'@GeneratedValue',_binary '',126),(191,'@ID',_binary '\0',126),(192,'@Generator',_binary '\0',126),(193,'@Unique',_binary '\0',126),(194,'Hibernate',_binary '\0',127),(195,'Ibatis',_binary '\0',127),(196,'Toplink ',_binary '\0',127),(197,' All of them',_binary '',127),(198,'asdfsfd',_binary '\0',128),(199,'asdfweee',_binary '\0',128),(200,'adsffsg',_binary '',128),(201,'1432',_binary '\0',128),(212,'asdfs',_binary '\0',133),(213,'q3234234',_binary '\0',133),(214,'q2r2r23',_binary '\0',133),(215,'afsfsdf',_binary '',133);
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'SPRING'),(2,'DATA'),(3,'JWT');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `levels`
--

DROP TABLE IF EXISTS `levels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `levels` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `levels`
--

LOCK TABLES `levels` WRITE;
/*!40000 ALTER TABLE `levels` DISABLE KEYS */;
INSERT INTO `levels` VALUES (1,'Dễ'),(2,'Trung bình'),(3,'Khó');
/*!40000 ALTER TABLE `levels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `category_id` bigint NOT NULL,
  `level_id` bigint NOT NULL,
  `type_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKctl6tuf74n8cufkb3ulj6b3fc` (`category_id`),
  KEY `FKd1eetxmrbe1x2sjff43j4qyp0` (`level_id`),
  KEY `FK8rbvul8iw10ue6243135sfl2` (`type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=134 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'Cái nào sau đây là tính năng của Spring MVC ?',1,3,1),(2,'Cái nào sau đây là tính năng của Spring MVC ?',1,1,1),(3,'Đâu là bộ phận quyết định xem Front Controller sẽ trả về View thực tế nào ?',1,1,1),(5,'Phát biểu nào đúng về ưu điểm của ORM',2,1,1),(4,'Phát biểu nào sau đây đúng khi sử dụng ORM',2,2,2),(125,'JPA là viết tắt của cụm từ gì?',2,1,1),(126,'Annotation nào sau đây được dùng để tạo giá trị duy nhất cho ID ',2,3,1),(127,'JPA implementation được cung cấp bởi .....?',2,2,1),(128,'Phát biểu sau đúng hay sai?  JPA là một interface trong khi Hibernate là implementation',2,2,1),(133,'afsdfasdfasdfafsd',1,1,1);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `updateAnswerIfQuestionNotExists` AFTER DELETE ON `questions` FOR EACH ROW begin
    delete from answers 
    where question_id = old.id;
    end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `result_answer`
--

DROP TABLE IF EXISTS `result_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result_answer` (
  `result_id` bigint NOT NULL,
  `answer_id` bigint NOT NULL,
  KEY `FK7ruri99poxtj42wvj26gwkt65` (`answer_id`),
  KEY `FKdxycjvpxcpfacsjq8jaawcikv` (`result_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result_answer`
--

LOCK TABLES `result_answer` WRITE;
/*!40000 ALTER TABLE `result_answer` DISABLE KEYS */;
INSERT INTO `result_answer` VALUES (1,1),(1,6),(1,10),(1,23),(1,24),(2,0),(2,0),(2,19),(3,4),(3,6),(3,11),(3,22),(3,23),(3,24),(4,12),(4,6),(4,1),(5,12),(5,6),(5,1),(6,1),(6,6),(6,12),(7,4),(7,6),(7,12),(8,4),(8,6),(8,10),(9,4),(9,6),(9,10),(34,4),(34,10),(34,6),(48,6),(48,19),(48,12),(49,6),(49,12),(49,4),(50,1),(50,10),(50,6),(51,19),(51,12),(51,6),(52,6),(52,19),(52,12),(53,12),(53,6),(53,19),(54,12),(54,19),(54,6),(55,12),(55,6),(55,19),(56,19),(56,12),(56,6),(57,19),(57,6),(57,12),(58,19),(58,6),(58,12),(59,9),(59,6),(59,4),(60,6),(60,9),(60,4),(61,6),(61,12),(61,19),(62,12),(62,19),(62,6),(63,9),(63,4),(63,6),(64,12),(64,19),(64,6),(65,12),(65,6),(65,19),(66,6),(66,10),(66,19),(67,197),(67,190),(67,12),(67,19),(67,23),(67,22),(67,21),(68,6),(68,4),(68,12),(69,6),(69,11),(69,4),(70,4),(70,6),(70,12),(71,11),(71,6),(71,4),(72,12),(72,6),(72,4),(73,4),(73,6),(73,12),(74,12),(74,6),(74,4),(75,6),(75,12),(75,4),(76,6),(76,4),(76,12),(77,12),(77,4),(77,6),(78,6),(78,3),(78,12),(79,10),(79,6),(79,4),(80,2),(80,6),(80,9),(81,4),(81,11),(81,6),(82,4),(82,12),(82,6),(83,10),(83,4),(83,6),(84,6),(84,4),(84,12),(85,6),(85,12),(85,4),(86,6),(86,4),(86,10),(87,6),(87,4),(87,12),(88,6),(88,12),(88,4),(89,6),(89,12),(89,4),(90,12),(90,4),(90,6),(91,12),(91,6),(91,4),(92,4),(92,12),(92,6),(93,4),(93,12),(93,6),(94,12),(94,6),(94,4),(95,12),(95,4),(95,6),(96,12),(96,6),(96,4),(97,6),(97,12),(97,4),(98,4),(98,12),(98,6),(99,6),(99,4),(99,12),(100,4),(100,6),(100,12),(101,4),(101,6),(101,12),(102,4),(102,12),(102,6),(103,6),(103,12),(103,4),(104,12),(104,4),(104,6),(105,4),(105,6),(105,12),(106,6),(106,12),(106,4),(107,12),(107,6),(107,4),(108,4),(108,12),(108,6),(109,12),(109,6),(109,4),(110,4),(110,12),(110,6),(111,6),(111,12),(111,4),(112,12),(112,6),(112,4),(113,4),(113,6),(113,12),(114,6),(114,12),(114,4),(115,12),(115,4),(115,6),(116,4),(116,12),(116,6),(117,6),(117,4),(117,12),(118,12),(118,6),(118,4),(119,4),(119,6),(119,12),(120,4),(120,12),(120,6),(121,12),(121,4),(121,6),(122,6),(122,4),(122,12),(123,6),(123,12),(123,4),(125,6),(125,4),(125,12),(126,4),(126,12),(126,6),(127,4),(127,12),(127,6),(132,6),(132,12),(132,4),(134,4),(134,10),(134,6),(135,12),(135,4),(136,6),(136,12),(137,12),(137,6),(137,4),(138,6),(138,4),(140,4),(141,4),(142,12),(143,6),(144,6),(145,4),(146,6),(147,6),(148,4),(149,12),(149,4),(150,6),(150,10),(150,4),(151,4),(151,6),(151,12),(152,2),(152,6),(152,12),(153,12),(154,10),(155,4),(156,12),(156,6),(156,2),(157,12),(157,6),(157,2),(158,2),(158,6),(158,12),(159,12),(160,4),(160,12),(161,6),(161,4),(161,12),(162,6),(162,12),(162,4),(163,12),(163,6),(163,4),(164,4),(164,6),(164,12),(165,4),(165,6),(165,12),(166,12),(166,4),(166,8),(167,4),(167,6),(167,12),(168,4),(168,6),(168,12),(169,4),(169,6),(169,10),(170,4),(170,12),(170,6),(171,6),(171,12),(171,4),(172,12),(172,6),(172,4),(173,6),(173,4),(173,12),(174,12),(174,4),(174,6),(175,12),(175,4),(175,6),(176,12),(176,6),(176,4),(177,6),(177,4),(177,12),(178,4),(178,6),(178,12),(179,6),(179,4),(179,12),(180,4),(180,12),(180,6),(181,4),(181,6),(181,12),(182,4),(182,12),(182,6),(183,6),(183,4),(183,12),(184,6),(184,12),(184,4),(185,4),(185,6),(185,10),(186,12),(186,6),(186,4),(187,4),(187,6),(187,10),(188,12),(188,6),(188,2),(189,4),(189,12),(189,8),(190,6),(190,10),(190,4),(191,6),(191,4),(191,12),(192,5),(192,4),(192,12),(193,10),(193,4),(193,6),(194,4),(194,6),(194,12),(195,4),(195,12),(195,6),(196,12),(196,3),(196,6),(197,4),(197,12),(197,6),(198,6),(198,12),(198,4),(199,6),(199,12),(199,4),(200,4),(200,6),(200,12),(201,4),(201,6),(201,12),(202,6),(202,2),(202,10),(203,4),(203,6),(203,12),(204,6),(204,3),(205,9),(205,4),(205,6),(206,10),(206,6),(206,4);
/*!40000 ALTER TABLE `result_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `results` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `mark` int DEFAULT NULL,
  `test_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe9uvk96os1lxpp8pf93p13lmv` (`test_id`),
  KEY `FKxtl9ahma532if6r68yvgo7ck` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=207 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
INSERT INTO `results` VALUES (1,0,1,1,NULL),(2,0,2,1,NULL),(3,0,1,1,NULL),(4,0,1,1,'2022-06-26 00:16:19'),(5,0,1,1,'2022-06-26 00:17:45'),(6,2,1,1,'2022-06-26 00:20:13'),(7,3,1,1,'2022-06-26 00:23:38'),(8,2,1,1,'2022-06-26 00:29:39'),(9,2,1,1,'2022-06-26 01:22:23'),(30,-3,2,1,'2022-06-26 10:44:28'),(38,-3,2,1,'2022-06-26 10:56:44'),(32,-3,2,1,'2022-06-26 10:45:28'),(33,-3,2,1,'2022-06-26 10:45:43'),(34,2,1,1,'2022-06-26 10:48:16'),(40,-3,2,1,'2022-06-26 11:09:35'),(35,0,2,1,NULL),(36,-2,2,1,'2022-06-26 10:54:42'),(37,-3,2,1,'2022-06-26 10:55:33'),(31,-3,2,1,'2022-06-26 10:45:06'),(39,-3,2,1,'2022-06-26 11:07:47'),(41,-3,2,1,'2022-06-26 11:11:02'),(42,-3,2,1,'2022-06-26 11:12:28'),(43,-3,2,1,'2022-06-26 11:13:30'),(44,-3,2,1,'2022-06-26 11:17:19'),(45,-3,2,1,'2022-06-26 11:42:42'),(46,-3,2,1,'2022-06-26 11:44:52'),(47,-3,2,1,'2022-06-26 11:52:58'),(48,3,2,1,'2022-06-26 12:00:38'),(49,3,1,1,'2022-06-26 12:04:01'),(50,1,1,1,'2022-06-26 12:04:46'),(51,3,2,1,'2022-06-26 15:05:24'),(52,3,2,1,'2022-06-26 15:06:27'),(53,3,2,1,'2022-06-26 15:08:19'),(54,3,2,1,'2022-06-26 15:09:07'),(55,3,2,1,'2022-06-26 15:09:28'),(56,3,2,1,'2022-06-26 15:09:58'),(57,3,2,1,'2022-06-26 15:10:26'),(58,3,2,1,'2022-06-26 15:42:22'),(59,2,1,1,'2022-06-26 15:53:27'),(60,2,1,1,'2022-06-26 15:54:15'),(61,3,2,1,'2022-06-26 15:54:45'),(62,3,2,1,'2022-06-26 15:55:59'),(63,2,1,1,'2022-06-26 15:58:34'),(64,3,2,1,'2022-06-26 16:17:53'),(65,3,2,1,'2022-06-26 16:17:54'),(66,2,2,1,'2022-06-26 16:18:15'),(67,6,5,1,'2022-06-26 23:20:37'),(68,3,1,1,'2022-06-26 23:52:06'),(69,2,1,1,'2022-06-26 23:54:06'),(70,3,1,1,'2022-06-26 23:54:51'),(71,2,1,1,'2022-06-27 00:03:48'),(72,3,1,1,'2022-06-27 00:07:53'),(73,3,1,1,'2022-06-27 00:09:09'),(74,3,1,1,'2022-06-27 00:10:24'),(75,3,1,1,'2022-06-27 00:16:35'),(76,3,1,1,'2022-06-27 00:18:24'),(77,3,1,1,'2022-06-27 00:22:21'),(78,2,1,1,'2022-06-27 00:24:00'),(79,2,1,1,'2022-06-27 00:27:53'),(80,1,1,1,'2022-06-27 00:28:30'),(81,2,1,1,'2022-06-27 00:29:42'),(82,3,1,1,'2022-06-27 00:30:57'),(83,2,1,1,'2022-06-27 00:33:06'),(84,3,1,1,'2022-06-27 00:34:25'),(85,3,1,1,'2022-06-27 00:36:17'),(86,2,1,1,'2022-06-27 00:37:04'),(87,3,1,1,'2022-06-27 00:37:28'),(88,3,1,1,'2022-06-27 00:38:13'),(89,3,1,1,'2022-06-27 00:54:37'),(90,3,1,1,'2022-06-27 00:55:32'),(91,3,1,1,'2022-06-27 00:56:04'),(92,3,1,1,'2022-06-27 00:56:47'),(93,3,1,1,'2022-06-27 00:58:33'),(94,3,1,1,'2022-06-27 01:05:16'),(95,3,1,1,'2022-06-27 01:18:01'),(96,3,1,1,'2022-06-27 01:18:33'),(97,3,1,1,'2022-06-27 01:21:08'),(98,3,1,1,'2022-06-27 01:21:56'),(99,3,1,1,'2022-06-27 01:25:25'),(100,3,1,1,'2022-06-27 01:26:53'),(101,3,1,1,'2022-06-27 01:32:39'),(102,3,1,1,'2022-06-27 01:33:12'),(103,3,1,1,'2022-06-27 01:34:53'),(104,3,1,1,'2022-06-27 01:38:52'),(105,3,1,1,'2022-06-27 01:39:48'),(106,3,1,1,'2022-06-27 01:40:06'),(107,3,1,1,'2022-06-27 01:41:58'),(108,3,1,1,'2022-06-27 01:44:33'),(109,3,1,1,'2022-06-27 01:44:58'),(110,3,1,1,'2022-06-27 01:45:24'),(111,3,1,1,'2022-06-27 01:45:56'),(112,3,1,1,'2022-06-27 01:46:32'),(113,3,1,1,'2022-06-27 01:47:15'),(114,3,1,1,'2022-06-27 01:48:17'),(115,3,1,1,'2022-06-27 01:50:01'),(116,3,1,1,'2022-06-27 01:50:39'),(117,3,1,1,'2022-06-27 01:51:13'),(118,3,1,1,'2022-06-27 01:51:35'),(119,3,1,1,'2022-06-27 01:52:04'),(120,3,1,1,'2022-06-27 01:52:56'),(121,3,1,1,'2022-06-27 01:54:12'),(122,3,1,1,'2022-06-27 01:54:28'),(123,3,1,1,'2022-06-27 01:55:14'),(124,-3,1,1,'2022-06-27 01:55:18'),(125,3,1,1,'2022-06-27 01:58:08'),(126,3,1,1,'2022-06-27 01:59:00'),(127,3,1,1,'2022-06-27 02:00:23'),(128,0,1,1,'2022-06-27 10:02:01'),(129,0,1,1,'2022-06-27 10:03:36'),(130,0,1,1,'2022-06-27 10:04:19'),(131,0,1,1,'2022-06-27 10:04:31'),(132,3,1,1,'2022-06-27 12:28:34'),(133,0,1,1,'2022-06-27 12:28:41'),(134,2,1,1,'2022-06-27 12:28:52'),(135,1,1,1,'2022-06-27 12:28:59'),(136,1,1,1,'2022-06-27 12:29:13'),(137,3,1,1,'2022-06-27 12:29:32'),(138,1,1,1,'2022-06-27 12:29:42'),(139,0,1,1,'2022-06-27 12:30:11'),(140,0,1,1,'2022-06-27 12:30:22'),(141,0,1,1,'2022-06-27 12:30:23'),(142,0,1,1,'2022-06-27 12:32:00'),(143,0,1,1,'2022-06-27 12:32:29'),(144,0,1,1,'2022-06-27 12:32:31'),(145,0,1,1,'2022-06-27 12:33:55'),(146,0,1,1,'2022-06-27 12:34:38'),(147,0,1,1,'2022-06-27 12:34:56'),(148,0,1,1,'2022-06-27 12:35:07'),(149,0,1,1,'2022-06-27 12:36:02'),(150,0,1,1,'2022-06-27 12:36:13'),(151,0,1,1,'2022-06-27 12:37:25'),(152,0,1,1,'2022-06-27 12:40:14'),(153,0,1,1,NULL),(154,0,1,1,NULL),(155,0,1,1,NULL),(156,0,1,1,NULL),(157,0,1,1,NULL),(158,2,1,1,'2022-06-27 12:55:30'),(159,1,1,1,'2022-06-27 12:55:46'),(160,2,1,1,'2022-06-27 12:55:56'),(161,3,1,1,'2022-06-27 13:16:57'),(162,3,1,1,'2022-06-27 13:17:29'),(163,3,1,1,'2022-06-27 13:18:43'),(164,3,1,1,'2022-06-27 13:19:37'),(165,3,1,1,'2022-06-27 13:20:08'),(166,2,1,1,'2022-06-27 13:20:38'),(167,3,1,1,'2022-06-27 13:23:31'),(168,3,1,1,'2022-06-27 13:24:51'),(169,2,1,1,'2022-06-27 13:25:29'),(170,3,1,1,'2022-06-27 13:25:44'),(171,3,1,1,'2022-06-27 13:28:00'),(172,3,1,1,'2022-06-27 13:29:52'),(173,3,1,1,'2022-06-27 13:31:58'),(174,3,1,1,'2022-06-27 13:37:37'),(175,3,1,1,'2022-06-27 13:38:35'),(176,3,1,1,'2022-06-27 13:39:00'),(177,3,1,1,'2022-06-27 13:41:27'),(178,3,1,1,'2022-06-27 13:42:01'),(179,3,1,1,'2022-06-27 13:50:04'),(180,3,1,1,'2022-06-27 13:50:25'),(181,3,1,1,'2022-06-27 13:51:07'),(182,3,1,1,'2022-06-27 13:56:10'),(183,3,1,1,'2022-06-27 13:57:43'),(184,3,1,1,'2022-06-27 13:58:04'),(185,2,1,1,'2022-06-27 13:59:03'),(186,3,1,1,'2022-06-27 14:00:32'),(187,2,1,1,'2022-06-27 14:01:53'),(188,2,1,1,'2022-06-27 14:02:48'),(189,2,1,1,'2022-06-27 14:03:25'),(190,2,1,1,'2022-06-27 14:04:31'),(191,3,1,1,'2022-06-27 14:06:21'),(192,2,1,1,'2022-06-27 14:07:35'),(193,2,1,1,'2022-06-27 14:07:51'),(194,3,1,1,'2022-06-27 14:08:45'),(195,3,1,1,'2022-06-27 14:09:50'),(196,2,1,1,'2022-06-27 14:10:56'),(197,3,1,1,'2022-06-27 14:12:26'),(198,3,1,1,'2022-06-27 14:13:21'),(199,3,1,1,'2022-06-27 14:15:48'),(200,3,1,1,'2022-06-27 14:16:25'),(201,3,1,1,'2022-06-27 14:17:23'),(202,1,1,1,'2022-06-27 14:17:58'),(203,3,1,1,'2022-06-27 14:18:41'),(204,1,1,1,'2022-06-27 14:18:50'),(205,2,1,1,'2022-06-27 14:22:23'),(206,2,1,2,'2022-06-27 16:46:47');
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nb4h0p6txrmfc0xbrd1kglp9t` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_ques`
--

DROP TABLE IF EXISTS `test_ques`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test_ques` (
  `test_id` bigint NOT NULL,
  `ques_id` bigint NOT NULL,
  PRIMARY KEY (`test_id`,`ques_id`),
  KEY `FK9md2x2wqmigxf6mfosi9ynlr1` (`ques_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_ques`
--

LOCK TABLES `test_ques` WRITE;
/*!40000 ALTER TABLE `test_ques` DISABLE KEYS */;
INSERT INTO `test_ques` VALUES (1,1),(1,2),(1,3),(2,2),(2,3),(2,5),(3,1),(3,2),(3,4),(4,1),(4,2),(4,5),(4,125),(4,126),(5,3),(5,4),(5,5),(5,126),(5,127),(6,1),(6,3),(6,4),(6,5),(6,125),(7,1),(7,2),(7,3),(7,4),(7,127),(7,128);
/*!40000 ALTER TABLE `test_ques` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tests`
--

DROP TABLE IF EXISTS `tests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tests` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  `level_id` bigint NOT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6vsqjjlqk2nkvgd8ywloxbv1s` (`level_id`),
  KEY `FKj48xn6umwt6ldy4v97iv2t1k3` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tests`
--

LOCK TABLES `tests` WRITE;
/*!40000 ALTER TABLE `tests` DISABLE KEYS */;
INSERT INTO `tests` VALUES (1,'demo',1,1,'2022-06-23 16:13:25'),(2,'demo2',1,1,'2022-06-23 16:23:01'),(3,'kienkien',1,1,'2022-06-26 23:13:09'),(4,'huehue',1,2,'2022-06-26 23:17:56'),(5,'kienkim',1,3,'2022-06-26 23:20:05'),(6,'asdw',1,1,'2022-06-27 09:55:15'),(7,'kienkien',1,3,'2022-06-27 16:45:47');
/*!40000 ALTER TABLE `tests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types`
--

DROP TABLE IF EXISTS `types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `types` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types`
--

LOCK TABLES `types` WRITE;
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` VALUES (1,'Single'),(2,'Multichoice');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (2,1),(3,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `avatar` longtext,
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'https://firebasestorage.googleapis.com/v0/b/blog-file-fb514.appspot.com/o/avatar.jfif?alt=media&token=faabef18-4a5f-4d3e-a9c7-efcf51b60c80','aaa@123','kimkim','$2a$10$U7NyrTj86lscQOUuDvn9LuE4G1974vX/yjCSHbgHbjezYjf7tVaQa','kienkien'),(2,'https://firebasestorage.googleapis.com/v0/b/blog-eab4c.appspot.com/o/images%2Fth%20(1).jpg?alt=media&token=aff3ee5b-f7c2-419a-98bb-9dd3e48041bd','tieutinhmy@gmail.com','huehue','$2a$10$CoiDgfzJcY0KgM3LzMZ1WOY9.sB7XgvEo/IaDN4.vaHxBvYktMU.q','huehue'),(3,'https://firebasestorage.googleapis.com/v0/b/blog-eab4c.appspot.com/o/images%2Fth%20(1).jpg?alt=media&token=aff3ee5b-f7c2-419a-98bb-9dd3e48041bd','hkajfksdf@jlakdjf','kakaka','$2a$10$CoiDgfzJcY0KgM3LzMZ1WOY9.sB7XgvEo/IaDN4.vaHxBvYktMU.q','kakaka');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'quizz'
--
/*!50003 DROP PROCEDURE IF EXISTS `searchQuestion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `searchQuestion`(
    in contents varchar(100),
    in type LONG,
    in category LONG,
    in level LONG
)
begin
    if (type=0 and category=0 and level=0)then
        select * from questions where content like contents;
        else if(category=0 and level=0) then
            select * from questions where content like contents and type_id = type;
            else if(type=0 and level=0) then
                select * from questions where content like contents and category_id = category;
                else if(type=0 and category=0)then
                    select * from questions where content like contents and level_id = level;
                    else if(type=0)then
                        select * from questions where content like contents
                                                  and category_id = category
                                                  and level_id = level;
                        else if(category=0)then
                            select * from questions where content like contents
                                                      and type_id = type
                                                      and level_id = level;
                            else if(level=0)then
                                select * from questions where content like contents
                                                          and type_id = type
                                                          and category_id = category;
                                else
                                    select * from questions where content like contents and type_id = type
                                                              and category_id = category
                                                              and level_id = level;
                            end if ;
                        end if ;
                    end if ;
                end if ;
            end if ;
        end if ;
    end if ;
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-27 21:49:10
