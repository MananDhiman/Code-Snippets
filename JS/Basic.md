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
const //immutable
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
```