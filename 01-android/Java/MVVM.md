# Implementation

## build.gradle (app)
```gradle
android {  
    dataBinding{  
        enable = true  
    }  
}

dependencies{

	def lifecycle_version = "2.5.1"
	implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
	implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
	implementation "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"
	
}
```

## gradle.properties
```gradle
android.databinding.enableV2=true
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
## MainViewModel.java
```java
public class MainViewModel extends ViewModel {
    private int firstNumber, secondNumber;

    void add(){}
    void subtract(){}
    void multiply(){}
    void divide(){}

    boolean isEditTextEmpty(){
        return true;
    }

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
