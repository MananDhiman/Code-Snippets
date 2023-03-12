Lambda function are used to make stuff less complex

```
//fun name  //param  //ret type //param name
val calcSquare: (Int) -> Int={number->
        number*number
}
println(calcSquare(5))
  
  //fun name //param   //ret type //no param name because 'it'
val printHi: (String) -> Unit={
        println("Hi $it")
}
printHi("World")

  //fun name  //no param //ret type //no param because it 
val simpleLamba: () -> Unit={
        println("perhaps")
}
simpleLamba()
```