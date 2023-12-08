# Class and Objects
* By default final (no inheritance) unless marked open
* No static methods
## Visiblity modifiers
* Public (default) = Visible everywhere
* Private =  inside same file containing declaration
* Protected = Same as private but visible to subclasses
* Internal = visible in same module, set of files compiled together 
an outer class does not see private members of its inner classes
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
Abstract and interface is same
Abstract has constructor. interface doesn't 
interface allows multiple inheritance
Interfaces are useful for the following: **Capturing similarities among unrelated classes without artificially forcing a class relationship**

***they allow different objects to expose COMMON functionality***

# Static
```kotlin
class Foo {
  companion object {
     fun a() : Int = 1
  }
}
```

You can then use it from inside Kotlin code as

```scss
Foo.a()
```