-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: jukebox
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `AccountID` bigint(20) NOT NULL AUTO_INCREMENT,
  `emailAddress` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `serviceId` varchar(255) DEFAULT NULL,
  `serviceName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AccountID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jukebox`
--

DROP TABLE IF EXISTS `jukebox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jukebox` (
  `JukeboxID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`JukeboxID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jukebox_accountroles`
--

DROP TABLE IF EXISTS `jukebox_accountroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jukebox_accountroles` (
  `Jukebox_JukeboxID` bigint(20) NOT NULL,
  `accountRoles` varchar(255) DEFAULT NULL,
  `accountRoles_KEY` bigint(20) NOT NULL,
  PRIMARY KEY (`Jukebox_JukeboxID`,`accountRoles_KEY`),
  KEY `FK_co160n4ls426y1ny1x2676ffm` (`accountRoles_KEY`),
  CONSTRAINT `FK_54ibrnspnwkqd3c5ifcoah44l` FOREIGN KEY (`Jukebox_JukeboxID`) REFERENCES `jukebox` (`JukeboxID`),
  CONSTRAINT `FK_co160n4ls426y1ny1x2676ffm` FOREIGN KEY (`accountRoles_KEY`) REFERENCES `account` (`AccountID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jukebox_savedplaylists`
--

DROP TABLE IF EXISTS `jukebox_savedplaylists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jukebox_savedplaylists` (
  `Jukebox_JukeboxID` bigint(20) NOT NULL,
  `savedPlaylists_PlaylistID` bigint(20) NOT NULL,
  PRIMARY KEY (`Jukebox_JukeboxID`,`savedPlaylists_PlaylistID`),
  UNIQUE KEY `UK_fe3niel47rl6b4wn511n037ak` (`savedPlaylists_PlaylistID`),
  CONSTRAINT `FK_ev0dxliv31gdhi3s9unsisews` FOREIGN KEY (`Jukebox_JukeboxID`) REFERENCES `jukebox` (`JukeboxID`),
  CONSTRAINT `FK_fe3niel47rl6b4wn511n037ak` FOREIGN KEY (`savedPlaylists_PlaylistID`) REFERENCES `playlist` (`PlaylistID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `oauthapiinfo`
--

DROP TABLE IF EXISTS `oauthapiinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauthapiinfo` (
  `name` varchar(255) NOT NULL,
  `apiKey` varchar(255) DEFAULT NULL,
  `apiSecret` varchar(255) DEFAULT NULL,
  `exampleGetRequest` varchar(255) DEFAULT NULL,
  `scribeApiName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlist` (
  `PlaylistID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PlaylistID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `playlist_song`
--

DROP TABLE IF EXISTS `playlist_song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlist_song` (
  `PlaylistID` bigint(20) NOT NULL,
  `SongID` bigint(20) NOT NULL,
  `songs_KEY` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`PlaylistID`,`songs_KEY`),
  KEY `FK_tapm4cs0iqrt4stg3h7xpb0kx` (`SongID`),
  CONSTRAINT `FK_83oadakqpd3huy9bwg37b80k0` FOREIGN KEY (`PlaylistID`) REFERENCES `playlist` (`PlaylistID`),
  CONSTRAINT `FK_tapm4cs0iqrt4stg3h7xpb0kx` FOREIGN KEY (`SongID`) REFERENCES `song` (`SongID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `song` (
  `SongID` bigint(20) NOT NULL AUTO_INCREMENT,
  `artist` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SongID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `song_metadata`
--

DROP TABLE IF EXISTS `song_metadata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `song_metadata` (
  `Song_SongID` bigint(20) NOT NULL,
  `metadataProperties` text,
  `metadataProperties_KEY` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`Song_SongID`,`metadataProperties_KEY`),
  CONSTRAINT `FK_ps6rtp9paa6pfbwx67o44t7wk` FOREIGN KEY (`Song_SongID`) REFERENCES `song` (`SongID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-21 11:28:03
