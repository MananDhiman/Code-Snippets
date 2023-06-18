# int vs Integer (wrapper class vs primitive)
int is faster bcs primitive data type. Integer when needing to use in a framework or arraylist.
Java automatically boxes int to Integer
int cannot be null. Integer can be null

# Scanner
import java.util.Scanner();

```java
Scanner input = new Scanner(System.in);

input.next()             //reads one word only as string. spaces break up

input.nextLine()      //reads entire input as string

input.nextInt()        //accepts only integer. If string entered,  exception mismatch type

//anytime before nextLine(), clear scanner by scanner.nextLine(). 

//Becase when nextInt(), scanner has residue of \\n  as nextInt accepts only numeric portion

scanner.close()
```

May choose to Integer.parseInt(scanner.nextLine()) and forget about scanner and idiocracies

# == vs .equals
== compares if the variable references the same location/object

.equals used commonly in string checks for value

# Copy Constructor
Passing another object of same class as a parameter to new object

Student s1 = new Student("abc",1);

Student s2 = new Student(s1);


# Array
```java
//type[] arrayName = new type[size];
int[] marks = new int[3];
int[] marks = {1,2,3};
Arrays.sort(marks);

Arrays.toString(arr); // directly print array

return new double[]{2.1,1.8};

```
