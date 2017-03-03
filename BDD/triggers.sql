# Triggers de création

CREATE DEFINER=`root`@`localhost` TRIGGER `physicalregatta`.`regatta_BEFORE_INSERT` BEFORE INSERT ON `regatta` FOR EACH ROW
BEGIN

	DECLARE chalBegin DATETIME;
    DECLARE chalEnd DATETIME;

    SELECT begin, end 
        INTO chalBegin, chalEnd 
        FROM challenge 
        WHERE challenge.id = NEW.challenge_id;

	IF NEW.date < chalBegin OR NEW.date > chalEnd THEN

		SIGNAL SQLSTATE '09000' SET MESSAGE_TEXT = 'Wrong date regatta', MYSQL_ERRNO = 9000;   

    END IF;
    
	SET NEW.code = newCode(NEW.challenge_id, NEW.date);

END

# Triggers de mise à jour

CREATE DEFINER=`root`@`localhost` TRIGGER `physicalregatta`.`compete_BEFORE_UPDATE` BEFORE UPDATE ON `compete` FOR EACH ROW
BEGIN

    DECLARE num_sailboat INT(4) DEFAULT 0;
    DECLARE class_id_sailboat INT(11);
    
    SELECT class_id 
        INTO class_id_sailboat 
        FROM sailboat s 
        WHERE s.id = NEW.sailboat_id;
        
    SELECT COUNT(co.id) 
        INTO num_sailboat
        FROM compete co 
        INNER JOIN sailboat s 
        ON s.id = co.sailboat_id 
        INNER JOIN sbclass cl 
        ON cl.id = s.class_id 
        WHERE co.regatta_id = NEW.regatta_id
        AND s.class_id = class_id_sailboat
        GROUP BY co.regatta_id;
        
    IF num_sailboat < NEW.position THEN
    
        SIGNAL SQLSTATE '09001' SET MESSAGE_TEXT = 'Wrong position', MYSQL_ERRNO = 9001;
        
    END IF;
    
END

# Triggers de suppression

CREATE DEFINER=`root`@`localhost` TRIGGER `physicalregatta`.`regatta_BEFORE_DELETE` BEFORE DELETE ON `regatta` FOR EACH ROW
BEGIN

    DECLARE chalEnd DATETIME;

    SELECT end 
        INTO chalEnd 
        FROM challenge 
        WHERE challenge.id = OLD.challenge_id;

    IF now() < chalEnd THEN

        SIGNAL SQLSTATE '09002' SET MESSAGE_TEXT = 'Can\'t delete a not finished challenge', MYSQL_ERRNO = 9002;  

    END IF;

END