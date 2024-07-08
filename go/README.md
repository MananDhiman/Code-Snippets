a tour of go, go by example
# Run
`go run foo.go`

# Data Types
Numbers: integer, uint, float, complex
default types: bool, string, int, uint32, byte, rune, float64, complex
const can be character, string, boolean, numeric
```go
var name string // ""
var age uint // 0

const Pi = 3.14 // cannot use :=
const txt = "Hello There"

// printf
// %v - generic type
// %s - string
// %f - decimal. %.2f - 2 decimal places
// %q - quoted values, like escape char
// %t - boolean
fmt.Printf("%T",PI) // prints data type
```

# Basic Go Program
```go
package main

import "fmt"

func main() {
  var name string = "Yo" 
  fmt.Println("Hello")
  fmt.Fprintf("Hllo, %s %s", "world", name) // formatted print

  fmt.Scanln(&name) // user input

  // declare variables single type, single line
  var i, j, k int 

  // declare input format for variables to be entered. if wrong, error receieved. 
  scanf, err := fmt.Scanf("%d %d %d", &i, &j, &k) 
  // scanf is number of values entered?
  // if variables input are incorrent
  if err != nil { 
    fmt.Println("Input Number error, Please run program again")
    return
  }

}
```

Scoped If
```go
// scope of if 
// if INIT_STATEMENT; CONDITION{}  
if length := getLength(x); length <= 1 {
  // length variable available only inside if block
}
```

# For Loop
```go

for i:=0; i<100; i++ {
  // do stuff
}

// loop over array / slice
ar := make([]string, 0)
for index, value := range ar {
  println(v)
}
```

# Array / Slice
Almost always slice is used
```go
arr := [6]int{1,2,3,4,5,6} // fixed size

// slice built on top of arr, it’s a view into array

// starting index, ending index. refers to existing array
slice := arr[0:2]

// auto create slice w/o array
myslice := make([]int, init_len, max_size) 

// auto create slice w/o array
myslice := make([]int, init_size) 

// get length
len(slice) 

arr = append(arr, value) // can be single or multiple values
```

# Functions
```go
// basic function
func z(x int) {
 fmt.Println("No returno")
}

// multiple return
func sub(x int, y int) (int, string) {
   return y - x, "Howdy"
}
  
// named return. x,y is automatically initialised and returned
func get() (x, y int) {
  return
}

func main() {
   a, b := get(5,10)
   fmt.Printf("%d",a)
   fmt.Printf("%s",q)
   z(19)
}
```

# Struct
```go
type Person struct {
  var age int
  var name string
  // can have another struct as memeber
  var ownedCar Car
  
  // if used once. better to create anonymous structs
  Degree struct {
    var name string,
    var year int
  }
}
```

# Misc
```go
// ?calling function of a struct?
func (p Person) carProp() string {
  // returning a string value
  return p.name + " has " +p.ownedCar.name + "."
}

p1 := Person{25,”zaza”, “accord”}
fmt.Println(p1.carProp())
```

String methods
```go
// ascii to string
str := string(rune(asci))

// string contains
strings.Contains(haystack, needle) // returns bool
```

# Data Structures
Map
```go
var m map[string]int // reference type. so init to nil

var numbers = make(map[int]int) // can make(map[int] int, 5) for map of size 5

m = make(map[string])
m["route"] = 66 // set value
i := m["route"] // get value. if key not exist, we get value type's zero valuer
n := len(m)
delete(m, "route")

for key, value := range m {
    fmt.Println("Key:", key, "Value:", value)
}

commits := map[string]int{
    "rsc": 3711,
    "r":   2138,
    "gri": 1908,
    "adg": 912,
}
```

Set (untested)
```go
set := make(map[string]bool) // New empty set
set["Foo"] = true            // Add
for k := range set {         // Loop
	fmt.Println(k)
}
delete(set, "Foo")    // Delete
size := len(set)      // Size
exists := set["Foo"]  // Membership
```
