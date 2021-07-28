-- MySQL dump 10.13  Distrib 5.6.14, for Win32 (x86)
--
-- Host: localhost    Database: escooter
-- ------------------------------------------------------
-- Server version	5.6.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `costumer`
--

DROP TABLE IF EXISTS `costumer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costumer` (
  `ID_Costumer` int(11) NOT NULL AUTO_INCREMENT,
  `Nama` char(30) DEFAULT NULL,
  `No_Telp` char(30) DEFAULT NULL,
  `Jurusan` char(50) DEFAULT NULL,
  `Prodi` char(30) DEFAULT NULL,
  `NIM` char(30) DEFAULT NULL,
  `Password` char(30) DEFAULT NULL,
  `Saldo` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Costumer`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costumer`
--

LOCK TABLES `costumer` WRITE;
/*!40000 ALTER TABLE `costumer` DISABLE KEYS */;
INSERT INTO `costumer` VALUES (1,'Kotori','082128281258','Teknik Elektro','D4 Teknik Telekomunikasi','181344019','Minami',264000),(2,'Riko','081356287435','Akutansi','D3 Keuangan dan Perbankan','191344902','Sakurauchi123',100000),(3,'Kanan','085248357356','Bahasa Inggris','D3 Bahasa Inggris','181344012','MatsuuraaCantq',130000),(4,'Nico','089643258432','Teknik Kimia','D3 Analis Kimia','181322032','Niconiconii',132000),(5,'Subaru','085325734852','Teknik Mesin','D3 Teknik Aeronautika','181344028','Subarukunn',10000),(6,'Emilia','082184537463','Teknik Konversi Energi','D4 Teknik Konservasi Energi','181344004','emilliatann',250000),(7,'Rem','089648593253','Teknik Komputer dan Informatika','D4 Teknik Informatika','181333021','remxsubarukun',41000);
/*!40000 ALTER TABLE `costumer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lokasi`
--

DROP TABLE IF EXISTS `lokasi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lokasi` (
  `ID_Lokasi` int(11) NOT NULL AUTO_INCREMENT,
  `Nama_Jalan` char(30) DEFAULT NULL,
  `Nama_Gedung` char(30) DEFAULT NULL,
  PRIMARY KEY (`ID_Lokasi`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lokasi`
--

LOCK TABLES `lokasi` WRITE;
/*!40000 ALTER TABLE `lokasi` DISABLE KEYS */;
INSERT INTO `lokasi` VALUES (1,'Jl. Teknik Elektro','Gedung A'),(2,'Jl. Administrasi Niaga','Gedung B'),(3,'Jl. Teknik Mesin','Gedung C'),(4,'Jl. Teknik Komputer','Gedung D'),(5,'Jl. Akutansi','Gedung E'),(6,'Jl. Teknik Konservasi Energi','Gedung F'),(7,'Jl. Teknik Refrigasi dan Tata','Gedung G'),(8,'Jl. Akutansi','Gedung H');
/*!40000 ALTER TABLE `lokasi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scooter`
--

DROP TABLE IF EXISTS `scooter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scooter` (
  `ID_Scooter` int(11) NOT NULL AUTO_INCREMENT,
  `Warna` char(30) DEFAULT NULL,
  `Status` char(30) DEFAULT NULL,
  `ID_Lokasi` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Scooter`),
  KEY `ID_Lokasi` (`ID_Lokasi`),
  CONSTRAINT `scooter_ibfk_1` FOREIGN KEY (`ID_Lokasi`) REFERENCES `lokasi` (`ID_Lokasi`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scooter`
--

LOCK TABLES `scooter` WRITE;
/*!40000 ALTER TABLE `scooter` DISABLE KEYS */;
INSERT INTO `scooter` VALUES (1,'Pink','Tersedia',1),(2,'Pink','Tidak Tersedia',2),(3,'Pink','Tersedia',3),(4,'Pink','Tersedia',4),(5,'Pink','Tersedia',5),(6,'Pink','Tersedia',6),(7,'Pink','Tersedia',7),(8,'Pink','Tersedia',8),(9,'Biru','Tersedia',1),(10,'Biru','Tersedia',2),(11,'Biru','Tersedia',3),(12,'Biru','Tersedia',4),(13,'Biru','Tersedia',5),(14,'Biru','Tersedia',6),(15,'Biru','Tersedia',7),(16,'Biru','Tersedia',8);
/*!40000 ALTER TABLE `scooter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaksi`
--

DROP TABLE IF EXISTS `transaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaksi` (
  `ID_Transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Costumer` int(11) DEFAULT NULL,
  `ID_Scooter` int(11) DEFAULT NULL,
  `Waktu_Penyewaan` char(30) DEFAULT NULL,
  `Tanggal_Penyewaan` char(30) DEFAULT NULL,
  `Durasi_Penyewaan` char(30) DEFAULT NULL,
  `Harga` char(30) DEFAULT NULL,
  PRIMARY KEY (`ID_Transaksi`),
  KEY `ID_Costumer` (`ID_Costumer`),
  KEY `ID_Scooter` (`ID_Scooter`),
  CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`ID_Costumer`) REFERENCES `costumer` (`ID_Costumer`),
  CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`ID_Scooter`) REFERENCES `scooter` (`ID_Scooter`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaksi`
--

LOCK TABLES `transaksi` WRITE;
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
INSERT INTO `transaksi` VALUES (1,1,15,'23:59:59','01-01-2020','60 menit','36000'),(2,2,3,'23:54:57','02-01-2020','15 menit','9000'),(3,1,6,'00:05:10','03-01-2020','45 menit','27000'),(4,1,6,'18:23:49','03-01-2020','15 menit','9000'),(5,4,13,'18:31:56','03-01-2020','30 menit','18000'),(6,7,2,'18:45:02','03-01-2020','15 menit','9000');
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-05 10:18:05
