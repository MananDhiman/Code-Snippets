EditText adds data to LazyColumn 
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

EditText TextView
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