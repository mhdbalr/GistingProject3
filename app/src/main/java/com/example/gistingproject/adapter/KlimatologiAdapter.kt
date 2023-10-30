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
import com.example.gistingproject.user.ListKlimatologi

class KlimatologiAdapter(var listKlimatologii: List<ListKlimatologi>): RecyclerView.Adapter<KlimatologiAdapter.ViewHolder>(){
    class ViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        var namaKlimatologi = view.findViewById<TextView>(R.id.tvNameSensor)
        var imgKlimatologi = view.findViewById<ImageView>(R.id.ivklimatologi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KlimatologiAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_klimatologi, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: KlimatologiAdapter.ViewHolder, position: Int) {
        val textViewKlimatologi = listKlimatologii[position].namaKlimatologi
        holder.namaKlimatologi.text = listKlimatologii[position].namaKlimatologi
        holder.imgKlimatologi.setImageResource(listKlimatologii[position].imgKlimatologi)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val transaction = p0?.context as AppCompatActivity
                //intent activity membawa data textpada item untuk disearch pada google
                val pindahweb = Intent(Intent.ACTION_VIEW)
                pindahweb.data = Uri.parse("https://www.google.com/search?q=$textViewKlimatologi")
                transaction.startActivity(pindahweb)
            }
        })
    }



    override fun getItemCount(): Int {
        return listKlimatologii.size
    }
}