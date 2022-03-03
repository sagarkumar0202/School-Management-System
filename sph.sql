-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: sph
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
-- Table structure for table `school_administer`
--

DROP TABLE IF EXISTS `school_administer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `school_administer` (
  `admin_id` int NOT NULL,
  `admin_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school_administer`
--

LOCK TABLES `school_administer` WRITE;
/*!40000 ALTER TABLE `school_administer` DISABLE KEYS */;
INSERT INTO `school_administer` VALUES (222,'Admin','12345');
/*!40000 ALTER TABLE `school_administer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school_teacher`
--

DROP TABLE IF EXISTS `school_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `school_teacher` (
  `teac_id` int NOT NULL,
  `teac_name` varchar(50) NOT NULL,
  `teac_address` varchar(50) NOT NULL,
  `teac_phone` varchar(50) NOT NULL,
  `teac_email` varchar(50) NOT NULL,
  `teac_type` varchar(50) NOT NULL,
  `teac_salary` varchar(50) NOT NULL,
  `password1` varchar(50) NOT NULL,
  PRIMARY KEY (`teac_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school_teacher`
--

LOCK TABLES `school_teacher` WRITE;
/*!40000 ALTER TABLE `school_teacher` DISABLE KEYS */;
INSERT INTO `school_teacher` VALUES (330,'sagar','dungra','78457455','sa@gnail','matha','2536.32','12345');
/*!40000 ALTER TABLE `school_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_admission`
--

DROP TABLE IF EXISTS `student_admission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_admission` (
  `stid` int NOT NULL,
  `stname` varchar(50) NOT NULL,
  `staddress` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `stclass` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_admission`
--

LOCK TABLES `student_admission` WRITE;
/*!40000 ALTER TABLE `student_admission` DISABLE KEYS */;
INSERT INTO `student_admission` VALUES (110,'Raj','dungra','7802020503','sa@gmail.com','12','12345');
/*!40000 ALTER TABLE `student_admission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_attendance`
--

DROP TABLE IF EXISTS `students_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_attendance` (
  `stid` int NOT NULL,
  `dat` varchar(50) NOT NULL,
  `stu_att` varchar(50) NOT NULL,
  KEY `stid` (`stid`),
  CONSTRAINT `students_attendance_ibfk_1` FOREIGN KEY (`stid`) REFERENCES `student_admission` (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_attendance`
--

LOCK TABLES `students_attendance` WRITE;
/*!40000 ALTER TABLE `students_attendance` DISABLE KEYS */;
INSERT INTO `students_attendance` VALUES (110,'28-02-2022','Present');
/*!40000 ALTER TABLE `students_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_attendance`
--

DROP TABLE IF EXISTS `teacher_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_attendance` (
  `teac_id` int NOT NULL,
  `dat` varchar(50) NOT NULL,
  `teac_att` varchar(50) NOT NULL,
  KEY `teac_id` (`teac_id`),
  CONSTRAINT `teacher_attendance_ibfk_1` FOREIGN KEY (`teac_id`) REFERENCES `school_teacher` (`teac_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_attendance`
--

LOCK TABLES `teacher_attendance` WRITE;
/*!40000 ALTER TABLE `teacher_attendance` DISABLE KEYS */;
INSERT INTO `teacher_attendance` VALUES (330,'28-02-2022','Present');
/*!40000 ALTER TABLE `teacher_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_table_student`
--

DROP TABLE IF EXISTS `time_table_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_table_student` (
  `stid` int NOT NULL,
  `clas` varchar(100) NOT NULL,
  `days` varchar(100) NOT NULL,
  `class_no` int NOT NULL,
  `start_tine` varchar(50) NOT NULL,
  `end_tine` varchar(50) NOT NULL,
  `sub` varchar(50) NOT NULL,
  KEY `stid` (`stid`),
  CONSTRAINT `time_table_student_ibfk_1` FOREIGN KEY (`stid`) REFERENCES `student_admission` (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_table_student`
--

LOCK TABLES `time_table_student` WRITE;
/*!40000 ALTER TABLE `time_table_student` DISABLE KEYS */;
INSERT INTO `time_table_student` VALUES (110,'10','Monday',1,'9.3','10.3','Maths');
/*!40000 ALTER TABLE `time_table_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_table_teacher`
--

DROP TABLE IF EXISTS `time_table_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_table_teacher` (
  `teac_id` int NOT NULL,
  `clas` varchar(100) NOT NULL,
  `days` varchar(100) NOT NULL,
  `class_no` int NOT NULL,
  `start_tine` varchar(50) NOT NULL,
  `end_tine` varchar(50) NOT NULL,
  `sub` varchar(50) NOT NULL,
  KEY `teac_id` (`teac_id`),
  CONSTRAINT `time_table_teacher_ibfk_1` FOREIGN KEY (`teac_id`) REFERENCES `school_teacher` (`teac_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_table_teacher`
--

LOCK TABLES `time_table_teacher` WRITE;
/*!40000 ALTER TABLE `time_table_teacher` DISABLE KEYS */;
INSERT INTO `time_table_teacher` VALUES (330,'12','Monday',1,'10.0','11.3','Maths');
/*!40000 ALTER TABLE `time_table_teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-03  9:58:44
