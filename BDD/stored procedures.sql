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

CREATE DEFINER=`root`@`localhost` PROCEDURE `crews`(IN regate_id INT, IN sailboat_id INT)
BEGIN

	SELECT p.firstname AS FIRSTNAME, 
			p.lastname AS LASTNAME 
	    FROM crew cr
        INNER JOIN compete co
        ON co.id = cr.compete_id
	    INNER JOIN entrant e 
	    ON e.id = cr.entrant_id
	    INNER JOIN person p 
	    ON p.id = e.person_id 
	    WHERE co.sailboat_id = sailboat_id
        AND co.regatta_id = regate_id;
    
END

# Procédure 3

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAuditorFrom`(IN challenge_id INT, IN date_début DATETIME, IN date_fin DATETIME)
BEGIN
	
    SELECT r.date AS DATE, 
		   pe.firstname AS AUDITOR_FIRSTNAME, 
		   pe.lastname AS AUDITOR_LASTNAME, 
		   co.name AS COMMITTEE
		FROM panel pa
        INNER JOIN regatta r
        ON r.id = pa.regatta_id
		INNER JOIN auditor a
		ON a.id = pa.auditor_id
		INNER JOIN person pe
		ON pe.id = a.person_id
		INNER JOIN committee co
		ON co.id = a.committee_id
		INNER JOIN challenge ch
		ON ch.id = r.challenge_id
		WHERE ch.id = challenge_id
		AND r.date > date_début
		AND r.date < date_fin;

END