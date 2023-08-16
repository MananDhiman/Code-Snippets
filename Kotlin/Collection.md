# Intro
- Lists – Ordered collections of elements that allow duplicates.
- Sets – Unordered collections of unique elements.
- Maps – Collections of key-value pairs, where each key is unique.
- Arrays – Fixed-length collections of elements with a specific type.
- Sequences – Lazily evaluated collections of elements that can be processed in a pipeline.

## Common Properties and Methods
- collection.size
- if (“BMW” in cars) {}
  
## Array
**Fixed Length, Mutable**
- arrayOf()

The below are better optimised to handle primitive data
- intArrayOf()
- byteArrayOf()
- charArrayOf()
- shortArrayOf()
- longArrayOf()

```kotlin
// initialisation
val cars = arrayOf(“BMW”,”Audi”)
val arr = IntArray(n) // n is size
val num = Array(3, {i-> i*1}) // first param is size, second param is lambda expression to fill values
val num = intArrayOf(1, 2, 3, 4) // method returning array type IntArray

// access
println(cars[0]) // BMW
num.get(0)

// modify
cars[1] = “mercedes”
num.set(0, 2) // index, value
```

## List
Two Types:
- **listOf()** -> Fixed Size, immutable
- **mutableListOf()** -> Dynamic Size, Mutable
```kotlin
val a = arrayOf(1, 2, 3) 
val l = listOf(1, 2, 3) 
val m = mutableListOf(1, 2, 3) 

// access
a[0] = a[1] // OK
l[0] = l[1] // doesn't compile
m[0] = m[1] // OK

a.indexOf('2')
println(numbers.first())
println(numbers.last())
```

## Set -> Unordered set (immutable)

```kotlin
var immutableSet = setOf(6,9,9,0,0,"Mahipal","Nikhil")
// gives compile time error
// immutableSet.add(7)

for(item in immutableSet){
	println(item)
}
// 6 9 0 Mahipal Nikhil
```

## Map
```kotlin
var immutableMap = mapOf(9 to “Manipal”, 8 to “Nikhil”, 7 to “Rahul”)

for (key in immutableMap.leys) {
	println(immutableMap[key])
}
```
##  Mutable Collection
- mutableList.add("Abhi")
- mutableSet.add(2)
- mutableMap.put(4,"Abhi")

# Array - Mutable - Fixed Size

```kotlin
val num = arrayOf(1, 2, 3, 4)   //implicit type declaration
val num = arrayOf<Int>(1, 2, 3) //explicit type declaration
```

Can print list directly, but not array

# List


## Read-only lists are created with listOf() - Immutable

```kotlin
val a = listOf('1', '2', '3')
```

## Mutable lists created with mutableListOf()

```kotlin
val mutableListA = mutableListOf<Int>( 1 , 2 , 3 , 4 , 3);

mutablelist.add("Geeks")

mutablelist.remove("For")
```


