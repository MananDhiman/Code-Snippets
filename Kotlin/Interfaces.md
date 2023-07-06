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