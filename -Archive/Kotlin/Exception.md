Exception used to patch up a code that may cause it to crash. To prevent from crashing you catch the exception and try a method

```
try{
    //do stuff that may crash program
    //when exception found, next line won't run
    #exception
    #line won't run and jumps to catch
}catch(e: `type of exception arithmetic, index out of bounds` Exception){
    //do stuff otherwise
    println(e.message)
    e.printStackTrace()
}catch(e: Exc_1){
    //can have multiple catch blocks
}finally{
    //runs whether exception found or not
}
```