package com.example.gistingproject.fragment

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gistingproject.R
import com.example.gistingproject.adapter.GreenHouseAdapter
import com.example.gistingproject.api.RetrofitClient
import com.example.gistingproject.model.GistingResponse
import com.example.gistingproject.user.ListGreenHouse
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat

class GreenHouseFragment : Fragment() {

    private lateinit var tvDataSensor: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_green_house, container, false)

        tvDataSensor = view.findViewById(R.id.tvDataSensor)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed(object : Runnable {
            override fun run() {
                loadData()
                Handler().postDelayed(this, 1000)
            }
        }, 1000)

    }

    private fun loadData(){
        RetrofitClient.apiVPSInstance
            .getGisting()
            .enqueue(object : Callback<GistingResponse> {
                override fun onResponse(
                    call: Call<GistingResponse>,
                    response: Response<GistingResponse>
                ) {
                    response.body()?.let {
                        val sensor = it.result[0]
                        val formattedDate = SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(
                            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(sensor.datetime))
                        with(sensor){
                            tvDataSensor.text = """
                            Datetime : $formattedDate
                            
                            Humidity 280 : $humidity280
                            
                            Pressure 280 : $pressure280
                            
                            Temperature 280 : $temperature280
                            
                            Temperature 388 : $temperature388
                            
                            Pressure 388 : $pressure388
                            
                            PH Sensor: $phsensor
                            
                            TDS Sensor: $tdssensor
                            
                            Moisture Sensor: $moisturesensor
                            
                            Anemometer: $anemometer
                            
                            Windvane: $windvane
                            
                            Current Sensor: $currentsensor
                            
                            Rain Intensity: $rainintensity
                            
                            Rain Status: $rainstatus
                        """.trimIndent()
                        }
                    }
                }
                override fun onFailure(call: Call<GistingResponse>, t: Throwable) {
                    t.message?.let {
                        Toast.makeText(requireContext(),it,Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }
}

