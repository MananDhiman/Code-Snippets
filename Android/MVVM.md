# Implementation

## build.gradle (app)
```gradle
android {  
    dataBinding{  
        enable = true  
    }  
}

dependencies{

	def lifecycle_version = "2.6.0"  
	def arch_version = "2.1.0"  
	  
	// ViewModel  
	implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"  
	// ViewModel utilities for Compose  
	//implementation "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version"  
	// LiveData  
	implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"  
	// Lifecycles only (without ViewModel or LiveData)  
	implementation "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"  
	  
	// Saved state module for ViewModel  
	implementation "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"  
	  
	// Annotation processor  
	//kapt "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"  
	// alternately - if using Java8, use the following instead of lifecycle-compiler  
	//implementation "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"

}
```

## gradle.properties
```gradle
android.databinding.enableV2=true
```
## activity_main.xml 
```xml
<layout>
	\?xml namespaces 3 lines\?
	<data>  
	    <variable        
		    name="viewModel"  
	        type="com.example.mvvm.ui.MainViewModel" />  
	</data>

<androidx.constraintlayout.widget.ConstraintLayout
	android:id="@+id/rootLayout"
	android:layout_width="match_parent"
	android:layout_height="match_parent"
	tools:context=".ui.MainActivity">
	
	<EditText
		android:id="@+id/editText"
		android:text="@={viewModel.text}"
		android:hint="Enter Text"
		app:layout_constraintBottom_toTopOf="@+id/textView"/>
		
	<Button
		android:id="@+id/button"
		android:text="Button"
		android:onClick="@{viewModel::onButtonClick}" />
		
</androidx.constraintlayout.widget.ConstraintLayout>

</layout>
```
## MainViewModel.kt
```kotlin
class MainViewModel: ViewModel(){
	var text: String? = null  
  
	var authListener: AuthListener? = null  
  
	fun onButtonClick(view: View){  
	    if(text.isNullOrBlank()){  
	        authListener?.onFailure("Enter Some Text")  
	        return  
	    }  
	    authListener?.onSuccess()  
	}
}
```
## AuthListener (Optional) (interface)
```kotlin
interface AuthListener {   
    fun onSuccess()  
    fun onFailure(message: String)  
}
```
## MainActivity
```kotlin
class MainActivity : AppCompatActivity(), AuthListener {  
    override fun onCreate(savedInstanceState: Bundle?) {  
        super.onCreate(savedInstanceState)  
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)  
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]  
        binding.viewmodel = viewModel  
        viewModel.authListener = this  
    }  
  
    override fun onSuccess() {  
        toast("Text Entered")  
    }  
  
    override fun onFailure(message: String) {  
        toast(message)  
    }  
}
```

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

