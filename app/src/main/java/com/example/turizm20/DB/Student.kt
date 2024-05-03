package com.example.turizm20.DB

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int?=null,
    @ColumnInfo(name="name") val name: String?,
    @ColumnInfo(name="opisanie") val opisanie: String?,
    @ColumnInfo(name="roll_no") val rollNo: Int?,
)
