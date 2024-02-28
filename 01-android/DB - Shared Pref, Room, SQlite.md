# Shared Preferences
Better create a object / singleton
```kotlin
object SharedPreferencesManager {  

  private const val PREF_NAME = "MySharedPrefs"  
  private lateinit var sharedPreferences: SharedPreferences  

  fun init(context: Context) {  
      sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)  
  }  

  fun saveString(key: String, value: String) {  
      sharedPreferences.edit().putString(key, value).apply()  
  }  

  fun getString(key: String, defaultValue: String): String {  
      return sharedPreferences.getString(key, defaultValue) ?: defaultValue  
  }
}

// use sharedPref
SharedPreferencesManager.init(this)
SharedPreferencesManager.getString("user","abc")

// handle db upgrade
override fun onUpgrade(
	db: SQLiteDatabase?, 
	oldVersion: Int, 
	newVersion: Int
) {  
	// or handle data migration
	val del = "DROP TABLE IF EXISTS $_TABLE_POSTS"  
	db?.execSQL(deletePostsTable)  
}
```

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
  implementation("androidx.room:room-runtime:$roomVersion")
  kapt("androidx.room:room-compiler:$roomVersion")
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

null primary key

```kotlin
@Entity(tableName = "subject")
data class Subject(
  @PrimaryKey(autoGenerate = true) val id: Int, val name: String
) {
  constructor(name: String) : this(0, name)
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

  @Query("SELECT * FROM user WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
  fun findByName(first:String, last:String): User

  @Insert
  fun insertAll(vararg users: User)

  @Insert
  fun addSubjects(subjectNames: ArrayList<Subject>)

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
  abstract fun personDao(): PersonDao
}
```

## Activity

```kotlin
onCreate(){
	val db = Room.databaseBuilder(
    applicationContext,
    AppDatabase::class.java, "database-name",)
    .allowMainThreadQueries() // find alternative
    .fallbackToDestructiveMigration() // when app updated
    .build()

  val userDao = db.userDao()

  binding.buttonAddUser.setOnClickListener{
    addNewUser(userDao)
    refreshUsersList(userDao)
  }

	binding.buttonDeleteUser.setOnClickListener { deleteUser(userDao) }
	refreshUsersList(userDao)
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
## Developer.Android
```kotlin
// Table contents grouped together in anonymous object
object FeedReaderContract { 
	object FeedEntry : BaseColumns { 
		const val TABLE_NAME = "entry"
		const val COLUMN_NAME_TITLE = "title"
		const val COLUMN_NAME_SUBTITLE = "subtitle"    
	}  
}

private const val SQL_CREATE_ENTRIES =
	"CREATE TABLE ${FeedEntry.TABLE_NAME} (" +
			"${BaseColumns._ID} INTEGER PRIMARY KEY," +
			"${FeedEntry.COLUMN_NAME_TITLE} TEXT," +
			"${FeedEntry.COLUMN_NAME_SUBTITLE} TEXT)"

private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${FeedEntry.TABLE_NAME}"
```

```kotlin
// DatabaseHandler
class FeedReaderDbHelper(context: Context) 
	: SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
	
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "FeedReader.db"
    }
}

// ------------------
// access db
val dbHelper = FeedReaderDbHelper(context)
```
CREATE
```kotlin
// insert into db
// Gets the data repository in write mode
val db = dbHelper.writableDatabase

// Create a new map of values, where column names are the keys
val values = ContentValues().apply {
    put(FeedEntry.COLUMN_NAME_TITLE, title)
    put(FeedEntry.COLUMN_NAME_SUBTITLE, subtitle)
}

// Insert the new row, returning the primary key value of the new row
val newRowId = db?.insert(FeedEntry.TABLE_NAME, null, values)

```
READ
``` kotlin
// read from db 
val db = dbHelper.readableDatabase

// Define a projection that specifies which columns from the database
// you will actually use after this query.
val projection = arrayOf(BaseColumns._ID, FeedEntry.COLUMN_NAME_TITLE, FeedEntry.COLUMN_NAME_SUBTITLE)

// Filter results WHERE "title" = 'My Title'
val selection = "${FeedEntry.COLUMN_NAME_TITLE} = ?"
val selectionArgs = arrayOf("My Title")

// How you want the results sorted in the resulting Cursor
val sortOrder = "${FeedEntry.COLUMN_NAME_SUBTITLE} DESC"

val cursor = db.query(
	FeedEntry.TABLE_NAME,   // table
	projection,             // array of columns to return (pass null to get all)
	selection,              // The columns for the WHERE clause
	selectionArgs,          // The values for the WHERE clause
	null,                   // don't group the rows
	null,                   // don't filter by row groups
	sortOrder               // The sort order
)

val itemIds = mutableListOf<Long>()
with(cursor) {
    while (moveToNext()) {
        val itemId = getLong(getColumnIndexOrThrow(BaseColumns._ID))
        itemIds.add(itemId)
    }
}
cursor.close()
```
DELETE
```kotlin
// Define 'where' part of query.  
val selection = "${FeedEntry.COLUMN_NAME_TITLE} LIKE ?"  
// Specify arguments in placeholder order.  
val selectionArgs = arrayOf("MyTitle")  
// Issue SQL statement.  returns no. of rows deleted
val deletedRows = db.delete(FeedEntry.TABLE_NAME, selection, selectionArgs)
```
UPDATE
```kotlin
val db = dbHelper.writableDatabase

// New value for one column
val title = "MyNewTitle"
val values = ContentValues().apply {
    put(FeedEntry.COLUMN_NAME_TITLE, title)
}

// Which row to update, based on the title
val selection = "${FeedEntry.COLUMN_NAME_TITLE} LIKE ?"
val selectionArgs = arrayOf("MyOldTitle")
val count = db.update(
	FeedEntry.TABLE_NAME,
	values,
	selection,
	selectionArgs
)
```

```kotlin
override fun onDestroy() {
    dbHelper.close()
    super.onDestroy()
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
  
  override fun onCreate(db: SQLiteDatabase?) {
	db.execSQL(SQL_CREATE_ENTRIES) // reduce code

    val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
      COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
      COL_NAME + " VARCHAR(256)," +
      COL_AGE + " INTEGER)";

    db?.execSQL(createTable)
  }

  override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    db.execSQL(SQL_DELETE_ENTRIES)
	onCreate(db)
  }

  fun insertData(user: Data){
    val db = this.writableDatabase
    
    var cv = ContentValues()
    cv.put(COL_NAME, user.name)
    cv.put(COL_AGE, user.age)

	val values = ContentValues().apply {
	    put(FeedEntry.COLUMN_NAME_TITLE, title)
	    put(FeedEntry.COLUMN_NAME_SUBTITLE, subtitle)
	}
	val newRowId = db?.insert(FeedEntry.TABLE_NAME, null, values) // return primary key
	
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
      } while (result.moveToNext())
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
