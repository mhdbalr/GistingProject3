package com.example.gistingproject.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListGreenHouse(
    val nameGreenHouse: String,
    val imgGreenHouse: Int

) : Parcelable
