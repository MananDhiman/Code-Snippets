# Saving Files to Permanent Storage
Types of Storage:
- App private storage: /data/data/com.example/files
- Shared Storage: Common storage accessible by all apps. Need uri of path

## App Private Storage
```kotlin
fun writeToFile(value: String) {
    try {
        val fileout: FileOutputStream = openFileOutput("mytextfile.txt", MODE_PRIVATE)
        val outputWriter = OutputStreamWriter(fileout)
        outputWriter.write(value)
        outputWriter.close()

        //display file saved message
        Toast.makeText(
            this, "File saved successfully!",
            Toast.LENGTH_SHORT
        ).show()

    } catch (e: Exception) {
        e.printStackTrace()
    }
}
```

## Shared Storage
Manifest.xml
```xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" android:maxSdkVersion="32" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"    android:maxSdkVersion="29" />
```
Activity
```kotlin
private var baseDocumentTreeUri: Uri? = null
private const val dirPathPickerIntentCode: Int = 1

// just to choose target dir for file output
private fun launchBaseDirectoryPicker() {
    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
    startActivityForResult(intent, dirPathPickerIntentCode)
}

// could choose to permanently save uri in SharedPref
@Deprecated(message = "deprecated") // don’t know if necessary
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
  
        if (resultCode == Activity.RESULT_OK) {
            baseDocumentTreeUri = Objects.requireNonNull(data)?.data
            val takeFlags: Int =
                (Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
            
            // take persistable Uri Permission for future use
            this.contentResolver.takePersistableUriPermission(data?.data!!, takeFlags)
            val preferences: SharedPreferences =
                this.getSharedPreferences("app", Context.MODE_PRIVATE)
            preferences.edit().putString("dirPathUri", data?.data.toString()).apply()
            
            try {
                val directory = DocumentFile.fromTreeUri(this, baseDocumentTreeUri!!)
                val file = directory!!.createFile("text/*", "fileoutput.txt");
                val pfd = this.contentResolver.openFileDescriptor(file!!.uri, "w");
                val fos = FileOutputStream(pfd!!.fileDescriptor);
                val dataToWrite = "Howdy"
                fos.write(dataToWrite.toByteArray());
                fos.close();
            } catch (e: IOException) {
                Log.d("tag except", "failed to write file")
            }

    } else {
        Log.e("TAG FileUtility", "Some Error Occurred : $data")
    }
}
```