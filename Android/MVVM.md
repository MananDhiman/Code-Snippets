# Implementation

## build.gradle (kts) (app)
```gradle
plugins {
	id("kotlin-kapt")
}

android {  
    buildFeatures {
		dataBinding = true
	}
}

dependencies{
	val lifecycle_version = "2.6.1"
//    ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
//    LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
//    Annotation processor
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")
}
```


## activity_main.xml 
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout 
	xmlns:tools="http://schemas.android.com/tools"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    
	<data>
        <variable
            name="mainViewModel"
            type="com.example.test.MainViewModel" />
    </data>

<androidx.constraintlayout.widget.ConstraintLayout
	android:layout_width="match_parent"
	android:layout_height="match_parent"
	tools:context=".MainActivity" >

	<TextView
		android:id="@+id/textViewName"
		android:text="@={mainViewModel.textViewName}" />

	<EditText
		android:id="@+id/editText"
		android:text="@={mainNiewModel.editText}" />
		
	<Button
		android:id="@+id/button"
		android:onClick="@{() -> mainViewModel.doStuff()}"
		android:text="@={mainViewModel.buttonText}" />
		
</androidx.constraintlayout.widget.ConstraintLayout>

</layout>
```
## MainViewModel.kt
```kotlin
class MainViewModel: ViewModel(), Observable {

	@Bindable
    val textViewName = MutableLiveData<String?>()

	@Bindable
    val editText = MutableLiveData<String?>()

	@Bindable
    val buttonText = MutableLiveData<String>()

	init {
		buttonText.value = "Submit"
		textViewName.value = "Enter Text Here"
	}

	fun doStuff() {
		buttonText.value = "Clear Form"
		textViewName.value = "Data Entered"
	}
}
```
## ViewModelFactory
```kotlin
class MainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel() as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}
```
## MainActivity
```kotlin
class MainActivity : AppCompatActivity() {  

	private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {  
        super.onCreate(savedInstanceState)  

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    	val factory = MainViewModelFactory()
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this 
    }  

}
```

***
***
# Fragments not yet tested

## Fragment (My code may contain residue from ViewBinding)
```kotlin
class NewContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentNewContactBinding = DataBindingUtil
            .inflate(layoutInflater, R.layout.fragment_new_contact, container, false)

        val viewModel = ViewModelProvider(this)[AddContactViewModel::class.java]
        binding.viewModel = viewModel

        return binding.root
    }
}
```


## ViewUtils
```kotlin
fun Context.toast(message: String){  
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()  
}
```

# ViewModel
**Generate data for activity from Model.**
	Activity or fragment should contain logic responsible for UI fragments only


MVVM Recommended by Google

