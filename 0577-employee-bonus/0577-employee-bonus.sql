# Write your MySQL query statement below
SELECT T1.name, T2.bonus FROM employee T1 LEFT JOIN bonus T2 ON T1.empId = T2.empId WHERE T2.bonus < 1000 OR T2.bonus IS NULL;