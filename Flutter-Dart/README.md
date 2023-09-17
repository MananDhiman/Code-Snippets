# Dart
## Data Types
```dart
// int, double, var
int x = 2; // explicit range -2^63 to 2^63 - 1
double height = 1.85;
var p = 5;  // implicit type

// dynamic
dynamic z = 8; // dynamic can take any type
z = “cool”;

// final, const
final email = “xyz@abc.om” // cannot be reassigned
const qty = 5; // compile time constant

// bool
bool isTrue = true;
bool isFalse = false;

// string
var f = “SS”;
var l = “GG”;
String name = “$f $l”
String uCase = name.toUpperCase() or ‘${f.toUpperCase()}’
```

## Loops
Use int, var, same syntax for for, while
```dart
var numbers = [1,2,3];
// for-in loop for lists
for(var number in numbers){
  print(number);
}
```

## Operator
```dart
print(5 ~/ 2); //Print: 2 - Result is an int
```

## Function
```dart
// functions that contain one expression, use a shorthand syntax
bool isFav(Product product) => favProductsList.contains(product);

// Lambda Function
// small one line functions that dont have name
int add(a,b) => a+b;

// lambda functions mostly passed as parameter to other functions
const list = ['apples', 'bananas', 'oranges'];
list.forEach(
  (item) => print('${list.indexOf(item)}: $item')
);
//Prints: 0: apples 1: bananas 2: oranges
```
## Null
The initial value of any object is null
```dart
userObject?.userName

//The code snippet above is equivalent to following:
(userObject != null) ? userObject.userName : null

//You can chain multiple uses of ?. together in a single expression
userObject?.userName?.toString()

// The preceeding code returns null and never calls toString() if either userObject or userObject.userName is null

Null
// ?? null aware operator

x ??=6; // ??= assignment operator, which assigns a value of a variable only if that variable is currently null
print(x); //Print: 6

x ??=3;
print(x); // Print: 6 - result is still 6

print(null ?? 10); // Prints: 10. Display the value on the left if it's not null else return the value on the right
```

## Collection
* List
* Set
* Map
```dart
// list
var list = [1, 2, 3];

print(list.length); //Print: 3
print(list[1]); // 2

// other ways of list declaration and initializations
List<String> cities = <String>["New York", "Mumbai", "Tokyo"];

// compile-time constant list
const constantCities = const ["New York", "Mumbai", "Tokyo"];

// set is an unordered collection of unique items.
var halogens = {'fluorine', 'chlorine', 'bromine', 'iodine', 'astatine'};

// empty set
var names = <String>{};
Set<String> names = {};
//var names = {}; // Creates a map, not a set.

// map
var nobleGases = {
  // Key: Value
  2: 'helium',
  10: 'neon',
  18: 'argon',
};

// empty map
var person = Map<String, String>();

// To initialize the map, do this:
person['firstName'] = 'Nicola';
person['lastName'] = 'Tesla';

// access element
print(person); //Print: {firstName: Nicola, lastName: Tesla}
print(person['lastName']); //Print: Tesla
```

## OOPS
### Class and Object
```dart
class Cat {
  String name;
  
  // constructor
  // initialising formal params
  Cat(this.name);

  void voice(){
      print("Meow");
  }
}

class Point {
  double x = 0;
  double y = 0;

  Point(double x, double y) {
    // See initializing formal parameters for a better way
    this.x = x;
    this.y = y;
  }
}

void main(){
  Cat myCat = Cat("Kitty");
  print(myCat.name); // Prints: Kitty
  myCat.voice();
}
```