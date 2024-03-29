# Only ViewModel

**Generate data for activity from Model.**
Activity or fragment should contain logic responsible for UI fragments only

Dependencies

```gradle
val lifecycle_version = "2.6.2"
implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
```

Example ViewModel class (MainViewModel)

```kotlin
import androidx.lifecycle.ViewModel

data class User(
  val name: String? = null,
  val age: Int? = null
)

// for context use AndroidViewModel, and getApplication()
// class MainViewModel(application: Application): AndroidViewModel(application) {
class MainViewModel: ViewModel() {
  private val list = arrayOf(
    User("A",10),
    User("B",20),
    User("C",30),
  )

  private var count = 0

  fun getUserById(id: Int): String {
    if(id in 0..2) {
      val user = list[id]
      return "${user.name} is ${user.age}"
    } else {
      return "Incorrect id"
    }
  }

  fun incrementCount() {
    this.count++
  }

  fun getCount(): Int = this.count
}
```

Activity

```kotlin
val viewModel: MainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

textView.text = viewModel.getCount().toString()
button.setOnClickListener {
  viewModel.incrementCount()
  textView.text = viewModel.getCount().toString()
}
```

Jetpack Compose (source: Google)

```kotlin
// SignUpViewModel.kt
class SignUpViewModel(private val userRepository: UserRepository) : ViewModel() {
	var username by mutableStateOf("")
	private set

    fun updateUsername(input: String) {
        username = input
    }
}

// SignUpScreen.kt
@Composable
fun SignUpScreen(/*...*/) {
    OutlinedTextField(
        value = viewModel.username,
        onValueChange = { username -> viewModel.updateUsername(username) }
        /*...*/
    )
}
```

# Live Data

```kotlin
// viewmodel
var count = MutableLiveData<Int>()
fun inc() {count.value = (count.value)?.plus(1) }

// MainActivity
viewModel.count.observe(this,{
  textView.text = it.toString()
})
```
## Mutability/immutability in ViewModel
1. Create a private MutableLiveData in viewModel
2. Create a getter method for that MutableLiveData
3. in onCreate() method you should register the observer without making any call
4. Then you should call a public method that fetches data and posts value into MutableLiveData.
5. This way, your observer in the UI should be triggered.

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

---

---

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

MVVM Recommended by Google
