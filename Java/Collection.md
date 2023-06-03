# ArrayList
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

ArrayList<String> list = new ArrayList<>();
list.add("A");
list.get(0);
int size = list.size();

Collections.sort(list);

list.set(0,5) //replaces 0th element as 5
list.add(3,1) //adds 1 at 3 index
list.remove(3) //removes element at 3 index
list.clear();
```

# Hash
Constant time insertion, deletion, access

## Set
Like array Single element Constant time insertion, deletion, access (Seems ordered but in docs it is said to be unordered)
```java
HashSet<Integer> setNums = new HashSet<Integer>();
	for(int i=0;i<nums.length;i++){
		setNums.add(nums[i]);

set.contains("No");
set.remove("Welcome");
list.get(0);
```

## HashMap
Key Value pair, store and access by 
```java
HashMap<String, Integer> empIds = new HashMap<>();
empIds.put("JOHN",69);

empIds.get("JOHN");
hash_map.containsValue("World"));
hash_map.containsKey(5));
```

### Iterate HashMap
```java
// using for-each loop for iteration over Map.entrySet()
for (Map.Entry<String,Integer> entry : empIds.entrySet()) 
	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}
```

# Queue
```java
Queue<Integer> q = new LinkedList<>();
q.add(i);
q.remove();
```

# Stack
```java
Stack<Integer> stk = new Stack<>();
stk.push(78);
Integer x = (Integer) stk.pop();
int x = stk.size();

boolean result = stk.empty();
Integer x = stk.peek();
int location = stk.search(78); //-1 if not exists 
```
