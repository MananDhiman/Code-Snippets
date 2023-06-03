- Always get something from volley to confirm message sent
# Dependency
```
 implementation 'com.android.volley:volley:1.2.1'
```


# Minimal Volley Response in String

```Kotlin
private fun getJSONObject() {
        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.1.10/iindex.php"

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener { response ->
                binding.textView.text = "Response Is: $response"
            },
            Response.ErrorListener {
                binding.textView.text = "Sorry Mate"
            }
    )
        queue.add(stringRequest)
}
```

# Volley Post Objects and Get String

```kotlin
var username, password //data to be sent
//

private fun postJSONObject() {
    val queue = Volley.newRequestQueue(this)
    val url = "http://192.168.1.10/iindex.php"

    val Request = object: StringRequest(Request.Method.GET, url,
        Response.Listener { response ->
            binding.textView.text = "Response Is: $response"
        },
        Response.ErrorListener {
            binding.textView.text = "Sorry Mate"
        }
    ){

        override fun getParams(): MutableMap<String, String>{
            val params = HashMap<String, String>()
            params.put(“username”,username)
            params.put(“password”,password)
            params.put(“age”,age)
            return params
        }
    
    }
    Volley.newRequestQueue(this).add(Request)
}
```

# Volley Get JsonArray

```kotlin
private fun getJSONArray(){

        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.1.10:8080"

            val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null,
            { response ->
                for (i in 0 until response.length()){
                    val jsonObject = response.getJSONObject(i)
                    binding.textView3.append("${jsonObject.getString("name")} = ${jsonObject.getString("capital")}\n")
                }
            },
            { error->
                binding.textView2.text = error.toString()
            }
        )
        queue.add(jsonArrayRequest)

    }
```
