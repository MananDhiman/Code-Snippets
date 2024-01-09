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

Min Fragment Code

```kotlin
class Fragment1 : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_1, container, false)
  }
}

```

First Fragment ViewBinding

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

## Methods
Recreate activity from within fragment
`getActivity().recreate()`