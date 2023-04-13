# DOM Manipulation
## Important
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
