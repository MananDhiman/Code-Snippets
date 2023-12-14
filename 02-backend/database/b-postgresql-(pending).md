# Postgresql

## Secondary commands
`\list`: lists all present databases

`\du`: lists users and their role

`\q`: quits postgresql 
 
`\c <databaseName>`: Opens / Uses database 

`\dt`: List all tables in database

## User and Database

CREATE USER `<jonathan>`;

CREATE USER `<username>` WITH ENCRYPTED PASSWORD `'<password>'`;

CREATE DATABASE `<dbname>`;

GRANT ALL PRIVILEGES ON DATABASE `<dbname>` TO `<username>`;


## DML
* For Auto Increment use 'SERIAL'

`CREATE TABLE test_table (id SERIAL PRIMARY KEY, name varchar(50));`
* Insert Into Auto increment column 'default'

`INSERT INTO test_table (id, name) VALUES (default, 'manan');`

## Text vs char vs varchar

Both CHAR(n) and VARCHAR(n)can store up to n characters. If you try to store a string that has more than n characters, PostgreSQL will issue an error.

## TEXT

TEXT unlimited length.

If not specify the n for VARCHAR, behavess like the TEXT datatype.

performance of the VARCHAR (without the size n) and TEXT same

## Types

Serial

- Smallserial 32707
- Serial 2.1 bill
- Bigserial 9223372036854775807
  Int
- Smallint -32k to 32k
- Integer -2.1 bil to 2.1 bil
- Bigint -9223372036854775808 to 9223372036854775807
  Float
- Decimal / numeric 13k whole digits and 16k after decimal
- real 1e-37 to 1e37
- double precision 1e-307 to 1e308. 15 precision place. when not very precise
  Boolean
- True, 1, t,y,yes,on
- False, 0,f,n,no,off
- null
- Binary, JSON, Array, XML

### Date

<img src="../_images/postgres-date-time.png">

```sql
CREATE TABLE customer(
first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  state CHAR(2) NOT NULL,
  zip SMALLINT NOT NULL,
  birth_date DATE NULL,
  date_entered TIMESTAMP NOT NULL,
  id SERIAL PRIMARY KEY
);
```

```sql
CREATE TABLE sales_person(
  state CHAR(2) NOT NULL DEFAULT 'PA',
  sex sex_type NOT NULL,
);
```

```sql
INSERT INTO customer(first_name,
  last_name,
  email,
  company,
  street,
  city,
  state,
  zip,
  phone,
  birth_date,
  sex,
  date_entered)
  VALUES  ('C', 'J', 'c@c.com','BP', '347 Cedar',
    'Lawrencevill','GA', '30044', '348-848',
    '1938-09-11','M', current_timestamp);
```

## No need to have id column when INSERT INTO table_name (id) when serial

VALUES (‘c’,’j’)

DATE: current_timestamp,

`SELECT * from customer ORDER BY id ASC; // may need public.customer`

Create own data type

`CREATE TYPE sex_type as enum ('M', 'F');`

Set Custom data type

`ALTER TABLE customer ALTER COLUMN sex TYPE sex_type USING sex::sex_type;`

Foreign Key

```sql
CREATE TABLE product(
  type_id INTEGER REFERENCES product_type(id),
  description TEXT NOT NULL,
);
```

```sql
-- ALter table add column
ALTER TABLE sales_item ADD day_of_week VARCHAR(8);
-- modify column
ALTER TABLE sales_item ALTER COLUMN day_of_week SET NOT NULL;
-- rename col
ALTER TABLE sales_item RENAME COLUMN day_of_week to weekday;
-- del col
ALTER TABLE sales_item DROP COLUMN weekday;
```

````sql
-- mod table name
ALTER TABLE transaction_type RENAME to transaction;
```sql
-- ???index based on individual column???
```sql
CREATE INDEX transaction_id ON transaction(name);
CREATE INDEX transaction_id_2 ON transaction(name, payment_type);
````

```sql
TRUNCATE TABLE transaction; -- delete table data

-- CHnage data type column
ALTER TABLE sales_person ALTER COLUMN zip TYPE INTEGER;
```
