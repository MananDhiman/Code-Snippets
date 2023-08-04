# == vs is
The Equality operator (\=\=) is a comparison operator in Python that compare values of both the operands and checks for value equality. Whereas the '**is'** operator is the identity operator that checks whether both the operands refer to the same object or not (present in the same memory location).

# Function
## default value of args
```python
def myFun(x, y=50):
	print("x: ", x)
	print("y: ", y)

myFun(10)

length = len(list)
```

# Bult in DS
* Tuple 
```python
# List -> Modifiable elements, variable length
list = []
list.append(i)
list.count(i)

list.pop() # removes last element
list.pop(index) # removes element at given index

list = str1.split(":") #on each occurrence of a string, element added to list

# Set -> Unique elements, unordered
sett = set()

sett.add(n)
set.remove(n)

if n not in sett:
if n in set

# Dictionary -> Key Value Pair
dict = {}
dict['key'] = value
if i (key) in dict

# Tuple -> elements immutable
thistuple = ("apple", "banana", "cherry")
```

# Type Casting
```python
list(set1)
str(int1)
int(str1)

my_set = {s for s in list}

ascii_int = ord(i) # i = string of length 1
```

# Loop
## For
```python

for i in range(10): # range has 3 params: start, end*(exclusive), step
    print(i)

for i in range(1,10,2):
	print(i)

for i in list # i is element of list
for i in range(len(list)) # i is index. access list element using index
for i in dict # i is keys of dict. access value using key

list = [1,2,3,4]
dict = {"brand": "Ford",
  "model": "Mustang",
  "year": 1964,
  "year": 2020}
```
## \*args (parameters sent as tuple)
## \*\*kwargs (parameters sent as key value pair)
```python
def myFun(**kwargs):
	for key, value in kwargs.items():
		print("%s == %s" % (key, value))

# Driver code
myFun(first='Geeks', mid='for', last='Geeks')
```
# Pass by reference, value
**Is Python Function Pass by Reference or pass by value?**   
One important thing to note is, in Python every variable name is a reference. When we pass a variable to a function, a new reference to the object is created.
# Multiple inputs
first,second=map(int, input().split())
