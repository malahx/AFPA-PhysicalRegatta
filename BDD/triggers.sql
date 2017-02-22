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

# Triggers de mise à jour

CREATE DEFINER=`root`@`localhost` TRIGGER `physicalregatta`.`register_BEFORE_UPDATE` BEFORE UPDATE ON `register` FOR EACH ROW
BEGIN
	DECLARE numSailboat INT(4) DEFAULT 0;
    DECLARE classSailboat INT(11);
    SELECT class_id INTO classSailboat FROM sailboat s WHERE s.id = OLD.sailboat_id;
    SELECT COUNT(r.id) INTO numSailboat FROM register r INNER JOIN sailboat s ON s.id = r.sailboat_id INNER JOIN class c ON c.id = s.class_id WHERE r.regatta_id = OLD.regatta_id AND s.class_id = classSailboat GROUP BY c.id;
    IF numSailboat < NEW.position THEN
		SIGNAL SQLSTATE '09001' SET MESSAGE_TEXT = 'Wrong position', MYSQL_ERRNO = 9001;
    END IF;
END