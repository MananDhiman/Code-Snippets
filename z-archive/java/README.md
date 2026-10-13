# Basic

## ASCII

- 'A' - 'Z' -> 65 - 90
- 'a' - 'z' -> 97 - 122
- Numbers 0 - 9 -> 48 - 57

## Scanner

import java.util.Scanner();

```java
Scanner input = new Scanner(System.in);
input.next()  //reads one word only. spaces break up
input.nextLine()  //reads entire input as string
input.nextInt() //accepts only integer. If string entered, exception mismatch type
scanner.close()
```

- Anytime before nextLine(), clear scanner by scanner.nextLine().
- Becase when nextInt(), scanner has residue of \n as nextInt accepts only numeric portion
- May choose to Integer.parseInt(scanner.nextLine()) and forget about scanner and idiocracies

## == vs .equals

- `==` compares if the variable references the same location/object

- `.equals` used commonly in string checks for value

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

- mutable. does not create new object of each string

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

## String Tokenizer
```java
StringTokenizer st = new StringTokenizer("Elephant", "AEIOUaeiou");
while(st.hasMoreTokens()) 
	System.out.println(st.nextToken());
// "l ph nt" whenever finds any char match in input string, splits string
```

## String split
```java
for(String s1: "Elephant".split("[aeiouAEIOU]")) 
	System.out.println(s1);
// "l ph nt" always returns array, need to input regex
```


# Generics

why generics? problems that generics solve. Have to create new class for different type. offer abilitty to accommodate many types

generics don't work with primitives

```java
// bounded generic
public class Printer<T extends Animal> {
	T t;
	public Printer(T t) {
	  // logic
  }
}

public class Printer<T> {
	T t;
	public Printer(T t) {
	  // logic
  }
}

psvm() {
  Printer<Integer> printer = new Printer<>(23);
  printer.print();
}
```

Generic Method

```java

psvm() {
	shout(“John”)
	shout(“John”, “mac”)
}

<T> void shout(T th) {
	sout(th + “!!!”);
}

<T,V> void shout(T th, V ch) {
	sout(th + “!!!”);
}

<T,V> V shout(T th, V ch) {
	sout(th + “!!!”);
}

```

Wildcard

```java
List<Integer>list;
printList(list);

printList(List<?> list) {
	// code
}
```

# Serialisation
Process of converting a object into a byteStream so as to save it in a file, send to different device. Has extension .ser

Deserialisation - Convert byteStream into object

Object class should implement serializable interface

Serialisation (import java.io.Serializable)
```java
User user = new User();

FileOutputSteam fileOut = new FileOutputSteam("UserInfo.ser");
ObjectOutputSteam out = new ObjectOutputSteam(fileOut);

out.writeObjectt(user);
out.close();
fileOut.close();
```
Deserialisation
```java
User user = null;

FielInputStream fileIn = new FileInputStream(<pathToSerialFile>);
ObjectInputStream in = ObjectInputStream(fileIn);

user = (User) in.readObject;
in.close();
fileIn.close();
```
