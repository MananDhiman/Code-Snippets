# Retrofit

## AndroidManifest.xml

```xml
<uses-permission android:name="android.permission.INTERNET"></uses-permission>
```

## build.gradle (app)
```gradle
implementation 'com.google.code.gson:gson:2.9.0'
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
```

## Model Class (Product.java)
```kotlin
data class Product(var rating: String,
    var category: String?,
    var price: String?,
    var id: String?,
    var name: String?
)
```

## ApiInterface.java
```java
public interface ApiInterface {
    
    //get request
    @GET("products/get_popular_products.php")
    fun getPopularProducts(): Call<List<Product>>

    //post request
    @FormUrlEncoded
    @POST("products/search_products.php")
    fun getProductById(@Field("id") id:String, @Field("name") name:String): Call<List<Product>>

    //other methods may be defined here
}
```

## RetrofitInstance.kt
```kotlin
object RetrofitInstance {
    private const val BASE_URL: String = "http://192.168.1.4/shophere/"

    private var instance: RetrofitInstance? = null
    var apiInterface: ApiInterface

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getInstance(): RetrofitInstance{
        if(instance == null) instance = RetrofitInstance
        return instance as RetrofitInstance
    }

}
```

## MainActivity
### Get Request
```kotlin
private fun getProductsFromApi() {
    val response = RetrofitInstance.getInstance().apiInterface.getPopularProducts()
    response.enqueue(object: Callback<List<Product>>{
        override fun onFailure(call: Call<List<Product>>, t: Throwable) {
            Log.d("response error",t.toString())
        }

        override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
            for (product in response.body()!!){
                Log.d("response from api", product.price.toString())
            }
        }
    })

}
```
### Post Request
```kotlin
//Only Change in function call of interface in which parameters are passed. Other handling is the same
private fun searchProduct() {
    val id = binding.editText.text.toString()
    if(id.isEmpty()) return

    val response = RetrofitInstance.getInstance().apiInterface.getProductById(id)
    response.enqueue(object: Callback<List<Product>>{
        override fun onFailure(call: Call<List<Product>>, t: Throwable) {
            Log.d("response error",t.toString())
        }

        override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
            for(product in response.body()!!){
                binding.textView.text = "${product.name} ${product.price} ${product.category}"
            }
        }
    })
}

```

## Sample API
```json
[
  {
    "name": "New Popular Phone",
    "price": "90000",
    "category": "smartphone",
    "rating": "13000"
  },
  {
    "name": "ABC Laptop",
    "price": "45000",
    "category": "laptop",
    "rating": "5000"
  },
  {
    "name": "Camera Phone",
    "price": "60000",
    "category": "smartphone",
    "rating": "2400"
  }
]
```