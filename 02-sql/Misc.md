```sql
-- Get last unique entries sorted
select date,max(id), subject_id from attendance group by subject_id;

-- Get last 3 chars. Order by last 3 chars, then id
SELECT name FROM students ORDER BY RIGHT(name, 3), ID
```