# SQL
## DDL Commands:
* CREATE: database objects, tables, and triggers.
```sql
CREATE TABLE customer(
  name VARCHAR(30) NOT NULL,
  id SERIAL PRIMARY KEY
);
```
* ALTER: adding, deleting, and modifying columns of existing tables
* DROP: deletes table
* TRUNCATE: deletes all the data and records from table. Unlike the DROP command, it does not delete the table.
* RENAME: changes the table name

```sql
/* ALTER */
ALTER TABLE table_name DROP COLUMN column_name;

```
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

# MongoDB
* Mongodb good for one to many relationships
* mongodb is scalable as not compulsary data structure
* Case sensitive

**Comparison**
* 'Mongo' -> 'SQL'
* Collection -> Table
* Document -> Single Record

## Secondary Commands
`show dbs`: lists all databases. three created by default

`use <database name>`:  creates database or uses db

`db`: prints currently using database

`show collections`: collections of database

## Commands
### Create
`db.<collection name>.insertOne(<js object>)`
```
db.coll.insert(
	{
    _id: 3, name: “”, price: 1.3, stock: 43,
    reviews: [
      { auth_name: “”, rating: 5 },
      { auth_name: “”, rating: 4 }
    ]
  }
)
```
### Read
`db.<collection>.find()`: if no param then prints all data in coll
* accepts two optional params. query and projection
* **query operators** such as $eq $gt $gte $in $lt $lte $ne $nin | $and $not
* **Insert or Update One vs many** when using one, it operates on top most element sorted by time, and returns
```
db.products.find({name: “pencil”})
db.products.find({price: {$gt: 1.0}})
```

**projections**

which fields to return

First Param Query = {_id: 1}
Second Param Projection = {name:1, _id:0}
```
db.products.find({_id: 1}, {name:1, _id:0}) 
```
* id always returned by default. 

### Update
Pass javascript object in all
```
db.products.updateOne({_id:1}, {$set: {stock:32}}) // two params. first is where, second is what

db.products.updateMany()

db.products.replaceOne()
```

### Delete
deleteOne, deleteMany
