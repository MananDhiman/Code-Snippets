# Flashlight

## Get Camera ID

```kotlin
val cameraManager: CameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
try {
  cameraId = cameraManager.cameraIdList[0]
}catch (e: CameraAccessException){
  Log.d("CameraApp", "Exception")
}
```

## Turn on/off flash (Can be merged into one function)

```kotlin
private fun turnOffFlashlight(mCameraManager: CameraManager) {
  flashlightStatus = false
    binding.imageView.setImageResource(R.drawable.f_off)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
      mCameraManager.setTorchMode(cameraId, flashlightStatus)
}

private fun turnOnFlashlight(mCameraManager: CameraManager) {
  flashlightStatus = true
  binding.imageView.setImageResource(R.drawable.f_on)
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
    mCameraManager.setTorchMode(cameraId, flashlightStatus)
}
```

## Manifest

```xml
<uses-permission android:name="android.permission.CAMERA" />
<uses-feature android:name="android.hardware.camera.flash" />
```

## Chronograph
```kotlin
private lateinit var binding: ActivityMainBinding
private lateinit var chronometer: Chronometer
private var running = false
private var pauseOffset: Long = 0

chronometer = binding.chronometer

fun startChronometer(view: View) {
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