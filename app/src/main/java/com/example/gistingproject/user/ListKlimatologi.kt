package com.example.gistingproject.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListKlimatologi(
    val namaKlimatologi: String,
    val imgKlimatologi: Int

) : Parcelable
