# Key Points:

- can create functions outside classes. No need to set functions as static members of classes
- There is no automatic conversion between types
- All variable declarations in Kotlin must be initialized
- In val the reference cannot be changed. Properties of objects be changed (if constructor contains var)
- When needing decimal answer. One variable must be of type double / float. Ex: `print(x/y.toDouble())`

## Data Types

Byte, Short, Int, Long

UByte, UShort, UByteArray, UIntArray

```kotlin
val l: Long = 412521L
val f: Float = 2.31F
val d: Double = 2.21321

val uB: UByte = 2u
```

## String

```kotlin
val str = "a b c"

// string methods
val strArray = str.split(" ") // splits strings separated by " ". ["a", "b", "c"]
```

## Null

have to decide if a variable can be null or not. Applies to both primitives or class types. A nullable variable is marked by assigning ? after the type, e.g. `var firstName: String?`

!! operator asserts that variable is not null

? if variable null, then null assigned, otherwise intended value

```kotlin
var marbles Int? = null
val firstName : String = "Adam"
val name : String? = firstName
```

Assigning a possibly null value to a non-null variable requires that the nullable variable is not null at assignment !! operator

```kotlin
val name : String? = "Adam"
val firstName : String = name!! // asserts not null, program crashes
val maybeNullName : String = name? // if null, assigns null, otherwise value

val c: Int  // Type required when no initializer is provided
c = 3       // deferred assignment

val str = String.format("%.2f", foo(bar))
```
## User Input
```kotlin
// use scanner
val s = Scanner(System.`in`)
val i = s.nextInt()

val r = readln()
```

## Primitive Array
**Fixed Length, Mutable**
- `arrayOf` types are boxed to wrapper classes. Integer[] instead of int[]
- IntArray, DoubleArray, BooleanArray are primitive
- intArrayOf(), byteArrayOf(), charArrayOf() are wrapper
```kotlin
val cars = arrayOf(“BMW”,”Audi”)
val arr: IntArray = intArrayOf(5,4,3,2) // init by elements, explicit primitive type 
val arr = IntArray(5) // size
val initArray = Array<Int>(3) { 0 } // 0 - lambda fun to init values
val num = Array(3, {i-> i*1}) // first param is size, second param is lambda expression to fill values

// access
println(cars[0]) // BMW
num.get(0)
list[2]

// modify
cars[1] = “mercedes”
num.set(0, 2) // index, value


// compare array
println(simpleArray.contentEquals(anotherArray))

// array to collection
val simpleArray = arrayOf("a", "b", "c", "c")

// Converts to a Set
println(simpleArray.toSet())
// [a, b, c]

// Converts to a List
println(simpleArray.toList())
// [a, b, c, c]
```
## Loops

### For Loop

```kotlin
val num = arrayOf(1, 2, 3, 4)

for (x in cars) {}
// x is each element in array / list cars

for(i in num.indices){
  println(num[i])
  // i is index
}

for (i in num.withIndex()) {
  println(arr[i.index])
}

// range first and last inclusive
for (chars in ‘a’..’d’){
	println(chars)
}
// Output -> a b c d

for (i in 0..num.size-1) {
  print(" "+num[i])
}

for (chars in 1..5){
	println(chars) // 1 2 3 4 5
}

for (x in 11..15 step 2) {
  println(x)
}
// 11 13 15

for(ch in 'e'.downTo('a')){
  println(ch)
}
// e d c b a

for (x in 9 downTo 0 step 3) {
  print(x)
}
// includes 0
```

### Range

```kotlin
val x = 10
val y = 9
if (x in 1..y+1) {
  println("fits in range")
}
```

### While loop

```kotlin
var number = 1

while(number <= 10) {
  println(number)
  number++
}
```

# Functions

- If a function returns value, you must declare it after the function name
- A void function returns Unit type but you are not required to declare it
- All parameters in a Kotlin function are read only. Not allowed to mark it with val or var.
- Function can be passed as param
- Given to function call is argument and variable in function body is parameter

Kotlin has Optional / Default Params, Named Params
Also vararg which produces array of argument

- If mixing mandatory and optional parameters, mandatory parameters must be listed first

```kotlin
// function with parameter and no return type
fun greet(msg : String){
  println(msg)
}

// single expression function with explicit return type
fun englishGreeting() : String = "Hello world"

// single expression function with implicit return type
fun englishGreeting() = "Hello world"
fun add(a : Int, b : Int) = a + b

// function without parameter
fun italianGreeting() : String{
  return "bon giorno"
}

// optional parameters or default value parameter
fun show (msg : String = "Hello World"){
  println("$msg")
}

// implied return
fun addTwoNumbers(x: Int, y: Int) = a + b // returns a + b

// return two values
fun nextTwo(num1: Int): Pair<Int, Int> {
  return Pair(num+1, num+2)
}
val (two, three) = nextTwo(5)

// pass fun as param
fun cToF(c: Double): Double = c*(9.0/5) + 32
printFinalTemperature(27.0, ::cToF)

fun printFinalTemperature(
 initialMeasurement: Double,
 conversionFormula: (Double) -> Double
) {
 val ans = conversionFormula(initialMeasurement) // two decimal places
}
```

# Exception Handling

Exception used to patch up a code that may cause it to crash. To prevent from crashing you catch the exception and try a method

```kotlin
try{
  //do stuff that may crash program
  //when exception found, next line won't run

}catch(e: `type of exception arithmetic, index out of bounds` Exception){
  //do stuff otherwise
  println(e.message)
  e.printStackTrace()

}catch(e: Exc_1){
  //can have multiple catch blocks
}finally{
  //runs whether exception found or not
}
```

# When (switch case)

```kotlin
val day = 4

val result = when(day) {
  1 -> "Monday"
  2 -> "Tuesday"
  3 -> "Wednesday"
  else -> "Invalid"
}

print(result)
```
