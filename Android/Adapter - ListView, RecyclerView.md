# Array Adapter
simple_list_item_1 -> 1 textView

simple_list_item_2 -> 2 textViews

```kotlin
val listView: ListView = findViewById(R.id.listView)

val worldCupArray = arrayOf(
   "Germany", "Brazil", "England", "Spain", "Qatar"
)

val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
   this,
   android.R.layout.simple_list_item_1,
   worldCupArray
)

listView.adapter = arrayAdapter
```


# Recycler View
Adapter
```kotlin
package com.jagratilaharadmin.helper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.jagratilaharadmin.R

class PostsAdapters(private val postsList: List<Posts>, /*val context: Context*/): RecyclerView.Adapter<PostsAdapters.ViewHolder>() {
    val variable: Variable = Variable()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		//Give a XML to inflate (Step 1)
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)

        return ViewHolder(view)
    }

	class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
		//Associate XML layout with variables (Step 2)
        val tvTitle: TextView = itemView.findViewById(R.id.itemTitle)
        val tvSubtitle: TextView = itemView.findViewById(R.id.itemSubtitle)
        val layout: ConstraintLayout = itemView.findViewById(R.id.item_post_layout)
        var ivImage: ImageView = itemView.findViewById(R.id.itemImage)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		//Perform tasks (Step 3)
        val posts = postsList[position]

        val postId = posts.id.toString()
        holder.tvTitle.text = posts.title
        holder.tvSubtitle.text = posts.subtitle

        holder.layout.setOnClickListener{  }

    }

    override fun getItemCount(): Int {
		//Just No. of Items in list
        return postsList.size
    }

}
```

Activity/Fragment
``` kotlin
binding.recyclerView.layoutManager = LinearLayoutManager(context)
val adapter = AttendanceAdapter(listAttendance,this)  
binding.recyclerView.adapter = adapter

```
