package com.example.myselfapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FriendData(
    val imageResId: Int,
    val name: String
): Parcelable
