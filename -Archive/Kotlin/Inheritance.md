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
