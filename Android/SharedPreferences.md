```kotlin
private lateinit var preferences: SharedPreferences  
private lateinit var myEdit: SharedPreferences.Editor

onCreate(){
		preferences = getSharedPreferences("AttendanceChecker", context.MODE_PRIVATE)  
	myEdit = preferences.edit()

}

getValues(){
	presentDays = preferences.getInt("presentDays",0); totalDays = preferences.getInt("totalDays",0)
}

putValues(){
	myEdit.putInt("totalDays",totalDays)
	myEdit.putInt("presentDays",presentDays)  
	myEdit.commit()
}
```
