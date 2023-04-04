# ArrayList
```java
ArrayList<String> list = new ArrayList<>();
list.add("A");
list.get(0);
list.size();

list.set(0,"AA");
list.remove();
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