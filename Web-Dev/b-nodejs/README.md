# NPM
## Package, Start
Define run commands in script in package.json
```json
"start": "node src/app.js"
"start": "npx nodemon src/app.js"
```
then in root folder `npm run start`

## Dependenices
`npm install xyz abc`

To referesh package.json, or download all dependencies in package.json `npm install`

## ES Modules vs ECMAscript Modules
Instead of common es modules that are accomplished using `const fs = require(“fs”)`, it is preferred to use ecmascript modules.

`npm init` to create a project / package.

To use, make changes to package.json: add `type=”module”`
```js
import sH from "superheroes";
console.log(sH.random());
```


# File handling
fs.open() method takes a "flag" as the second argument, if the flag is "w" for "writing", the specified file is opened for writing. 

If the file does not exist, an empty file is created.



```js
const fs = require("fs")

// write to file
fs.writeFile("message.txt", "Hello from Node JS", (err) => {
    if (err) throw err;
    console.log("File saved");
});

// append to file
fs.appendFile("message.txt", "Helllo again", (err) => {
    if (err) throw err;
    console.log("Appended");
});

// read from file. Use utf8 encoding otherwise raw buffer printed
fs.readFile("message.txt", "utf8", (err, data) => {
    if (err) throw err;
    console.log("Data -> "+data);
});

// delete file
fs.unlink("example_file.txt", (err) => {
  if (err) console.log(err);
  else {
    console.log("\nDeleted file: example_file.txt");
  }
});

// Rename the file
fs.rename('original.txt', 'changed.txt', () => {
  console.log("\nFile Renamed!\n");
});
```
# ENV Files
.env files or variables are defined in a hidden file on local machine. Not to be added to git as they contain device specific data or auth data

`npm install dotenv`

In .env in root folder
```env
PORT=3005
CONNECTION_URI=mongodb://127.0.0.1/test
```
In app.js
```js
require(‘dotenv’).config();

const PORT = process.env.PORT || 3000;
```

# Include another JS File
In app.js
```js
const Customer = require('./models/customers');
```

# HTTP Server
For automatic reloading of server, `npm install nodemon`

Run using nodemon app.js or change script to `npx nodemon src/app.js`
## Vanilla Node HTTP Server
* if sending an object, res.send and res.json are same
* res.json will convert non objects (ex. null, undefined etc) to JSON which is invalid
```js
const http = require('http'); // built in 

// postitional params. request received, response sent
const server = http.createServer((req, res) => {
 res.statusCode = 200;
 res.setHeader('Content-Type', 'text/html');
 res.send('<h1>Hello, Node</h1>')
});

server.listen(3000, () => {
 console.log('Server Running');
});
```

## Express
```js
const express = require('express');
const app = express();
const PORT = 3000;

app.get('/', (req, res) => {
 res.send('Express Working with npm start');
});

// app.listen starts the server
app.listen(PORT, () => {
 console.log("App listeining on " + PORT);
});
```
### GET JSON From Request
```js
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// req.body.<param>
app.post('/', (req, res) => {
 res.send(req.body);
});
```
### Req and Res methods
```js
req.rawHeaders 

// send file as response w/o file handling
res.sendFile(__dirname + "file.txt")
```
### Parameterised URL & Query String Param
* / is treated as different path

* ? is treated as optional param or query

* & for multiple queries

**Ex:**
```
/api/customers?id=1
/api/customers/diff?id=1&name=omae 
```
**URL:**

`http://localhost:3005/api/customers/125/this-is-name?query=test`

**Code:**
```js
app.get('/api/customers/:id/:name', async(req,res) => {
  res.json({
    requestParams: req.params,
    requestQuery: req.query
  })
});
```
**Output**
```json
{
  "requestParams": {
    "id": "125",
    "name": "this-is-name"
  },
  "requestQuery": {
    "query": "test"
  }
}
```