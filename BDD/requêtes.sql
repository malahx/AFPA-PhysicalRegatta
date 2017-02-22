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
FROM crew c
INNER JOIN entrant e
ON e.id = c.entrant_id
INNER JOIN person p
ON p.id = e.person_id
INNER JOIN sailboat s
ON s.id = c.sailboat_id
INNER JOIN register r
ON r.sailboat_id = s.id
WHERE r.regatta_id = 3

# Requête 3

SELECT r.name AS REGATTA, 
	r.date AS DATE, 
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
WHERE r.date > '2016-02-15 09:00:00'