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

```kotlin
// fragment
val scope = CoroutineScope(CoroutineName(“MyScope”))
// val scope = CoroutineScope(Dispatchers.IO + CoroutineName(“MyScope”))

scope.launch { // parent
	launch { 
	// launch is extension fun that returns job. Responsible for crt lifecycle, cancellation, parent child rel
	// child
	}
}
```

## Coroutine Context

Tells on which threads our coroutines run

## Dispatcher

way to define on which crt executed

- Dispatcher.IO - Network and Disk
- Dispatcher.Main - UI, tasks that are short
- Dispatcher.Default - CPU heavy task, like parsing large file

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
## Running Clock
ViewModel
```kotlin
class MViewModel: ViewModel() {
	val count = mutableStateOf(1)
	
	fun increment() {
		CoroutineScope(Dispatchers.IO).async {
			_increment()
		}
	}
	fun _increment() {
		for(i in 0..200_000) {
			Log.d("tag dummy long task", i.toString())
		}
		count.value = 200_000
	}
	fun addNote(note: Note) {
		 viewModelScope.launch(Dispatchers.IO) {
			 db.createNote(note)
			 notes.value = db.readNotes(notebookSelected.value)
		}
	}
}
```
UI
```kotlin
Column(Modifier.fillMaxSize()) {
	Button(onClick = { viewModel.increment() }) {
		Text(text = viewModel.count.value.toString())
	}
	
	var ticks by remember { mutableIntStateOf(0) }
	
	Text(text = ticks.toString())
	
	LaunchedEffect(Unit) {
		while(true) {
			delay(1.milliseconds)
			ticks++
		}
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
