# JSON
```javascript
let jsonData = {
    name: "John",
    age: 25,
    arr: [1,3,5,7],
    obj:{
        name: "Obj",
        arr: [
            {name:"Name0", age:20},
            {name:"Name1", age:21},
            {name:"Name2", age:22}
        ]
    }
};

console.log(jsonData.name);
console.log(jsonData.arr[3]);
console.log(jsonData.obj.arr[1].name);

let emp = {"employees":[
    { "firstName":"John", "lastName":"Doe" },
    { "firstName":"Anna", "lastName":"Smith" },
    { "firstName":"Peter", "lastName":"Jones" }
]};
console.log(emp.employees[0].firstName);
```

# Objects

```javascript
// Destructure
// Taking properties out of an object
const { message, price} = object4;

// Function in Object
const obj5 = {
    method: function functionName(){
        console.log('Method');
    }
}
```