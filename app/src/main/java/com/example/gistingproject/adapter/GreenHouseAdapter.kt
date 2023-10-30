package com.example.gistingproject.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.gistingproject.R
import com.example.gistingproject.user.ListGreenHouse

class GreenHouseAdapter(var listStudent: List<ListGreenHouse>): RecyclerView.Adapter<GreenHouseAdapter.ViewHolder>(){
    class ViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        var nameGreenHouse = view.findViewById<TextView>(R.id.tvNamaSensor)
        var imgGreenHouse = view.findViewById<ImageView>(R.id.ivGreenHouse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GreenHouseAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_greenhouse, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GreenHouseAdapter.ViewHolder, position: Int) {
        val textViewGreenHouse = listStudent[position].nameGreenHouse
        holder.nameGreenHouse.text = listStudent[position].nameGreenHouse
        holder.imgGreenHouse.setImageResource(listStudent[position].imgGreenHouse)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val transaction = p0?.context as AppCompatActivity
                //intent activity membawa data textpada item untuk disearch pada google
                val pindahweb = Intent(Intent.ACTION_VIEW)
                pindahweb.data = Uri.parse("https://www.google.com/search?q=$textViewGreenHouse")
                transaction.startActivity(pindahweb)
            }
        })
    }



    override fun getItemCount(): Int {
        return listStudent.size
    }
}