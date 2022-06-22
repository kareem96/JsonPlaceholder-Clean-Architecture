package com.kareemdev.apptestjsonplaceholder.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Json (
    val userId: Int,
    val id: Int,
    val title: String,
    val isFavorite: Boolean
): Parcelable