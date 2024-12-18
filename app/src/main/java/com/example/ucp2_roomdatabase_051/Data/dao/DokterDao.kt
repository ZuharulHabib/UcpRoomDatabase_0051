package com.example.ucp2_roomdatabase_051.Data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.ucp2_roomdatabase_051.Data.entity.Dokter

@Dao
interface DokterDao {@Insert
suspend fun insertDokter(dokter: Dokter)

    @Query("SELECT * FROM dokter")
    suspend fun getAllDokter(): List<Dokter>

    @Delete
    suspend fun deleteDokter(dokter: Dokter)

}