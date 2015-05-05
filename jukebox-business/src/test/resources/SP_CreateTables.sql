DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_CreateTables`()
BEGIN
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: jukebox
-- ------------------------------------------------------
-- Server version	5.6.23-log

 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT ;
 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS ;
 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION ;
 SET NAMES utf8 ;
 SET @OLD_TIME_ZONE=@@TIME_ZONE ;
 SET TIME_ZONE='+00:00' ;
 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 ;
 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 ;
 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' ;
 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 ;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
 SET @saved_cs_client     = @@character_set_client ;
 SET character_set_client = utf8 ;
CREATE TABLE `account` (
  `AccountID` bigint(20) NOT NULL AUTO_INCREMENT,
  `emailAddress` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `serviceId` varchar(255) DEFAULT NULL,
  `serviceName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AccountID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 SET character_set_client = @saved_cs_client ;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
 SET @saved_cs_client     = @@character_set_client ;
 SET character_set_client = utf8 ;
CREATE TABLE `currency` (
  `PAYPALCODE` varchar(255) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PAYPALCODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 SET character_set_client = @saved_cs_client ;

--
-- Table structure for table `jukebox`
--

DROP TABLE IF EXISTS `jukebox`;
 SET @saved_cs_client     = @@character_set_client ;
 SET character_set_client = utf8 ;
CREATE TABLE `jukebox` (
  `JukeboxID` bigint(20) NOT NULL AUTO_INCREMENT,
  `looped` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `random` bit(1) NOT NULL,
  `currentPlaylist_PlaylistID` bigint(20) DEFAULT NULL,
  `mandatoryPlaylist_PlaylistID` bigint(20) DEFAULT NULL,
  `payPalSettings_PayPalSettingsID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`JukeboxID`),
  KEY `FK_94u7eixvvbkc8owacv3r7ppwh` (`currentPlaylist_PlaylistID`),
  KEY `FK_l6t34dldjwmjdq82h613fee5r` (`mandatoryPlaylist_PlaylistID`),
  KEY `FK_3nygyngudsjr5e8lqp3t1wixx` (`payPalSettings_PayPalSettingsID`),
  CONSTRAINT `FK_3nygyngudsjr5e8lqp3t1wixx` FOREIGN KEY (`payPalSettings_PayPalSettingsID`) REFERENCES `paypalsettings` (`PayPalSettingsID`),
  CONSTRAINT `FK_94u7eixvvbkc8owacv3r7ppwh` FOREIGN KEY (`currentPlaylist_PlaylistID`) REFERENCES `playlist` (`PlaylistID`),
  CONSTRAINT `FK_l6t34dldjwmjdq82h613fee5r` FOREIGN KEY (`mandatoryPlaylist_PlaylistID`) REFERENCES `playlist` (`PlaylistID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
 SET character_set_client = @saved_cs_client ;

--
-- Table structure for table `jukebox_accountroles`
--

DROP TABLE IF EXISTS `jukebox_accountroles`;
 SET @saved_cs_client     = @@character_set_client ;
 SET character_set_client = utf8 ;
CREATE TABLE `jukebox_accountroles` (
  `Jukebox_JukeboxID` bigint(20) NOT NULL,
  `accountRoles` varchar(255) DEFAULT NULL,
  `accountRoles_KEY` bigint(20) NOT NULL,
  PRIMARY KEY (`Jukebox_JukeboxID`,`accountRoles_KEY`),
  KEY `FK_co160n4ls426y1ny1x2676ffm` (`accountRoles_KEY`),
  CONSTRAINT `FK_54ibrnspnwkqd3c5ifcoah44l` FOREIGN KEY (`Jukebox_JukeboxID`) REFERENCES `jukebox` (`JukeboxID`),
  CONSTRAINT `FK_co160n4ls426y1ny1x2676ffm` FOREIGN KEY (`accountRoles_KEY`) REFERENCES `account` (`AccountID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 SET character_set_client = @saved_cs_client ;

--
-- Table structure for table `jukebox_savedplaylists`
--

DROP TABLE IF EXISTS `jukebox_savedplaylists`;
 SET @saved_cs_client     = @@character_set_client ;
 SET character_set_client = utf8 ;
CREATE TABLE `jukebox_savedplaylists` (
  `Jukebox_JukeboxID` bigint(20) NOT NULL,
  `savedPlaylists_PlaylistID` bigint(20) NOT NULL,
  PRIMARY KEY (`Jukebox_JukeboxID`,`savedPlaylists_PlaylistID`),
  UNIQUE KEY `UK_fe3niel47rl6b4wn511n037ak` (`savedPlaylists_PlaylistID`),
  CONSTRAINT `FK_ev0dxliv31gdhi3s9unsisews` FOREIGN KEY (`Jukebox_JukeboxID`) REFERENCES `jukebox` (`JukeboxID`),
  CONSTRAINT `FK_fe3niel47rl6b4wn511n037ak` FOREIGN KEY (`savedPlaylists_PlaylistID`) REFERENCES `playlist` (`PlaylistID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 SET character_set_client = @saved_cs_client ;

--
-- Table structure for table `oauthapiinfo`
--

DROP TABLE IF EXISTS `oauthapiinfo`;
 SET @saved_cs_client     = @@character_set_client ;
 SET character_set_client = utf8 ;
CREATE TABLE `oauthapiinfo` (
  `name` varchar(255) NOT NULL,
  `apiKey` varchar(255) DEFAULT NULL,
  `apiSecret` varchar(255) DEFAULT NULL,
  `exampleGetRequest` varchar(255) DEFAULT NULL,
  `scribeApiName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 SET character_set_client = @saved_cs_client ;

--
-- Table structure for table `paypalsettings`
--

DROP TABLE IF EXISTS `paypalsettings`;
 SET @saved_cs_client     = @@character_set_client ;
 SET character_set_client = utf8 ;
CREATE TABLE `paypalsettings` (
  `PayPalSettingsID` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `pricePerSong` double NOT NULL,
  `currency_PAYPALCODE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PayPalSettingsID`),
  KEY `FK_q4ve0mjk889ymq364s5nw1m55` (`currency_PAYPALCODE`),
  CONSTRAINT `FK_q4ve0mjk889ymq364s5nw1m55` FOREIGN KEY (`currency_PAYPALCODE`) REFERENCES `currency` (`PAYPALCODE`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
 SET character_set_client = @saved_cs_client ;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
 SET @saved_cs_client     = @@character_set_client ;
 SET character_set_client = utf8 ;
CREATE TABLE `playlist` (
  `PlaylistID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PlaylistID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
 SET character_set_client = @saved_cs_client ;

--
-- Table structure for table `playlist_song`
--

DROP TABLE IF EXISTS `playlist_song`;
 SET @saved_cs_client     = @@character_set_client ;
 SET character_set_client = utf8 ;
CREATE TABLE `playlist_song` (
  `PlaylistID` bigint(20) NOT NULL,
  `SongID` bigint(20) NOT NULL,
  `songs_KEY` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`PlaylistID`,`songs_KEY`),
  KEY `FK_tapm4cs0iqrt4stg3h7xpb0kx` (`SongID`),
  CONSTRAINT `FK_83oadakqpd3huy9bwg37b80k0` FOREIGN KEY (`PlaylistID`) REFERENCES `playlist` (`PlaylistID`),
  CONSTRAINT `FK_tapm4cs0iqrt4stg3h7xpb0kx` FOREIGN KEY (`SongID`) REFERENCES `song` (`SongID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 SET character_set_client = @saved_cs_client ;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
 SET @saved_cs_client     = @@character_set_client ;
 SET character_set_client = utf8 ;
CREATE TABLE `song` (
  `SongID` bigint(20) NOT NULL AUTO_INCREMENT,
  `artist` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SongID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
 SET character_set_client = @saved_cs_client ;

--
-- Table structure for table `song_metadata`
--

DROP TABLE IF EXISTS `song_metadata`;
 SET @saved_cs_client     = @@character_set_client ;
 SET character_set_client = utf8 ;
CREATE TABLE `song_metadata` (
  `Song_SongID` bigint(20) NOT NULL,
  `metadataProperties` text,
  `metadataProperties_KEY` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`Song_SongID`,`metadataProperties_KEY`),
  CONSTRAINT `FK_ps6rtp9paa6pfbwx67o44t7wk` FOREIGN KEY (`Song_SongID`) REFERENCES `song` (`SongID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 SET character_set_client = @saved_cs_client ;
 SET TIME_ZONE=@OLD_TIME_ZONE ;

 SET SQL_MODE=@OLD_SQL_MODE ;
 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS ;
 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS ;
 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT ;
 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS ;
 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION ;
 SET SQL_NOTES=@OLD_SQL_NOTES ;

-- Dump completed on 2015-05-04 22:04:59

END$$
DELIMITER ;