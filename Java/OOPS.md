# Inheritance

```java
class Shape{
	String colour;
}

class Triangle extends Shape{

}

psmv(){
	Triangle t1 = new Triangle();
	t1.colour = "red";
}
```

# Access Modifiers
1.  **Private**: The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
2.  **Default**: The access level of a default modifier is only within the package. It cannot be accessed from outside the package. If you do not specify any access level, it will be the default.
3.  **Protected**: The access level of a protected modifier is within the package and outside the package through child class. If you do not make the child class, it cannot be accessed from outside the package.
4.  **Public**: The access level of a public modifier is everywhere. It can be accessed from within the class, outside the class, within the package and outside the package.

# Abstract
`abstract` same as `static` except abstract used in inheritance and static used just to provide space

`static` indicates the class can only have static members and you cannot create an instance of it. This is used for stateless functionality methods, or utility methods). 
[Here's more detail on using static members and classes](http://msdn.microsoft.com/en-us/library/79b3xss3(VS.80).aspx).

## Static

### Class Inside Class
```java
class OuterClass {
    ...
    class InnerClass {
        ...
    }
}

psvm(){
	OuterClass outerObject = new OuterClass();
	OuterClass.InnerClass innerObject = outerObject.new InnerClass();
	
}
```

In static no need to create object, mainly methods and variables are static, not classes
Properties not related to object, but to all objects of that class
Better convention to access static variable using class name not object name
Ex: Each human of class Human does not have a separated population for each person
```java
Class Human{
	static Int population;
	
	Human(){
		Human.population++;
	}
}
main(){
	sout(Human.population);
}
```

Need to create object to use non static item in static context
Ex:
Giga.java
```java
class Giga{
	void doStuff(){
		sout(“Good”);
	}
	psvm(){
		Giga giga = new Giga();
		giga.doStuff();
	}
}
```

`abstract`s define the basic structure and functionality shared by all derivative types, but cannot be used by themselves. Think of them as, I suppose, a blue print and a contract.

Classess or methods can be abstracts if they cannot be instantiated or called
These serve only to be used in inherited functions to make a method or attribute compulsary

Runtime Error

```java
abstract class Animal{
	abstract void walk();
}

class Horse extends Animal{
	void walk(){...}
}
```

## Interface
Interface created to describe functionality. Cannot be instantiated and normal class needs to be created whose object can be created. Interface is just to describe necessary components of a class
```java
interface class Animal{
	abstract void walk();
}

class Horese implements Animal{

}

```
## Multiple Inheritance
```java
interface class Animal{
	abstract void walk();
}

interface Herbivore{

}

class Horse implements Animal, Herbivore{

}
```

Interface is pure abstraction as everything in it needs to be abstract and cannot be called

## Static
Static means cannot be changed. In derived class access modifier must be public


# Singleton
The singleton design pattern restricts the instantiation of a class to a single instance. This is done in order to provide coordinated access to a certain resource, throughout an entire software system. Through this design pattern, the singleton class ensures that it’s only instantiated once, and can provide easy access to the single instance.
Primarily due to the fact that a singleton holds an instantiated object, whereas static classes do not, _singletons have the following advantages over static classes_:
-   Singletons can implement interfaces
-   Singletons can be passed as parameters
-   Singletons can have their instances swapped out (such as for testing purposes)
-   Singletons can be handled polymorphically, so there may exist multiple implementations