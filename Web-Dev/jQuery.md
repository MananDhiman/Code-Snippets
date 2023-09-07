```javascript
$(document).ready(function(){
	//all jquery code here or include script after body tag
})
```
# Selector
```html
<p>This is a sample paragraph</p>
<p id="para">This is a sample id paragraph</p>
<p class="smallPara">This is a sample class paragraph</p>
```
```javascript
$('p').click(function(){
	// if no selector then all elements modifed
})

$('#para').click(function(){
	// # id
})

$('.smallPara').click(function(){
	// . class
})
```

# Common Methods
Everything used by methods
```javascript
$("h1").css("color","blue"); // set colour
console.log($("h1").css("color”)); // get colour

$("h1").addClass(“big-title”); // add css class
$("h1").removeClass(“big-title”); // remove css class

$("h1").text("Modified using jquery"); // modify text
$("foo").html(“<em>Butt</em>”) // innerHTML
```

For any attribute use attr
```javascript
$("#image").attr("src","image.jpg");

// hover
$(“#body”).on(“mouseover”, function() {
	console.log(“mouseover can be replaced with any event”)
});

// keypress
$("body").keypress(function(event) {
	$("#h1").text($("#h1").text() + event.key);
});

$("#h1").after("<h1>sasa</h1>");
// .before -> before tag
// .after -> after tag
// .prepend -> adds before innercontent of html
// .append -> adds after innercontent of html

// remove element
$(“#h1”).remove(); 
```



# ajax
```javascript
// $("#button").click(function(){ getData(); });
function getData() {
	$.ajax({
		url: 'sample.html',
		type: 'GET',
		dataType: 'text',
		success: successFun, // if page found
		error: errorFun, // if page not found
		complete: function(xhr, status) { // runs when req complete
			console.log("request complete");
		}
	});
}

function successFun(result) {
	console.log("success");
	$("#ajaxMessage").html(result);
}

function errorFun() {
	console.log("failure");
}
```
