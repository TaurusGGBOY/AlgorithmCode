# Write your MySQL query statement below
SELECT t1.Score AS score, (SELECT COUNT(DISTINCT t2.Score) FROM Scores t2 WHERE t1.Score <= t2.Score) AS `rank` FROM Scores t1
ORDER BY t1.Score DESC
