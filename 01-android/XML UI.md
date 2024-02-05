# Font

Drawable -> new resource -> font, paste otf in folder

In textView XML tags

```xml
android:fontFamily="@font/glakome"
```

## Highlight a View
`view.requestFocus()`
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

## Button colour Background tint

```xml
android:backgroundTint="@color/black"
```

# Create XML Elements dynamically

```kotlin
for(i in 0..5) {
  val editText = EditText(this)
  editText.setText("${i+10}")
  linearLayout.addView(editText)
}

// delete all elements of layout
layout.removeAllViews()
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

# Spinner

```kotlin
// elements to be displayed
val timeDuration = arrayOf("1","3","5","7","10","15")

val arrayAdapter = ArrayAdapter(requireContext(), <simple-spinner>, timeDuration)

binding.spinner.adapter = arrayAdapter

// on spinner click. if any item selected. if none selected
binding.spinner.onItemSelectedListener = object :
AdapterView.OnItemSelectedListener {
  override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
    val durationSelected = binding.spinner.getItemAtPosition(p2).toString()
    getPostsOfDuration(durationSelected)
  }

  override fun onNothingSelected(p0: AdapterView<*>?) {
    TODO("Not yet implemented")
  }
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

```kotlin
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
```

# Progress Bar

Create Layout

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  android:orientation="horizontal"
  android:padding="20dp">

  <ProgressBar
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_weight="1" />

  <TextView
    android:layout_width="0dp"
    android:layout_height="match_parent"
    android:layout_weight="4"
    android:gravity="center"
    android:text="Loading" />
</LinearLayout>
```

In Activity

```kt
// first create builder
val builder: AlertDialog.Builder = AlertDialog.Builder(context)
builder.setCancelable(false)
builder.setView(R.layout.loading_dialog)

// then create dialog
val loadingDialog : AlertDialog = builder.create()
loadingDialog.show()
loadingDialog.dismiss()
```
