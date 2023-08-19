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
## Font
Drawable -> new resource -> font, paste otf in folder

In textView XML tags
```xml
android:fontFamily="@font/glakome"
```
## Button colour Background tint
```xml
android:backgroundTint="@color/black"
```

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

## Android Menu
Inflate with menu inflater. Main menu in top bar of activity

In themes, select any theme with ActionBar

### XML Layout
```xml
<menu xmlns:app="http://schemas.android.com/apk/res-auto"
	xmlns:android="http://schemas.android.com/apk/res/android">

	<item
    android:title="Item 1"
    android:id="@+id/menu_item_1" />

	<item
    android:title="Item 2"
    android:id="@+id/menu_item_2" />

	<item
    android:title="Item 3"
    android:id="@+id/menu_item_3" />
</menu>
```

### Activity (outside onCreate())
```kotlin
override fun onCreateOptionsMenu(menu: Menu?): Boolean {
  menuInflater.inflate(R.menu.menu, menu)
  return true
}
```

## Function call with XML declare onClick
```xml
<Button
   android:id="@+id/button5"
   android:layout_width="wrap_content"
   android:layout_height="wrap_content"
   android:tag="black"
   android:text="Black"
   android:onClick="sayColour"
   android:backgroundTint="@color/black" />
```


fun sayColour(view: View) {
   val clickedButton: Button = view as Button


   var mediaPlayer: MediaPlayer = MediaPlayer.create(
       this,
       resources.getIdentifier(
           clickedButton.tag.toString(),
           "raw",
           packageName
       )
   )
   mediaPlayer.start()
}


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

# Progress Dialog
```kotlin
private lateinit var progressDialog: ProgressDialog 
progressDialog = ProgressDialog(this) // var progressDialog: ProgressDialog = ProgressDialog(this)

progressDialog.setTitle("Loading Posts...")
progressDialog.show()

progressDialog.dismiss()
```


