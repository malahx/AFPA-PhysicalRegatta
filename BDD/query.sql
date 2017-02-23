# Requête 1

SELECT c.name AS CHALLENGE, AVG(r.distance) AS AVERAGE
FROM challenge c 
INNER JOIN regatta r
ON c.id = r.challenge_id
GROUP BY c.name

# Requête 2

SELECT p.firstname AS FIRSTNAME, 
	p.lastname AS LASTNAME, 
	e.num_licence AS LICENCE
FROM crew cr
INNER JOIN entrant e
ON e.id = cr.entrant_id
INNER JOIN person p
ON p.id = e.person_id
INNER JOIN compete co
ON co.id = cr.compete_id
WHERE co.regatta_id = 3

# Requête 3

SELECT r.name AS REGATTA, 
	r.date AS DATE, 
	pe.firstname AS AUDITOR_FIRSTNAME, 
	pe.lastname AS AUDITOR_LASTNAME, 
	c.name AS COMMITTEE
FROM panel pa
INNER JOIN auditor a
ON a.id = pa.auditor_id
INNER JOIN committee c
ON c.id = a.committee_id
INNER JOIN person pe
ON pe.id = a.person_id
INNER JOIN regatta r
ON r.id = pa.regatta_id
WHERE r.date > '2016-02-15 09:00:00'