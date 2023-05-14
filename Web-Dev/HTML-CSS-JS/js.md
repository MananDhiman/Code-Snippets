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
const arr = [10,20,40];
arr.push(50); arr.pop();
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

# DOM
## Important

Modification
```javascript
const body = document.body
const div = document.createElement('div')

body.append("Hello World", "Bye") //can use single parameter also
div.innerText = "Hello World"
body.append(div)

//new div
div.innerHTML = "<strong>Hellow Worl 2</strong>"

//directly access css or style tags
spanText.style.backgroundColor = "red"

//better way is to separate attribute and text
const strong = document.createElement("strong")
strong.innerText = "Hello World 3"
div.append(strong)

div.remove() //deletes element

console.log(spanText.title || spanText.id) //use getAttribute as alternative

spanText.id = "newID"
spanText.removeAttribute("id")

spanText.classList.add('newClass')
spanText.classList.remove('newClass')
spanText.classList.remove('class')
```

## textContent vs innerText
same but, textContent = displays with spacing, indentation
innerText = displays with respect to css (if visible or not)
