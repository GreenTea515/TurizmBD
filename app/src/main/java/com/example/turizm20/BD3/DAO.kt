package com.example.turizm20.BD3

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {
    @Insert
    fun insertpredmet(item: predmet)
    @Query("SELECT * FROM predmets")
    fun getAllpredmet(): Flow<List<predmet>>
}