# Write your MySQL query statement below
SELECT DISTINCT a.email AS Email FROM Person a JOIN Person b ON a.email = b.email WHERE a.id <> b.id;
