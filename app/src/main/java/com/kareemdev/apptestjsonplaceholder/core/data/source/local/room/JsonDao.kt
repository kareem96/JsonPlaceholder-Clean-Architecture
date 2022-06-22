package com.kareemdev.apptestjsonplaceholder.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kareemdev.apptestjsonplaceholder.core.data.source.local.entity.JsonEntity

@Dao
interface JsonDao {
    @Query("SELECT * FROM jsonPlace")
    fun getAllJson(): LiveData<List<JsonEntity>>

    @Query("SELECT * FROM jsonPlace where isFavorite = 1")
    fun getFavoriteJson(): LiveData<List<JsonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertJson(jsons: List<JsonEntity>)

    @Update
    fun updateFavoriteJson(jsons: JsonEntity)
}