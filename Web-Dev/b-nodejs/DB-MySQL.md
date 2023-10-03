# Connection
```js
const mysql = require('mysql');

var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "",
  database: "test_database"
});
```
## Check if connection successfull
```js
con.connect(function(err) {
  if(err) throw err.message; 
});
```

# READ
```js
app.get('/all', (req, res) => {
  console.log('api hit');
  
  let sqlResult = null;
  con.query("SELECT * FROM test_table", function(err, result, fields) {
    if(err) throw err;

    sqlResult = result;
console.log(sqlResult);
  });
});
```