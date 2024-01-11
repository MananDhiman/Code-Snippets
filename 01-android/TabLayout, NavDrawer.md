# Tab Layout

ViewPagerAdapter, Fragments, MainActivity

## ViewPagerAdapter

```kotlin
class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
  override fun getItemCount(): Int {
    return 3
  }

  override fun createFragment(position: Int): Fragment {
    when (position) {
      0 -> return GamesFragment()
      1 -> return BooksFragment()
      2 -> return MoviesFragment()
    }
    return GamesFragment() // default fragment to open
  }
}
```

## No Modification in Fragments

## activity_main.xml

```xml
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto"
  xmlns:tools="http://schemas.android.com/tools"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  tools:context=".MainActivity">

  <com.google.android.material.tabs.TabLayout
    android:id="@+id/tabLayout"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintHorizontal_bias="0.5"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />

  <androidx.viewpager2.widget.ViewPager2
    android:id="@+id/viewPager"
    android:layout_width="match_parent"
    android:layout_height="0dp"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintHorizontal_bias="0.5"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@id/tabLayout" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

## MainActivity

```kotlin
class MainActivity : AppCompatActivity() {

  private val tabsArray = arrayOf("Games","Books","Movies")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val viewPager2: ViewPager2 = findViewById(R.id.viewPager)
    val tabLayout: TabLayout = findViewById(R.id.tabLayout)

    val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
    viewPager2.adapter = adapter
    TabLayoutMediator(tabLayout, viewPager2) {
      tab, position -> tab.text = tabsArray[position]
    }.attach()
  }
}
```

# Navigation Drawer

## activity_main.xml

```xml
<androidx.drawerlayout.widget.DrawerLayout
  xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto"
  xmlns:tools="http://schemas.android.com/tools"
  android:id="@+id/drawerLayout"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  tools:context=".MainActivity">

  <androidx.constraintlayout.widget.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <FrameLayout
      android:id="@+id/frameLayout"
      android:layout_width="match_parent"
      android:layout_height="match_parent" />

  </androidx.constraintlayout.widget.ConstraintLayout>

  <com.google.android.material.navigation.NavigationView
    android:layout_width="wrap_content"
    android:layout_height="match_parent"
    android:id="@+id/navView"
    android:fitsSystemWindows="true"
    android:layout_gravity="start"
    app:headerLayout="@layout/nav_header"
    app:menu="@menu/nav_menu"/>

</androidx.drawerlayout.widget.DrawerLayout>
```

## nav_menu.xml

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:tools="http://schemas.android.com/tools"
  tools:showIn="navigation_view" >

  <group android:checkableBehavior="single" >
    <item android:id="@+id/home" android:title="Home Page" />
    <item android:id="@+id/message" android:title="Message Page" />
    <item android:id="@+id/settings" android:title="Settings Page" />
  </group>

  <item android:title="Profile">
    <menu>
      <group android:checkableBehavior="single">
        <item android:id="@+id/login" android:title="Login Page" />
      </group>
    </menu>
  </item>
</menu>
```

## nav_header.xml (optional)

```xml
<TextView
  android:id="@+id/textView"
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  android:layout_marginStart="16dp"
  android:layout_marginTop="16dp"
  android:text="Navigation Header"
  android:textSize="32sp"
  app:layout_constraintStart_toStartOf="parent"
  app:layout_constraintTop_toTopOf="parent" />
```

## No Change in Fragments

## MainActivity

```kotlin
class MainActivity : AppCompatActivity() {

  private lateinit var toggle: ActionBarDrawerToggle
  private lateinit var drawerLayout: DrawerLayout
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    drawerLayout = findViewById(R.id.drawerLayout)

    toggle = ActionBarDrawerToggle(
      this@MainActivity,
      drawerLayout,
      R.string.open, // <string name="open">Open</string>
      R.string.close // <string name="close">Close</string>
    )

    drawerLayout.addDrawerListener(toggle)
    toggle.syncState()
    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    val navView: NavigationView = findViewById(R.id.navView)
    navView.setNavigationItemSelectedListener {
      it.isChecked = true
      when(it.itemId) {
        R.id.home -> { // corresponds to item id in nav_menu
          replaceFragment(HomeFragment(), it.title.toString())
        }
        // depending on number of fragments, add more cases
      }
      true
    }
  }

  private fun replaceFragment(fragment: Fragment, title: String) {
    val fragmentManager = supportFragmentManager
    val fragTrans = fragmentManager.beginTransaction()
    fragTrans.replace(R.id.frameLayout, fragment)

    fragTrans.commit()
    drawerLayout.closeDrawers()
    setTitle(title)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (toggle.onOptionsItemSelected(item)) {
      return true
    }
    return super.onOptionsItemSelected(item)
  }
}
```
