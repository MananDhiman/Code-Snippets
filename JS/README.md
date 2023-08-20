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
function doSomething(a, b){
    return a + b;
}

//arrow function
let doSomething = (a,b) => {
    return a+b
}

//minimised arrow function
let doSomething = (a,b) => a+b

// minimised single param
let doSomething = a => a*a

// arrow function no param
let doSomething = () => console.log("Arr Fun")

// if no braces after arrow, then tries to return the value
```

# Function as variable
```javascript
function run(param){
    param();
}

run(function(){
    console.log('hello4');
});
```

# Built in DS
## Map
```javascript
const map = new Map();

map.set("jan","31");
map.set("mar","31");
map.set("may","31");

// get value by key
console.log(map.get("may"));

// check if key exists
if(map.has("nov")) console.log("Winter");
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
// let i for arr is used to access element


let arr = [5,10,15];

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

map.set("jan","31");
map.set("mar","31");
map.set("may","31");

for (let i of map) console.log(`of map, i = ${i}`);
// of map, i = jan,31
// of map, i = mar,31
// of map, i = may,31
```

# Async / Await
The keyword async before a function makes the function return a promise
The await keyword can only be used inside an async function.
The await keyword makes the function pause the execution and wait for a resolved promise before it continues:

```javascript
getParsedDataCollection().then( list => {

    const allCurrencies = list[0];
    const eurRate = list[1]["eur"];

});

async function getParsedDataCollection() {

    const allCurrencies = await getJsonFromApi(URL_ALL_CURRENCIES_AND_SHORTFORM);
    const currencyRateEurAsBase = await getJsonFromApi(URL_EUR_AS_BASE_TO_OTHER_CURRENCIES);

    return [allCurrencies, currencyRateEurAsBase];
}


async function getJsonFromApi(url) {

    const response = await fetch(url);

    var data = await response.json();

    return data;
}

```
