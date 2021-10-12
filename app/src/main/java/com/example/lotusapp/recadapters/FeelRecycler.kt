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

class FeelRecycler(val context: Context, val list: ArrayList<feel>):RecyclerView.Adapter<FeelRecycler.MyVH>() {
    class MyVH(ListOfView: View): RecyclerView.ViewHolder(ListOfView){
        val image: ImageView = itemView.findViewById(R.id.img_feel)
        val textview: TextView = itemView.findViewById(R.id.text_feel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeelRecycler.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.feel_adapter, parent, false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: FeelRecycler.MyVH, position: Int) {
       // Glide.with(context).load(feelings.data[position].image).into(holder.image)
        holder.image.setImageResource(list[position].image)
        holder.textview.setText(list[position].name_feel)
    }

    override fun getItemCount(): Int {
       // return feelings.data.size
        return list.size
    }
}