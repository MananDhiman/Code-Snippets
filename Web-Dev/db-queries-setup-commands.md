# SQL
## DDL Commands:
* CREATE: database objects, tables, and triggers.
* ALTER: adding, deleting, and modifying columns of existing tables
* DROP: deletes table
* TRUNCATE: deletes all the data and records from table. Unlike the DROP command, it does not delete the table.
* RENAME: changes the table name

## DML COmmands:
* SELECT
* INSERT
* UPDATE
* DELETE
## DCL Commands:
* GRANT
* REVOKE

## Nested Queries
```sql
SELECT * FROM ( SELECT * FROM posts ORDER BY id DESC LIMIT 3 ) t ORDER BY likes DESC;
```

# PostgreSQL
## DDL
* For Auto Increment use 'SERIAL'

`CREATE TABLE test_table (id SERIAL PRIMARY KEY, name varchar(50));`
## DML
* Insert Into Auto increment column 'default'

`INSERT INTO test_table (id, name) VALUES (default, 'manan');`
## User and Database
CREATE USER `<username>` WITH ENCRYPTED PASSWORD `'<password>'`;

CREATE DATABASE `<dbname>`;

GRANT ALL PRIVILEGES ON DATABASE `<dbname>` TO `<username>`;

## Secondary commands
`\list`: lists all present databases

`\du`: lists users and their role

`\q`: quits postgresql 
 
`\c <databaseName>`: Opens / Uses database 

`\dt`: List all tables in database
