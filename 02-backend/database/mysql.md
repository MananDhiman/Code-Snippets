# MySQL
## User and Database
CREATE USER 'admin'@’localhost’ IDENTIFIED BY 'admin';

GRANT ALL PRIVILEGES ON *.* TO 'admin'@'localhost' WITH GRANT OPTION;

## Types

### Data Definition Language

CREATE, ALTER, DROP, TRUNCATE, RENAME

### Data Manipulation Language

INSERT, UPDATE, DELETE

### Data Query - SELECT

### Data Control

GRANT, REVOKE

## DDL

```sql
CREATE DATABASE db_name;

DROP DATABASE db_name;

CREATE TABLE bands (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
);

CREATE TABLE albums (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  band_id INT,
  PRIMARY KEY(id),
  FOREIGN KEY (band_id) REFERENCES bands(id)
);

DROP TABLE test;
```

```sql
ALTER TABLE table_name ADD another_column VARCHAR(255);

ALTER TABLE table_name
DROP COLUMN column_name;

ALTER TABLE table_name
RENAME COLUMN old_name to new_name;

ALTER TABLE table_name
ALTER COLUMN column_name datatype;
```

## DML

INSERT

```sql
INSERT INTO bands (name) VALUES ('Iron Maiden');

INSERT INTO bands (name) VALUES
  ('Iron Maiden'),
  ('Avenged Sevenfold'),
  ('Ankor');
```

UPDATE

```sql
UPDATE albums SET release_year=1982 WHERE id=1;
```

SELECT

```sql
-- limit number of results
SELECT * FROM bands LIMIT 2;

-- skip a number of results
SELECT * FROM bands OFFSET 5;

-- first offset, then limit (pagination)
SELECT * FROM sub_categories LIMIT 1,2;
-- same as above
SELECT * FROM sub_categories LIMIT 2 OFFSET 1;

-- choose columns to display
SELECT name FROM bands;

-- where
WHERE release_year < 2000;
WHERE id % 2 = 0;
WHERE area >= 3000000 OR population >= 25000000;

WHERE release_year IS NULL;

WHERE NOT city=’Berlin’;

WHERE release_year BETWEEN 2000 and 2018;

WHERE LENGTH(content) > 15;

WHERE CITY NOT LIKE "%a";

WHERE name LIKE "%er%" OR band_id=2;

-- column alias
SELECT id AS 'ID', name AS 'Band Name' FROM bands;

-- order by
FROM bands ORDER BY name;
customers ORDER By country, city DESC; -- alphabetically, first by country, then city desc;

-- distinct values of column
DISTINCT name FROM albums;

-- search in multiple given columns
SELECT * FROM table WHERE 'val' IN (col1, col2, ..., colN) ;
```

DELETE

```sql
-- del everything
DELETE FROM albums;

DELETE FROM albums WHERE id=5;
```

Wildcard, AND OR

% - everything

```sql
SELECT * FROM albums WHERE name LIKE '%er%';

-- where the first letter is an "a" or "c" or "s".
WHERE City LIKE '[acs]’ %';

-- where the first letter starts with anything from an "a" to an "f"
WHERE City LIKE ‘[a-f]%’;

-- where the first letter of the City is NOT "a" or "c" or "f"
WHERE CITY LIKE ‘![acf]’
```

JOIN

INNER / LEFT / RIGHT
```sql
-- basic syntax
SELECT tbl1.col1, tbl2.col1, tbl2.col2 FROM tbl1 INNER JOIN tbl2 ON tbl1.id = tbl2.fkid;
```

```sql
SELECT * FROM bands JOIN albums ON bands.id = albums.band_id;
```

AGGREGATE FUNCTIONS

```sql
SELECT AVG(release_year) FROM albums; -- SUM(), COUNT()
SELECT band_id, COUNT(albums) FROM albums;
```

GROUP BY

Where runs before group by

```sql
SELECT albums FROM albums GROUP BY band_id;

SELECT COUNT(id) AS 'Customer Count', country FROM customers GROUP BY country;
SELECT category, SUM(units) AS 'total units' FROM products GROUP BY category HAVING SUM(units) > 300    ;

```

MISC

```sql
SELECT b.name AS band_name, COUNT(a.id) AS num_albums
FROM bands AS b
LEFT JOIN albums AS a ON b.id = a.band_id
GROUP BY b.id;

SELECT b.name AS band_name, COUNT(a.id) AS num_albums
FROM bands AS b
LEFT JOIN albums AS a ON b.id = a.band_id
GROUP BY b.id
HAVING num_albums = 1;
```

### Subqueries / nested queries
```sql
select f_name, last_name, (select AVG(hourly_pay) from employees) AS avg_pay FROM emp;
select f_name from emp  where h_pay > (select avg(h_pay) from emp);
```

### AUTOCOMMIT, COMMIT, ROLLBACK
- AUTOCOMMIT when execute trans, it is saved. 
- To be able to Undo trans. SET AUTOCOMMIT = OFF. 
- When saving trans.: COMMIT. 
- ROLLBACK will restore previous commit

Primary key
```sql
CREATE TABLE trans(
  trans_id PRIMARY KEY AUTO_INCREMENT,
  amount DECIMAL(5,2)
);

alter table trans ADD CONSTRAINT PRIMARY KEY(t_id);
```
Foreign KEY
```sql
CREATE TABLE transactions (
  transaction_id INT PRIMARY KEY AUTO_INCREMENT,
  amount DECIMAL(5, 2),
  customer_id INT,
  FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

ALTER TABLE customers
ADD CONSTRAINT fk_customer_id
FOREIGN KEY (customer_id) REFERENCES customers(customer_id);

ALTER TABLE `posts`
ADD  CONSTRAINT `user_id`
FOREIGN KEY (`user_id`) REFERENCES `users`(`id`)
ON DELETE RESTRICT ON UPDATE RESTRICT;
```
### Views
virtual tables, made from real table change to original table will update the view
```sql
CREATE VIEW e_att AS
SELECT f_name, l_name
FROM emp;
```

### Index
Data Structure to find value in col. B-tree. mysql searches sequentially. update takes more time, select takes less time
```sql
SHOW INDEXES FROM customers;

CREATE INDEX last_name_idx ON CUSTOMERS(last_name);

CREATE IDNEX f_l_idx ON custoemrs(last_name, f_name);

ALTER TABLE customers DROP INDEX last_name_idx;
```