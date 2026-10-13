```kotlin
class BGTask(private val context: Context, workerParams:  WorkerParameters): Worker(context, workerParams) {

  override fun doWork(): Result {
	// code
    return Result.success()
  }
}
```

Activity
```kotlin
// Main activity
val wr = OneTimeWorkRequest.Builder(MyWorker::class.java).build()

// enqueue with WorkManager
WorkManager.getInstance(<context>).enqueue(wr)

// monitor status
WorkManager.getInstance(<context>).getWorkInfoByIdLiveData(wr.getId()).observer(this, ::callback)

// ------- //
 val workRequest = PeriodicWorkRequestBuilder<BGTask>(16, TimeUnit.MINUTES).build()

WorkManager.getInstance(this).enqueue(workRequest)
```
