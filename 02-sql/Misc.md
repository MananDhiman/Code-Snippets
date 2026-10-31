```sql
-- Get last unique entries sorted
select date,max(id), subject_id from attendance group by subject_id;

-- Get last 3 chars. Order by last 3 chars, then id
SELECT name FROM students ORDER BY RIGHT(name, 3), ID

-- concat
SELECT name, CONCAT(ROUND(100 * population / (SELECT population FROM world WHERE name = 'Germany')), '%')
AS percentage
FROM world
WHERE continent = 'europe'

--
SELECT CAST(CEILING(AVG(CAST(salary AS FLOAT)) - AVG(CAST(REPLACE(salary, '0', '') AS FLOAT))) AS INT) 
FROM employees;

--
SELECT * FROM x WHERE y IN ('a','b','c')

--
SELECT * FROM x WHERE y LIKE '[a-c]%' -- [a-c] from a to c, [!ac] Neither a nor c  

--
SELECT productName AS [Great Products]

--
SELECT salary * months, COUNT(*)    
FROM employee   
WHERE salary * months = (SELECT MAX(salary * months) FROM employee)  
GROUP BY salary*months

--
SELECT COUNT(*) AS total_patients
FROM patients
WHERE YEAR(birth_date) = 2010;
```