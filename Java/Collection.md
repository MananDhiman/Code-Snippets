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

- Min Heap: -> to keep the `min element always on top`, so you can access it in O(1).
- Max Heap: -> to keep the `max element always on top`, so you can access it in O(1).

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
