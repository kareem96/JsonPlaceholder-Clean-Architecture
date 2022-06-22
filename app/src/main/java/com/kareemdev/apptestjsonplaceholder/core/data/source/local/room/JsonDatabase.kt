package com.kareemdev.apptestjsonplaceholder.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kareemdev.apptestjsonplaceholder.core.data.source.local.entity.JsonEntity


@Database(entities = [JsonEntity::class], version = 1, exportSchema = false)
abstract class JsonDatabase : RoomDatabase(){
    abstract  fun jsonDao(): JsonDao

    companion object{
        @Volatile
        private var INSTANCE: JsonDatabase? = null

        fun getInstance(context: Context): JsonDatabase =
            INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JsonDatabase::class.java,
                    "Json.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
    }
}