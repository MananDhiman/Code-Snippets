# Drawable 
Can be used as background or foreground of any android view
```xml
<shape xmlns:android="http://schemas.android.com/apk/res/android">
  <gradient
    android:type="linear"
    android:angle="45"
    android:startColor="@color/black"
    android:centerColor="@color/gray"
    android:endColor="@color/white" />
  
  <corners
    android:topRightRadius="8dp"
    android:radius="50dp"/>
  
  <stroke
    android:width="5dp"
    android:color="@color/white" />
</shape>
```

## Background
Either colour or a drawable
```xml
android:background="#E1D4D4"
```

# Intent
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
## Enable view binding
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

# Adjust layout when soft keyboard opened
In Manifest.xml
```xml
<activity 
     android:name=".activity.MyActivity"
     android:windowSoftInputMode="adjustResize">
</activity>
```

# Progress Dialog
```kotlin
private lateinit var progressDialog: ProgressDialog 
progressDialog = ProgressDialog(this) // var progressDialog: ProgressDialog = ProgressDialog(this)

progressDialog.setTitle("Loading Posts...")
progressDialog.show()

progressDialog.dismiss()
```
