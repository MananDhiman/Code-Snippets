## User and Database
CREATE USER <username> WITH ENCRYPTED PASSWORD ‘<password>’;
CREATE DATABASE <dbname>;
GRANT ALL PRIVILEGES ON DATABASE <dbname> TO username;

## Secondary commands
\list
lists all present databases

\du
lists users and their role

\q
quits postgresql 
 
\c <databaseName>
Opens / Uses database 

\dt
List all tables in database
