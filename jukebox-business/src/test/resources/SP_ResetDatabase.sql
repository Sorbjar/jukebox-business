DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ResetDatabase`()
BEGIN
CALL `jukebox`.`SP_DropWholeJukebox`();
CALL `jukebox`.`SP_CreateTables`();
END$$
DELIMITER ;