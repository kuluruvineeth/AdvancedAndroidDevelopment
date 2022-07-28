package com.kuluruvineeth.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(val fruitsList: List<Fruit>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruit = fruitsList.get(position)
        holder.bind(fruit)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }

}

class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){
    fun bind(fruit: Fruit){
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = "${fruit.name} supplied by ${fruit.supplier}"

        view.setOnClickListener {
            Toast.makeText(
                view.context,
                "Selected fruit is : ${fruit.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}