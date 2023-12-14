# Create
```sh
npx create-react-app <app name here>
# or
npm init react-app <app name here>
npm start
# or
npm install -g create-react-app-offline
crao -n appname
# or
npm create vite@latest
```
Compulsary files is index.js

## App.js
```javascript
function App(){
  return(
    <div>
      // website
    </div>
  )
}

export default App
```

## index.js
```javascript
import React from 'react';
import ReactDOM from 'react-dom';
import `component` from '`components/component`';

// ReactDom.render(what, where, optional callback)
ReactDOM.render(<`component`/>, document.getElementById('root'));
// or
ReactDOM.render(<h1>Hello World</h1>, document.getElementById(“root”))
```

## Component
### Function
```javascript
function Component() {
  // logic goes here
  console.log('about to show component');
  const flag = true;

  // content to be displayed inside return. Can only return single element so <div></div> pr <></>
  return (
    { flag ? <h4>If true<h4>: <h4>if false</h4> }
  )
}

export default Component;
```
### Function Example
```javascript
import { useState } from "react";

function TodoFormAndList() {

  const [newTodo, setNewTodo] = useState("");
  const [todoList, setTodoList] = useState([]);
  
  function handleAddTodo() {
    if(newTodo === "") alert("Empty Text");
    else {
      const newList = todoList.concat(newTodo);
      setTodoList(newList);
      setNewTodo("");
    }
  }

  return (
    <>
      <input type="text" placeholder="Todo" onChange={(e) => setNewTodo(e.target.value)} value={newTodo}/>
      <button onClick={handleAddTodo}>Add</button>
      { todoList.map((data) => <p>{data}</p>) }
    </>
  );

}

export default TodoFormAndList;
```
### Class
```javascript
import React, { Component } from 'react';

class `component` extends Component {
  state = {
    count: 1
  };

  render() {
    //return <h1>Hello</h1>;
    return (
      <span>{this.state.count}</span>
      <span>{foo()}</span>
      <h1>Hello</h1>
      <button>Button that Does</button>
      </div>
    );
  }

  foo(){
    //return this.state.count;
    const { count } = this.state;
    return count;

  }
}

export default `component`;
```
Uses JSX (JavaScript XML)



## Props (Data from parent to child)
* Props is an object, not Meant to be Change
* to use props, set as param in child function

```js
// child component
function Child(props) { 
  // const name = props.name
}

// in parent
<Employee name=”Caleb” />
<Employee name=”Caleb” role=”intern” />

// ternary op if props exist:
{props.role ? props.role : “No Role”}
```

## Hooks
### State

* State is tied to UI, keeps track of values
* Never save variable directly, always use function
```js
import { useState } from ‘react’;

function Comp() {
  const [value, funToSetValue] = useState("default value" );
  const [arr, setArr] = useState([]);


  // wherever set value
  function update() {
    console.log(value);
    funToSetVar("updated value");
    console.log(value);
  }
}
```