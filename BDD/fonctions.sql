CREATE DEFINER=`root`@`localhost` FUNCTION `newCode`(challenge_id INT, regatta_date DATETIME) RETURNS varchar(10) CHARSET latin1
BEGIN
	DECLARE chalCode VARCHAR(5);
    DECLARE numRegatta INT(4) DEFAULT 0;
	SELECT code INTO chalCode FROM challenge c WHERE c.id = challenge_id;
    SELECT COUNT(r.id)+1 INTO numRegatta FROM regatta r INNER JOIN challenge c ON c.id = r.challenge_id WHERE c.id = 1 GROUP BY c.id;
    
	RETURN CONCAT(chalCode, '-', MONTH(regatta_date), '-', numRegatta);
END