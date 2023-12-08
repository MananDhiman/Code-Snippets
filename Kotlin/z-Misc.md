# Methods
## Random
Kotlin random number in range
```kotlin
val num = (0..500).random()
val num = Random.nextInt(1000)
```

# Example Code
Pass Function as argument
```kotlin
fun main() {    
  printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }
  printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
}

fun printFinalTemperature(
  initialMeasurement: Double, 
  initialUnit: String, 
  finalUnit: String, 
  conversionFormula: (Double) -> Double
) {
  val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
  println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

```
Smaller If when
```kotlin
fun main() {
  val child = 5
  val adult = 28
  val senior = 87
  
  val isMonday = true
  
  println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
  println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
  println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}
 
fun ticketPrice(age: Int, isMonday: Boolean): Int {
  return when(age) {
    in 0..12 -> 15
    in 13..60 -> if (isMonday) 25 else 30
    in 61..100 -> 20
    else -> -1
  }
}
```
Constructor value
```kotlin
class Song(
  val title: String, 
  val artist: String, 
  val yearPublished: Int, 
  val playCount: Int
){
  val isPopular: Boolean
    get() = playCount >= 1000

  fun printDescription() {
    println("$title, performed by $artist, was released in $yearPublished.")
  }   
}


```

# Function Literal (Lambda)
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

//  literal
val mul = {num1: Int, num2: Int -> num1*num2}
println("5*3 = ${mul(5,3)}")
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

# Vararg
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