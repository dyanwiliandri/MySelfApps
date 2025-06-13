package com.example.myselfapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DailyData(
    val imageResId: Int,
    val title: String,
    val time: String
): Parcelable
