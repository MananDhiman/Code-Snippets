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