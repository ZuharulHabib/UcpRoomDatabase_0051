package com.example.ucp2_roomdatabase_051.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Jadwal")
data class Jadwal(
    @PrimaryKey
    val idAntrian: String,
    val namaDokter: String,
    val namaPasien: String,
    val noHp: String,
    val tanggal:String,
    val status:String,
)