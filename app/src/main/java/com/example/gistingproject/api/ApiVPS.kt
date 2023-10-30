package com.example.gistingproject.api

import com.example.gistingproject.model.GistingResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiVPS {
    @GET("GetDataGisting")
    fun getGisting(
    ): Call<GistingResponse>
}