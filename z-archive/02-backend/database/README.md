Get last unique entries sorted
`select date,max(id), subject_id from attendance group by subject_id;`

## URI / URL
MongoDB
`mongodb+srv://<user>:<password>@mongodb0.example.com/<optional-db>?authSource=admin&replicaSet=myRepl`

PostgreSQL
```shell
postgresql://[userspec@][hostspec][/dbname][?paramspec]
postgresql://
postgresql://localhost
postgresql://localhost:5433
postgresql://localhost/mydb
postgresql://user@localhost
postgresql://user:secret@localhost
postgresql://other@localhost/otherdb?connect_timeout=10&application_name=myapp
postgresql://host1:123,host2:456/somedb?target_session_attrs=any&application_name=myapp
```
