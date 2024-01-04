Go to https://www.firebase.google.com, and create a new project
Inside the project, add an app to your Firebase Project

Enter the package name of your app. You will get a `google-services.json` file
and place it in your android project `app` folder and add these dependencies

project gradle
```kotlin
plugins {
  id("com.google.gms.google-services") version "4.4.0" apply false
}
```

module gradle
```kotlin
// manage all firebase specifying single version
implementation(platform("com.google.firebase:firebase-bom:32.7.0"))  

// analytics dependency
implementation("com.google.firebase:firebase-analytics")  

// realtime database dependency
implementation("com.google.firebase:firebase-database")
```

Activity
```kotlin
val database: DatabaseReference = Firebase.database.reference

// write data to realtime database (key value pair)
database.child("price").setValue(5000)

// write custom objects 
val user = User("Adam","123") // data class User (name:String, pass: String)
database.child("users").setValue(u1)

// read data once
database.child("price").get().addOnSuccessListener {  
  // if successfully read data
  textView.text = it.value.toString()  
}.addOnFailureListener {  
  // if failed to get data
  Toast.makeText(this,"Problem in getting data", Toast.LENGTH_LONG).show()  
}

// read data persistently
val priceListener = object : ValueEventListener {  
  override fun onDataChange(snapshot: DataSnapshot) {
    // data read is stored in snapshot
    val price = snapshot.value  
    textView.text = pric.toString()  
  }  
  
  override fun onCancelled(error: DatabaseError) {  
    // if client does not have permission to read data
    Toast.makeText(this,"Problem in getting data", Toast.LENGTH_LONG).show() 
  }  
}
```