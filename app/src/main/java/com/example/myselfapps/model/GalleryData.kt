package com.example.myselfapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GalleryData(
    val imageResId: Int
): Parcelable
