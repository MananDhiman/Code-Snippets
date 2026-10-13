## EditText adds data to LazyColumn 
```kotlin
@Composable
private fun UI() {
  Column {
    var namesList = remember {
      mutableStateOf(listOf<String>())
    }
    InputSection(namesList)
    DisplayList(namesList)
  }
}

@Composable
private fun DisplayList(namesList: MutableState<List<String>>) {
  LazyColumn {
    items(namesList.value.size) {
      Text(text = namesList.value[it])
      Divider()
    }
  }
}

@Composable
private fun InputSection(namesList: MutableState<List<String>>) {
  var name by remember {
    mutableStateOf("")
  }
  Row {
    OutlinedTextField(
      value = name,
      onValueChange = {
        name = it
      },
      label = {
        Text(text = "Name")
      }
    )
    Button(
      onClick = {
        if(name != "") {
          val list = namesList.value.toMutableList()
          list.add(name)
          namesList.value = list
        }
       }
    ) {
      Text(text = "Add name")
    }
  }
}
```

## EditText TextView
```kotlin
@Composable
fun UI() {
  var billAmount by remember {
    mutableStateOf(0)
  }
  var tipPercentage by remember {
    mutableStateOf(0)
  }

  val tip = (billAmount * tipPercentage)/100
  val finalAmount = billAmount + tip

  Column {
    TextField(

      value = billAmount.toString(),
      onValueChange = {
        billAmount = it.toInt()
      },
      keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
      label = { Text(text = "Enter Bill Amount") }
    )

    TextField(
      value = tipPercentage.toString(),
      onValueChange = {
        tipPercentage = it.toInt()
      },
      keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
      label = { Text(text = "Enter Percentage To Tip") }
    )

    Text (text = finalAmount.toString())

  }
}
```
## LazyColumn Dynamic List of Input Fields
```kotlin
val subjectNames = remember { mutableStateListOf<String>() }
LazyColumn {
  items(confirmedNumberOfSubjects.intValue) { ind ->
    subjectNames.add("")
    OutlinedTextField(
      value = subjectNames[ind], 
      onValueChange = { subjectNames[ind] = it }
    )
  }
}
```
## Glide Image
implementation("com.github.bumptech.glide:compose:1.0.0-beta01")
```kotlin
GlideImage(  
  model = imageURL, contentDescription = "Post Image",  
  Modifier  
    .fillMaxWidth(1f)  
    .wrapContentSize(),  
  contentScale = ContentScale.FillWidth  
)
```

## Font family
Import in resource manager, dropdown
```
val font = FontFamily(Font(R.font.courg))
Text(
	fontFamily = font
)
```

## Exposing immutability Jetpack Compose

MutableStateFlow
```kotlin
// ViewModel
private val _plantPictures = MutableStateFlow<PagingData<UnsplashPhoto>?>(null)
val plantPictures: Flow<PagingData<UnsplashPhoto>> get() = _plantPictures.filterNotNull()

private val _uiState = MutableStateFlow(GameUiState())
val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

// view
val gameUiState by gameViewModel.uiState.collectAsState()
```

# Intent
```kotlin
val context = LocalContext.current

fun sharePost(post: Post, context: Context) {
  val link = "http://www.jagratilahar.com/${post.language}/${post.categires}/${post.id}/${post.tags}"

  val sendIntent: Intent = Intent().apply {
    action = Intent.ACTION_SEND
    putExtra(Intent.EXTRA_TEXT, link)
    type = "text/html"
  }

  val shareIntent = Intent.createChooser(sendIntent, null)
  context.startActivity(shareIntent)

}
```