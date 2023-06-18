## Enable view binding
1.  Open the app's build.gradle file ( Gradle Scripts > build.gradle (Module: Tip_Time.app) )
    
2.  In the android section, add the following lines

```Kotlin
buildFeatures {
    viewBinding = true
}

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
```

## Layout 
```xml
android:background="#E1D4D4"
```

# Intent to another App
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
