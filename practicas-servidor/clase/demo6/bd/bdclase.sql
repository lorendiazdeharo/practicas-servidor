CREATE DATABASE  IF NOT EXISTS `demospringboot` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `demospringboot`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: demospringboot
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nif` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `apellidos` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `claveseguridad` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'44999594K','Keiko','Meadows1','1732','meadowskeiko6933@icloud.net'),(2,'28553744Y','Whoopi','Phelps','4488','w-phelps@aol.ca'),(3,'25861374E','Hilary','Mcmahon','5418','hmcmahon6589@google.org'),(4,'12242423G','Hunter','Frederick','1332','h_frederick@icloud.edu'),(5,'51724739D','Diana','Dickerson','5053','d-dickerson5965@aol.net'),(6,'13176696D','Amber','Ramirez','2375','amber.ramirez6505@protonmail.org'),(7,'82568848H','Chava','Floyd','3011','cfloyd@hotmail.couk'),(8,'03768520L','Tatum','Walsh','2463','walsh_tatum2491@outlook.couk'),(9,'51976869H','Ezekiel','Woodard','2707','e-woodard@icloud.couk'),(10,'55172493N','Coby','Lester','9856','c-lester7681@hotmail.couk'),(11,'48037186R','Brielle','Howard','7848','b_howard@aol.com'),(12,'71227610F','Candace','Bates','4990','c-bates@google.org'),(13,'41124626J','Eagan','Carpenter','2060','e_carpenter9768@outlook.org'),(14,'86926685Y','Yvette','Slater','6646','yslater@google.edu'),(15,'18829162J','Heather','Abbott','9983','abbottheather@hotmail.org'),(16,'10159358C','Kessie','Rich','4285','k_rich804@google.net'),(17,'61816073X','Keelie','Forbes','1844','k-forbes1767@hotmail.com'),(18,'27682739N','Dale','Glass','2545','gdale@google.ca'),(19,'91124511M','Farrah','Farmer','5208','farrah-farmer6033@hotmail.com'),(20,'21865746E','Graham','Casey','6223','g.casey3482@google.com'),(21,'12345678N','a','b','pepito','pepito@juanito.org'),(22,'34534','34534534','3454354','345345','3453454');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientesdirecciones`
--

DROP TABLE IF EXISTS `clientesdirecciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientesdirecciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idcliente` int NOT NULL,
  `iddireccion` int NOT NULL,
  `fechaalta` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IX_UNIQUE_CD` (`idcliente`,`iddireccion`),
  KEY `FG_CD_CLIENTES_idx` (`idcliente`),
  KEY `FG_CD_DIRECCIONES_idx` (`iddireccion`),
  CONSTRAINT `FG_CD_CLIENTES` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FG_CD_DIRECCIONES` FOREIGN KEY (`iddireccion`) REFERENCES `direcciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientesdirecciones`
--

LOCK TABLES `clientesdirecciones` WRITE;
/*!40000 ALTER TABLE `clientesdirecciones` DISABLE KEYS */;
INSERT INTO `clientesdirecciones` VALUES (1,17,44,'2023-01-18 10:49:48'),(2,3,20,'2023-01-18 10:49:48'),(3,9,26,'2023-01-18 10:49:48'),(4,5,64,'2023-01-18 10:49:48'),(5,9,6,'2023-01-18 10:49:48'),(7,18,37,'2023-01-18 10:49:48'),(8,14,61,'2023-01-18 10:49:48'),(9,19,41,'2023-01-18 10:49:48'),(11,13,28,'2023-01-18 10:49:48'),(12,3,54,'2023-01-18 10:49:48'),(13,14,18,'2023-01-18 10:49:48'),(14,2,28,'2023-01-18 10:49:48'),(15,12,8,'2023-01-18 10:49:48'),(16,9,64,'2023-01-18 10:49:48'),(17,2,61,'2023-01-18 10:49:48'),(18,14,12,'2023-01-18 10:49:48'),(19,17,75,'2023-01-18 10:49:48'),(20,17,14,'2023-01-18 10:49:48'),(21,2,30,'2023-01-18 10:49:48'),(22,10,22,'2023-01-18 10:49:48'),(23,13,51,'2023-01-18 10:49:48'),(24,3,21,'2023-01-18 10:49:48'),(25,16,13,'2023-01-18 10:49:48'),(26,17,36,'2023-01-18 10:49:48'),(27,20,33,'2023-01-18 10:49:48'),(28,11,47,'2023-01-18 10:49:48'),(29,14,29,'2023-01-18 10:49:48'),(30,12,21,'2023-01-18 10:49:48'),(31,12,57,'2023-01-18 10:49:48'),(32,17,10,'2023-01-18 10:49:48'),(34,10,16,'2023-01-18 10:49:48'),(35,6,1,'2023-01-18 10:49:48'),(36,11,74,'2023-01-18 10:49:48'),(37,3,72,'2023-01-18 10:49:48'),(38,12,56,'2023-01-18 10:49:48'),(39,16,23,'2023-01-18 10:49:48'),(40,5,46,'2023-01-18 10:49:48'),(41,10,14,'2023-01-18 10:49:48'),(42,9,27,'2023-01-18 10:49:48'),(43,5,43,'2023-01-18 10:49:48'),(44,17,29,'2023-01-18 10:49:48'),(46,17,63,'2023-01-18 10:49:48'),(47,19,18,'2023-01-18 10:49:48'),(49,12,31,'2023-01-18 10:49:48'),(50,5,6,'2023-01-18 10:49:48'),(51,10,31,'2023-01-18 10:49:48'),(52,10,45,'2023-01-18 10:49:48'),(53,12,22,'2023-01-18 10:49:48'),(56,19,35,'2023-01-18 10:49:48'),(57,5,76,'2023-01-18 10:49:48'),(58,5,48,'2023-01-18 10:49:48'),(59,2,72,'2023-01-18 10:49:48'),(60,16,9,'2023-01-18 10:49:48'),(61,12,11,'2023-01-18 10:49:48'),(62,3,53,'2023-01-18 10:49:48'),(63,2,41,'2023-01-18 10:49:48'),(65,12,42,'2023-01-18 10:49:48'),(66,2,27,'2023-01-18 10:49:48'),(67,19,52,'2023-01-18 10:49:48'),(69,16,21,'2023-01-18 10:49:48'),(70,3,50,'2023-01-18 10:49:48'),(71,12,52,'2023-01-18 10:49:48'),(73,9,66,'2023-01-18 10:49:48'),(74,5,37,'2023-01-18 10:49:48'),(75,12,30,'2023-01-18 10:49:48'),(78,11,51,'2023-01-18 10:49:48'),(80,10,70,'2023-01-18 10:49:48'),(81,6,18,'2023-01-18 10:49:48'),(82,11,22,'2023-01-18 10:49:48'),(83,13,76,'2023-01-18 10:49:48'),(84,16,6,'2023-01-18 10:49:48'),(85,10,11,'2023-01-18 10:49:48'),(86,12,9,'2023-01-18 10:49:48'),(87,9,8,'2023-01-18 10:49:48'),(88,18,78,'2023-01-18 10:49:48'),(90,17,11,'2023-01-18 10:49:48'),(91,16,61,'2023-01-18 10:49:48'),(92,14,62,'2023-01-18 10:49:48'),(93,13,30,'2023-01-18 10:49:48'),(94,5,3,'2023-01-18 10:49:48'),(97,19,38,'2023-01-18 10:49:48'),(98,6,35,'2023-01-18 10:49:48'),(99,9,50,'2023-01-18 10:49:48'),(100,5,21,'2023-01-18 10:49:48'),(101,6,75,'2023-01-18 10:49:48'),(102,18,20,'2023-01-18 10:49:48'),(103,20,40,'2023-01-18 10:49:48'),(104,13,10,'2023-01-18 10:49:48'),(105,8,57,'2023-01-18 10:49:48'),(106,17,47,'2023-01-18 10:49:48'),(107,6,79,'2023-01-18 10:49:48'),(108,12,6,'2023-01-18 10:49:48'),(109,10,12,'2023-01-18 10:49:48'),(110,9,40,'2023-01-18 10:49:48'),(111,19,51,'2023-01-18 10:49:48'),(112,19,79,'2023-01-18 10:49:48'),(113,17,62,'2023-01-18 10:49:48'),(114,13,48,'2023-01-18 10:49:48'),(115,8,56,'2023-01-18 10:49:48'),(116,10,6,'2023-01-18 10:49:48'),(117,5,41,'2023-01-18 10:49:48'),(118,5,77,'2023-01-18 10:49:48'),(119,3,34,'2023-01-18 10:49:48'),(120,6,41,'2023-01-18 10:49:48'),(121,20,55,'2023-01-18 10:49:48'),(124,17,54,'2023-01-18 10:49:48'),(125,2,15,'2023-01-18 10:49:48'),(127,16,73,'2023-01-18 10:49:48'),(128,19,67,'2023-01-18 10:49:48'),(129,11,53,'2023-01-18 10:49:48'),(130,8,25,'2023-01-18 10:49:48'),(131,2,79,'2023-01-18 10:49:48'),(132,5,13,'2023-01-18 10:49:48'),(133,19,77,'2023-01-18 10:49:48'),(134,10,5,'2023-01-18 10:49:48'),(135,8,30,'2023-01-18 10:49:48'),(136,10,69,'2023-01-18 10:49:48'),(137,17,17,'2023-01-18 10:49:48'),(139,2,46,'2023-01-18 10:49:48'),(140,4,7,'2023-01-18 10:49:48'),(141,4,24,'2023-01-18 10:49:48'),(142,4,43,'2023-01-18 10:49:48'),(143,4,70,'2023-01-18 10:49:48'),(144,4,71,'2023-01-18 10:49:48'),(145,7,3,'2023-01-18 10:49:48'),(146,7,56,'2023-01-18 10:49:48'),(147,7,76,'2023-01-18 10:49:48'),(148,7,81,'2023-01-18 10:49:48'),(149,15,5,'2023-01-18 10:49:48'),(150,15,8,'2023-01-18 10:49:48'),(151,15,24,'2023-01-18 10:49:48'),(152,15,37,'2023-01-18 10:49:48'),(153,15,44,'2023-01-18 10:49:48'),(154,15,57,'2023-01-18 10:49:48'),(155,15,68,'2023-01-18 10:49:48'),(156,15,78,'2023-01-18 10:49:48'),(157,15,82,'2023-01-18 10:49:48'),(158,13,83,'2023-01-18 10:49:48'),(163,5,86,'2023-01-18 12:21:50');
/*!40000 ALTER TABLE `clientesdirecciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `banco` varchar(4) COLLATE latin1_spanish_ci NOT NULL,
  `sucursal` varchar(4) COLLATE latin1_spanish_ci NOT NULL,
  `dc` varchar(2) COLLATE latin1_spanish_ci NOT NULL,
  `numerocuenta` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `saldoactual` float NOT NULL DEFAULT '0',
  `idcliente` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_CLIENTES_idx` (`idcliente`),
  CONSTRAINT `FG_CUENTAS_CLIENTES` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES (1,'7324','8921','50','3279863463',14414.8,2),(2,'5247','4648','76','8012450658',16035.8,2),(3,'6503','8361','55','4492660132',10314.3,2),(4,'7431','3431','37','2762860738',3747.64,4),(5,'6525','7588','61','3225222173',23042.4,2),(6,'1854','6256','50','0135102313',3713.53,3),(7,'8633','6242','73','5645896216',997.68,4),(8,'2115','0565','16','5883977077',5919.57,4),(9,'5139','8867','98','2171775812',14492.2,2),(10,'8386','0266','50','9885779522',4738.74,1),(11,'6789','3715','63','2199081317',4258.32,1),(12,'3380','2833','12','3726171683',1463.33,3),(13,'9985','5977','77','8986259446',4838.85,3),(14,'5587','6788','34','7706192777',4673.03,5),(15,'8376','4482','08','0823513582',15284.9,4),(16,'6685','8760','98','2717322537',4690.04,3),(17,'0428','8016','65','6081235627',11759.8,4),(18,'3950','6497','86','6448798950',12404.4,4),(19,'2484','3138','53','6389755885',21733.2,5),(20,'3018','4318','35','5284872370',277.81,1),(21,'6801','2438','17','5428117294',1015.1,9),(22,'8858','9133','12','7188054849',3989.94,9),(23,'5832','9724','83','6513413315',5699.01,7),(24,'2900','4122','86','7540817458',8057.13,10),(25,'2146','6447','44','5413826986',818.82,10),(26,'8622','3652','35','8477533415',1918.74,8),(27,'2385','3476','47','4862155636',35291.9,7),(28,'6046','1995','44','8045327684',3317.29,6),(29,'4056','6608','61','6162280121',16974.6,9),(30,'4654','7458','63','3781616582',3825.93,8),(31,'6715','2614','46','6344426358',8973.2,8),(32,'5551','5269','86','5474846384',5732.95,8),(33,'4221','9447','34','4517758671',18268.4,9),(34,'4734','2038','44','1112026302',2318.58,9),(35,'7311','8161','74','6287165832',2360.29,7),(36,'4513','6589','17','9202881622',26846.6,9),(37,'6412','7043','50','5913644254',11826.6,6),(38,'9645','2578','76','6920843777',32272.3,10),(39,'1868','7713','76','1115841464',1622.8,9),(40,'4826','6888','37','2054668818',7121.95,10),(41,'6801','2438','17','5428117294',1015.1,15),(42,'8858','9133','12','7188054849',3989.94,12),(43,'5832','9724','83','6513413315',5699.01,15),(44,'2900','4122','86','7540817458',8057.13,14),(45,'2146','6447','44','5413826986',818.82,12),(46,'8622','3652','35','8477533415',1918.74,13),(47,'2385','3476','47','4862155636',35291.9,11),(48,'6046','1995','44','8045327684',3317.29,11),(49,'4056','6608','61','6162280121',16974.6,14),(50,'4654','7458','63','3781616582',3825.93,13),(51,'6715','2614','46','6344426358',8973.2,14),(52,'5551','5269','86','5474846384',5732.95,12),(53,'4221','9447','34','4517758671',18268.4,12),(54,'4734','2038','44','1112026302',2318.58,14),(55,'7311','8161','74','6287165832',2360.29,12),(56,'4513','6589','17','9202881622',26846.6,13),(57,'6412','7043','50','5913644254',11826.6,15),(58,'9645','2578','76','6920843777',32272.3,14),(59,'1868','7713','76','1115841464',1622.8,11),(60,'4826','6888','37','2054668818',7121.95,13),(61,'5135','2981','58','3254876814',2092.23,19),(62,'4555','9345','67','3563339472',975.88,16),(63,'7795','3185','81','7154365519',5004.85,16),(64,'8062','1855','78','4646879195',4692.27,18),(65,'2616','6328','26','6671866375',8199.72,20),(66,'2881','1372','71','9818316121',355.46,17),(67,'1522','4918','44','4467464216',9828.49,18),(68,'4871','3346','38','7866448990',18163.4,16),(69,'2553','0205','88','3415671625',4731.88,17),(70,'8454','5325','28','1276682987',7372.49,17),(71,'1887','5971','44','6676384451',5967.51,17),(72,'0762','2946','74','5533736273',5896.77,20),(73,'3753','7468','38','3585483713',6597.06,18),(74,'6519','4911','06','9021237656',12692.6,17),(75,'7356','2657','19','8846914636',4304.45,18),(76,'4147','7250','67','1355557617',10400.3,18),(77,'9237','3724','62','6456388138',12303.8,16),(78,'8238','1435','86','4001284223',7925.9,17),(79,'4125','1721','05','0045452157',32134.8,17),(80,'8834','0640','83','8077554878',6674.63,17);
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direcciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `pais` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `cp` varchar(5) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
INSERT INTO `direcciones` VALUES (1,'Ap #838-4348 Eros. St.','Nigeria','92977'),(2,'333-9796 Sem, Rd.','Ireland','17221'),(3,'Ap #282-2375 Donec Street','Austria','35795'),(4,'324-493 Elit, Ave','Netherlands','49569'),(5,'Ap #263-7963 Suspendisse Av.','Nigeria','11982'),(6,'204-4479 Nullam Rd.','Germany','84777'),(7,'7013 Adipiscing St.','Nigeria','14219'),(8,'6194 In Rd.','Austria','54458'),(9,'309-9174 Sed Rd.','Vietnam','16664'),(10,'600-7639 Ut, Road','Philippines','41663'),(11,'Ap #250-4150 Donec St.','Indonesia','55825'),(12,'9297 Duis Rd.','United States','61856'),(13,'511-9481 Interdum. St.','Ireland','58771'),(14,'Ap #796-3301 Molestie Av.','Mexico','77274'),(15,'Ap #327-6294 Integer Av.','Spain','51172'),(16,'Ap #939-819 Vestibulum Road','Ireland','82605'),(17,'Ap #607-5810 Erat Avenue','France','14143'),(18,'P.O. Box 670, 5307 Praesent Ave','Norway','61948'),(19,'739 Netus Avenue','Costa Rica','86318'),(20,'347-5338 Phasellus St.','Germany','22612'),(21,'906-9945 Laoreet Avenue','Sweden','28139'),(22,'508-8419 Sit Avenue','Spain','46636'),(23,'Ap #954-2658 Consequat, Rd.','Germany','14564'),(24,'Ap #268-2308 Quisque St.','Brazil','29247'),(25,'815-2232 Nullam Ave','South Korea','46310'),(26,'Ap #506-3026 Velit Av.','Norway','81861'),(27,'Ap #185-7332 Dui Av.','Germany','65782'),(28,'P.O. Box 501, 2438 Sodales Av.','China','73726'),(29,'Ap #775-2327 Fusce Rd.','South Korea','22575'),(30,'291-7517 Lobortis Street','Italy','50085'),(31,'P.O. Box 371, 3363 Suspendisse Avenue','Singapore','33421'),(32,'900-5693 Pellentesque St.','Germany','21414'),(33,'P.O. Box 419, 6772 Sagittis Street','Costa Rica','73828'),(34,'998-8166 Vel, Street','Colombia','49677'),(35,'894-6620 Odio. Av.','New Zealand','83819'),(36,'4511 Lorem Rd.','Germany','78465'),(37,'Ap #176-9738 Phasellus Rd.','Poland','22001'),(38,'9890 Nec Av.','Austria','83496'),(39,'4631 Pellentesque. Ave','South Korea','95732'),(40,'103-5022 Donec St.','Russian Federation','05878'),(41,'238-733 Aenean Road','Turkey','38880'),(42,'3258 Ullamcorper Avenue','Indonesia','53851'),(43,'Ap #270-8384 Mollis St.','India','17133'),(44,'909-3129 Nulla Street','Singapore','61244'),(45,'1399 Non, Av.','United States','47167'),(46,'Ap #127-8719 Quis Avenue','Turkey','87532'),(47,'2479 Sapien. St.','Sweden','91561'),(48,'P.O. Box 548, 7423 Vel, Av.','Philippines','09759'),(49,'873-770 Gravida. Av.','Nigeria','73466'),(50,'Ap #824-7037 Fames St.','Pakistan','77714'),(51,'Ap #676-3278 Metus. St.','Chile','80276'),(52,'P.O. Box 875, 2659 Donec St.','Mexico','88382'),(53,'676-3884 Leo. St.','South Korea','65421'),(54,'105-7385 Volutpat. Street','Turkey','83339'),(55,'Ap #293-8191 Donec Avenue','Spain','54586'),(56,'5602 Aliquet Av.','Brazil','47216'),(57,'Ap #608-6296 Scelerisque Ave','Germany','66585'),(58,'528-148 Consectetuer Avenue','Norway','33285'),(59,'Ap #443-9053 Nulla. Rd.','Pakistan','71042'),(60,'212-4072 Cursus Rd.','Chile','11687'),(61,'582-1013 Magna Road','China','27752'),(62,'928-6933 Eleifend, St.','South Korea','65717'),(63,'8407 Natoque Av.','Poland','34444'),(64,'418-9258 Nec St.','South Africa','34213'),(65,'Ap #750-8336 Arcu Rd.','Brazil','76747'),(66,'613-6503 Mauris Road','Poland','58861'),(67,'Ap #414-8760 Nibh Av.','Spain','23878'),(68,'956-974 Erat. Avenue','Singapore','58331'),(69,'509-5131 Feugiat Rd.','Spain','65593'),(70,'Ap #382-5932 Gravida. Avenue','Turkey','79545'),(71,'4818 Sapien Street','Netherlands','42226'),(72,'Ap #359-9989 Tortor. Road','Italy','82767'),(73,'P.O. Box 955, 1773 Neque Av.','Canada','22793'),(74,'5150 Eros Avenue','Peru','72955'),(75,'P.O. Box 223, 8796 Magna. St.','Indonesia','22661'),(76,'P.O. Box 489, 4632 Nulla. Avenue','Ukraine','38571'),(77,'530-9117 Metus Avenue','Peru','74509'),(78,'Ap #248-3123 Amet, Avenue','Norway','32732'),(79,'Ap #817-7092 Dolor. Av.','Nigeria','13198'),(80,'Ap #709-4277 Interdum St.','Colombia','72762'),(81,'aaaaaaaaaa','aaaaaaaaaaa','1111'),(82,'bbbbbbbbbbbbb','bbbbb','66666'),(83,'erwerwe','werwerew','23423'),(86,'dddd','dddd','56876');
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recomendaciones`
--

DROP TABLE IF EXISTS `recomendaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recomendaciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `observaciones` varchar(500) COLLATE latin1_spanish_ci NOT NULL,
  `idcliente` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sblcnbtsi1fgj6ksbok1nt6lv` (`idcliente`),
  KEY `FG_CLIENTES_idx` (`idcliente`),
  CONSTRAINT `FG_CLIENTES` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recomendaciones`
--

LOCK TABLES `recomendaciones` WRITE;
/*!40000 ALTER TABLE `recomendaciones` DISABLE KEYS */;
INSERT INTO `recomendaciones` VALUES (1,'Quisque nonummy ipsum non arcu. Vivamus sit amet risus. Donec egestas. Aliquam nec1',1),(2,'Nullam velit dui, semper et, lacinia vitae,',2),(3,'mi felis, adipiscing fringilla, porttitor vulputate, posuere vulputate, lacus. Cras interdum.',3),(4,'diam at pretium aliquet, metus urna convallis',4),(5,'Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus orci luctus et',5),(6,'ligula tortor, dictum eu, placerat eget, venenatis a,',6),(7,'ac nulla. In tincidunt congue turpis. In condimentum. Donec at arcu. Vestibulum ante',7),(8,'ligula tortor, dictum eu, placerat eget, venenatis a, magna. Lorem ipsum dolor sit amet,',8),(9,'molestie pharetra nibh. Aliquam ornare, libero at auctor ullamcorper, nisl arcu iaculis enim,',9),(10,'sem eget massa. Suspendisse eleifend. Cras sed leo.',10),(11,'velit. Sed malesuada augue ut lacus. Nulla tincidunt,',11),(12,'netus et malesuada fames ac turpis egestas. Fusce',12),(13,'vitae, sodales at, velit. Pellentesque ultricies dignissim lacus. Aliquam rutrum',13),(14,'vitae sodales nisi magna sed dui. Fusce aliquam,',14),(15,'hendrerit id, ante. Nunc mauris sapien, cursus in, hendrerit',15),(16,'at, nisi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin',16),(17,'nisl arcu iaculis enim, sit amet ornare lectus justo eu arcu. Morbi sit amet',17),(18,'mollis dui, in sodales elit',18),(19,'facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet',19),(20,'ornare placerat, orci lacus vestibulum lorem,',20),(22,'Hola',21),(23,'43543543',22);
/*!40000 ALTER TABLE `recomendaciones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-20 13:28:59
