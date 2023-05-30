Dependencies
```gradle
plugins{
	id 'kotlin-kapt'
}
dependencies{
	def room_version = "2.5.0"
    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
}
```

User
```kotlin
@Entity
data class User(
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null
}
```

Dao
```kotlin
@Dao
interface UserDao {
 @Query("SELECT * FROM user")
 fun getAll(): List<User>

 @Query("SELECT * FROM user WHERE id IN (:userIds)")
 fun loadAllByIds(userIds: IntArray): List<User>

 @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
         "last_name LIKE :last LIMIT 1")
 fun findByName(first:String, last:String): User

 @Insert
 fun insertAll(vararg users: User)

// @Delete
// fun delete(user: User)

 @Query("DELETE FROM user WHERE id = :id")
 fun deleteUserById(id: Int)
}
```


AppDatabase
```kotlin
@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}
```


Activity
```kotlin
onCreate(){
	val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name",)
            .allowMainThreadQueries().build()

    val userDao = db.userDao()

    /*binding.buttonAddUser.setOnClickListener{
        addNewUser(userDao)
        refreshUsersList(userDao)
    }

	binding.buttonDeleteUser.setOnClickListener { deleteUser(userDao) }
	refreshUsersList(userDao)
    */

}

private fun deleteUser(userDao: UserDao) {
    //val id = binding.editTextDeleteId.text.toString().toInt()
    userDao.deleteUserById(id)
    //refreshUsersList(userDao)
}

private fun refreshUsersList(userDao: UserDao) {
    val listUser = userDao.getAll()
    binding.textViewListUsers.text = ""
    //Log.v("list user", listUser[i].toString())
    for (i in listUser.indices) binding.textViewListUsers.text =
        "${binding.textViewListUsers.text}\n${listUser[i].Id} = ${listUser[i]} "
}

private fun addNewUser(userDao: UserDao) {
    /*var firstName: String = binding.editTextFirstName.text.toString().trim()
    var lastName: String = binding.editTextLastName.text.toString().trim()

    val user = User(firstName,lastName)*/

    userDao.insertAll(user)
}
```