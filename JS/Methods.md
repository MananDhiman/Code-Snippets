# JSON
```javascript
let jsonData = {
    name: "John",
    age: 25,
    arr
};

let jsonAsString = JSON.stringify(jsonData);
let jsonAsJson = JSON.parse(jsonAsString);
```
# Time
setTimeout
```javascript
// runs function after given time (milliseconds)
setTimeout({
    console.log('timeout');
}, 3000);

// keeps calling function after given interval

setInterval({
    console.log('time interval');
},3000);
```