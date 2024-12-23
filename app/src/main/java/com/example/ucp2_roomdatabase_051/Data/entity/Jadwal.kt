package com.example.ucp2_roomdatabase_051.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jadwal")
data class Jadwal(
    @PrimaryKey(autoGenerate = true)
    val idJdl: Int = 0,
    val namaDokter: String,
    val namaPasien: String,
    val noHp: String,
    val tanggalKonsul: String,
    val status: String
)