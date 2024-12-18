package com.example.ucp2_roomdatabase_051.Data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2_roomdatabase_051.Data.entity.Jadwal

@Dao
interface JadwalDao {

    // **CREATE**: Menambahkan data jadwal baru
    @Insert
    suspend fun insertJadwal(jadwal: Jadwal)

    // **READ**: Mendapatkan semua data jadwal
    @Query("SELECT * FROM jadwal")
    suspend fun getAllJadwal(): List<Jadwal>

    // **READ**: Mendapatkan data jadwal berdasarkan ID
    @Query("SELECT * FROM jadwal WHERE id = :id")
    suspend fun getJadwalById(id: Int): Jadwal

    // **UPDATE**: Memperbarui data jadwal
    @Update
    suspend fun updateJadwal(jadwal: Jadwal)

    // **DELETE**: Menghapus data jadwal berdasarkan ID
    @Delete
    suspend fun deleteJadwal(jadwal: Jadwal)

    // **DELETE**: Menghapus semua data jadwal
    @Query("DELETE FROM jadwal")
    suspend fun deleteAllJadwal()
}