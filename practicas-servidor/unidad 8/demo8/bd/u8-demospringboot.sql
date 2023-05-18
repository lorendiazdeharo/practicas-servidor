CREATE DATABASE  IF NOT EXISTS `demospringboot` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `demospringboot`;
-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
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
  `nif` varchar(9) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `apellidos` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `claveseguridad` varchar(128) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `fechanacimiento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'44999594K','Keiko','Meadows','1732','meadowskeiko6933@icloud.net','2023-01-03'),(2,'28553744Y','Whoopi','Phelps','4488','w-phelps@aol.ca','2023-01-12'),(3,'25861374E','Hilary','Mcmahon','5418','hmcmahon6589@google.org','2022-12-30'),(4,'12242423G','Hunter','Frederick','1332','h_frederick@icloud.edu','2023-01-20'),(5,'51724739D','Diana','Lopez','5053','d-lopez5965@aol.net','2023-01-05'),(6,'13176696D','Amber','Ramirez','2375','amber.ramirez6505@protonmail.org',NULL),(7,'82568848H','Chava','Floyd','3011','cfloyd@hotmail.couk','2023-01-10'),(8,'03768520L','Tatum','Walsh','2463','walsh_tatum2491@outlook.couk',NULL),(9,'51976869H','Ezekiel','Woodard','2707','e-woodard@icloud.couk',NULL),(10,'55172493N','Coby','Lester','9856','c-lester7681@hotmail.couk',NULL),(11,'48037186R','Brielle','Howard','7848','b_howard@aol.com',NULL),(12,'71227610F','Candace','Bates','4990','c-bates@google.org',NULL),(13,'41124626J','Eagan','Carpenter','2060','e_carpenter9768@outlook.org',NULL),(14,'86926685Y','Yvette','Slater','6646','yslater@google.edu',NULL),(15,'18829162J','Heather','Abbott','9983','abbottheather@hotmail.org',NULL),(16,'10159358C','Kessie','Rich','4285','k_rich804@google.net',NULL),(17,'61816073X','Keelie','Forbes','1844','k-forbes1767@hotmail.com',NULL),(18,'27682739N','Dale','Glass','2545','gdale@google.ca',NULL),(19,'91124511M','Farrah','Farmer','5208','farrah-farmer6033@hotmail.com',NULL),(20,'21865746E','Graham','Casey','6223','g.casey3482@google.com','2022-08-31');
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
  UNIQUE KEY `IX_UNIQUE_CLIENTE_DIRECCION` (`idcliente`,`iddireccion`),
  KEY `fg_cliente_idx` (`idcliente`),
  KEY `fg_direccion_idx` (`iddireccion`),
  CONSTRAINT `fg_cliente` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fg_direccion` FOREIGN KEY (`iddireccion`) REFERENCES `direcciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientesdirecciones`
--

LOCK TABLES `clientesdirecciones` WRITE;
/*!40000 ALTER TABLE `clientesdirecciones` DISABLE KEYS */;
INSERT INTO `clientesdirecciones` VALUES (1,17,44,'2023-01-10 22:14:15'),(2,3,20,'2023-01-10 22:14:15'),(3,9,26,'2023-01-10 22:14:15'),(4,5,64,'2023-01-10 22:14:15'),(5,9,6,'2023-01-10 22:14:15'),(7,18,37,'2023-01-10 22:14:15'),(8,14,61,'2023-01-10 22:14:15'),(9,19,41,'2023-01-10 22:14:15'),(11,13,28,'2023-01-10 22:14:15'),(12,3,54,'2023-01-10 22:14:15'),(13,14,18,'2023-01-10 22:14:15'),(14,2,28,'2023-01-10 22:14:15'),(15,12,8,'2023-01-10 22:14:15'),(16,9,64,'2023-01-10 22:14:15'),(17,2,61,'2023-01-10 22:14:15'),(18,14,12,'2023-01-10 22:14:15'),(19,17,75,'2023-01-10 22:14:15'),(20,17,14,'2023-01-10 22:14:15'),(21,2,30,'2023-01-10 22:14:15'),(22,10,22,'2023-01-10 22:14:15'),(23,13,51,'2023-01-10 22:14:15'),(24,3,21,'2023-01-10 22:14:15'),(25,16,13,'2023-01-10 22:14:15'),(26,17,36,'2023-01-10 22:14:15'),(27,20,33,'2023-01-10 22:14:15'),(28,11,47,'2023-01-10 22:14:15'),(29,14,29,'2023-01-10 22:14:15'),(30,12,21,'2023-01-10 22:14:15'),(31,12,57,'2023-01-10 22:14:15'),(32,17,10,'2023-01-10 22:14:15'),(33,15,5,'2023-01-10 22:14:15'),(34,10,16,'2023-01-10 22:14:15'),(35,6,1,'2023-01-10 22:14:15'),(36,11,74,'2023-01-10 22:14:15'),(37,3,72,'2023-01-10 22:14:15'),(38,12,56,'2023-01-10 22:14:15'),(39,16,23,'2023-01-10 22:14:15'),(40,5,46,'2023-01-10 22:14:15'),(41,10,14,'2023-01-10 22:14:15'),(42,9,27,'2023-01-10 22:14:15'),(43,5,43,'2023-01-10 22:14:15'),(44,17,29,'2023-01-10 22:14:15'),(45,15,37,'2023-01-10 22:14:15'),(46,17,63,'2023-01-10 22:14:15'),(47,19,18,'2023-01-10 22:14:15'),(48,15,24,'2023-01-10 22:14:15'),(49,12,31,'2023-01-10 22:14:15'),(50,5,6,'2023-01-10 22:14:15'),(51,10,31,'2023-01-10 22:14:15'),(52,10,45,'2023-01-10 22:14:15'),(53,12,22,'2023-01-10 22:14:15'),(56,19,35,'2023-01-10 22:14:15'),(57,5,76,'2023-01-10 22:14:15'),(58,5,48,'2023-01-10 22:14:15'),(59,2,72,'2023-01-10 22:14:15'),(60,16,9,'2023-01-10 22:14:15'),(61,12,11,'2023-01-10 22:14:15'),(62,3,53,'2023-01-10 22:14:15'),(63,2,41,'2023-01-10 22:14:15'),(64,7,76,'2023-01-10 22:14:15'),(65,12,42,'2023-01-10 22:14:15'),(66,2,27,'2023-01-10 22:14:15'),(67,19,52,'2023-01-10 22:14:15'),(68,15,44,'2023-01-10 22:14:15'),(69,16,21,'2023-01-10 22:14:15'),(70,3,50,'2023-01-10 22:14:15'),(71,12,52,'2023-01-10 22:14:15'),(72,15,57,'2023-01-10 22:14:15'),(73,9,66,'2023-01-10 22:14:15'),(74,5,37,'2023-01-10 22:14:15'),(75,12,30,'2023-01-10 22:14:15'),(78,11,51,'2023-01-10 22:14:15'),(80,10,70,'2023-01-10 22:14:15'),(81,6,18,'2023-01-10 22:14:15'),(82,11,22,'2023-01-10 22:14:15'),(83,13,76,'2023-01-10 22:14:15'),(84,16,6,'2023-01-10 22:14:15'),(85,10,11,'2023-01-10 22:14:15'),(86,12,9,'2023-01-10 22:14:15'),(87,9,8,'2023-01-10 22:14:15'),(88,18,78,'2023-01-10 22:14:15'),(90,17,11,'2023-01-10 22:14:15'),(91,16,61,'2023-01-10 22:14:15'),(92,14,62,'2023-01-10 22:14:15'),(93,13,30,'2023-01-10 22:14:15'),(94,5,3,'2023-01-10 22:14:15'),(96,15,8,'2023-01-10 22:14:15'),(97,19,38,'2023-01-10 22:14:15'),(98,6,35,'2023-01-10 22:14:15'),(99,9,50,'2023-01-10 22:14:15'),(100,5,21,'2023-01-10 22:14:15'),(101,6,75,'2023-01-10 22:14:15'),(102,18,20,'2023-01-10 22:14:15'),(103,20,40,'2023-01-10 22:14:15'),(104,13,10,'2023-01-10 22:14:15'),(105,8,57,'2023-01-10 22:14:15'),(106,17,47,'2023-01-10 22:14:15'),(107,6,79,'2023-01-10 22:14:15'),(108,12,6,'2023-01-10 22:14:15'),(109,10,12,'2023-01-10 22:14:15'),(110,9,40,'2023-01-10 22:14:15'),(111,19,51,'2023-01-10 22:14:15'),(112,19,79,'2023-01-10 22:14:15'),(113,17,62,'2023-01-10 22:14:15'),(114,13,48,'2023-01-10 22:14:15'),(115,8,56,'2023-01-10 22:14:15'),(116,10,6,'2023-01-10 22:14:15'),(117,5,41,'2023-01-10 22:14:15'),(118,5,77,'2023-01-10 22:14:15'),(119,3,34,'2023-01-10 22:14:15'),(120,6,41,'2023-01-10 22:14:15'),(121,20,55,'2023-01-10 22:14:15'),(122,15,68,'2023-01-10 22:14:15'),(123,7,56,'2023-01-10 22:14:15'),(124,17,54,'2023-01-10 22:14:15'),(125,2,15,'2023-01-10 22:14:15'),(126,7,3,'2023-01-10 22:14:15'),(127,16,73,'2023-01-10 22:14:15'),(128,19,67,'2023-01-10 22:14:15'),(129,11,53,'2023-01-10 22:14:15'),(130,8,25,'2023-01-10 22:14:15'),(131,2,79,'2023-01-10 22:14:15'),(132,5,13,'2023-01-10 22:14:15'),(133,19,77,'2023-01-10 22:14:15'),(134,10,5,'2023-01-10 22:14:15'),(135,8,30,'2023-01-10 22:14:15'),(136,10,69,'2023-01-10 22:14:15'),(137,17,17,'2023-01-10 22:14:15'),(138,15,78,'2023-01-10 22:14:15'),(139,2,46,'2023-01-10 22:14:15'),(140,4,7,'2023-01-10 22:14:15'),(141,4,24,'2023-01-10 22:14:15'),(142,4,43,'2023-01-10 22:14:15'),(143,4,70,'2023-01-10 22:14:15'),(144,4,71,'2023-01-10 22:14:15'),(145,6,117,'2023-02-10 11:48:46'),(146,9,119,'2023-02-11 18:15:31'),(147,9,120,'2023-02-11 18:18:17'),(148,17,121,'2023-02-11 18:18:31'),(149,1,122,'2023-02-15 20:22:52');
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
  `banco` varchar(4) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `sucursal` varchar(4) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `dc` varchar(2) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `numerocuenta` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `saldoactual` float NOT NULL,
  `idcliente` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fg_cuentas_clientes_idx` (`idcliente`),
  CONSTRAINT `fg_cuentas_clientes` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES (1,'7324','8921','50','3279863463',14414.8,2),(2,'8475','9273','05','7384756229',7500,1),(3,'9374','5548','19','4739288766',5500,3),(4,'7431','3431','37','2762860738',3747.64,4),(5,'6525','7588','61','3225222173',23042.4,2),(6,'1854','6256','50','0135102313',3713.53,3),(7,'1134','7433','2','8463889900',3434,2),(8,'2115','0565','16','5883977077',5919.57,4),(9,'5139','8867','98','2171775812',14492.2,2),(10,'7734','3456','21','8733225466',8549,2),(11,'3847','3309','15','8829374455',2344,3),(12,'8834','3349','01','1192663455',5349,4),(13,'9985','5977','77','8986259446',4838.85,3),(14,'5587','6788','34','7706192777',4673.03,5),(15,'8376','4482','08','0823513582',15284.9,4),(16,'6685','8760','98','2717322537',4690.04,3),(17,'0428','8016','65','6081235627',11759.8,4),(18,'3950','6497','86','6448798950',12404.4,4),(19,'2484','3138','53','6389755885',21733.2,5),(20,'3018','4318','35','5284872370',277.81,1),(21,'6801','2438','17','5428117294',1015.1,9),(22,'8858','9133','12','7188054849',3989.94,9),(23,'5832','9724','83','6513413315',5699.01,7),(24,'2900','4122','86','7540817458',8057.13,10),(25,'2146','6447','44','5413826986',818.82,10),(26,'8622','3652','35','8477533415',1918.74,8),(27,'2385','3476','47','4862155636',35291.9,7),(28,'6046','1995','44','8045327684',3317.29,6),(29,'4056','6608','61','6162280121',16974.6,9),(30,'4654','7458','63','3781616582',3825.93,8),(31,'6715','2614','46','6344426358',8973.2,8),(32,'5551','5269','86','5474846384',5732.95,8),(33,'4221','9447','34','4517758671',18268.4,9),(34,'4734','2038','44','1112026302',2318.58,9),(35,'7311','8161','74','6287165832',2360.29,7),(36,'4513','6589','17','9202881622',26846.6,9),(37,'6412','7043','50','5913644254',11826.6,6),(38,'9645','2578','76','6920843777',32272.3,10),(39,'1868','7713','76','1115841464',1622.8,9),(40,'4826','6888','37','2054668818',7121.95,10),(41,'6801','2438','17','5428117294',1015.1,15),(42,'8858','9133','12','7188054849',3989.94,12),(43,'5832','9724','83','6513413315',5699.01,15),(44,'2900','4122','86','7540817458',8057.13,14),(45,'2146','6447','44','5413826986',818.82,12),(46,'8622','3652','35','8477533415',1918.74,13),(47,'2385','3476','47','4862155636',35291.9,11),(48,'6046','1995','44','8045327684',3317.29,11),(49,'4056','6608','61','6162280121',16974.6,14),(50,'4654','7458','63','3781616582',3825.93,13),(51,'6715','2614','46','6344426358',8973.2,14),(52,'5551','5269','86','5474846384',5732.95,12),(53,'4221','9447','34','4517758671',18268.4,12),(54,'4734','2038','44','1112026302',2318.58,14),(55,'7311','8161','74','6287165832',2360.29,12),(56,'4513','6589','17','9202881622',26846.6,13),(57,'6412','7043','50','5913644254',11826.6,15),(58,'9645','2578','76','6920843777',32272.3,14),(59,'1868','7713','76','1115841464',1622.8,11),(60,'4826','6888','37','2054668818',7121.95,13),(61,'5135','2981','58','3254876814',2092.23,19),(62,'4555','9345','67','3563339472',975.88,16),(63,'7795','3185','81','7154365519',5004.85,16),(64,'8062','1855','78','4646879195',4692.27,18),(65,'2616','6328','26','6671866375',8199.72,20),(66,'2881','1372','71','9818316121',355.46,17),(67,'1522','4918','44','4467464216',9828.49,18),(68,'4871','3346','38','7866448990',18163.4,16),(69,'2553','0205','88','3415671625',4731.88,17),(70,'8454','5325','28','1276682987',7372.49,17),(71,'1887','5971','44','6676384451',5967.51,17),(72,'0762','2946','74','5533736273',5896.77,20),(73,'3753','7468','38','3585483713',6597.06,18),(74,'6519','4911','06','9021237656',12692.6,17),(75,'7356','2657','19','8846914636',4304.45,18),(76,'4147','7250','67','1355557617',10400.3,18),(77,'9237','3724','62','6456388138',12303.8,16),(78,'8238','1435','86','4001284223',7925.9,17),(79,'4125','1721','05','0045452157',32134.8,17),(80,'8834','0640','83','8077554878',6674.63,17);
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
  `descripcion` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `pais` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `cp` varchar(5) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
INSERT INTO `direcciones` VALUES (1,'Ap #838-4348 Eros. St.','Nigeria','92977'),(2,'333-9796 Sem, Rd.','Ireland','17221'),(3,'Ap #282-2375 Donec Street','Austria','35795'),(4,'324-493 Elit, Ave','Netherlands','49569'),(5,'Ap #263-7963 Suspendisse Av.','Nigeria','11982'),(6,'204-4479 Nullam Rd.','Germany','84777'),(7,'7013 Adipiscing St.','Nigeria','14219'),(8,'6194 In Rd.','Austria','54458'),(9,'309-9174 Sed Rd.','Vietnam','16664'),(10,'600-7639 Ut, Road','Philippines','41663'),(11,'Ap #250-4150 Donec St.','Indonesia','55825'),(12,'9297 Duis Rd.','United States','61856'),(13,'511-9481 Interdum. St.','Ireland','58771'),(14,'Ap #796-3301 Molestie Av.','Mexico','77274'),(15,'Ap #327-6294 Integer Av.','Spain','51172'),(16,'Ap #939-819 Vestibulum Road','Ireland','82605'),(17,'Ap #607-5810 Erat Avenue','France','14143'),(18,'P.O. Box 670, 5307 Praesent Ave','Norway','61948'),(19,'739 Netus Avenue','Costa Rica','86318'),(20,'347-5338 Phasellus St.','Germany','22612'),(21,'906-9945 Laoreet Avenue','Sweden','28139'),(22,'508-8419 Sit Avenue','Spain','46636'),(23,'Ap #954-2658 Consequat, Rd.','Germany','14564'),(24,'Ap #268-2308 Quisque St.','Brazil','29247'),(25,'815-2232 Nullam Ave','South Korea','46310'),(26,'Ap #506-3026 Velit Av.','Norway','81861'),(27,'Ap #185-7332 Dui Av.','Germany','65782'),(28,'P.O. Box 501, 2438 Sodales Av.','China','73726'),(29,'Ap #775-2327 Fusce Rd.','South Korea','22575'),(30,'291-7517 Lobortis Street','Italy','50085'),(31,'P.O. Box 371, 3363 Suspendisse Avenue','Singapore','33421'),(32,'900-5693 Pellentesque St.','Germany','21414'),(33,'P.O. Box 419, 6772 Sagittis Street','Costa Rica','73828'),(34,'998-8166 Vel, Street','Colombia','49677'),(35,'894-6620 Odio. Av.','New Zealand','83819'),(36,'4511 Lorem Rd.','Germany','78465'),(37,'Ap #176-9738 Phasellus Rd.','Poland','22001'),(38,'9890 Nec Av.','Austria','83496'),(39,'4631 Pellentesque. Ave','South Korea','95732'),(40,'103-5022 Donec St.','Russian Federation','05878'),(41,'238-733 Aenean Road','Turkey','38880'),(42,'3258 Ullamcorper Avenue','Indonesia','53851'),(43,'Ap #270-8384 Mollis St.','India','17133'),(44,'909-3129 Nulla Street','Singapore','61244'),(45,'1399 Non, Av.','United States','47167'),(46,'Ap #127-8719 Quis Avenue','Turkey','87532'),(47,'2479 Sapien. St.','Sweden','91561'),(48,'P.O. Box 548, 7423 Vel, Av.','Philippines','09759'),(49,'873-770 Gravida. Av.','Nigeria','73466'),(50,'Ap #824-7037 Fames St.','Pakistan','77714'),(51,'Ap #676-3278 Metus. St.','Chile','80276'),(52,'P.O. Box 875, 2659 Donec St.','Mexico','88382'),(53,'676-3884 Leo. St.','South Korea','65421'),(54,'105-7385 Volutpat. Street','Turkey','83339'),(55,'Ap #293-8191 Donec Avenue','Spain','54586'),(56,'5602 Aliquet Av.','Brazil','47216'),(57,'Ap #608-6296 Scelerisque Ave','Germany','66585'),(58,'528-148 Consectetuer Avenue','Norway','33285'),(59,'Ap #443-9053 Nulla. Rd.','Pakistan','71042'),(60,'212-4072 Cursus Rd.','Chile','11687'),(61,'582-1013 Magna Road','China','27752'),(62,'928-6933 Eleifend, St.','South Korea','65717'),(63,'8407 Natoque Av.','Poland','34444'),(64,'418-9258 Nec St.','South Africa','34213'),(65,'Ap #750-8336 Arcu Rd.','Brazil','76747'),(66,'613-6503 Mauris Road','Poland','58861'),(67,'Ap #414-8760 Nibh Av.','Spain','23878'),(68,'956-974 Erat. Avenue','Singapore','58331'),(69,'509-5131 Feugiat Rd.','Spain','65593'),(70,'Ap #382-5932 Gravida. Avenue','Turkey','79545'),(71,'4818 Sapien Street','Netherlands','42226'),(72,'Ap #359-9989 Tortor. Road','Italy','82767'),(73,'P.O. Box 955, 1773 Neque Av.','Canada','22793'),(74,'5150 Eros Avenue','Peru','72955'),(75,'P.O. Box 223, 8796 Magna. St.','Indonesia','22661'),(76,'P.O. Box 489, 4632 Nulla. Avenue','Ukraine','38571'),(77,'530-9117 Metus Avenue','Peru','74509'),(78,'Ap #248-3123 Amet, Avenue','Norway','32732'),(79,'Ap #817-7092 Dolor. Av.','Nigeria','13198'),(80,'Ap #709-4277 Interdum St.','Colombia','72762'),(95,'AAA','AAAA','444'),(96,'1111','11111','1111'),(97,'2222','2222','2222'),(98,'3333','3333','333'),(99,'4444','4444','444'),(100,'55555','55555','55555'),(101,'666','666','666'),(104,'777','777','777'),(105,'888','888','888'),(106,'999','999','999'),(107,'0000','0000','0000'),(108,'0011','0011','0011'),(109,'0022','0022','0022'),(110,'0033','0033','0033'),(111,'0044','0044','0044'),(112,'0055','0055','0055'),(113,'0066','0066','0066'),(114,'0077','0077','0077'),(115,'12','12','12'),(116,'11','11','22'),(117,'sad','asd','234'),(118,'ewrew','ewr','546'),(119,'aaa','aaa','23'),(120,'bbb','bbb','777'),(121,'ddd','ddd','8888'),(122,'a','a','4');
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `fechaoperacion` datetime NOT NULL,
  `descripcion` text CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `importe` float NOT NULL DEFAULT '0',
  `idcuentaorigen` int NOT NULL,
  `idcuentadestino` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idcuentaorigen` (`idcuentaorigen`),
  KEY `idcuentadestino` (`idcuentadestino`),
  CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`idcuentaorigen`) REFERENCES `cuentas` (`id`),
  CONSTRAINT `movimientos_ibfk_2` FOREIGN KEY (`idcuentadestino`) REFERENCES `cuentas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (1,'Bizum','2023-06-20 12:07:08','Fames Ac Corp.',52,15,31),(2,'Retirada','2021-03-12 08:14:41','A Dui Corp.',254,30,17),(3,'Recibos','2023-03-14 14:49:24','Placerat Eget Inc.',125,67,23),(4,'Bizum','2023-01-09 16:47:33','Nullam Limited',-30,9,50),(5,'Transferencias','2022-05-30 19:57:24','In Mi Corp.',-192,62,5),(6,'Transferencias','2021-07-21 15:44:28','Augue Ut Lacus Industries',-602,1,10),(7,'Retirada','2021-09-22 13:16:01','Et Ultrices Industries',875,69,50),(8,'Bizum','2021-04-24 12:34:33','Eleifend Non Dapibus Corp.',91,55,76),(9,'Bizum','2023-03-20 20:27:41','Mauris A Nunc Foundation',535,2,52),(10,'Bizum','2023-06-09 21:25:57','Ligula Eu Ltd',17,9,45),(11,'Transferencias','2023-11-10 22:12:40','Risus Donec Consulting',-407,41,44),(12,'Transferencias','2021-02-16 17:35:15','Vel Mauris Inc.',671,55,28),(13,'Retirada','2023-12-12 00:07:24','Auctor Vitae Limited',-882,52,49),(14,'Recibos','2021-12-02 13:12:55','Nam Interdum Company',857,11,54),(15,'Retirada','2021-07-31 14:54:46','Duis At LLC',667,65,54),(16,'Recibos','2023-08-09 02:38:49','Aliquet Molestie Industries',179,53,10),(17,'Transferencias','2023-10-19 19:26:29','Magna Nam Ligula Limited',330,1,49),(18,'Bizum','2022-05-28 20:14:24','Sed Dictum Limited',370,21,77),(19,'Recibos','2021-07-07 04:57:50','Sit Associates',-67,62,53),(20,'Retirada','2022-02-09 15:58:14','Curabitur Ut Ltd',737,79,16),(21,'Recibos','2022-09-27 19:37:19','Suspendisse Tristique Inc.',-666,69,47),(22,'Transferencias','2021-07-16 05:17:43','Tempus Scelerisque Lorem Institute',-698,8,43),(23,'Retirada','2022-01-10 13:36:02','Metus Vitae Foundation',-107,52,80),(24,'Transferencias','2022-07-20 19:07:01','Odio Tristique Inc.',31,57,45),(25,'Retirada','2022-09-16 18:26:52','Duis Dignissim PC',-64,65,20),(26,'Recibos','2023-03-28 14:48:48','Integer Aliquam Foundation',-14,70,58),(27,'Retirada','2021-04-10 20:08:31','Et LLP',-297,47,36),(28,'Transferencias','2021-05-07 10:36:50','Tempor Est Foundation',-542,44,35),(29,'Retirada','2021-12-20 16:21:09','Lectus Pede Institute',-396,44,56),(30,'Bizum','2021-10-01 22:00:04','Sem Magna Nec Foundation',427,2,46),(31,'Transferencias','2022-12-02 08:30:51','Egestas Ltd',256,30,60),(32,'Transferencias','2023-04-01 06:36:58','Vivamus Industries',-579,75,63),(33,'Transferencias','2021-12-07 04:36:39','Erat Volutpat Nulla Institute',-370,58,25),(34,'Transferencias','2022-04-05 16:47:48','Lobortis Quam PC',260,36,69),(35,'Transferencias','2021-09-04 04:02:54','Cubilia Curae Ltd',-557,29,40),(36,'Transferencias','2023-06-03 14:35:26','Placerat Foundation',598,8,7),(37,'Retirada','2022-06-03 18:59:38','Nonummy Ipsum Non Ltd',781,24,21),(38,'Retirada','2021-04-26 13:11:31','Est Vitae Corporation',-952,5,61),(39,'Recibos','2021-07-11 04:34:57','Cras Eu Corporation',775,78,28),(40,'Retirada','2023-11-04 07:53:14','Ante Dictum Cursus Associates',442,74,46),(41,'Transferencias','2024-02-16 12:25:25','Neque Sed LLC',-224,55,50),(42,'Bizum','2021-07-16 11:20:58','Nonummy Ut Institute',-51,65,63),(43,'Retirada','2023-08-03 11:51:49','Velit In LLP',935,73,42),(44,'Bizum','2021-03-18 19:47:55','Faucibus Orci Luctus PC',900,9,51),(45,'Retirada','2024-01-05 09:44:17','Ante Bibendum Company',517,53,11),(46,'Transferencias','2023-12-15 09:22:50','Aliquet Sem Incorporated',-54,18,5),(47,'Transferencias','2022-12-06 21:17:48','Ut Industries',407,44,5),(48,'Transferencias','2021-08-24 23:53:48','Non Justo Foundation',519,1,61),(49,'Transferencias','2024-01-03 21:45:08','Lorem Ipsum LLC',164,42,72),(50,'Transferencias','2021-07-02 12:46:10','Magna Sed LLC',-705,18,22),(51,'Retirada','2021-11-20 16:23:31','Pellentesque Ut Foundation',512,53,75),(52,'Transferencias','2022-08-21 11:33:25','Aliquet Vel Company',156,46,9),(53,'Retirada','2023-03-05 14:56:49','Augue Malesuada Consulting',974,12,21),(54,'Retirada','2023-09-06 17:17:52','Penatibus Et Industries',-782,26,9),(55,'Recibos','2023-06-13 08:08:49','Vivamus Sit Ltd',349,72,77),(56,'Transferencias','2023-05-29 14:49:11','Arcu Industries',963,29,9),(57,'Transferencias','2023-07-17 15:38:51','Ut Nisi A Industries',-33,73,22),(58,'Retirada','2022-01-14 21:18:27','Nulla Cras Eu Industries',552,23,3),(59,'Transferencias','2021-09-07 20:37:38','Neque Foundation',235,30,9),(60,'Retirada','2021-02-12 15:08:33','Quam Dignissim Pharetra Corporation',247,70,28),(61,'Retirada','2023-07-22 22:42:27','Massa Vestibulum Associates',-312,56,33),(62,'Retirada','2021-07-03 08:19:25','Ante Ipsum Consulting',765,50,46),(63,'Retirada','2022-10-06 09:57:08','Aliquet Diam Associates',62,72,70),(64,'Transferencias','2022-11-11 06:25:56','Vel Incorporated',877,64,63),(65,'Transferencias','2021-09-30 10:57:18','Cum Ltd',-829,31,69),(66,'Retirada','2023-09-07 01:41:32','Aenean Massa Integer Associates',259,26,16),(67,'Retirada','2023-12-02 03:33:46','Scelerisque Lorem Inc.',375,18,46),(68,'Retirada','2021-03-31 23:18:38','Dignissim Tempor Corp.',519,53,31),(69,'Bizum','2022-10-06 19:53:02','Aliquam Iaculis Associates',868,7,70),(70,'Retirada','2023-02-28 09:07:52','Orci LLC',21,79,16),(71,'Retirada','2022-08-22 07:17:44','Libero Lacus Ltd',-218,2,33),(72,'Transferencias','2024-01-12 19:14:58','Eget Laoreet Posuere Associates',-184,75,73),(73,'Retirada','2022-12-27 04:39:01','Id Ante Dictum Corp.',-500,52,14),(74,'Bizum','2023-11-24 18:32:14','Egestas Fusce Institute',151,79,36),(75,'Recibos','2022-01-03 15:56:38','Dictum Proin Ltd',-993,4,25),(76,'Bizum','2023-12-15 16:20:56','Leo Cras LLP',973,54,4),(77,'Retirada','2024-02-04 12:36:54','Ipsum Suspendisse Incorporated',-503,30,5),(78,'Bizum','2021-12-16 09:02:37','Congue Incorporated',-525,66,61),(79,'Bizum','2023-08-29 20:50:34','Arcu LLP',-281,13,53),(80,'Transferencias','2023-12-08 02:02:24','Egestas Blandit Limited',96,25,7),(81,'Transferencias','2022-11-04 22:58:39','Ut Semper Pretium Institute',339,35,55),(82,'Transferencias','2022-10-12 03:45:53','Purus Accumsan Interdum Company',998,39,18),(83,'Bizum','2021-03-16 08:23:12','Congue Turpis Incorporated',-972,23,13),(84,'Recibos','2023-10-11 08:55:46','Mauris Ipsum Institute',449,38,28),(85,'Transferencias','2023-03-04 15:57:47','Curabitur Ltd',-445,31,66),(86,'Retirada','2023-06-25 14:50:16','Habitant LLP',-672,18,26),(87,'Bizum','2021-11-06 02:34:53','Gravida Molestie Arcu Consulting',125,65,63),(88,'Bizum','2022-02-14 17:03:06','Tincidunt Corporation',-542,54,59),(89,'Recibos','2023-01-30 16:43:42','Netus Et Limited',293,45,42),(90,'Bizum','2021-12-02 16:23:17','Sed Eu Eros Ltd',90,73,34),(91,'Transferencias','2023-03-02 04:02:37','Eu Ligula Aenean PC',655,64,43),(92,'Transferencias','2021-05-26 00:53:48','Quisque Corp.',415,12,76),(93,'Bizum','2023-11-12 11:41:56','Ultrices Iaculis Limited',-430,17,13),(94,'Recibos','2023-04-20 00:31:34','Lacus Incorporated',-151,76,44),(95,'Bizum','2021-09-15 04:41:43','Aliquet Proin PC',-519,11,16),(96,'Retirada','2023-11-26 12:51:10','Tristique Senectus Inc.',-850,62,61),(97,'Transferencias','2022-03-16 14:26:28','Vitae Foundation',261,68,10),(98,'Bizum','2022-03-20 02:49:35','Velit Consulting',198,8,7),(99,'Transferencias','2021-05-21 13:18:00','Duis Ltd',-763,24,16),(100,'Retirada','2023-11-19 02:12:32','Ligula Aenean Company',-449,68,67),(101,'Recibos','2023-08-25 07:46:51','Eu Nulla At LLP',562,51,8),(102,'Recibos','2022-09-02 23:55:11','Euismod Enim Foundation',819,3,51),(103,'Transferencias','2022-04-07 03:57:23','Sapien Imperdiet Company',287,64,41),(104,'Recibos','2021-09-17 12:45:23','Ut Associates',258,32,49),(105,'Retirada','2021-08-18 22:47:43','Auctor Non Feugiat LLC',757,16,74),(106,'Retirada','2021-02-23 19:25:35','Augue Scelerisque Mollis Industries',-744,13,60),(107,'Bizum','2021-07-26 01:15:51','Amet Incorporated',-755,59,16),(108,'Transferencias','2021-03-23 15:53:31','Neque Venenatis Industries',-315,30,3),(109,'Transferencias','2021-02-07 16:10:27','A Dui Corporation',391,59,7),(110,'Bizum','2022-11-03 18:54:42','Quisque Porttitor Industries',781,21,17),(111,'Retirada','2022-05-13 11:13:12','Adipiscing Elit Etiam Consulting',-93,48,33),(112,'Bizum','2022-03-01 22:24:12','Sed Dictum Industries',53,29,59),(113,'Transferencias','2021-09-17 02:10:52','Neque Ltd',-814,70,79),(114,'Retirada','2022-11-21 15:27:48','Non Dapibus Foundation',236,77,75),(115,'Retirada','2023-07-29 07:15:08','Morbi Tristique Company',414,5,9),(116,'Recibos','2021-08-06 16:32:06','Natoque Penatibus Et PC',178,12,59),(117,'Transferencias','2023-03-10 16:52:28','Aenean Ltd',838,71,6),(118,'Bizum','2021-05-05 19:00:26','Turpis Inc.',82,14,18),(119,'Retirada','2022-12-11 00:50:21','Eros Ltd',-232,25,25),(120,'Retirada','2023-10-16 15:00:03','Pharetra Nibh Industries',99,35,66),(121,'Retirada','2021-10-12 22:57:51','Quis Arcu Industries',-349,46,76),(122,'Transferencias','2022-11-03 14:41:17','Turpis Non Industries',498,70,34),(123,'Retirada','2023-04-18 12:05:57','Adipiscing Elit Consulting',194,7,48),(124,'Transferencias','2023-12-05 15:40:25','Est Nunc Ullamcorper Inc.',-752,23,10),(125,'Bizum','2023-07-14 08:36:17','Mollis Incorporated',-572,71,78),(126,'Transferencias','2023-11-23 01:41:41','Cursus Integer Foundation',196,20,12),(127,'Retirada','2023-11-02 04:33:27','Vivamus Non Lorem Ltd',-688,15,14),(128,'Retirada','2021-07-15 07:02:39','Habitant Morbi Foundation',-564,62,42),(129,'Retirada','2023-09-18 19:49:46','Hendrerit Corp.',755,59,11),(130,'Recibos','2022-01-22 17:18:56','Ut Pharetra Limited',506,26,69),(131,'Bizum','2023-10-14 17:10:39','Ac Mattis Institute',-290,25,33),(132,'Retirada','2023-08-01 04:19:05','Arcu Curabitur PC',-330,58,48),(133,'Recibos','2021-06-17 21:59:23','Nec Malesuada Industries',885,27,79),(134,'Transferencias','2023-11-05 10:22:53','A Limited',-357,8,9),(135,'Recibos','2021-04-11 17:01:13','Scelerisque Neque Ltd',142,58,48),(136,'Transferencias','2023-09-04 02:08:01','Aliquam Erat Incorporated',-843,59,20),(137,'Bizum','2021-05-21 14:48:14','Sem Ut Inc.',-343,77,42),(138,'Transferencias','2021-10-04 09:51:52','Fermentum Consulting',-50,22,54),(139,'Bizum','2021-02-15 18:33:25','Tellus Phasellus PC',614,26,45),(140,'Recibos','2023-03-18 18:02:05','Vitae Sodales Nisi Associates',-470,3,24),(141,'Retirada','2021-05-13 05:19:06','Maecenas LLC',923,42,26),(142,'Recibos','2021-11-26 04:10:52','Sapien Aenean LLC',106,64,29),(143,'Transferencias','2021-10-04 16:19:30','Vel Nisl Inc.',750,37,78),(144,'Retirada','2021-07-04 19:31:08','Hendrerit A Ltd',-898,6,13),(145,'Transferencias','2021-11-06 03:47:05','Tempor Diam Dictum Inc.',693,65,27),(146,'Retirada','2021-07-09 01:11:55','Proin Inc.',-662,9,40),(147,'Transferencias','2021-04-24 04:28:46','Augue Malesuada Malesuada LLC',-850,12,79),(148,'Transferencias','2021-02-20 19:57:17','Luctus Industries',-455,32,70),(149,'Retirada','2022-09-22 20:20:41','Nisi Nibh Associates',-719,40,8),(150,'Transferencias','2021-06-26 06:09:00','Phasellus Industries',826,26,24),(151,'Retirada','2023-10-16 19:07:18','Dolor Nonummy Associates',655,79,66),(152,'Retirada','2022-01-30 15:00:48','Adipiscing Lobortis Risus Industries',769,1,10),(153,'Recibos','2022-06-06 21:27:57','Sem Magna Inc.',596,30,39),(154,'Bizum','2023-06-27 06:55:32','Malesuada Fames Limited',867,38,68),(155,'Retirada','2021-07-07 15:21:39','Ut Corp.',436,42,62),(156,'Retirada','2023-02-09 23:08:37','Cras Interdum Nunc LLC',-512,33,68),(157,'Bizum','2022-12-23 04:42:09','Duis Mi LLP',459,66,3),(158,'Retirada','2022-07-15 14:56:46','Proin PC',-922,64,35),(159,'Recibos','2023-05-26 03:56:32','Tortor Dictum Eu Limited',-599,54,27),(160,'Bizum','2023-04-01 22:15:40','Molestie Dapibus Ligula LLP',178,76,20),(161,'Retirada','2021-09-01 05:43:54','Sed Dui Fusce Industries',43,32,38),(162,'Recibos','2022-01-14 18:56:24','Sed Hendrerit Associates',655,52,24),(163,'Retirada','2022-09-02 07:14:33','A Tortor Limited',-899,5,20),(164,'Transferencias','2023-06-20 14:53:35','Eu Enim Limited',195,22,50),(165,'Transferencias','2023-05-30 01:18:28','Nam Nulla Institute',658,33,24),(166,'Bizum','2024-01-16 18:24:01','Cras Eu Tellus Industries',-840,33,64),(167,'Retirada','2022-02-08 02:49:19','Semper Nam Tempor Consulting',871,49,77),(168,'Retirada','2021-09-17 10:01:53','Sit Amet PC',-985,26,17),(169,'Retirada','2022-02-17 02:18:03','Purus Maecenas PC',-79,22,36),(170,'Transferencias','2023-08-21 14:20:18','Tempor Lorem Institute',-400,72,66),(171,'Transferencias','2023-06-10 14:46:57','Hendrerit Consectetuer Institute',6,4,73),(172,'Transferencias','2024-02-13 16:43:57','Tristique Foundation',722,57,47),(173,'Retirada','2021-05-09 06:52:00','Magna Sed Eu PC',-797,77,38),(174,'Bizum','2022-07-15 10:12:31','Faucibus Ut Incorporated',-8,40,70),(175,'Transferencias','2021-03-22 03:01:47','Nulla Company',-579,55,52),(176,'Retirada','2023-07-24 12:33:56','Egestas Duis LLP',434,22,24),(177,'Transferencias','2021-10-10 14:57:08','Non Enim Commodo Incorporated',-836,65,54),(178,'Retirada','2022-12-13 16:31:29','A Associates',955,58,62),(179,'Transferencias','2021-08-08 07:37:28','Magnis Dis Limited',-456,51,6),(180,'Bizum','2023-03-27 07:20:26','Amet Risus Donec Incorporated',135,72,10);
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recomendaciones`
--

DROP TABLE IF EXISTS `recomendaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recomendaciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `observaciones` varchar(500) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `idcliente` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_recomendaciones1` (`idcliente`),
  UNIQUE KEY `UK_sblcnbtsi1fgj6ksbok1nt6lv` (`idcliente`),
  KEY `fk_cliente_recomendacion_idx` (`idcliente`),
  CONSTRAINT `fk_cliente_recomendacion` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recomendaciones`
--

LOCK TABLES `recomendaciones` WRITE;
/*!40000 ALTER TABLE `recomendaciones` DISABLE KEYS */;
INSERT INTO `recomendaciones` VALUES (1,'Quisque nonummy ipsum non arcu. Vivamus sit amet risus. Donec egestas. Aliquam nec',1),(2,'Nullam velit dui, semper et, lacinia vitae,',2),(3,'mi felis, adipiscing fringilla, porttitor vulputate, posuere vulputate, lacus. Cras interdum.',3),(4,'diam at pretium aliquet, metus urna convallis',4),(5,'Modificamos el apellido y las observaciones.',5),(6,'ligula tortor, dictum eu, placerat eget, venenatis a,',6),(7,'ac nulla. In tincidunt congue turpis. In condimentum. Donec at arcu. Vestibulum ante',7),(8,'ligula tortor, dictum eu, placerat eget, venenatis a, magna. Lorem ipsum dolor sit amet,',8),(9,'molestie pharetra nibh. Aliquam ornare, libero at auctor ullamcorper, nisl arcu iaculis enim,',9),(10,'sem eget massa. Suspendisse eleifend. Cras sed leo.',10),(11,'velit. Sed malesuada augue ut lacus. Nulla tincidunt,',11),(12,'netus et malesuada fames ac turpis egestas. Fusce',12),(13,'vitae, sodales at, velit. Pellentesque ultricies dignissim lacus. Aliquam rutrum',13),(14,'vitae sodales nisi magna sed dui. Fusce aliquam,',14),(15,'hendrerit id, ante. Nunc mauris sapien, cursus in, hendrerit',15),(16,'at, nisi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin',16),(17,'nisl arcu iaculis enim, sit amet ornare lectus justo eu arcu. Morbi sit amet',17),(18,'mollis dui, in sodales elit',18),(19,'facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet',19),(20,'ornare placerat, orci lacus vestibulum lorem,',20);
/*!40000 ALTER TABLE `recomendaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `idusuario` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FG_USUARIOS_idx` (`idusuario`),
  CONSTRAINT `FG_USUARIOS` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN',1),(2,'ROLE_USER',1),(3,'ROLE_USER',2),(10,'ROLE_ADMIN',8),(11,'ROLE_USER',8);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `password` varchar(128) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','$2a$10$EjwDPgcd8UWemi.qSq/ZAe1rfTLPgiWX.isgIopWZWrNw5NZj0Dhu'),(2,'user','$2a$10$0.hgl9q1BgLIEto4Qfs4HuDWn97lCSKB9uWiqjAxpmDF5ErQ.Djhu'),(8,'profesor','$2a$10$O9AC/umyl3NTJP6WE9CIn.khZV9piR82pR1HF4Dvg0WTI8hkmfoi6');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-01 19:56:27
