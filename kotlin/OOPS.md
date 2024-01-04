# Class and Objects
* By default final (no inheritance) unless marked open
* No static methods
## Visibility modifiers
* Public (default) = Visible everywhere
* Private =  inside same file containing declaration
* Protected = Same as private but visible to subclasses
* Internal = visible in same module, set of files compiled together 
an outer class does not see private members of its inner classes

`const val PI = 3.14 // static final. known before runtime`
`val pi = 3.14 // final`
## Constructor
- Ideally only one constructor
- No logic in primary constructor or use Init Block

```kotlin
//primary constructor
//if no visibility modifier
class Student(
  var age: Int = 16, //default values
  var name: String = "Def",
  var r_no: Int = "100001"
){
  //class body
}
```

```kotlin
//secondary constructor
class Student(
  var age: Int,
  var name: String,
  var r_no: Int
){
  init{
    //logic for primary const here
  }
  //class body
}
```

```kotlin
//secondary constructor
class Student(
  var age: Int,
  var name: String,
  var r_no: Int
){
  init{
    //logic for primary const here     
  }

  constructor(uni_r: Int): this(0,"",0){ //needs to go through primary cons anyways
    printl("$uni_r is uni roll")
    //full on cons here, does everything runs after primary cons
  }
  //class body
}
```

# Inheritance
- the derived class can’t access the private members of the base class
- abstract class cannot be instantiated because it is incomplete
- \`override\` makes sure that the function in base class doesn't run

```kotlin
open class Base
class Derived : Base()
```

- base - derived
- parent - child
- superclass - subclass

```kotlin
open class Car(var manu:String, var year:Int){
  fun disp(){
    println("$manu of $year")
  }
}
class Sports(
  s_manu: String,
  s_year: Int,
  power:Int): Car(s_manu, s_year){
  init {
    disp()
    println("top speed = ${power*2}")
  }
}
fun main() {
  val ciaz = Car(manu = "Maruti", year = 2014)
  ciaz.disp()

  println("Now making sports car...")
  val carreraGT = Sports("porsche", 2006, 500)
}
```



# Abstract
Hiding certain elements and showing only essential information. Achieved with either abstract class or interface.

Cannot be instantiated

In base class need to override the prescribed memebers
When needing to define a common set of rules for multiple classes

## Interface
can contain declarations of abstract methods, as well as method implementations. interfaces cannot store state.
```kotlin
interface MyInterface {
  fun bar()
  fun foo() {
    // optional body
  }
}
//
class Child : MyInterface {
  override fun bar() {
    // body
  }
}

```
# No static keyword in kotlin
```kotlin
class Foo {
  companion object {
    fun a() : Int = 1
  }
}
```

You can then use it from inside Kotlin code as

```kotlin
Foo.a()
```

# Object without class
- Init block only, no constructor
- Singleton
- Can inherit class/interface
```kotlin
object B {
  val p: Int = 29
  fun test() {
    println("HELLO")
  }
}
```

# Enum Classes
A given fixed set of values. We restrict values
```kotlin
fun main() {
  val day = Day.MON
  println(day) // MON
  // println(day.n) verify

  for(i in Days.values()) {
    println(i)
  }
}

// only values
enum class Days {
  MON, // objects
  TUE,
  WED,
  THU
}

enum class Days(num: Int) {
  MON(1),
  TUE(2),
  WED(3),
  THU(4);

  fun print() {
    println("Day is $this")
  }
} 
```

# Sealed Class
We restrict type
```kotlin
fun main() {
  val tile: Tile = Red(p)
  // when gives error if not all classes covered
  val points = when(tile) {
    is Red -> 
    isBlue -> 
  }
}

sealed class Tile
class Red(p)
class Blue(p)
```