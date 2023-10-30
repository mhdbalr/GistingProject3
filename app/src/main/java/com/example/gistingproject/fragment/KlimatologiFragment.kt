package com.example.gistingproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gistingproject.R
import com.example.gistingproject.adapter.GreenHouseAdapter
import com.example.gistingproject.user.ListGreenHouse

class KlimatologiFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_klimatologi, container, false)

        recyclerView = view.findViewById(R.id.rvklimatologi)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Contoh data untuk ditampilkan di RecyclerView
        val dataListKlimatologi = listOf(
            ListGreenHouse("Sensor Suhu", R.drawable.iconsuhu),
            ListGreenHouse("Sensor Ketinggian", R.drawable.iconsuhu),
            ListGreenHouse("Sensor Kecepatan Angin", R.drawable.iconsuhu),
            ListGreenHouse("Sensor Kelembapan",R.drawable.iconkelembapan),
            ListGreenHouse("Sensor PH", R.drawable.iconph),
            ListGreenHouse("Sensor Arah angin", R.drawable.iconarahangin),
            ListGreenHouse("Sensor Intensitas Air Hujan", R.drawable.iconanemometer),
            ListGreenHouse("Battery", R.drawable.iconbattery),
            ListGreenHouse("Sensor Arus Listrik", R.drawable.iconsuhu),
            ListGreenHouse("Sensor Curah Hujan", R.drawable.iconcurahhujan),
            ListGreenHouse("Sensor Soil Moisture", R.drawable.iconsoilmoisture),
            ListGreenHouse("Sensor Intensitas Cahaya", R.drawable.iconsuhu),
            ListGreenHouse("Sensor Berat", R.drawable.iconsuhu),
            ListGreenHouse("Sensor Infrared", R.drawable.iconsuhu),
            ListGreenHouse("Sensor Intensitas Arus Air", R.drawable.iconsuhu),
            ListGreenHouse("Sensor tds", R.drawable.icontds),
            ListGreenHouse("Sensor Tekanan Udara", R.drawable.icontekananudara)

            // ... tambahkan item lainnya sesuai kebutuhan
        )

        val adapter = GreenHouseAdapter(dataListKlimatologi)
        recyclerView.adapter = adapter

        return view
    }
}