package com.example.lotusapp.recadapters
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
import com.example.lotusapp.R


class StateRecycler(val context: Context, val list: ArrayList<state>):RecyclerView.Adapter<StateRecycler.MyVH>() {
    class MyVH(ListOfView: View): RecyclerView.ViewHolder(ListOfView){
        val img: ImageView = itemView.findViewById(R.id.state_img)
        val title: TextView = itemView.findViewById(R.id.state_title)
        val state_text: TextView = itemView.findViewById(R.id.state_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateRecycler.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.state_adapter, parent, false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: StateRecycler.MyVH, position: Int) {
        //Glide.with(context).load(quotes.data[position].image).into(holder.img)
        holder.title.setText(list[position].title)
        holder.state_text.setText(list[position].text_state)
    }

    override fun getItemCount(): Int {
        //return quotes.data.size
        return list.size
    }
}