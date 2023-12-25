# Shared Preferences
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

# ROOM
## Dependencies
```gradle
plugins{
	id("kotlin-kapt")
}
dependencies{
	val roomVersion = "2.6.1"
  implementation("androidx.room:room-runtime:$room_version")  
  kapt("androidx.room:room-compiler:$room_version")
}
```

## Model Class - User
Room will use data class name as table name, if in entity data class table name not specified.

For custom column name use column info.
```kotlin
@Entity
data class User(
    val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null
}
```
Second Method
```kotlin
@Entity (tableName = "user")
data class User{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val id: Int,

    @ColumnInfo(name = "first_name") val firstName: String?
}
```

## Data Access Object (DAO)
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

## AppDatabase
```kotlin
@Database(entities = [User::class, Person::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}
```

## Activity
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

# SQLite
## Data Class
```kotlin
class Data{
    var id: Int = 0
    var name: String = ""
    var age: Int = 0

    constructor(name:String, age: Int){
        this.name = name
        this.age = age
    }
    
    constructor(){ }	//empty constructor for read 
}
```

## DataBaseHandler
```kotlin
val DATABASE_NAME = "MyDB"
val TABLE_NAME = "Users"
val COL_NAME = "name"
val COL_AGE = "age"
val COL_ID = "id"

class DataBaseHandler(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null,1){
    var context = context
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " VARCHAR(256)," +
                COL_AGE + " INTEGER)";

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user: Data){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, user.name)
        cv.put(COL_AGE, user.age)
        var result = db.insert(TABLE_NAME,null,cv)

        if(result == (-1).toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show()
        else{
            Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
        }
    }
    
    fun readData(): MutableList<Data>{
        var list: MutableList<Data> = ArrayList()
        var db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = db.rawQuery(query, null)

        if(result.moveToFirst()){
            do{
                var user = Data()
                user.id = result.getString(0).toInt()
                user.name = result.getString(1)
                user.age = result.getString(2).toInt()
                list.add(user)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    
}
```

## Main Activity
```kotlin
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val context = this

        binding.butSubmit.setOnClickListener {
            validateAndSaveData(context)
        }
        binding.butView.setOnClickListener {
            readData()
        }
    }

    private fun validateAndSaveData(context: MainActivity) {
        if(binding.etAge.text.isEmpty() || binding.etName.text.isEmpty()){
            Toast.makeText(this,"Please Enter The Required Data",Toast.LENGTH_LONG).show()
            return
        }
        var user = Data(binding.etName.text.toString(), binding.etAge.text.toString().toInt())
        var db = DataBaseHandler(context)
        db.insertData(user)
    }
    
    private fun readData(){
        val data = db.readData()
        binding.tvAge.text = ""
        binding.tvName.text = ""
        for (i in 0 until data.size){
            binding.tvAge.append(data[i].age.toString() + "\n")
            binding.tvName.append(data[i].name.toString() + "\n")
        }
    }
}
```