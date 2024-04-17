-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: maids
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `author` varchar(45) DEFAULT NULL,
  `publication_year` datetime DEFAULT NULL,
  `ISBN` varchar(17) DEFAULT NULL,
  `price` int DEFAULT '0',
  `Insertion_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title_UNIQUE` (`title`),
  UNIQUE KEY `ID_UNIQUE` (`id`),
  UNIQUE KEY `ISBN_UNIQUE` (`ISBN`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'NetherLand','Ahmed Gamal','2021-04-06 22:00:00','94219445',23,NULL),(2,'Snifro2','Mohamed Abdelmaoty','2020-09-04 22:00:00','9421941',122,NULL),(3,'NetherLand2','Ahmed Gamal','2021-04-06 22:00:00','94219446',23,NULL),(6,'NetherLand6','Ahmed Gamal','2021-04-06 22:00:00','942194458',23,'2024-04-17 15:25:43');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrowing_record`
--

DROP TABLE IF EXISTS `borrowing_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrowing_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bookid` int NOT NULL,
  `patronid` int NOT NULL,
  `return_date` datetime DEFAULT NULL,
  `borrow_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UN_IDs` (`bookid`,`patronid`),
  KEY `bookFK_idx` (`bookid`),
  KEY `patronFK_idx` (`patronid`),
  CONSTRAINT `bookFK` FOREIGN KEY (`bookid`) REFERENCES `book` (`id`),
  CONSTRAINT `patronFK` FOREIGN KEY (`patronid`) REFERENCES `patron` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowing_record`
--

LOCK TABLES `borrowing_record` WRITE;
/*!40000 ALTER TABLE `borrowing_record` DISABLE KEYS */;
INSERT INTO `borrowing_record` VALUES (8,1,1,'2024-04-17 16:54:59','2024-04-17 16:41:33'),(15,1,2,'2024-04-17 16:57:52','2024-04-17 16:57:32'),(16,3,3,'2024-04-17 16:58:34','2024-04-17 16:58:25');
/*!40000 ALTER TABLE `borrowing_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patron`
--

DROP TABLE IF EXISTS `patron`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patron` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `contact_information` varchar(200) DEFAULT NULL,
  `Gender` varchar(8) DEFAULT NULL,
  `Join_Date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patron`
--

LOCK TABLES `patron` WRITE;
/*!40000 ALTER TABLE `patron` DISABLE KEYS */;
INSERT INTO `patron` VALUES (1,'Alaa','phone number: 12345','Male','2024-04-17 10:57:16'),(2,'Mohamed','Address:Giza , Street:12H','Male','2024-04-17 10:57:48'),(3,'Ahmed','Test','Male','2024-04-17 10:57:16');
/*!40000 ALTER TABLE `patron` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-17 17:02:36
