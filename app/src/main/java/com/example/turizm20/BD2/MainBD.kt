package com.example.turizm20.BD2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class MainDB : RoomDatabase() {

    //выдаёт базу данных
    abstract fun getDao(): Dao
    companion object{
        fun getDB(context: Context): MainDB{
            return Room.databaseBuilder(
                context.applicationContext,
                MainDB::class.java,
                "test.db"
            ).build()
        }
    }
}