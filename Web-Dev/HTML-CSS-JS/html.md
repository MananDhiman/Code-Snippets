# Tags
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
     
# Form
* action = sends data to this url
* method = get / post. Post for sensitive data

# Header and Footer
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
## Text Formatting
### Tags
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
### Style Attributes (style="---")
Button
* font-size: 25px; (sets size of button)
* background-color: gray;
* color: lightblue (font colour)
* border-radius:10px

# Attributes
* **id:** access element by 'id 'in CSS and JS
* **name:** used in http request when communicating with server
* **title:** text displayed on hover (tool tip)
* **style="background-color:black; border:2px"**

# Misc.
## Favicon
```html
<head>
    <link rel="icon" type="image/jpeg" href="favicon.jpg">
</head>
```
## Div vs Span (style="background-color: cyan")
Span spans only the width of the text

Div spans the width of the page.
 
# JavaScript
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