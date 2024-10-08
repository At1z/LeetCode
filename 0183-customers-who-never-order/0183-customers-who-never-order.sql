# Write your MySQL query statement below
SELECT a.name AS Customers FROM Customers a LEFT JOIN Orders o ON a.id = o.customerId WHERE o.customerId IS NULL;