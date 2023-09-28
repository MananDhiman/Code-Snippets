# Basic
## ASCII
* 'A' - 'Z' -> 65 - 90
* 'a' - 'z' -> 97 - 122
* Numbers 0 - 9 -> 48 - 57
## Scanner
import java.util.Scanner();

```java
Scanner input = new Scanner(System.in);
input.next()  //reads one word only. spaces break up
input.nextLine()  //reads entire input as string
input.nextInt() //accepts only integer. If string entered, exception mismatch type
scanner.close()
```
* Anytime before nextLine(), clear scanner by scanner.nextLine().
* Becase when nextInt(), scanner has residue of \n  as nextInt accepts only numeric portion
* May choose to Integer.parseInt(scanner.nextLine()) and forget about scanner and idiocracies

## == vs .equals
* `==` compares if the variable references the same location/object

* `.equals` used commonly in string checks for value

# Data Types
## int vs Integer (wrapper class vs primitive)
int is faster bcs primitive data type. Integer when needing to use in a framework or arraylist.
Java automatically boxes int to Integer
int cannot be null. Integer can be null

## Primitive
```java
int x = 0b1010; // binary number
int x = 123_456_789; // underscore do not break int
```

## Array
```java
//type[] arrayName = new type[size];
int[] marks = new int[3];
int[] marks = {1,2,3};
Arrays.sort(marks);

Arrays.toString(arr); // directly print array
Arrays.fill(array, val) // only 1d array

return new double[]{2.1,1.8};
```

## Type Conversion
### Primitive to Primitve
Bool cannot be converted to and from any type
```java
// from int
int i = 1;
char ic = (char) i; // A, ascii char of int
double id = i; // no need for explicit type case

// from char
char c = 'c';
int ci = (int) c; // 99, ascii char to inr
double cd = (double) c; // 99.0

// from double
double d = 65.5;
int di = (int) d; // 65
char dc = (char) d; // A

double weightInDouble = 87.5;
int weight = (double) weightInDouble;
```
### Reference to Primitive
All Wrapper class except Character **parseXxx()** to convert from String to Wrapper
```java
int i = Integer.parseInt("10");
double d = Double.parseDouble("10.5");
boolean b = Boolean.parseBoolean("true");
```
### Primitive to Reference
All primitives can be directly converted to referency types by autoboxing

```java
// to String
String s = String.valueOf(char c);

Integer age = new Integer(10);
// All Wrapper including Character static toString() convert from primitive to String
String s = age.toString();
String s1 = Integer.toString(10);
String s2 = Character.toString('a');

// from string (Having incorrect types will cause exception)
Integer I = Integer.valueOf("10"); // 10
Double D = Double.valueOf("10.0"); // 10.0
Boolean B = Boolean.valueOf("true"); // true
```

### Reference to Reference
```java
static Integer valueOf(String valStr)
```

### StringBuilder and Character
```java
String str = Character.toString(char c)
```

## StringBuilder
* mutable. does not create new object of each string

```java
methods

sb.append(x) // x = all primitives, char[]

sb.indexOf(String str) // returns int

int length()

char charAt(int index)

int indexOf(String str) // -1 if not found

StringBuilder delete(int start, int end)

StringBuilder deleteCharAt(int index)

StringBuilder insert()

StringBuilder replace(int start, int end, String str)

StringBuilder reverse()

void setCharAt(int index, char ch)

String substring()
```

## String
### String Pool
If string previously exists, string will point to same object

# Collection
## Misc
```java
// create an array list from all values of a hashmap
List<Integer> list = new ArrayList<>(map.values());
```
## ArrayList
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

ArrayList<String> list = new ArrayList<>();
list.add("A");
list.get(index); 
int size = list.size();

Collections.sort(list);

list.set(0,5) //replaces 0th element as 5
list.add(3,1) //adds 1 at 3 index
list.remove(3) //removes element at 3 index
list.clear();

// List of List
List<List<Int>> arrayList = new ArrayList();
List<Int> listAtI = new ArrayList ();

// will return arrayList
List<List<Int>> arrayList = new ArrayList();
for(int i = 0; i < desiredSize; i++){
	// inner list to be returned
    List<Int> listAtI = new ArrayList ();
    for(int j = 0; j < rowLength; j++){
        listAtI.set(j, 0);
    }
    arrayList.set(i, listAtI);
}

arrayList.get(5); //returns the list at index 5
arrayList.get(5).get(5) // returns values from column 5 in row 5
```

## Hash
Constant time insertion, deletion, access

### Set
Like array Single element Constant time insertion, deletion, access (unordered)
```java
HashSet<Integer> set = new HashSet<Integer>();
for(int i=0;i<nums.length;i++)
	set.add(nums[i]);

set.contains("No");
set.remove("Welcome");
```

### HashMap
Key Value pair, store and access by 
```java
HashMap<String, Integer> map = new HashMap<>();
map.put("JOHN",69);

map.get("JOHN");
map.containsValue("World"));
map.containsKey(5));
```

#### Iterate HashMap
```java
// using for-each loop for iteration over Map.entrySet()
for (Map.Entry<String,Integer> entry : empIds.entrySet()) {
	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}
```

## Queue
```java
Queue<Integer> q = new LinkedList<>();
q.add(i);
q.remove();
```

## Stack
```java
Stack<Integer> stk = new Stack<>();
stk.push(78);
Integer x = (Integer) stk.pop();
int x = stk.size();

boolean result = stk.empty();
Integer x = stk.peek();
int location = stk.search(78); //-1 if not exists 
```

## Tree
### TreeSet
```java
TreeSet<Integer> tree = new TreeSet<>();

tree.lower(); //arithmetically smaller value than current
tree.last(); //largest value
tree.higher(); //arithmetically greater value than current
```

## Heap / Priority Queue 
Tree Based DS

* Min Heap: -> to keep the `min element always on top`, so you can access it in O(1).
* Max Heap: -> to keep the `max element always on top`, so you can access it in O(1).

```java
// min heap
PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
// maxheap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
// same as above. Collections does not enforce type checking
Queue<Double> q = new PriorityQueue<>(Collections.reverseOrder());

heap.add(int i) // add element to the queue. O(log n) returns true but throws exception if cannot add
q.offer(3.0); // add element. can return false if cannot add

// poll can return false. remove will raise exception
heap.remove(int i) // get and remove the min/max. O(log n).
print(queu.poll()) // display and remove each element in ascending order
heap.peek() // get, but not remove the min/max. O(1)

// iterate
Iterator iterator = heap.iterator();

while (heap.hasNext()) 
    System.out.print(heap.next() + " ");
```
