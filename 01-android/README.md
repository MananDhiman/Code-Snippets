jvm test - unit test
instrumentation test - android, espresso - views

## Font

Drawable -> new resource -> font, paste otf in folder

In textView XML tags

```xml
android:fontFamily="@font/glakome"
```

Highlight a View
`view.requestFocus()`

# Adjust layout when soft keyboard opened

In Manifest.xml

```xml
<activity
  android:name=".activity.MyActivity"
  android:windowSoftInputMode="adjustResize">
</activity>
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
val c = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
Log.d("TAG",c.primaryClip?.itemCount.toString())
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

`dependencies {
  implementation 'com.github.bumptech.glide:glide:4.16.0'
}`

```kotlin
Glide
  .with(context)
  .load(url)
  .centerCrop()
  .placeholder(R.drawable.loading_spinner)
  .into(myImageView);
```
