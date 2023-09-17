## Nested Queries
```sql
SELECT * FROM ( SELECT * FROM posts ORDER BY id DESC LIMIT 3 ) t ORDER BY likes DESC;
```