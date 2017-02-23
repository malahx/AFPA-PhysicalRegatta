# Procédure 1

CREATE DEFINER=`root`@`localhost` PROCEDURE `average`(IN challenge_id INT)
BEGIN

	SELECT c.name AS CHALLENGE, AVG(r.distance) AS AVERAGE
	FROM challenge c 
	INNER JOIN regatta r
	ON c.id = r.challenge_id
    WHERE c.id = challenge_id
	GROUP BY c.name;

END

# Procédure 2

CREATE DEFINER=`root`@`localhost` PROCEDURE `crews`(IN sailboat_id INT)
BEGIN

	SELECT p.firstname AS FIRSTNAME, 
		p.lastname AS LASTNAME 
    FROM crew c 
    INNER JOIN entrant e 
    ON e.id = c.entrant_id 
    INNER JOIN person p 
    ON p.id = e.person_id 
    WHERE c.sailboat_id = sailboat_id;
    
END

# Procédure 3

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAuditorFrom`(IN challenge_id INT)
BEGIN
	
    SELECT r.date AS DATE, 
		p.firstname AS AUDITOR_FIRSTNAME, 
		p.lastname AS AUDITOR_LASTNAME, 
		c.name AS COMMITTEE
	FROM regatta r
	INNER JOIN auditor a
	ON a.id = r.auditor_id
	INNER JOIN person p
	ON p.id = a.person_id
	INNER JOIN committee c
	ON c.id = a.committee_id
	INNER JOIN challenge cha
	ON cha.id = r.challenge_id
	WHERE cha.id = challenge_id;

END