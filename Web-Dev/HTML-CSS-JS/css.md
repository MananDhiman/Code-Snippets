# Types:
Inline, Internal, External

Gives precedence to last defined element


## html
```html
<h1 class="red square 'class1 class2'">Content</h1>
```

## Syntax
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

## grouping multiple selectors
Write together without space separation

h1.large-heading{ } //all h1 elements with class large-heading

Share properties between selectors

.big, .large{ }
* { } //everything

# Common Properties

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
# Notes
* Div,p is a full page width block,
* Img and span are partial width

# Flex
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


## Width of each element
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

Float used to float an image to the left or right of a block of text. 