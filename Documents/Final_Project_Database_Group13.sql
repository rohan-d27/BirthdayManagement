CREATE DATABASE  IF NOT EXISTS `project_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `project_db`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: project_db
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `admin_info_table`
--

DROP TABLE IF EXISTS `admin_info_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_info_table` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `admin_fname` varchar(50) NOT NULL,
  `admin_lname` varchar(50) NOT NULL,
  `admin_mobno` varchar(20) DEFAULT 'NA',
  `admin_email` varchar(50) NOT NULL,
  `admin_username` varchar(50) NOT NULL,
  `admin_password` varchar(50) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_info_table`
--

LOCK TABLES `admin_info_table` WRITE;
/*!40000 ALTER TABLE `admin_info_table` DISABLE KEYS */;
INSERT INTO `admin_info_table` VALUES (101,'Akshay','Patil','9988776655','akshay@patil.com','akshay','akshay@123');
/*!40000 ALTER TABLE `admin_info_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `custom_order_table`
--

DROP TABLE IF EXISTS `custom_order_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `custom_order_table` (
  `custom_order_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `service_id` int NOT NULL,
  PRIMARY KEY (`custom_order_id`),
  UNIQUE KEY `custom_order_table` (`order_id`,`service_id`),
  KEY `service_id` (`service_id`),
  CONSTRAINT `custom_order_table_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders_info_table` (`order_id`),
  CONSTRAINT `custom_order_table_ibfk_2` FOREIGN KEY (`service_id`) REFERENCES `services_info_table` (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4007 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custom_order_table`
--

LOCK TABLES `custom_order_table` WRITE;
/*!40000 ALTER TABLE `custom_order_table` DISABLE KEYS */;
INSERT INTO `custom_order_table` VALUES (4001,5003,2001),(4005,5003,2002),(4002,5003,2003),(4003,5003,2004),(4006,5003,2005),(4004,5003,2007);
/*!40000 ALTER TABLE `custom_order_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_info_table`
--

DROP TABLE IF EXISTS `customer_info_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_info_table` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_fname` varchar(50) NOT NULL,
  `customer_lname` varchar(50) NOT NULL,
  `customer_mobno` varchar(20) DEFAULT 'NA',
  `customer_email` varchar(50) DEFAULT 'NA',
  `customer_address` varchar(255) DEFAULT 'NA',
  `customer_city` varchar(50) DEFAULT 'NA',
  `customer_zipcode` int DEFAULT NULL,
  `customer_username` varchar(50) NOT NULL,
  `customer_password` varchar(50) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=304 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_info_table`
--

LOCK TABLES `customer_info_table` WRITE;
/*!40000 ALTER TABLE `customer_info_table` DISABLE KEYS */;
INSERT INTO `customer_info_table` VALUES (301,'Amol','Deshmukh','9213671830','amol@deshmukh.com','shivajinagar','Pune',411005,'amol','amol@123'),(302,'Rahul','Sharma','9977667744','rahul@sharma.com','Hinjawadi','Pune',411057,'rahul','rahul@123'),(303,'Mahesh','Gade','7788996660','mahesh@gadade.com','Dhayari','Pune',410234,'mahesh','mahesh@123');
/*!40000 ALTER TABLE `customer_info_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback_table`
--

DROP TABLE IF EXISTS `feedback_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback_table` (
  `feedback_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `feedback_details` varchar(500) NOT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `feedback_table_ibfk_1` (`order_id`),
  CONSTRAINT `feedback_table_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders_info_table` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback_table`
--

LOCK TABLES `feedback_table` WRITE;
/*!40000 ALTER TABLE `feedback_table` DISABLE KEYS */;
INSERT INTO `feedback_table` VALUES (7001,5001,'very good services'),(7002,5002,'Best service'),(7003,5003,'Custom packages are good');
/*!40000 ALTER TABLE `feedback_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_info_table`
--

DROP TABLE IF EXISTS `orders_info_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_info_table` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `package_id` int DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `event_date` date DEFAULT NULL,
  `event_time` time DEFAULT NULL,
  `event_venue` varchar(255) DEFAULT 'NA',
  `number_of_guests` int DEFAULT NULL,
  `order_amount` double DEFAULT NULL,
  `order_status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `customer_id` (`customer_id`),
  KEY `package_id` (`package_id`),
  CONSTRAINT `orders_info_table_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer_info_table` (`customer_id`),
  CONSTRAINT `orders_info_table_ibfk_2` FOREIGN KEY (`package_id`) REFERENCES `packages_info_table` (`package_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_info_table`
--

LOCK TABLES `orders_info_table` WRITE;
/*!40000 ALTER TABLE `orders_info_table` DISABLE KEYS */;
INSERT INTO `orders_info_table` VALUES (5001,301,1003,'2022-03-01','2022-03-15','20:00:00','Kothrud',100,30000,'confirmed'),(5002,302,1004,'2022-03-02','2022-03-07','19:00:00','Hinjawadi',50,40000,'confirmed'),(5003,303,1111,'2022-03-15','2022-03-20','20:30:00','Dhayari',30,25000,'confirmed');
/*!40000 ALTER TABLE `orders_info_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packages_info_table`
--

DROP TABLE IF EXISTS `packages_info_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `packages_info_table` (
  `package_id` int NOT NULL AUTO_INCREMENT,
  `package_name` varchar(50) NOT NULL,
  `package_desc` varchar(100) NOT NULL,
  `package_price` double NOT NULL,
  PRIMARY KEY (`package_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4006 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packages_info_table`
--

LOCK TABLES `packages_info_table` WRITE;
/*!40000 ALTER TABLE `packages_info_table` DISABLE KEYS */;
INSERT INTO `packages_info_table` VALUES (1001,'Basic','Most Affordable Package with all essential services for birthday',15000),(1002,'Standard','Most popular package',20000),(1003,'Classic','Classic package for Classic experience',30000),(1004,'Premium','Premium package with premium services',40000),(1111,'custom package','customized package',1);
/*!40000 ALTER TABLE `packages_info_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packages_services_table`
--

DROP TABLE IF EXISTS `packages_services_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `packages_services_table` (
  `package_id` int NOT NULL,
  `service_id` int NOT NULL,
  PRIMARY KEY (`package_id`,`service_id`),
  KEY `service_id` (`service_id`),
  CONSTRAINT `packages_services_table_ibfk_1` FOREIGN KEY (`package_id`) REFERENCES `packages_info_table` (`package_id`),
  CONSTRAINT `packages_services_table_ibfk_2` FOREIGN KEY (`service_id`) REFERENCES `services_info_table` (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packages_services_table`
--

LOCK TABLES `packages_services_table` WRITE;
/*!40000 ALTER TABLE `packages_services_table` DISABLE KEYS */;
INSERT INTO `packages_services_table` VALUES (1001,2001),(1002,2001),(1003,2001),(1004,2001),(1001,2002),(1002,2002),(1003,2002),(1004,2002),(1001,2003),(1002,2003),(1003,2003),(1004,2003),(1002,2004),(1004,2004),(1001,2005),(1002,2005),(1003,2005),(1004,2005),(1003,2006),(1004,2006),(1004,2007);
/*!40000 ALTER TABLE `packages_services_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_provider_info_table`
--

DROP TABLE IF EXISTS `service_provider_info_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_provider_info_table` (
  `service_provider_id` int NOT NULL AUTO_INCREMENT,
  `service_provider_fname` varchar(50) NOT NULL,
  `service_provider_lname` varchar(50) NOT NULL,
  `service_provider_mobno` varchar(20) DEFAULT 'NA',
  `service_provider_email` varchar(50) NOT NULL,
  `service_provider_address` varchar(255) DEFAULT 'NA',
  `service_provider_city` varchar(50) DEFAULT 'NA',
  `service_provider_zipcode` int DEFAULT NULL,
  `service_provider_username` varchar(50) NOT NULL,
  `service_provider_password` varchar(50) NOT NULL,
  PRIMARY KEY (`service_provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=207 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_provider_info_table`
--

LOCK TABLES `service_provider_info_table` WRITE;
/*!40000 ALTER TABLE `service_provider_info_table` DISABLE KEYS */;
INSERT INTO `service_provider_info_table` VALUES (201,'Amol','Deshmukh','9213671830','amol@deshmukh.com','shivajinagar','Pune',411005,'amol','amol@123'),(202,'Dhiraj','Kulkarni','9243571630','dhiraj@kulkarni.com','kothrud','Pune',411038,'dhiraj','dhiraj@123'),(203,'Prakash','Sharma','8976755221','prakash@sharma.com','Baner','Pune',411078,'prakash','prakash@123'),(204,'Kavita','Kale','8921755224','kavita@kale.com','Sinhagad','Pune',411021,'kavita','kaviata@123'),(205,'Sumit','Shinde','9988776644','sumit@shinde.com','Katraj','Pune',411032,'sumit','sumit@123'),(206,'Ravi','Hinge','8833226644','ravi@hinge.com','Swargate','Pune',411009,'ravi','ravi@123');
/*!40000 ALTER TABLE `service_provider_info_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services_info_table`
--

DROP TABLE IF EXISTS `services_info_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services_info_table` (
  `service_id` int NOT NULL AUTO_INCREMENT,
  `service_name` varchar(50) NOT NULL,
  `service_desc` varchar(100) DEFAULT 'NA',
  `service_provider_id` int NOT NULL,
  `service_price` double NOT NULL,
  `service_images` blob,
  PRIMARY KEY (`service_id`),
  KEY `service_provider_id` (`service_provider_id`),
  CONSTRAINT `services_info_table_ibfk_1` FOREIGN KEY (`service_provider_id`) REFERENCES `service_provider_info_table` (`service_provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2008 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services_info_table`
--

LOCK TABLES `services_info_table` WRITE;
/*!40000 ALTER TABLE `services_info_table` DISABLE KEYS */;
INSERT INTO `services_info_table` VALUES (2001,'Birthday Cake','Different flavoured cakes',201,3000,NULL),(2002,'Decoration','Variety of decoration themes',205,6000,NULL),(2003,'Photography','Photoshoot of birthday party',202,3000,NULL),(2004,'Videography','Video Recording of birthday party',202,5000,NULL),(2005,'Games and Activities','Fun games and activities',203,3000,NULL),(2006,'Catering','Catering Services',204,15000,NULL),(2007,'Music System','Music Entertainment System',206,5000,NULL);
/*!40000 ALTER TABLE `services_info_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-02  8:33:25
