implementation 'com.github.dhaval2404:imagepicker:2.1'

```kotlin

private fun pickImage(){  
    ImagePicker.with(this)  
        .crop()  
        .compress(1440)  
        .start()  
}  
  
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {  
    super.onActivityResult(requestCode, resultCode, data)  
    if (resultCode == Activity.RESULT_OK) {  
        val uri= data?.data!!  
        bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)  
        binding.ivImage.setImageURI(uri)  
    } else if (resultCode == ImagePicker.RESULT_ERROR) {  
        Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()  
    } else {  
        Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()  
    }  
}  
  
private fun bitmapToString(bitmap: Bitmap?): String{  
    val byteArrayOutputStream = ByteArrayOutputStream()  
    bitmap?.compress(Bitmap.CompressFormat.JPEG, 15 ,byteArrayOutputStream)  
    val imageByte = byteArrayOutputStream.toByteArray()  
    return Base64.encodeToString(imageByte, Base64.DEFAULT)  
}

```
