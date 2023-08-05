## Vararg
```kotlin
// varargs
fun main() {
    names("John", "Adam", "Joy", age = 20)
    // or
    val n = array("John", "Adam", "Joy")
    names(*n)
}

fun names(vararg  names : String, age : Int){
    for(n in names){
        println("$n is $age old")
    }
}

fun names(vararg  names : String){
    println("Argument length is ${names.size}")
    println("${names[0]}")
    val nns : Array<String> = names
    println("${nns[1]}")
}
```
## Function Literal (Lambda)
Lambda function are used to make stuff less complex

```kotlin
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


`() -> Unit` 
type for a function that takes no parameter and returns a Unit (void)

`() -> String`
type for a function that takes no parameter and return a String

`(String) -> Unit`
type for a function that takes a string and returns nothing.

`(String, Float) -> Unit` type for a function that takes two parameters (String and Float) and returns nothing.
```kotlin
val m = { (x : String) -> println("$x") } 
val n : (String) -> Unit = { x -> println("$x") } 
val o : (String) -> Unit = { (x : String) -> println("$x") } 

fun main(args : Array<String>) { 
    m("good morning")
    n("good morning") 
    o("good morning") 
}
```