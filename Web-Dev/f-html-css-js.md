# Include Bootstrap
```html
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
```
# Include jQuery
```html
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
```
# HTML
## Tags
* div = enclosing any element(s) in div, makes them occupy entire width
* pre = preformatted text
* anchor a target (attribute)
    * **_blank** = link in new window or tab
    * **_self** = link in same frame as clicked  (this is default)
    * **_parent** = parent frame
    * **_top** = full window body
    * **framename**  = in named iframe
* audio
    * can add fallback by adding second source
    * **autoplay, muted, loop** = runtime conditions applied at runtime
    * source has option  al type attribute
* video
    * mp4, webm, ogg
    * **controls, autoplay, muted, loop**
     
## Form
* action = sends data to this url
* method = get / post. Post for sensitive data

## Header and Footer
Semantic tags, describe meaning to web browser and developer. Organise content

input types:

```html
<form action="file_to_send_data.php" method="POST" enctype="multipart/form-data">
    <label for="username">username</label>
    <input type="text" id="username" placeholder="John Doe" minlength="6" maxlength="15" required>

    <input type="tel" id="phone" placeholder="123-456-7890" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}">

    <input type="date" id="bday">
    
    <input type="number" id="quantity" min="0" max="99" value="1">
    
    <label for="Mr.">Mr.</label>
    <input type="radio" id="Mr." value="Mr." name="title">
    <label for="Ms.">Ms.</label>
    <input type="radio" id="Ms." value="Ms." name="title">
    <label for="PhD.">PhD.</label>
    <input type="radio" id="PhD." value="PhD." name="title">

    <label for="payment">Payment</label>
    <select id="payment">
        <option value="visa">Visa</option>
        <option value="mastercard">Mastercard</option>
        <option value="giftcard">Giftcard</option>
    </select>

    <input type="checkbox" id="subsribe">
    <textarea id="comment" rows="3" cols="25"></textarea>

    <label for="file">file:</label>
    <input type="file" id="file" accept="image/png, image/jpeg">

    <input type="reset"><br>

</form>
```
```html
<!-- pre -->
<pre>
this   is preformatted text. Text retains line breaks and spaces
</pre>

<!-- a -->
<a href="www.url.com" target="_blank">Click here. href="mailto:name@email.com"</a>

<!-- audio -->
<audio controls>
    <source src="file.mp3">
    <source src="fallback.mp3 type="audio/mpeg">
</audio>

<!-- video -->
<video src="video.mp4" width="500px" height="500px"></video>

<video width="500px">
    <source src="video.mp4">
</video>

<!-- description list -->
<dl>
    <dt>Object</dt>
    <dd>Definition</dd>
    <dt>Drink</dt>
    <dd>Coffee</dd>
    <dd>Milk</dd>
</dl>

<!-- table -->
<table border="1" style="background-color:blue">
    <tr align="center">
        <td width="50">Day A</td>
    </tr>
</table>

<!-- button -->
<a href="www.ab.c">
<button onclick="jsFunction()">Click Here</button></a>
```

```html
<header style="background-color:blue">
    <h1>Welcome to our WebPage</h1>
    <a href="">About</a>
    <a href="">Contact</a>
</header>

<main>
    <h2>This is the main body</h2>
    <p>lorem ipsum</p>

</main>

<footer>
    &copy; copyright reserved
</footer>
```
### Text Formatting
#### Tags
* b / strong = bold
* i / em = italic
* u = underlined
* del = deleted (strikethrough)
* big = big
* small = small
* sub = subscript
* sup = superscript
* tt = monospace
* mark = highlight
#### Style Attributes (style="---")
Button
* font-size: 25px; (sets size of button)
* background-color: gray;
* color: lightblue (font colour)
* border-radius:10px

## Attributes
* **id:** access element by 'id 'in CSS and JS
* **name:** used in http request when communicating with server
* **title:** text displayed on hover (tool tip)
* **style="background-color:black; border:2px"**

## Misc.
### Favicon
```html
<head>
    <link rel="icon" type="image/jpeg" href="favicon.jpg">
</head>
```
### HTML Call JS Function With param
```html
<button id='button' value='Click' onclick=setText(this.value)>
```
### Div vs Span (style="background-color: cyan")
Span spans only the width of the text

Div spans the width of the page.
 
## JavaScript
include js, best to add at end of body tag
```html
<script type = "text/javascript">
//JavaScript coding can be done inside this tag
</script>

<script src="script.js"></script>
```

# CSS
```html
<head>
    <style>
        .blue {
            color: blue;
        }
    </style>

    <!-- better to include file -->
    <link rel="stylesheet" href="style.css"/>
</head>
```

## Types:
Inline, Internal, External

Gives precedence to last defined element


### html
```html
<h1 class="red square 'class1 class2'">Content</h1>
```

### Syntax
```css

selector{
    property1: value;
    property2: valu2;
}

h1 { }

.class_name { }

#id { }

/* Select child of a parent, can use tag, class or id */
parent > child 
parent > *
```

<button class="btn btn-1">button 1</button>
<button class="btn btn-2">button 2</button>
<button class="btn btn-3">button 3</button>

.btn{
    padding: 10px;
    color: white;
}

.btn-1 {background-color: green;}
.btn-2 {background-color: blue;}
.btn-3 {background-color: purple;}

### grouping multiple selectors
Write together without space separation

h1.large-heading{ } //all h1 elements with class large-heading

Share properties between selectors

.big, .large{ }
* { } //everything

## Common Properties

```css
/* Text Colour */
p {
  color: blue;
  color: #0A1B3C; /* Hex Value */
  color: rgba(0, 0, 0, 0.3); /* RGBA */
  color: black; /* Named Colors */
}

/* Text Size */
p {
  font-size: 48px;
}

/* Any Element */
h1 {
  background-color: #FFB300;
  height: 250px;
  width: 500px;
  border: 5px solid #FF6DBA; /*solid dashed dotted*/
}

h1 {
  height: 300px;
  color: white;
  border: 1px solid black;
  background-image: url("../img/rainbow_bg.jpg");
}

img {
  border: 1px solid black;
  border-radius: 25px;
}
```
## Notes
* Div,p is a full page width block,
* Img and span are partial width

## Flex
* To create tabular design, use flex
* Flexbox, grid, bootstrap are used to create an overall page structure
flex pushes everything to single line, and width of each content is based on the content, gap property of flexbox
* Flex makes element occupy full width, use inline flex to wrap content to widest content
* Default flex direction is row
* Cross axis is perpendicular to main axis
```css
.container {
  display: flex;
  gap: 5px;

  /* attributes */
  flex-direction: column;
  flex-wrap: wrap;
}

<div class="container">
  <Item 1> <Item 2> <Item 3>
</div>
```


### Width of each element
Property to be set of child element not the main container. ``
```css
.container > div {
  flex-basis: 100px; // (height or width of each element)
  justify-content: center /* flex-start / flex-end / space-between (last elements pushed to boundary) / space-around (last elements have space) */

  align-items: 'same attrs as above' /* sets alignment to cross axis, for this to work, the container must have size larger than each element */

  align-self (child property): 'same attrs as above' /* makes the item independent from other children */

  align-content: /* works when wrap in use */
}
```

### Summary
```css
container {
  display: flex;

  justify-content: end / center / space-around / space-between / space-evenly 
  /* align items along main axis */

  align-items: end / center / baseline / stretch 
  /* align items along cross axis */

  flex-direction: row-reverse / column / column-reverse
  /* direction of main axis */

  flex-wrap: wrap / wrap-reverse
  flex-flow: /* shorthand for flex-direction and flex-wrap */

  align-content: start / end / center / space-between / space-around / space-evenly / stretch
  /* Aligns a flex container's lines within the flex container when there is extra space on the cross-axis. */
}

item {
  order: integer /* relatively change position */
  align-self: start / end / center / baseline / stretch
}
```

Float used to float an image to the left or right of a block of text. 

# JavaScript
## DOM
### Important

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
Event Listener
```javascript
element.addEventListener("click", function(){ 
    alert("Hello World!"); 
});

// same as below

element.addEventListener("click", myFunction);

function myFunction() {
    alert ("Hello World!");
}
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

### textContent vs innerText
same but, textContent = displays with spacing, indentation

innerText = displays with respect to css (if visible or not)

## LocalStorage
Permanently stores data as key value pairs in storage. Can be used to store previous score

Stores only strings. HTML 5

```javascript
localStorage.getItem('key');
localStorage.setItem('key','value');
```
