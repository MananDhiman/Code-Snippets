# Intro
- Lists – Ordered collections of elements that allow duplicates.
- Sets – Unordered collections of unique elements.
- Maps – Collections of key-value pairs, where each key is unique.
- Arrays – Fixed-length collections of elements with a specific type.
- Sequences – Lazily evaluated collections of elements that can be processed in a pipeline.

## Common Properties and Methods
- collection.size
- if(“BMW” in cars) {}
- if(-1 !in 0..list.lastIndex)
  


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
list[2]

a.indexOf('2')
println(numbers.first())
println(numbers.last())

// add
list.add(5)

// delete
list.remove(1)
list.removeAt(1)
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
val immutableMap = mapOf(9 to “Manipal”, 8 to “Nikhil”, 7 to “Rahul”)
val map = mapOf(1 to "Doug", 2 to 25)
val map2 = mutableMapOf<Int, Any?>()

map2[1] = "Derek"
map2[2] = 42

for (key in immutableMap.leys) {
	println(immutableMap[key])
}

for((key, value) in map) {
  println($key, $value)
	println("Key = $key, Value = $value")
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


## Methods
### List / Array
```kotlin
var list3 = list1.subList(0,3)
list1.forEach{ n -> println("$n")}
```