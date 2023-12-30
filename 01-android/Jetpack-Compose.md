# Jetpack Compose
- Declarative. UI built in kotlin using lambda functions annotated by @Composable. 
- Need to use state variables, when state changes, component is recomposed. use remember so initial val not always loaded
- Can write logic inside composable functions. Funs rendered in order written, effects applied accordingly
- function can be outside class

Live Preview
```kotlin
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  JetpackComposeTheme {
    Comp() // list fun that gen UI
  }
}
```
Basics
```kotlin
// state variable
val count = remember {
  mutableStateOf(0) // 0 is default valuue
}
var names by remember { // eliminates need to get 'value' member
  mutableStateOf(listOf<String>())
}

// text
Text(
  text = count.value.toString(), // value
  fontSize = 30.sp,
  color = Color.Blue,
  modifier = Modifier
    .background(Color.Red)
    .padding(16.dp)
    .background(Color.Green)
)

// button
Button(onClick = {
  count.value++
  if(name.isNotBlank()) {
    names = names + name
    name = ""
  }
}) {
  Text(text = "SSS") // text inside button
}

// edit text
OutlinedTextField(
  value = name,
  onValueChange = { text ->
    name = text
  },
  modifier = Modifier.weight(1f) // how muc space to occupy, like linear layout
)

// image
Image(
  painter = painterResource(id = R.drawable.ic_launcher_foreground),
  contentDescription = null,
  modifier = Modifier.background(Color.Blue)
)
Icon(
  imageVector = Icons.Default.Add,
  contentDescription = "add",
  modifier = Modifier.size(54.dp)
)

// empty space
Spacer(modifier = Modifier.width(16.dp)) 

// column (elements vertically place)
Column(
  modifier = Modifier.fillMaxSize().fillMaxWidth().size(400.dp),
  verticalArrangement = Arrangement.Center,
  horizontalAlignment = Alignment.CenterHorizontally
) {
  // fun here. all elements to display in column
}

// recyclable
LazyRow{
  items(20) { // how many times to render items
    // fun here. all elements to display in column
    Icon(
      imageVector = Icons.Default.Add,
      contentDescription = "add",
      modifier = Modifier.size(54.dp)
    )

    Divider() // partition horizontal rule
  }
}

// iterate over items passed as list
// import androidx.compose.foundation.lazy.items
LazyColumn(modifier) {
  items(names) { currentName -> // names: List<String>
    Text(
      text = currentName,
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    )
    Divider()
  }
}
```

MainActivity
```kotlin
setContent {
  JetpackComposeTheme {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
      Column {
        Greeting("Android")
        IMG("msg")
        RV()
        State()
      }
    }
  }
}
```