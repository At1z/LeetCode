# Write your MySQL query statement below
SELECT DISTINCT 
    b.id AS "Id" 
FROM 
    Weather a, Weather b  
WHERE  
    b.recordDate = DATE_ADD(a.recordDate, INTERVAL 1 DAY)  
AND 
    b.temperature > a.temperature;