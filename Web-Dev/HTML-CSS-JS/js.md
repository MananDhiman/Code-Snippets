# DOM
## Important

Form
```javascript
button.setAttribute( "onClick", `updateItem(${i})`); // modify onclick call of button

inputText.value = "New value"; // set value
let name = inputText.value; // get value

// add edit and delete buttons dynamically to list of items 
list.innerHTML += arr[i] + `<button onclick="deleteById(${i})">D</button>` + `<button onclick="editById(${i})">E</button><br>`;

list.innerHTML += `<tr>
            <td>${todoArray[i]}</td>
            <td><button onclick="deleteById(${i})">D</button></td>
            <td><button onclick="editById(${i})">E</button></td>
        </tr>`;
```

Modification
```javascript
const body = document.body;
const div = document.createElement('div');

body.append("Hello World", "Bye"); //can use single parameter also
div.innerText = "Hello World";
body.append(div);

//new div
div.innerHTML = "<strong>Hellow Worl 2</strong>";

//directly access css or style tags
spanText.style.backgroundColor = "red";

//better way is to separate attribute and text
const strong = document.createElement("strong");
strong.innerText = "Hello World 3";
div.append(strong);

div.remove(); //deletes element

console.log(spanText.title || spanText.id); //use getAttribute as alternative

spanText.id = "newID";
spanText.removeAttribute("id");

spanText.classList.add('newClass');
spanText.classList.remove('newClass');
spanText.classList.remove('class');
```

## textContent vs innerText
same but, textContent = displays with spacing, indentation

innerText = displays with respect to css (if visible or not)

# LocalStorage
Permanently stores data as key value pairs in storage. Can be used to store previous score

Stores only strings. HTML 5

```javascript
localStorage.getItem('key');
localStorage.setItem('key','value');
```
