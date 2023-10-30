package com.example.gistingproject.model

import com.google.gson.annotations.SerializedName

data class GistingResponse (
        @SerializedName("count") val count: Int,
        @SerializedName("result") val result: List<Sensor>
)