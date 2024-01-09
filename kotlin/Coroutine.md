Dependency
```gradle
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
```

Coroutine(lightweight thread, not really thread) exist only in kotlin not in java

Threads are heavy and cannot create too many of them.
```kotlin
//Name of current thread. 'main' is default.
Thread.currentThread().name

//Java type thread
thread(start = true){
	executeLongRunningTask()
}
```
# Coroutine
- All Processes executed on a thread. There is thread pool
- coroutine executed inside thread. One thread contains many coroutine. Cheaper than threads
- Main thread is UI thread
- Main thread has a queue, all events and process in main thread added to msg q

Need two things to create crt, crt scope (lifetime), and crt context (which threads)



## Coroutine Scope
Defines lifetime of coroutine. If a coroutine starts a process derived from MainActivity (fragment or ViewModel) but activity changes, then all the coroutines in the MainActivity scope get destroyed
Can wait for a scope 

## Coroutine Context
Tells on which threads our coroutines run

## Dispatcher
way to define on which crt executed

- Dispatcher.IO
- Dispatcher.Main
- Dispatcher.Default


# Minimal Coroutine Android

```kotlin
GlobalScope.launch {
	// long running tasks
	startCount()
}

CoroutineScope(Dispatchers.IO).launch {
  Log.d(‘sasa)
}

fun startCount() {
	// function body
}
```

# Example

```kotlin
CoroutineScope(Dispatchers.IO).launch {
	sendLoginReq(etPass.text.toString(), etUser.text.toString())
}

private suspend fun sendLoginReq(pass: String, user: String) {
	try {
		val loginResponse = RetrofitInstance.getInstance().apiInterface.login(user, pass)
		Log.d("response", loginResponse.body().toString())
	}  catch (e: Exception) {
		Log.d("response exception", e.message.toString())
	}
}
```

## Suspend Function
`suspend fun foo() { }`
when crt reaches point, crt waits for result
?the next process can be executed while we wait for first output?

## Coroutine Builder
`.launch` helps to create crt
`CoroutineScope(Dispatchers.IO).launch {}` returns job

- launch - fire and forget (no care about result)
- async - when result needed
```kotlin
var x
sus fun() {
  val job = CRT { x = 10 }
  // job join waits for crt to be finished then executes the next code
  job.join()
  print(x)
}
```

### Async
returns deferred object which equals the last line of block, can fun call, can be direct string
```kotlin
val deffObj = CoroutineScope(Dispatchers.IO).async {
  getFoll() // returns int
  “Helllo” // str
}
deffObj.await().toString()
//do stuff
```

