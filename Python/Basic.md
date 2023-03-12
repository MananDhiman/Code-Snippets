# == vs is
The Equality operator (\=\=) is a comparison operator in Python that compare values of both the operands and checks for value equality. Whereas the '**is'** operator is the  identity operator that checks whether both the operands refer to the same object or not (present in the same memory location).

# Function
## default value of args
```python3
def myFun(x, y=50):
	print("x: ", x)
	print("y: ", y)

myFun(10)
```
## \*args (parameters sent as tuple)
## \*\*kwargs (parameters sent as key value pair)
```python3
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