-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: my_db
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cities` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `country_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `cities_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'Moscow',1),(2,'Novosibirsk',1),(3,'New-York',2),(4,'Tokyo',NULL),(5,'Okinawa',3),(6,'London',4),(7,'Leads',4);
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countries` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,'Russia'),(2,'USA'),(3,'Japan'),(4,'United Kingdom');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pointservice`
--

DROP TABLE IF EXISTS `pointservice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pointservice` (
  `servicepoint_id` int NOT NULL,
  `service_id` int NOT NULL,
  PRIMARY KEY (`servicepoint_id`,`service_id`),
  KEY `service_id` (`service_id`),
  CONSTRAINT `pointservice_ibfk_1` FOREIGN KEY (`servicepoint_id`) REFERENCES `servicepoint` (`id`),
  CONSTRAINT `pointservice_ibfk_2` FOREIGN KEY (`service_id`) REFERENCES `services` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pointservice`
--

LOCK TABLES `pointservice` WRITE;
/*!40000 ALTER TABLE `pointservice` DISABLE KEYS */;
INSERT INTO `pointservice` VALUES (7,1),(2,2);
/*!40000 ALTER TABLE `pointservice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicepoint`
--

DROP TABLE IF EXISTS `servicepoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicepoint` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(25) DEFAULT NULL,
  `pointname` varchar(25) DEFAULT NULL,
  `city_id` int DEFAULT NULL,
  `country_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `servicepoint_ibfk_1` (`city_id`),
  KEY `servicepoint_ibfk_2` (`country_id`),
  CONSTRAINT `servicepoint_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`) ON UPDATE RESTRICT,
  CONSTRAINT `servicepoint_ibfk_2` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`) ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicepoint`
--

LOCK TABLES `servicepoint` WRITE;
/*!40000 ALTER TABLE `servicepoint` DISABLE KEYS */;
INSERT INTO `servicepoint` VALUES (2,'Lenina 13','TechPort',1,1),(3,'Chigorina 2','ServiceNSK',2,1),(4,'Servafimovicha 14','TochkaRemonta',2,1),(6,'Ave 5','LuxuryTools',3,3),(7,'Itoku 15','Samurai',4,2),(8,'Anney 132','Harakiri',4,3),(9,'Asuka 46','ChangService',5,3),(10,'Sindzuway 11','MaoRepair',5,3),(11,'Bond 7','Fix, James Fix',6,4),(12,'Red Street 23','TechQueen',6,4),(13,'Big Ben 11','Capital',7,4),(14,'United 64','ForGeeks',7,4),(17,'Ave 555','LuxuryTools3',3,3);
/*!40000 ALTER TABLE `servicepoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  KEY `services_ibfk_1_idx` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'Repair'),(2,'Clean'),(3,'Change'),(4,'Custom modifications');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'my_db'
--

--
-- Dumping routines for database 'my_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-08 16:09:26
