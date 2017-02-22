# Triggers de création

CREATE DEFINER=`root`@`localhost` TRIGGER `physicalregatta`.`regatta_BEFORE_INSERT` BEFORE INSERT ON `regatta` FOR EACH ROW
BEGIN
	DECLARE chalBegin DATETIME;
    DECLARE chalEnd DATETIME;
    SELECT begin, end INTO chalBegin, chalEnd FROM challenge WHERE challenge.id = NEW.challenge_id;
	IF NEW.date < chalBegin OR NEW.date > chalEnd THEN
		SIGNAL SQLSTATE '09000' SET MESSAGE_TEXT = 'Wrong date regatta', MYSQL_ERRNO = 9000;    
    END IF;
    
	SET NEW.code = newCode(NEW.challenge_id);
END