# Basic
## Key Points:
* can create functions outside classes. No need to set functions as static members of classes
* There is no automatic conversion between types
* All variable declarations in Kotlin must be initialized

## Null
have to decide if a variable can be null or not. Applies to both primitives or class types. A nullable variable is marked by assigning ? after the type, e.g. `var firstName: String?`

!! operator asserts that variable is not null

? if variable null, then null assigned, otherwise intended value
```kotlin
val firstName : String = "Adam"
val name : String? = firstName
```
Assigning a possibly null value to a non-null variable requires that the nullable variable is not null at assignment !! operator
```kotlin
val name : String? = "Adam" 
val firstName : String = name!! // asserts not null, program crashes
val maybeNullName : String = name? // if null, assigns null, otherwise value
```

## Functions

* If a function returns value, you must declare it after the function name
* A void function returns Unit type but you are not required to declare it
* All parameters in a Kotlin function are read only. Not allowed to mark it with val or var.

Kotlin has Optional / Default Params, Named Params
Also vararg which produces array of argument
* If mixing mandatory and optional parameters, mandatory parameters must be listed first
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
```

## Collection
List
```kotlin

```

## Vararg and Function Literal
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

### Function Literal (Lambda)
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