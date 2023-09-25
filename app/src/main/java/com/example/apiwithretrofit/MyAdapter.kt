package com.example.apiwithretrofit

import Apidata
import Product
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context : Activity, val productarraylist : List<Product>) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView
        val  productimage : ShapeableImageView
        init {
            title = itemView.findViewById(R.id.textView)
            productimage = itemView.findViewById(R.id.imaageView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val  itemview = LayoutInflater.from(context).inflate(R.layout.eachitem, parent,false)
        return MyViewHolder(itemview)

    }

    override fun getItemCount(): Int {
        return productarraylist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productarraylist[position]
        holder.title.text = currentItem.title
        Picasso.get().load(currentItem.thumbnail).into(holder.productimage);
    }
}