```kotlin

class MyWorker: Worker {

// doWork() runs async in bg
// thread by work manager
  override doWork(): Result {
    // thing to run async
    return Result.success
  }

}

// Main activity
val wr = OneTimeWorkRequest.Builder(MyWorker::class.java).build()

// enqueue with WorkManager
WorkManager.getInstance(<context>).enqueue(wr)

// monitor status
WorkManager.getInstance(<context>).getWorkInfoByIdLiveData(wr.getId()).observer(this, ::callback)
```