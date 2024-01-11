# Jetpack Compose

- Declarative. UI built in kotlin using lambda functions annotated by @Composable.
- Need to use state variables, when state changes, component is recomposed. Goal is to update state
- use remember so initial val not always loaded. remember remembers last value. mutablestateof rerenders UI when value change. comp fun called any time, so essential to have a remember
- Can write logic inside composable functions. Funs rendered in order written, effects applied accordingly
- function can be outside class
- the only way to update it is by calling the same composable with new arguments.
- Best practtice to have modifier param in composable

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
  mutableStateOf(0) // 0 is default value
}
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
    ..align(Alignment.CenterHorizontally),
  fontWeight = FontWeight.Bold
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
  onValueChange = { text -> // text comes from edit text
    name = text
  },
  modifier = Modifier.weight(1f) // how muc space to occupy, like linear layout
)

// image
Image(
  painter = painterResource(id = R.drawable.ic_launcher_foreground),
  contentDescription = null,
  modifier = Modifier.background(Color.Blue).size(40.dp)
  alpha = 0.5F // image opacity
)
Icon(
  imageVector = Icons.Default.Add,
  contentDescription = "add",
  modifier = Modifier.size(54.dp)
)

// empty space
Spacer(modifier = Modifier.width(16.dp))

Box (contentAlignment = )  // box is simple container like Frame layout. Inner elements One on top of other

// column (elements vertically place)
Column(
  modifier = Modifier.fillMaxSize().fillMaxWidth().size(400.dp),
  verticalArrangement = Arrangement.SpaceBetween // Evenly,Around
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

# Elements

## Colours

```kotlin
import androidx.compose.ui.graphics.Color
```

## Surface

Basic building block

```kotlin
Surface(color = Color.Cyan) {}
```

## Modifier

Used to decorate composable
