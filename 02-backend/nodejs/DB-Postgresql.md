# Setup
```bash
npm init -y
touch app.js
touch queries.js
npm i express pg
```
# App.js
```javascript
// dependencies and import
const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const port = 3000
const db = require('./queries')

// configure express to parse all response as json
app.use(bodyParser.json())
app.use(
    bodyParser.urlencoded({
        extended: true,
    })
)

// root endpoint for API that should print basic info about API etc...
app.get('/',(request, response) => {
    response.json({
        Server:"Node JS",
        Database:"PostgreSQL",
        Host:"Endeavour OS"
    })
})

// port for host
app.listen(port, () => {
    console.log(`App running on ${port}`)
})

// describing endpoint and corresponding function call
app.get('/users', db.getUsers)
app.post('/user', db.getUserById)
```

# Queries.js
```js
// for local db
const Pool = require('pg').Pool
const pool = new Pool({
    user: 'postgres',
    host: 'localhost',
    database: 'test',
    password: '1234',
    port: 5432
})

// for cloud db such as elephant sql
var pg = require('pg');
var client = new pg.Client("postgres://uri-here");

// Simple GET Request
// Not Arrow Function for clarity
function getUsers(request, response){
  pool.query('SELECT * FROM students ORDER BY id ASC', (error, results) => {
    if (error) {
      throw error
    }
    response.status(200).json(results.rows)
  })
}

// Needs more logic to prevent sql injection
// POST Request, that takes only `id` as parameter from request body
const getUserById = (request, response) => {
  const id = request.body.id

  pool.query(`SELECT * FROM students WHERE id = ${id}`, (error, results) => {
    if (error) {
      throw error
    }
    response.status(200).json(results.rows)
  })
}

// For multiple variables have to pass array
const createPost = async (req, res) => {
    
  const values = [req.body.body, req.body.title, Date.now()];
  client.query(`INSERT INTO posts (id, body, title, time_created) VALUES (default, $1, $2, $3) RETURNING *;`, values, (err, results) => {
    if(err) throw err.message;

    res.status(200).json(results.rows);
  });  

};

// exporting functions to use in app.js
// if too many functions, may add them to a single class
module.exports = {
  getUsers,
  getUserById,
  createPost
}
```