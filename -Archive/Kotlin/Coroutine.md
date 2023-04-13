Coroutine(lightweight thread, not really thread) exist only in kotlin not in java

Threads are heavy and cannot create too many of them.
```
//Name of current thread. 'main' is default.
Thread.currentThread().name

//Java type thread
thread(start = true){
	executeLongRunningTask()
}
```

## Coroutine Scope
Defines the lifetime of a coroutine. If a coroutine starts a process derived from MainActivity (fragment or ViewModel) but activity changes, then all the coroutines in the MainActivity scope get destroyed
Can wait for a scope 

## Coroutine Context
Tells on which threads our coroutines run

## Dispatcher
Dispatcher.IO
Dispatcher.Main
Dispatcher.Default

![[Pasted image 20230118065934.png]]
 