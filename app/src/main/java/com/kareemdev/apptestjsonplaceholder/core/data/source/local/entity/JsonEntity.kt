package com.kareemdev.apptestjsonplaceholder.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "jsonPlace")
data class JsonEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "userId")
    var userId: Int,

    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "title")
    var title: String,


    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : Parcelable