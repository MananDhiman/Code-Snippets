# Read + Write

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
    
    constructor(){	//empty constructor for read
    
    }

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