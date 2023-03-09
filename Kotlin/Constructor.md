- Ideally only one constructor
- No logic in primary constructor or use Init Block

```
//primary constructor
//if no visibility modifier
class Student(
    var age: Int = 16, //default values
    var name: String = "Def",
    var r_no: Int = "100001"
){
    //class body

}
```

```
//secondary constructor
class Student(
    var age: Int,
    var name: String,
    var r_no: Int
){
    init{
        //logic for primary const here
        
    }

//class body

}
```

```
//secondary constructor
class Student(
    var age: Int,
    var name: String,
    var r_no: Int
){
    init{
        //logic for primary const here
        
    }
    constructor(uni_r: Int): this(0,"",0){ //needs to go through primary cons anyways
    	printl("$uni_r is uni roll")
    	//full on cons here, does everything runs after primary cons
    }


//class body

}
```