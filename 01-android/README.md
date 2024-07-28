jvm test - unit test
instrumentation test - android, espresso - views

# Orientation Rotate 
AndroidManifest.xml
```xml
android_:screenOrientation="portrait"
```

# Relase APK without signing 
```kotlin
signingConfig = signingConfigs.getByName("debug")
```


# Adjust layout when soft keyboard opened

AndroidManifest.xml

```xml
<activity
  android:name=".activity.MyActivity"
  android:windowSoftInputMode="adjustResize">
</activity>
```
# Runtime Permission
```xml
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
```

Ask for Permission
```kotlin
private fun askForPermission() {
    val pState = ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)


    if (pState == PackageManager.PERMISSION_DENIED) {
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS) ,1)
    }
}

```
## Use xml defined colours in activities

```kotlin
val colors: Int = resources.getColor(R.color.purple_700)
```

## Use xml defined strings

```kotlin
// in fragment
val apiKey = context?.getString(R.string.api_key)

// in activity
val apiKey = R.string.api_key
```

# Intent

finish() after startActivity clears prev activity

## Implicit Intent

Intent that does not specifically states the target

```kotlin
val intent = Intent(Intent.ACTION_SEND)
intent.type = "text/plain" // MIME type
intent.putExtra(Intent.EXTRA_SUBJECT, "$name is lucky today")
intent.putExtra(Intent.EXTRA_TEXT, "Their lucky number is ${luckyNumber.toString()}") // main body
startActivity(intent)
```

## Use parse uri to handle specific request

```kotlin
try{
	var intent = Intent(Intent.ACTION_VIEW)
	intent.data = Uri.parse("https://wa.me/$number")
	startActivity(intent)
}

catch(e: Exception){
	Toast.makeText(this,"Some Error Occurred. Please Try Again",Toast.LENGTH_LONG).show()
}
```

## Explicit Intent

Intent that specifically states the target

```kotlin
val intent: Intent = Intent(this, SecondActivity::class.java)
intent.putExtra("name",name) // pass data to activity
startActivity(intent)
```

# WebView
```kotlin
val webView = findViewById<WebView>(R.id.web_view)  
webView.loadUrl("https://webhead.in/lptv/")  
webView.settings.javaScriptEnabled = true

webView.webViewClient = WebViewClient()

override fun onBackPressed() {  
	if (webView.canGoBack()) webView.goBack()  
	else super.onBackPressed()  
}
```
# Enable view binding

build.grade

```
buildFeatures {
    viewBinding = true
}
```

MainActivity

```Kotlin
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
```

# Clipboard

```kotlin
// copy last from clipboard
val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
Log.d("TAG",clipboard.primaryClip?.itemCount.toString())

// save to clipboard
val clip = ClipData.newPlainText("label", "data to copy")
clipboard.setPrimaryClip(clip)
```

# Progress Dialog (Deprecated. Use ProgressBar)

```kotlin
private lateinit var progressDialog: ProgressDialog
progressDialog = ProgressDialog(this) // var progressDialog: ProgressDialog = ProgressDialog(this)

progressDialog.setTitle("Loading Posts...")
progressDialog.show()

progressDialog.dismiss()
```

# Glide Image Load
`implementation("com.github.bumptech.glide:glide:4.16.0")`

```kotlin
Glide
    .with(context)
    .load(url)
    .centerCrop()
    .placeholder(R.drawable.loading_spinner)
    .into(myImageView);
```
# Dhaval Image picker
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
-
implementation 'com.github.dhaval2404:imagepicker:2.1'
```

```kotlin
// call image picker
ImagePicker.with(this)
    .crop()                     //Crop image(Optional), Check Customization for more option
    .compress(1024)             //Final image size will be less than 1 MB(Optional)
    .maxResultSize(1080, 1080)  //Final image resolution will be less than 1080 x 1080(Optional)
    .start()

// handle operation
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (resultCode
        == Activity.RESULT_OK) {
        //Image Uri will not be null for RESULT_OK
        val uri: Uri = data?.data!!

        // Use Uri object instead of File to avoid storage permissions
        imgProfile.setImageURI(fileUri)

    }
    else if (resultCode == ImagePicker.RESULT_ERROR) {
        Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
    }
}

// customisation
ImagePicker.with(this)
    .compress(1024)                 //Final image size will be less than 1 MB(Optional)
    .maxResultSize(1080, 1080)      //Final image resolution will be less than 1080 x 1080(Optional)
    .createIntent { intent -> startForProfileImageResult.launch(intent) }

ImagePicker.with(this)
    .galleryOnly()          //User can only select image from Gallery
    .cameraOnly()           //User can only capture image using Camera
    .crop()                 //Crop image and let user choose aspect ratio.
    .crop(16f, 9f)          //Crop image with 16:9 aspect ratio
    .cropSquare()           //Crop square image, its same as crop(1f, 1f)
    .compress(1024)         //Final image size will be less than 1 MB
    .maxResultSize(620, 620)//Final image resolution will be less than 620 x 620
    .setDismissListener { /* Handle dismiss event */ Log.d("ImagePicker", "onDismiss"); }
    .start()                //Default Request Code is ImagePicker.REQUEST_CODE
```
# Format Number Currency
NumberFormat.getCurrencyInstance().format(tip) // tip is double