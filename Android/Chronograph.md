```kotlin
private lateinit var binding: ActivityMainBinding
private lateinit var chronometer: Chronometer
private var running = false
private var pauseOffset: Long = 0

chronometer = binding.chronometer

fun startChronometer(view: View){
        //Log.d("toast", "Toast")
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset)
            chronometer.start()
            running = true
        }
    }

    fun stopChronometer(view: View){
        if(running){
            chronometer.stop()
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase()
            running = false
        }
    }

    fun resetChronometer(view: View){
        chronometer.setBase(SystemClock.elapsedRealtime())
        pauseOffset = 0
    }
```