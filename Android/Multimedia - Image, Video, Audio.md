# Image

## Image Picker and Cropper
### Dependency
implementation 'com.github.dhaval2404:imagepicker:2.1'

### Kotlin Code in main Activity
```kotlin
// function called when imageView clicked or something
private fun pickImage(){
  ImagePicker.with(this)
    .crop()  
    .compress(1440) // resolution
    .start()  
}  
  
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {  
  super.onActivityResult(requestCode, resultCode, data) 

  if (resultCode == Activity.RESULT_OK) {  
    val uri= data?.data!!  
    bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)  
    binding.ivImage.setImageURI(uri)  
  } 
  else if (resultCode == ImagePicker.RESULT_ERROR) {  
    Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()  
  }
  else {  
    Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()  
  }  
}  
  
private fun bitmapToString(bitmap: Bitmap?): String{  
  val byteArrayOutputStream = ByteArrayOutputStream()  
  bitmap?.compress(Bitmap.CompressFormat.JPEG, 15 ,byteArrayOutputStream) // 15 is jpeg quality
  val imageByte = byteArrayOutputStream.toByteArray()  
  return Base64.encodeToString(imageByte, Base64.DEFAULT)  
}
```

# Video
## Video in VideoView

Add internet permission for online video

```kotlin
val networkVideoURL = "url_of_video"
val localVideoResourcePath = "android.resource://$packageName/${R.raw.sample_video}"

val videoView: VideoView = findViewById(R.id.videoView)

// videoView.setVideoPath(localVideoResourcePath)

// use either above one line or 2 lines below depending on video source

// val uri = Uri.parse(networkVideoURL)
// videoView.setVideoURI(uri)

val mediaController = MediaController(this)
mediaController.setAnchorView(videoView)
mediaController.setMediaPlayer(videoView)
videoView.setMediaController(mediaController)
```

# Audio
## From Local Resource
```kotlin
fun sayColour() {
  var mediaPlayer: MediaPlayer = MediaPlayer.create(
    this,
    resources.getIdentifier(
      "audio_file",
      "raw",
      packageName
    )
  )
  mediaPlayer.start()
}

```
