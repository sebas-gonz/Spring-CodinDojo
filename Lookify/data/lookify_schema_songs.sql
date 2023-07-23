CREATE DATABASE  IF NOT EXISTS `lookify_schema` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lookify_schema`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lookify_schema
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `songs`
--

DROP TABLE IF EXISTS `songs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `songs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `artist` varchar(40) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `rating` int NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `songs_chk_1` CHECK (((`rating` >= 1) and (`rating` <= 10)))
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `songs`
--

LOCK TABLES `songs` WRITE;
/*!40000 ALTER TABLE `songs` DISABLE KEYS */;
INSERT INTO `songs` VALUES (4,'Ed Sheeran','2023-07-23 01:28:15.303000',9,'Castle on The Hill',NULL),(7,'Drake','2023-07-23 05:07:55.559000',7,'Fake Love',NULL),(8,'Chain Smokers','2023-07-23 05:08:16.760000',3,'Paris',NULL),(9,'Ed Sheeran','2023-07-23 05:09:05.266000',8,'Shape of you',NULL),(10,'Ed Sheeran','2023-07-23 05:09:34.258000',3,'Galway Girl',NULL),(11,'The Strokes','2023-07-23 05:15:50.289000',7,'You Only Lives Once',NULL),(12,'Ozzy Osbourne','2023-07-23 05:16:52.208000',9,'No More Tears',NULL),(13,'Led Zeppelin','2023-07-23 05:17:59.235000',10,'Stairway to Heaven',NULL),(14,'Zomboy','2023-07-23 05:22:51.958000',4,'Terror Squad',NULL),(15,'D.O.D','2023-07-23 05:23:42.243000',6,'More  Cowbell',NULL),(16,'Skrillex','2023-07-23 05:26:04.962000',2,'Scary Monsters And Nice Sprites',NULL),(17,'Lil Peep','2023-07-23 05:32:26.497000',7,'lil jeep',NULL),(18,'Nirvana ','2023-07-23 05:33:23.987000',7,'Come As You Are',NULL),(19,'Nirvana','2023-07-23 05:34:48.362000',4,'Gallons of rubbing alcohol ...',NULL);
/*!40000 ALTER TABLE `songs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-23  9:38:35
