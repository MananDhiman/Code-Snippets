# Tags
* div = enclosing any element(s) in div, makes them occupy entire width
* pre = preformatted text
* a target (attribute)
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
<button>Click Here</button></a>
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