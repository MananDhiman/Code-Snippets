MainActivity
```kotlin
val firstFragment = FirstFragment()  
val secondFragment = SecondFragment()
firstFragment = FirstFragment.newInstance()

binding.button1.setOnClickListener {  
    supportFragmentManager.beginTransaction().apply {  
        replace(R.id.frameLayout,firstFragment)  
        commit()  
    }  
}  

binding.button2.setOnClickListener {  
    supportFragmentManager.beginTransaction().apply {  
        replace(R.id.frameLayout,secondFragment)  
        commit()  
    }  
}
```

First Fragment
```kotlin
class FirstFragment : Fragment() {  
  
    private lateinit var binding: FragmentFirstBinding  
  
    override fun onCreateView(
	    inflater: LayoutInflater, container: ViewGroup?,  
        savedInstanceState: Bundle?  
    ): View? {  
        binding = FragmentFirstBinding.inflate(layoutInflater,container, false)  
  
        binding.button.setOnClickListener { changeText() }  
  
        return binding.root  
  
    }  
  
    private fun changeText() {  
        Toast.makeText(context,"this is toast message",Toast.LENGTH_SHORT).show()  
    }  
}
```