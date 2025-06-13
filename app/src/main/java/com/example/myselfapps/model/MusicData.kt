package com.example.myselfapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MusicData(
    val albumArtResId: Int,
    val title: String,
    val artist: String
): Parcelable
