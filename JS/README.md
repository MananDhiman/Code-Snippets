# Concepts

## Variable scope

```javascript
//let is standard scope
<script src="script.js" type="module"> //isolates variables of each file

//To export from Module
const moduleVar = "Module"
export const exportedVar = "Exported"

//In other file
import { exportedVar } from "./firstScript.js"
```

# Syntax

```javascript
var //function scope
const //immutable block scope
let //block scope

== //loose equality. performs type conversion
=== //strict equality. no type conversion

const num = 0;
const obj = new String("0");
const str = "0";
//on using ==, result will be true
//on using ===, result will be false

//array
let arr = [30,50,60]; // empty declaration
const arrr = [10,20,40];
arr.push(50);
arr.pop();
arr.reverse();

//type conversion
String()
Number()
let num = Number("98");

// String Template
let n = 7;
for(let i=0; i<=10; i++){
    console.log(`${n} X ${i} = ${n * i}`);
}
```

# Function

```javascript
//function
//arguments as value
//objects as reference
function doSomething(a, b) {
  return a + b;
}

//arrow function
let doSomething = (a, b) => {
  return a + b;
};

//minimised arrow function
let doSomething = (a, b) => a + b;

// minimised single param
let doSomething = (a) => a * a;

// arrow function no param
let doSomething = () => console.log("Arr Fun");

// if no braces after arrow, then tries to return the value
```

# Function as variable

```javascript
function run(param) {
  param();
}

run(function () {
  console.log("hello4");
});
```

# Built in DS

## Map

```javascript
const map = new Map();

map.set("jan", "31");
map.set("mar", "31");
map.set("may", "31");

// get value by key
console.log(map.get("may"));

// check if key exists
if (map.has("nov")) console.log("Winter");
else console.log("No WInter");

// delete key - pair
map.delete("may");
console.log(map.get("may"));

// iterate through each element
map.forEach(function (value, key) {
  console.log(key + "- " + value);
});
```

## For Loop

```js
// let i in arr is used to access keys or index
// let i of arr is used to access element

let arr = [5, 10, 15];

for (let i in arr) console.log(`in arr, i = ${i}`);

// in arr, i = 0
// in arr, i = 1
// in arr, i = 2

for (let i of arr) console.log(`of arr, i = ${i}`);

// of arr, i = 5
// of arr, i = 10
// of arr, i = 15

let str = "Name";

for (let i in str) console.log(`in str, i = ${i}`);
// in str, i = 0
// in str, i = 1
// in str, i = 2
// in str, i = 3

for (let i of str) console.log(`of str, i = ${i}`);
// of str, i = N
// of str, i = a
// of str, i = m
// of str, i = e

const map = new Map();

map.set("jan", "31");
map.set("mar", "31");
map.set("may", "31");

for (let i of map) console.log(`of map, i = ${i}`);
// of map, i = jan,31
// of map, i = mar,31
// of map, i = may,31
```

## Array Iteration

```js
const arr = [1, 2, 3];

// foreach -> simply iterates over elements
arr.forEach(function (item, index) {
  console.log(item, index);
});

// map -> takes item, returns after operation
const doubled = arr.map(function (item) {
  return item * 2;
});
console.log("Doubled", doubled);

// filter -> take item and check for condition. if true, returns elements
const evens = arr.filter(function (item) {
  return item > 1;
});
console.log("> 1", evens);

// reduce -> do something, pass result to next iteration
const sum = arr.reduce(function (result, item) {
  return result + item;
}, 0); // initial item);

// some -> returns boolean if condition true by single element
const hasNeg = arr.some(function (item) {
  return item < 0;
});

// every -> returns true if every number returns true condition
const hasPos = [1, 2 - 1].every(function (item) {
  return item < 0;
});
```

# Promise

- can resolve, or fail
- cleaner way of callback
- for something that takes long time, like downloading image
- promise meant to replace callback

```js
let p = new Promise((resolve, reject) => {
  let a = 1 + 1;
  if (a == 2) {
    resolve(“succ”);
  } else {
    reject(“failed”);
  }
});

// resolve if successful
// catch catches error by reject
p().then((message) => {
  c.log(“in then ” + message);
}).catch((message) => {
  c.log(‘the catch ’ + message);
})

// methods
// when all completed
Promise.all([p1, p2, p3]).then((messages) => { // messages is array })

// runs when any one completed
Promise.race([p1, p2, p3]).then((message) => { })
```

# Async / Await
- Synactical Wrapper around Promise
- The keyword async before a function makes the function return a promise
- The await keyword can only be used inside an async function.
- The await keyword makes the function pause the execution and wait for a resolved promise before it continues:

```javascript
getParsedDataCollection().then((list) => {
  const allCurrencies = list[0];
  const eurRate = list[1]["eur"];
});

async function getParsedDataCollection() {
  const allCurrencies = await getJsonFromApi(URL_ALL_CURRENCIES_AND_SHORTFORM);
  const currencyRateEurAsBase = await getJsonFromApi(
    URL_EUR_AS_BASE_TO_OTHER_CURRENCIES
  );

  return [allCurrencies, currencyRateEurAsBase];
}

async function getJsonFromApi(url) {
  const response = await fetch(url);

  var data = await response.json();

  return data;
}
```
