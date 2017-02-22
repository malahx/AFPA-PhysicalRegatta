CREATE DEFINER=`root`@`localhost` FUNCTION `newCode`(challenge_id INT) RETURNS varchar(10) CHARSET latin1
BEGIN
    DECLARE chalCode VARCHAR(5);
    DECLARE numRegatta INT(4) DEFAULT 0;
    DECLARE dateNow DateTime DEFAULT now();
    SELECT code INTO chalCode FROM challenge WHERE challenge.id = challenge_id;
    SELECT COUNT(r.id)+1 INTO numRegatta FROM regatta r INNER JOIN challenge c ON c.id = r.challenge_id WHERE c.id = 1 GROUP BY c.id;
    RETURN CONCAT(chalCode, '-', MONTH(dateNow), '-', numRegatta);
END
