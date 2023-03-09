# ViewModel
**Generate data for activity from Model.**
	Activity or fragment should contain logic responsible for UI fragments only


MVVM Recommended by Google

build.gradle
```gradle
val lifecycle_version = "2.5.1"
?val arch_version = "2.1.0"?

// ViewModel        
implementation("androidx.lifecycle:lifecycle-viewmodel-tx:$lifecycle_version")
```

MainViewModel.kt
```kotlin
class MainViewMode: ViewModel(){
	var count: Int = 0

	fun increment(){
		count++
	}
}
```

MainActivity
```kotlin
lateinit var mainViewModel: MainViewModel

fun onCreate(savedIns? Bundle){
	mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
}
fun doThingWithActivity(){
	binding.textView.text = mainViewModel.count.toString()
}
fun incrememnt(){
	mainViewModel.incrememnt()
	doThingWithActivity()
}
```